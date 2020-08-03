package top.guoshihua.blog.repository;

import top.guoshihua.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author guoshihua
 */
public interface CommentRepository extends JpaRepository<Comment, Long>{}
