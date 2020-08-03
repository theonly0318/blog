package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.service.TagService;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/tag")
public class TagController {

	@Autowired
	private TagService tagService;

}
