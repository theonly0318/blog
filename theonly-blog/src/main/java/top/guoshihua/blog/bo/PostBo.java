package top.guoshihua.blog.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import top.guoshihua.blog.entity.Category;
import top.guoshihua.blog.entity.Post;
import top.guoshihua.blog.entity.Tag;

import java.util.List;

/**
 * @ClassName PostBo
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/8 0008 下午 5:27
 * @Version V1.0
 * @See 版权声明
 **/
@Data
@NoArgsConstructor
@ToString
public class PostBo extends Post {

    private List<Category> categoryList;
    private List<Tag> tagList;
}
