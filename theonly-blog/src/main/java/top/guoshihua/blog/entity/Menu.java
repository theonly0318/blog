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
@Table(name = "tb_menu")
@JsonIgnoreProperties(ignoreUnknown = true)
// @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@ApiModel(value = "menu实体对象", description = "menu实体对象")
public class Menu implements Serializable {

	private static final long serialVersionUID =  1741427104893386523L;
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(length = 32)
	private String id;

	/**菜单图标*/
	@ApiModelProperty(value = "菜单图标", name = "icon")
	private String icon;

	/**菜单名称*/
	@ApiModelProperty(value = "菜单名称", name = "name", required = true, example = "图库")
	private String name;

	/**父级菜单（0：一级菜单）*/
	@Column(name = "parent_id")
	@ApiModelProperty(value = "父级菜单", name = "url")
	private Integer parentId;

	/**菜单优先级*/
	@ApiModelProperty(value = "菜单优先级", name = "priority")
	private Integer priority;

	/**菜单打开方式（_self、_black、_parent、_top）*/
	@ApiModelProperty(value = "菜单打开方式", name = "target", allowableValues = "_self,_black,_parent,_top")
	private String target;

	/**菜单分组名称*/
	@ApiModelProperty(value = "菜单分组名称", name = "team")
	private String team;

	/**菜单url*/
	@ApiModelProperty(value = "菜单url", name = "url", required = true)
	private String url;

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
