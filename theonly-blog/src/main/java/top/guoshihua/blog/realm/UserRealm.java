package top.guoshihua.blog.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import top.guoshihua.blog.entity.User;
import top.guoshihua.blog.service.UserService;
import top.guoshihua.blog.util.MD5Utils;

/**
 * @ClassName UserRealm
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/3 0003 下午 6:48
 * @Version V1.0
 * @See 版权声明
 **/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户输入的用户名和密码
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        System.out.println("用户" + username + "认证-----ShiroRealm.doGetAuthenticationInfo");

        // 通过用户名到数据库查询用户信息
        User user = userService.findByUserName(username);

        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        ByteSource salt = ByteSource.Util.bytes(user.getSalt());
//        if (!MD5Utils.md5Hash(password, user.getSalt()).equals(user.getPassword())) {
//            throw new IncorrectCredentialsException("用户名或密码错误！");
//        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), salt, getName());
        return info;
    }
}
