package top.guoshihua.blog.util;

import org.springframework.util.IdGenerator;

import java.util.UUID;

/**
 * @ClassName UuidUtil
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/5 0005 上午 9:29
 * @Version V1.0
 * @See 版权声明
 **/
public class UuidUtil implements IdGenerator {

    @Override
    public UUID generateId() {
        return null;
    }

    public static String getUUIDStr(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        str = str.replaceAll("-", "");
        return str;
    }

    public static String UUID2Str(UUID uuid){
        String str = uuid.toString();
        str = str.replaceAll("-", "");
        return str;
    }
}
