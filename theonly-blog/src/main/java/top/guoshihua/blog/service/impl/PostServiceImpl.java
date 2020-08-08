package top.guoshihua.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import tk.mybatis.mapper.entity.Example;
import top.guoshihua.blog.common.response.PageResult;
import top.guoshihua.blog.common.response.ResponseResult;
import top.guoshihua.blog.common.response.enums.CommonCode;
import top.guoshihua.blog.dao.PostMapper;
import top.guoshihua.blog.dao.PostStatusMapper;
import top.guoshihua.blog.entity.Post;
import top.guoshihua.blog.entity.PostStatus;
import top.guoshihua.blog.exception.ExceptionCast;
import top.guoshihua.blog.service.PostService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.util.MD5Utils;
import top.guoshihua.blog.util.UuidUtil;

import java.util.List;

/**
 * @author guoshihua
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostMapper postMapper;
	@Autowired
	private PostStatusMapper postStatusMapper;

	@Override
	public List<Post> findAll() {
		return postMapper.selectAll();
	}

	@Override
	public Post findById(String id) {
		return postMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult<Post> findByPage(Integer page, Integer rows, String sortBy, Boolean desc) {

		Example example = new Example(Post.class);
		example.orderBy(sortBy).desc();
		PageHelper.startPage(page, rows);
		List<Post> posts = postMapper.selectByExample(example);
		PageInfo pageInfo = new PageInfo<>(posts);
		return new PageResult<>(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
	}

	@Override
	public ResponseResult save(Post post) {
		checkPost(post);
		post.setId(UuidUtil.getUUIDStr());
		postMapper.insertSelective(post);
		return ResponseResult.SUCCESS();
	}

	@Override
	public ResponseResult update(Post post) {
		checkPostById(post.getId());
		checkPost(post);
		postMapper.updateByPrimaryKeySelective(post);
		return ResponseResult.SUCCESS();
	}

	@Override
	public ResponseResult delete(String id) {
		checkPostById(id);
		postMapper.deleteByPrimaryKey(id);
		return ResponseResult.SUCCESS();
	}

	@Override
	public ResponseResult updateTypeById(String id) {
		Post post = checkPostById(id);
		if (post.getType() == 0) {
			post.setType(1);
		} else if(post.getType() == 1) {
			post.setType(0);
		}
		postMapper.updateByPrimaryKeySelective(post);
		return ResponseResult.SUCCESS();
	}

	@Override
	public ResponseResult updateStatusById(String id, Integer status) {
		Post post = checkPostById(id);
		PostStatus postStatus = postStatusMapper.selectByPrimaryKey(status);
		if (postStatus == null) {
			ExceptionCast.cast(CommonCode.POST_UPDATE_INVALID_STATUS);
		}
		post.setStatus(status);
		postMapper.updateByPrimaryKeySelective(post);
		return ResponseResult.SUCCESS();
	}

	@Override
	public ResponseResult updatePriorityById(String id, Integer priority) {
		Post post = checkPostById(id);
		if (priority == null || priority < 0) {
			ExceptionCast.cast(CommonCode.POST_UPDATE_INVALID_PRIORITY);
		}
		post.setTopPriority(priority);
		postMapper.updateByPrimaryKeySelective(post);
		return ResponseResult.SUCCESS();
	}

	@Override
	public ResponseResult updatePasswordById(String id, String password) {
		Post post = checkPostById(id);
		password = StringUtils.trim(password);
		if (StringUtils.isNotBlank(password)) {
			password = MD5Utils.md5Hash(password, null);
		}
		post.setPassword(password);
		postMapper.updateByPrimaryKeySelective(post);
		return ResponseResult.SUCCESS();
	}

	/**
	 *
	 * @param id
	 */
	private Post checkPostById(String id) {
		if (StringUtils.isBlank(id)) {
			ExceptionCast.cast(CommonCode.POST_INVALID_PARAMETER);
		}
		Post post = postMapper.selectByPrimaryKey(id);
		if (post == null) {
			ExceptionCast.cast(CommonCode.POST_UPDATE_NOTEXISTS);
		}
		return post;
	}

	/**
	 *
	 * @param post
	 */
	private void checkPost(Post post) {
		if (post == null || StringUtils.isBlank(post.getTitle()))  {
			ExceptionCast.cast(CommonCode.TAG_INVALID_PARAMETER);
		}

		Example example = new Example(Post.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("title", post.getTitle());
		List<Post> posts = postMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(posts)) {
			ExceptionCast.cast(CommonCode.TAG_ADD_EXISTSNAME);
		}
	}
}
