package top.guoshihua.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

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
	@ApiModelProperty(value = "type", name = "类型", notes = "博客文章类型；0：公开；1：私密", allowableValues = "0,1")
	private Integer type;

	/**创建渠道*/
	@Column(name = "create_from")
	@ApiModelProperty(value = "type", name = "创建渠道", allowableValues = "0,1")
	private Integer createFrom;

	/**文章标题*/
	@ApiModelProperty(value = "title", name = "标题", notes = "博客文章标题", required = true)
	private String title;

	/**原始内容*/
	@Column(name = "original_content")
	@ApiModelProperty(value = "originalContent", name = "原始内容", notes = "博客文章原始内容", required = true)
	private String originalContent;

	/**格式化内容*/
	@Column(name = "format_content")
	@ApiModelProperty(value = "formatContent", name = "格式化内容", notes = "博客文章格式化内容")
	private String formatContent;

	/**访问密码*/
	@ApiModelProperty(value = "password", name = "访问密码", notes = "博客文章访问密码")
	private String password;

	/**摘要总结*/
	@ApiModelProperty(value = "summary", name = "摘要总结", notes = "博客文章摘要总结")
	private String summary;

	/**文章模板*/
	@ApiModelProperty(value = "template", name = "模板", notes = "博客文章模板")
	private String template;

	/**文章缩略图*/
	@ApiModelProperty(value = "thumbnail", name = "缩略图", notes = "博客文章缩略图")
	private String thumbnail;

	/**文章url*/
	@ApiModelProperty(value = "url", name = "url", notes = "博客文章访问url")
	private String url;

	/**编辑时间*/
	@Column(name = "edit_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(hidden = true)
	private java.util.Date editTime;

	/**文章状态（0：草稿；1：已发布；2：回收站；3：私密）*/
	@ApiModelProperty(value = "status", name = "状态", notes = "博客文章状态(0：草稿；1：已发布；2：回收站；3：私密)",
			allowableValues = "0,1,2,3")
	private Integer status;

	/**置顶顺序（0：不置顶）*/
	@Column(name = "top_priority")
	@ApiModelProperty(value = "topPriority", name = "置顶顺序", notes = "博客文章置顶顺序（0：不置顶）", dataType = "Integer")
	private Integer topPriority;

	/**是否允许评论（0：不允许，1：允许）*/
	@Column(name = "disallow_comment")
	@ApiModelProperty(value = "topPriority", name = "是否允许评论", notes = "博客文章是否允许评论（0：不允许，1：允许）",
			allowableValues = "0,1", dataType = "Integer")
	private Integer disallowComment;

	/**喜欢数*/
	@ApiModelProperty(hidden = true)
	private Long likes;

	/**浏览数*/
	@ApiModelProperty(hidden = true)
	private Long visits;

	/**创建时间*/
	@Column(name = "create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(hidden = true)
	private java.util.Date createTime;

	/**最后修改时间*/
	@Column(name = "update_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(hidden = true)
	private java.util.Date updateTime;

	/**是否已删除（回收站）*/
	@ApiModelProperty(hidden = true)
	private Boolean deleted;

	@Transient
	private List<Tag> tagList;

	@Transient
	private List<Comment> commentList;

	@Transient
	private String statusName;

}
