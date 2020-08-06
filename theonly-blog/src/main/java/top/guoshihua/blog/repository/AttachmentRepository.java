package top.guoshihua.blog.repository;

import top.guoshihua.blog.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author guoshihua
 */
public interface AttachmentRepository extends JpaRepository<Attachment, String>{}
