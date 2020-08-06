package top.guoshihua.blog.test;
import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.guoshihua.blog.entity.Tag;
import top.guoshihua.blog.repository.TagRepository;
import top.guoshihua.blog.util.IPAddressUtils;
import top.guoshihua.blog.util.IdWorker;
import top.guoshihua.blog.util.UUIDGenerator;
import top.guoshihua.blog.util.UuidUtil;

import java.util.UUID;

/**
 * @ClassName BlogApplicationTest
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/5 0005 上午 9:24
 * @Version V1.0
 * @See 版权声明
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTest {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private UUIDGenerator uuidGenerator;
    @Autowired
    private TagRepository repository;

    @Test
    public void idWorkerTest() {
        long l = idWorker.nextId();
        System.out.println(l);
    }

    @Test
    public void uuidTest() {
        UUID uuid = uuidGenerator.generateId();
        String s = UuidUtil.UUID2Str(uuid);
        System.out.println(s);
    }

    @Test
    public void tagTest() {
        Tag tag = new Tag();
        tag.setName("Spring");
        tag.setSlugName("Spring");
        tag.setDeleted(false);
        Tag tag1 = repository.saveAndFlush(tag);
        System.out.println(tag1);

    }

    @Test
    public void ipLocationTest() {

    }
}
