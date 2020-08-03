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
@Table(name = "tb_comment")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment implements Serializable {

	private static final long serialVersionUID =  737730970906981921L;
	@Id
	@GeneratedValue(generator = "JDBC", strategy = GenerationType.IDENTITY)
	private Long id;

	/**类型（0：公开，1：私密）*/
	private Integer type;

	/**评论者*/
	private String author;

	/**评论者主页url*/
	@Column(name = "author_url")
	private String authorUrl;

	/**评论内容*/
	private String content;

	/**评论者邮箱*/
	private String email;

	/**评论者 在Gravatar网站上注册的邮箱的MD5值*/
	@Column(name = "gravatar_md5")
	private String gravatarMd5;

	/**评论者ip地址*/
	@Column(name = "ip_address")
	private String ipAddress;

	/**评论者是否是管理员（0：不是，1：是）*/
	@Column(name = "is_admin")
	private Boolean isAdmin;

	/**父级评论id（0：该评论是一级评论）*/
	@Column(name = "parent_id")
	private Long parentId;

	/**文章id*/
	@Column(name = "post_id")
	private Integer postId;

	/**评论状态*/
	private Integer status;

	/**制定顺序（0：不置顶）*/
	@Column(name = "top_priority")
	private Integer topPriority;

	/**浏览器user_agent*/
	@Column(name = "user_agent")
	private String userAgent;

	/**是否允许通知（0：不允许；1：允许）*/
	@Column(name = "allow_notification")
	private Boolean allowNotification;

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
