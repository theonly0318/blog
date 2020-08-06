package top.guoshihua.blog.config;

import com.github.jarod.qqwry.QQWry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.guoshihua.blog.util.IPAddressUtils;
import top.guoshihua.blog.util.IPSeeker;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @ClassName QQWryConfig
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/5 0005 下午 3:33
 * @Version V1.0
 * @See 版权声明
 **/
@Configuration
public class QQWryConfig {

    @Value("${qqwry.dat.file.path}")
    private String filePath;
    @Value("${qqwry.dat.file.name}")
    private String fileName;

    @Bean
    public QQWry qqWry() throws IOException {
        return new QQWry(Paths.get(filePath+fileName));
    }

    @Bean
    public IPSeeker ipSeeker() {
        return new IPSeeker(fileName, filePath);
    }

    @Bean
    public IPAddressUtils ipAddressUtils() {
        return new IPAddressUtils(fileName, filePath);
    }
}
