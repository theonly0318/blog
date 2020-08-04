package top.guoshihua.blog.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import top.guoshihua.blog.entity.Menu;
import top.guoshihua.blog.service.MenuService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author guoshihua
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<Menu> findAll() {
		return menuRepository.findAll();
	}

	@Override
	public Menu findById(Integer id) {
		return menuRepository.findById(id).get();
	}

	@Override
	public Page<Menu> findByPage(Integer page, Integer rows, String sortBy, Boolean desc) {
		return null;
	}

	@Override
	public Menu save(Menu menu) {
		return menuRepository.save(menu);
	}

	@Override
	public Menu update(Integer id, Menu menu) {
		Menu menu1 = menuRepository.findById(id).get();
		menu.setId(menu1.getId());
		return menuRepository.save(menu);
	}

	@Override
	public void recovery(Integer id) {
		Menu menu = menuRepository.updateDeletedById(id);
	}

	@Override
	public void delete(Integer id) {
		menuRepository.deleteById(id);
	}
}
