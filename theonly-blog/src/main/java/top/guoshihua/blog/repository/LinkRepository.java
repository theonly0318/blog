package top.guoshihua.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import top.guoshihua.blog.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author guoshihua
 */
public interface LinkRepository extends JpaRepository<Link, String> {

    Link findFirstByName(String name);
}
