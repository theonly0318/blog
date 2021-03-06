package top.guoshihua.blog.bo;

import lombok.Data;
import lombok.ToString;
import top.guoshihua.blog.entity.Category;
import top.guoshihua.blog.entity.Post;

import java.util.List;

/**
 * @ClassName CategoryBo
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/8 0008 上午 11:19
 * @Version V1.0
 * @See 版权声明
 **/
@Data
@ToString
public class CategoryBo extends Category {
    private List<Post> postList;
    private Long postCount;
}
