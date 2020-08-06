package top.guoshihua.blog.repository;

import javafx.scene.control.MenuItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import top.guoshihua.blog.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author guoshihua
 */
public interface MenuRepository extends JpaRepository<Menu, String>{

    @Modifying
    @Query(value = "update Menu set deleted = 1 where id = :id")
    Menu updateDeletedById(@Param("id") String id);

    Menu findFirstByName(String name);
}
