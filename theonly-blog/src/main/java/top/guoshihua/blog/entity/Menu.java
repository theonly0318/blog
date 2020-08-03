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
@Table(name = "tb_menu")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu implements Serializable {

	private static final long serialVersionUID =  1741427104893386523L;
	@Id
	@GeneratedValue(generator = "JDBC", strategy = GenerationType.IDENTITY)
	private Integer id;

	/**菜单图标*/
	private String icon;

	/**菜单名称*/
	private String name;

	/**父级菜单（0：一级菜单）*/
	@Column(name = "parent_id")
	private Integer parentId;

	/**菜单优先级*/
	private Integer priority;

	/**菜单打开方式（_self、_black、_parent、_top）*/
	private String target;

	/**菜单分组名称*/
	private String team;

	/**菜单url*/
	private String url;

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
