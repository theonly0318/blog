package top.guoshihua.blog.repository;

import top.guoshihua.blog.entity.FlywaySchemaHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author guoshihua
 */
public interface FlywaySchemaHistoryRepository extends JpaRepository<FlywaySchemaHistory, Integer>{}
