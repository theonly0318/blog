package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.service.PostService;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;

}
