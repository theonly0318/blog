package top.guoshihua.blog.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import top.guoshihua.blog.entity.Category;
import top.guoshihua.blog.service.CategoryService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author guoshihua
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll(Sort.by("createTime").descending());
	}

	@Override
	public Category findById(Integer id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Page<Category> findByPage(Integer page, Integer rows, String sortBy, Boolean desc) {
		Pageable pageable = null;
		if (StringUtils.isBlank(sortBy)) {
			sortBy = "createTime";
		}
		Sort sort = Sort.by(sortBy);
		if (desc) {
			sort = sort.descending();
		} else {
			sort = sort.ascending();
		}
		pageable = PageRequest.of(page, rows, sort);
		Page<Category> categoryPage = categoryRepository.findAll(pageable);
		return categoryPage;
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category update(Integer id, Category category) {
		Category c = categoryRepository.findById(id).get();
		category.setId(c.getId());
		return categoryRepository.save(category);
	}

	@Override
	public void delete(Integer id) {
		categoryRepository.deleteById(id);
	}
}
