package top.guoshihua.blog.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName PostStatus
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/8 0008 下午 5:08
 * @Version V1.0
 * @See 版权声明
 **/
@Data
@Entity
@Table(name = "tb_post_status")
public class PostStatus {

    @Id
    private Integer id;
    private String name;
}
