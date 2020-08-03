package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.service.PostCategoryService;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/postCategory")
public class PostCategoryController {

	@Autowired
	private PostCategoryService postCategoryService;

}
