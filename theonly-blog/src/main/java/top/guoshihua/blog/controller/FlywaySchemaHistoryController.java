package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.service.FlywaySchemaHistoryService;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/flywaySchemaHistory")
public class FlywaySchemaHistoryController {

	@Autowired
	private FlywaySchemaHistoryService flywaySchemaHistoryService;

}
