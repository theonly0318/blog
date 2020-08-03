package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.MenuService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

}
