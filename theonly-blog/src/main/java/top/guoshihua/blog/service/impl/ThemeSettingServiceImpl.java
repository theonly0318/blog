package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.service.ThemeSettingService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.ThemeSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class ThemeSettingServiceImpl implements ThemeSettingService {

	@Autowired
	private ThemeSettingRepository themeSettingRepository;

}
