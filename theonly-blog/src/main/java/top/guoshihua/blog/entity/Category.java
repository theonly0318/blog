package top.guoshihua.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@Table(name = "tb_category")
@JsonIgnoreProperties(value={"createTime", "updateTime"})
// @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
// 通用mapper值只允许以下几种形式:
// 	1.useGeneratedKeys的@GeneratedValue(generator=\"JDBC\")
//	2.类似mysql数据库的@GeneratedValue(strategy=GenerationType.IDENTITY[,generator="Mysql"])
@ApiModel(value = "category对象", description = "category实体对象")
public class Category implements Serializable {

	private static final long serialVersionUID =  2474835121656903754L;
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(length = 32)
	// @ApiModelProperty(hidden = true)
	private String id;

	/**分类名称*/
	@ApiModelProperty(value = "分类名称", name = "name", required = true, example = "Java")
	private String name;

	/**分类别名（全英文）*/
	@Column(name = "slug_name")
	@ApiModelProperty(value = "分类别名（全英文）", name = "slugName", required = true, example = "Java")
	private String slugName;

	/**父级分类id；0：父级*/
	@Column(name = "parent_id", length = 32)
	@ApiModelProperty(value = "父级分类id；默认为null：父级", name = "parentId")
	private String parentId;

	/**描述*/
	@ApiModelProperty(value = "父级描述", name = "description", example = "Java")
	private String description;

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

}
