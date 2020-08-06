package top.guoshihua.blog.service;


import org.springframework.data.domain.Page;
import top.guoshihua.blog.entity.Category;

import java.util.List;

/**
 * @author guoshihua
 */
public interface CategoryService {

    List<Category> findAll();

    Category findById(String id);

    Page<Category> findByPage(Integer page, Integer rows, String sortBy, Boolean desc);

    Category save(Category category);

    Category update(String id, Category category);

    void delete(String id);
}
