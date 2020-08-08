package top.guoshihua.blog.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.api.CategoryApi;
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
	@GetMapping("/{id}")
	public Category findById(@PathVariable("id") String id) {
		return categoryService.findById(id);
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
	@PostMapping("/save")
	public void save(Category category) {
		categoryService.save(category);
	}

	@Override
	@PutMapping("/{id}")
	public void update(@PathVariable("id") String id, Category category) {
		categoryService.update(id, category);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		categoryService.delete(id);
	}

	@Override
	@PostMapping("/addToMenu/{id}")
	public ResponseResult addCategoryToMenu(@PathVariable("id") String categoryId) {

		return categoryService.addCategoryToMenu(categoryId);

	}
}
