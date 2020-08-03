package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.PostCategoryService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.PostCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class PostCategoryServiceImpl implements PostCategoryService {

	@Autowired
	private PostCategoryRepository postCategoryRepository;

}
