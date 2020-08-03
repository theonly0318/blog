package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.service.MetaService;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/meta")
public class MetaController {

	@Autowired
	private MetaService metaService;

}
