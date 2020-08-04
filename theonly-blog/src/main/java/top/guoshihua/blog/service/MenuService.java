package top.guoshihua.blog.service;

import org.springframework.data.domain.Page;
import top.guoshihua.blog.entity.Menu;

import java.util.List;

/**
 * @author guoshihua
 */
public interface MenuService  {

    List<Menu> findAll();

    Menu findById(Integer id);

    Page<Menu> findByPage(Integer page, Integer rows, String sortBy, Boolean desc);

    Menu save(Menu menu);

    Menu update(Integer id, Menu menu);

    void recovery(Integer id);

    void delete(Integer id);
}
