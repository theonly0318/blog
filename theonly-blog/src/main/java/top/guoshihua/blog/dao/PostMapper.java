package top.guoshihua.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import top.guoshihua.blog.entity.Post;

/**
 *
 * @author Administrator
 */
@Mapper
public interface PostMapper extends tk.mybatis.mapper.common.Mapper<Post> {
}
