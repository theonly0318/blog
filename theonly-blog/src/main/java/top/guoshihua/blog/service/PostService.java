package top.guoshihua.blog.service;

import top.guoshihua.blog.common.response.PageResult;
import top.guoshihua.blog.common.response.ResponseResult;
import top.guoshihua.blog.entity.Post;

import java.util.List;

/**
 * @author guoshihua
 */
public interface PostService {

    List<Post> findAll();

    Post findById(String id);

    PageResult<Post> findByPage(Integer page, Integer rows, String sortBy, Boolean desc);

    ResponseResult save(Post post);

    ResponseResult update(Post post);

    ResponseResult delete(String id);

    ResponseResult updateTypeById(String id);

    ResponseResult updateStatusById(String id, Integer status);

    ResponseResult updatePriorityById(String id, Integer priority);

    ResponseResult updatePasswordById(String id, String password);
}
