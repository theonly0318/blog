package top.guoshihua.blog.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import top.guoshihua.blog.dao.MenuMapper;
import top.guoshihua.blog.entity.Menu;
import top.guoshihua.blog.service.MenuService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.util.UuidUtil;

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
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> findAll() {
		return menuRepository.findAll();
	}

	@Override
	public Menu findById(String id) {
		return menuRepository.findById(id).get();
	}

	@Override
	public Page<Menu> findByPage(Integer page, Integer rows, String sortBy, Boolean desc) {
		return null;
	}

	@Override
	public Menu save(Menu menu) {
		Menu c = menuRepository.findFirstByName(menu.getName());
		if (c != null) {
			return null;
		}
		String id = UuidUtil.getUUIDStr();
		menu.setId(id);
		menuMapper.insertSelective(menu);
		return menuRepository.findById(id).get();
	}

	@Override
	public Menu update(String id, Menu menu) {

		Menu menu1 = menuRepository.findById(id).get();
		menu.setId(menu1.getId());
		menuMapper.updateByPrimaryKeySelective(menu);
		return menuMapper.selectByPrimaryKey(id);

	}

	@Override
	public void recovery(String id) {
		Menu menu = menuRepository.updateDeletedById(id);
	}

	@Override
	public void delete(String id) {
		menuRepository.deleteById(id);
	}
}
