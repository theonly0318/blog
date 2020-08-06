package top.guoshihua.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import top.guoshihua.blog.entity.Category;

/**
 * @ClassName CategoryMapper
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/4 0004 下午 7:22
 * @Version V1.0
 * @See 版权声明
 **/

@Mapper
public interface CategoryMapper extends tk.mybatis.mapper.common.Mapper<Category> {
}
