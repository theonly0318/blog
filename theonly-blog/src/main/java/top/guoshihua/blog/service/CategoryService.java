package top.guoshihua.blog.service;


import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import top.guoshihua.blog.common.response.PageResult;
import top.guoshihua.blog.common.response.ResponseResult;
import top.guoshihua.blog.entity.Category;

import java.util.List;

/**
 * @author guoshihua
 */
@CacheConfig(cacheNames = {"category"})
public interface CategoryService {

    List<Category> findAll();

    @Cacheable(key = "#p0")
    Category findById(String id);
    @Cacheable(key = "#p0")
    Category findByName(String name);
    @Cacheable(key = "#p0")
    Category findBySlugName(String slugName);

    Page<Category> findByPage(Integer page, Integer rows, String sortBy, Boolean desc);

    Category save(Category category);

    Category update(String id, Category category);

    void delete(String id);

    ResponseResult addCategoryToMenu(String categoryId);

    PageResult<Category> findPostByCategorySlugName(Integer page, Integer rows, String sortBy, Boolean desc,
                                                               String slugName);
}
