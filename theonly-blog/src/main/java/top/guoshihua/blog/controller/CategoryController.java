package top.guoshihua.blog.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.api.CategoryApi;
import top.guoshihua.blog.bo.CategoryBo;
import top.guoshihua.blog.common.response.PageResult;
import top.guoshihua.blog.common.response.ResponseResult;
import top.guoshihua.blog.entity.Category;
import top.guoshihua.blog.service.CategoryService;

import java.util.List;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/category")
public class CategoryController implements CategoryApi {

	@Autowired
	private CategoryService categoryService;

	@Override
	@GetMapping("/list")
	public List<Category> list() {

		return categoryService.findAll();
	}

	@Override
	@GetMapping("/page")
	public Page<Category> findByPage(
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "rows", defaultValue = "10") Integer rows,
			@RequestParam(name = "sortBy", required = false) String sortBy,
			@RequestParam(name = "desc", required = false) Boolean desc) {
		return categoryService.findByPage(page, rows, sortBy, desc);
	}

	@Override
	@GetMapping("/page/{slugName}")
	public PageResult<CategoryBo> findPostByCategorySlugName(@RequestParam(name = "page", defaultValue = "1") Integer page,
															 @RequestParam(name = "rows", defaultValue = "10") Integer rows,
															 @RequestParam(name = "sortBy", required = false) String sortBy,
															 @RequestParam(name = "desc", required = false) Boolean desc,
															 @PathVariable("slugName") String slugName) {
		return categoryService.findPostByCategorySlugName(page, rows, sortBy, desc, slugName);
	}

}
