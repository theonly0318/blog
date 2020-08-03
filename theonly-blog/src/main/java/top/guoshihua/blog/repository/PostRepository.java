package top.guoshihua.blog.repository;

import top.guoshihua.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author guoshihua
 */
public interface PostRepository extends JpaRepository<Post, Integer>{}
