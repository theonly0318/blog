package top.guoshihua.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import top.guoshihua.blog.entity.PostStatus;

/**
 * @ClassName PostStatusMapper
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/8 0008 下午 5:10
 * @Version V1.0
 * @See 版权声明
 **/
@Mapper
public interface PostStatusMapper extends tk.mybatis.mapper.common.Mapper<PostStatus> {
}
