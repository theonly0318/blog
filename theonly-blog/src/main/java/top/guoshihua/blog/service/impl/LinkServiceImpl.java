package top.guoshihua.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import top.guoshihua.blog.common.response.PageResult;
import top.guoshihua.blog.common.response.enums.CommonCode;
import top.guoshihua.blog.common.response.ResponseResult;
import top.guoshihua.blog.dao.LinkMapper;
import top.guoshihua.blog.entity.Link;
import top.guoshihua.blog.exception.ExceptionCast;
import top.guoshihua.blog.service.LinkService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.util.UuidUtil;

import java.util.List;

/**
 * @author guoshihua
 */
@Service("linkService")
@Transactional
public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkRepository linkRepository;
	@Autowired
	private LinkMapper linkMapper;

	@Override
	public List<Link> findAll() {
		List<Link> linkList = linkMapper.selectAll();
		return linkList;
	}

	@Override
	public Link findById(String id) {
		Link link = linkMapper.selectByPrimaryKey(id);
		return link;
	}

	@Override
	public PageResult<Link> findByPage(Integer page, Integer rows, String sortBy, Boolean desc) {

		tk.mybatis.mapper.entity.Example example = new Example(Link.class);
		Example.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(sortBy)) {
			sortBy = "createTime";
		}
		if (desc == null) {
			desc = true;
		}
		PageHelper.startPage(page, rows);
		example.setOrderByClause(sortBy + "  " + (desc ? "desc" : "asc"));
		List<Link> linkList = linkMapper.selectByExample(example);
		PageInfo<Link> pageInfo = new PageInfo<>(linkList);
		return new PageResult<Link>(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
	}

	@Override
	public ResponseResult save(Link link) {
		if (link == null) {
			// 抛出异常非法请求
			ExceptionCast.cast(CommonCode.LINK_INVALID_PARAMETER);
		}
		Link c = linkRepository.findFirstByName(link.getName());
		if (c != null) {
			// 抛出异常，分类已存在
			ExceptionCast.cast(CommonCode.LINK_ADD_EXISTSNAME);
		}
		String id = UuidUtil.getUUIDStr();
		link.setId(id);
		linkMapper.insertSelective(link);
		Link link1 = linkRepository.findById(id).get();
		ResponseResult responseResult = new ResponseResult(CommonCode.SUCCESS);
		return responseResult;
	}

	@Override
	public ResponseResult update(Link link) {
		if (link == null) {
			// 抛出异常非法请求
			ExceptionCast.cast(CommonCode.LINK_INVALID_PARAMETER);
		}
		Link link1 = linkMapper.selectByPrimaryKey(link.getId());
		if (link1 == null) {
			// 抛出异常，分类不存在
			ExceptionCast.cast(CommonCode.LINK_UPDATE_NOTEXISTS);
		}
		linkMapper.updateByPrimaryKeySelective(link);
		ResponseResult responseResult = new ResponseResult(CommonCode.SUCCESS);
		return responseResult;
	}

	@Override
	public ResponseResult deleteById(String id) {
		if (StringUtils.isBlank(id)) {
			// 抛出异常非法请求
			ExceptionCast.cast(CommonCode.LINK_INVALID_PARAMETER);
		}
		Link link = linkMapper.selectByPrimaryKey(id);
		if (link == null) {
			// 抛出异常，分类不存在
			ExceptionCast.cast(CommonCode.LINK_UPDATE_NOTEXISTS);
		}
		linkRepository.deleteById(id);
		ResponseResult responseResult = new ResponseResult(CommonCode.SUCCESS);
		return responseResult;
	}
}
