package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.service.LogService;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/log")
public class LogController {

	@Autowired
	private LogService logService;

}
