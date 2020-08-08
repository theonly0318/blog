package top.guoshihua.blog.service.impl;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import top.guoshihua.blog.common.response.ResponseResult;
import top.guoshihua.blog.common.response.enums.CommonCode;
import top.guoshihua.blog.dao.CategoryMapper;
import top.guoshihua.blog.entity.Category;
import top.guoshihua.blog.entity.Menu;
import top.guoshihua.blog.exception.ExceptionCast;
import top.guoshihua.blog.service.CategoryService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.service.MenuService;
import top.guoshihua.blog.util.UUIDGenerator;
import top.guoshihua.blog.util.UuidUtil;

import java.util.List;
import java.util.Optional;

/**
 * @author guoshihua
 */
@Service("categoryService")
@Transactional(rollbackFor = Exception.class)
public class CategoryServiceImpl implements CategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private MenuService menuService;

	@Override
	public List<Category> findAll() {
		LOGGER.info("获取所有分类");
		return categoryRepository.findAll(Sort.by("createTime").descending());
	}

	@Override
	public Category findById(String id) {
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
		Category c = categoryRepository.findFirstByName(category.getName());
		if (c != null) {
			return null;
		}
		String id = UuidUtil.getUUIDStr();
		category.setId(id);
		categoryMapper.insertSelective(category);
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category update(String id, Category category) {
		Category c = categoryRepository.findById(id).get();
		category.setId(c.getId());
		categoryMapper.updateByPrimaryKeySelective(category);
		return categoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(String id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public ResponseResult addCategoryToMenu(String categoryId) {
		Category category = categoryMapper.selectByPrimaryKey(categoryId);
		if (category == null) {
			ExceptionCast.cast(CommonCode.CATEGORY_UPDATE_NOTEXISTS);
		}
		Menu menu = new Menu();
		String id = UuidUtil.getUUIDStr();
		menu.setId(id);
		menu.setIcon("");
		menu.setName(category.getName());
		menu.setParentId(0);
		menu.setPriority(0);
		menu.setTarget("");
		menu.setTeam("");
		menu.setUrl("category/"+category.getSlugName());
		menu.setDeleted(false);

		menuService.save(menu);

		return ResponseResult.SUCCESS();
	}
}
