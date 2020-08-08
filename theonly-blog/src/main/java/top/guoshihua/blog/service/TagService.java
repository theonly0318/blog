package top.guoshihua.blog.service;

import top.guoshihua.blog.common.response.PageResult;
import top.guoshihua.blog.common.response.ResponseResult;
import top.guoshihua.blog.entity.Tag;

import java.util.List;

/**
 * @author guoshihua
 */
public interface TagService  {

    List<Tag> findAll();

    Tag findById(String id);

    PageResult<Tag> findByPage(Integer page, Integer rows, String sortBy, Boolean desc);

    ResponseResult save(Tag tag);

    ResponseResult update(Tag tag);

    ResponseResult delete(String id);
}
