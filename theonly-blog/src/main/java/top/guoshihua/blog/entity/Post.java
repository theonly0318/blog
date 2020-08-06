package top.guoshihua.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Administrator
 */
@Data
@Entity
@Table(name = "tb_post")
@JsonIgnoreProperties(ignoreUnknown = true, value={"password"})
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Post implements Serializable {

	private static final long serialVersionUID =  7780977340627124027L;
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(length = 32)
	private String id;

	/**类型*/
	private Integer type;

	/**创建渠道*/
	@Column(name = "create_from")
	private Integer createFrom;

	/**文章标题*/
	private String title;

	/**原始内容*/
	@Column(name = "original_content")
	private String originalContent;

	/**格式化内容*/
	@Column(name = "format_content")
	private String formatContent;

	/**访问密码*/
	private String password;

	/**摘要总结*/
	private String summary;

	/**文章模板*/
	private String template;

	/**文章缩略图*/
	private String thumbnail;

	/**文章url*/
	private String url;

	/**编辑时间*/
	@Column(name = "edit_time")
	private java.util.Date editTime;

	/**文章状态（0：草稿；1：已发布；2：回收站；3：私密）*/
	private Integer status;

	/**置顶顺序（0：不置顶）*/
	@Column(name = "top_priority")
	private Integer topPriority;

	/**是否允许评论（0：不允许，1：允许）*/
	@Column(name = "disallow_comment")
	private Integer disallowComment;

	/**喜欢数*/
	private Long likes;

	/**浏览数*/
	private Long visits;

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
