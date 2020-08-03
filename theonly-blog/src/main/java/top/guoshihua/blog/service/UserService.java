package top.guoshihua.blog.service;

import top.guoshihua.blog.entity.User;

/**
 * @author guoshihua
 */
public interface UserService  {

    User findByUserName(String username);
}
