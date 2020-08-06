package top.guoshihua.blog.repository;

import top.guoshihua.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author guoshihua
 */
public interface TagRepository extends JpaRepository<Tag, String>{}
