package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.CategoryService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

}
