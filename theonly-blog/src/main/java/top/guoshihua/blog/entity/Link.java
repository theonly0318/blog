package top.guoshihua.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

/**
 * @author Administrator
 */
@Data
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "tb_link")
@JsonIgnoreProperties(ignoreUnknown = true)
// @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@ApiModel(value = "link对象", description = "友情链接实体类")
public class Link implements Serializable {

	private static final long serialVersionUID =  5811438209153191790L;
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(length = 32)
	private String id;

	/**链接名称*/
	@ApiModelProperty(value = "链接名称", name = "name", required = true, example = "Spring")
	private String name;

	/**链接url*/
	@ApiModelProperty(value = "链接url", name = "url", required = true, example = "spring.io")
	private String url;

	/**链接logo*/
	@ApiModelProperty(value = "链接logo，默认为空", name = "logo")
	private String logo;

	/**链接描述*/
	@ApiModelProperty(value = "链接描述", name = "description", example = "Spring官网")
	private String description;

	/**链家优先级*/
	@ApiModelProperty(value = "链接排序优先级，默认为0：不设优先级", name = "priority", example = "0")
	private Integer priority;

	/**链接分组*/
	@ApiModelProperty(value = "链接分组名称", name = "team", example = "Java开发框架")
	private String team;

	/**创建时间*/
	@Column(name = "create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Transient
	@ApiModelProperty(hidden = true)
	private java.util.Date createTime;

	/**最后修改时间*/
	@Column(name = "update_time")
	//@CreatedDate
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Transient
	@ApiModelProperty(hidden = true)
	private java.util.Date updateTime;

	/**是否已删除（回收站）*/
	@Transient
	@ApiModelProperty(hidden = true)
	private Boolean deleted;

}
