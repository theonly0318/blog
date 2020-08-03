package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.FlywaySchemaHistoryService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.FlywaySchemaHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class FlywaySchemaHistoryServiceImpl implements FlywaySchemaHistoryService {

	@Autowired
	private FlywaySchemaHistoryRepository flywaySchemaHistoryRepository;

}
