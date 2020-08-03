package top.guoshihua.blog.repository;

import top.guoshihua.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author guoshihua
 */
public interface UserRepository extends JpaRepository<User, Integer>{

    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return
     */
    User findByUsername(String username);
}
