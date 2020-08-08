package top.guoshihua.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import tk.mybatis.mapper.entity.Example;
import top.guoshihua.blog.common.response.PageResult;
import top.guoshihua.blog.common.response.ResponseResult;
import top.guoshihua.blog.common.response.enums.CommonCode;
import top.guoshihua.blog.dao.TagMapper;
import top.guoshihua.blog.entity.Tag;
import top.guoshihua.blog.exception.ExceptionCast;
import top.guoshihua.blog.service.TagService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.util.UuidUtil;

import java.util.List;

/**
 * @author guoshihua
 */
@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private TagMapper tagMapper;

	@Override
	public List<Tag> findAll() {
		return tagMapper.selectAll();
	}

	@Override
	public Tag findById(String id) {
		return tagMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult<Tag> findByPage(Integer page, Integer rows, String sortBy, Boolean desc) {

		Example example = new Example(Tag.class);
		example.orderBy(sortBy).desc();
		PageHelper.startPage(page, rows);
		List<Tag> tags = tagMapper.selectByExample(example);
		PageInfo<Tag> pageInfo = new PageInfo<>(tags);
		return new PageResult<>(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
	}

	@Override
	public ResponseResult save(Tag tag) {
		this.checkTag(tag);
		tag.setId(UuidUtil.getUUIDStr());
		tagMapper.insertSelective(tag);

		return new ResponseResult(CommonCode.SUCCESS);
	}

	@Override
	public ResponseResult update(Tag tag) {
		this.checkTagById(tag.getId());
		this.checkTag(tag);
		tagMapper.updateByPrimaryKey(tag);
		return new ResponseResult(CommonCode.SUCCESS);
	}

	@Override
	public ResponseResult delete(String id) {
		this.checkTagById(id);
		tagMapper.deleteByPrimaryKey(id);
		return new ResponseResult(CommonCode.SUCCESS);
	}


	/**
	 *
	 * @param id
	 */
	private void checkTagById(String id) {
		if (StringUtils.isBlank(id)) {
			ExceptionCast.cast(CommonCode.TAG_INVALID_PARAMETER);
		}
		Tag tag = tagMapper.selectByPrimaryKey(id);
		if (tag == null) {
			ExceptionCast.cast(CommonCode.TAG_UPDATE_NOTEXISTS);
		}
	}

	/**
	 *
	 * @param tag
	 */
	private void checkTag(Tag tag) {
		if (tag == null || StringUtils.isBlank(tag.getName()) || StringUtils.isBlank(tag.getSlugName()))  {
			ExceptionCast.cast(CommonCode.TAG_INVALID_PARAMETER);
	}

		Example example = new Example(Tag.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("name", tag.getName());
		criteria.orEqualTo("slugName", tag.getSlugName());
		List<Tag> tags = tagMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(tags)) {
			ExceptionCast.cast(CommonCode.TAG_ADD_EXISTSNAME);
		}
	}
}
