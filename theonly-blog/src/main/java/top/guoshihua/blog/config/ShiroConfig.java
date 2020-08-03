package top.guoshihua.blog.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.guoshihua.blog.realm.UserRealm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/3 0003 下午 6:49
 * @Version V1.0
 * @See 版权声明
 **/
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.setLoginUrl("/admin/login"); // 登录url
        shiroFilterFactoryBean.setSuccessUrl("/admin/index"); // 登录成功url
        shiroFilterFactoryBean.setUnauthorizedUrl("/403"); // 没有授权url

        //添加Shiro内置过滤器
        Map<String,String> filterMap = new LinkedHashMap<String,String>();
        // 定义filterChain，静态资源不拦截
        filterMap.put("/css/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/fonts/**", "anon");
        filterMap.put("/img/**", "anon");

        // 配置退出过滤器，其中具体的退出代码Shiro已经替我们实现了
        filterMap.put("/admin/logout", "logout");
        filterMap.put("/**", "anon");
        // 除上以外所有url都必须认证通过(管理员身份)才可以访问，未通过认证自动访问LoginUrl
        filterMap.put("/admin/**", "admin");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);


        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name="userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

}
