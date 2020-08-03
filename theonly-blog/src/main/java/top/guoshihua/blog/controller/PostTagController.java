package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.service.PostTagService;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/postTag")
public class PostTagController {

	@Autowired
	private PostTagService postTagService;

}
