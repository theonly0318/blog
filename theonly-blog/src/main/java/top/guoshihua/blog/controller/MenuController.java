package top.guoshihua.blog.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.api.MenuApi;
import top.guoshihua.blog.entity.Menu;
import top.guoshihua.blog.service.MenuService;

import java.util.List;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/menu")
public class MenuController implements MenuApi {

	@Autowired
	private MenuService menuService;

	@Override
	@GetMapping("/list")
	public List<Menu> findAll() {
		return menuService.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public Menu findById(@PathVariable("id") String id) {
		return menuService.findById(id);
	}

	@Override
	@GetMapping("/page")
	public Page<Menu> findByPage(Integer page, Integer rows, String sortBy, Boolean desc) {
		return menuService.findByPage(page, rows, sortBy, desc);
	}

	@Override
	@PostMapping("/")
	public Menu save(Menu menu) {
		return menuService.save(menu);
	}

	@Override
	@PutMapping("/{id}")
	public Menu update(@PathVariable("id") String id, Menu menu) {
		return menuService.update(id, menu);
	}

	@Override
	@GetMapping("/recovery/{id}")
	public void recovery(@PathVariable("id") String id) {
		menuService.recovery(id);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		menuService.delete(id);
	}
}
