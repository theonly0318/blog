package top.guoshihua.blog.service.impl;

import top.guoshihua.blog.entity.User;
import top.guoshihua.blog.service.UserService;
import org.springframework.stereotype.Service;
import top.guoshihua.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author guoshihua
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}
}
