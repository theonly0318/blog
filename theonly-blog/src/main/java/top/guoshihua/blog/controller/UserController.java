package top.guoshihua.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.api.UserApi;
import top.guoshihua.blog.entity.User;
import top.guoshihua.blog.service.UserService;

/**
 * @author guoshihua
 */
@RestController
@RequestMapping("/user")
public class UserController implements UserApi {

	@Autowired
	private UserService userService;

	@Override
	@GetMapping("/{username}")
	public User findByUsername(@PathVariable("username") String username) {
		User user = new User();
		user.setNickname("theonly");
		user.setUsername("guoshihua");
		user.setDescription("管理员");
		return user;
	}
}
