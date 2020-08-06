package top.guoshihua.blog.repository;

import top.guoshihua.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author guoshihua
 */
public interface CategoryRepository extends JpaRepository<Category, String>{
    Category findFirstByName(String name);
    Category findFirstById(String id);
}
