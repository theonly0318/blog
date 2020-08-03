package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.service.OptionService;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/option")
public class OptionController {

	@Autowired
	private OptionService optionService;

}
