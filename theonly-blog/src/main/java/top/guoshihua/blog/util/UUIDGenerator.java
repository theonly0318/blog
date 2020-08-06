package top.guoshihua.blog.util;

import org.springframework.stereotype.Component;
import org.springframework.util.IdGenerator;

import java.util.UUID;

/**
 * @ClassName UUIDGenerator
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/5 0005 上午 9:29
 * @Version V1.0
 * @See 版权声明
 **/
@Component
public class UUIDGenerator implements IdGenerator {
    @Override
    public UUID generateId() {
        return UUID.randomUUID();
    }
}
