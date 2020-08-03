package top.guoshihua.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @ClassName BlogApplication
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/2 0002 下午 5:25
 * @Version V1.0
 * @See 版权声明
 **/
@SpringBootApplication
@EnableCaching
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
