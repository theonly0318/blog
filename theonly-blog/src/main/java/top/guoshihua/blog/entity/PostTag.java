package top.guoshihua.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @author Administrator
 */
@Data
@Entity
@Table(name = "tb_post_tag")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostTag implements Serializable {

	private static final long serialVersionUID =  411913157868520382L;
	@Id
	@GeneratedValue(generator = "JDBC", strategy = GenerationType.IDENTITY)
	private Integer id;

	/**文章id*/
	@Column(name = "post_id")
	private Integer postId;

	/**标签id*/
	@Column(name = "tag_id")
	private Integer tagId;

	/**创建时间*/
	@Column(name = "create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;

	/**最后修改时间*/
	@Column(name = "update_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateTime;

	/**是否已删除（回收站）*/
	private Boolean deleted;

}
