package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.service.ThemeSettingService;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/themeSetting")
public class ThemeSettingController {

	@Autowired
	private ThemeSettingService themeSettingService;

}
