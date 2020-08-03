package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.service.PhotoService;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/photo")
public class PhotoController {

	@Autowired
	private PhotoService photoService;

}
