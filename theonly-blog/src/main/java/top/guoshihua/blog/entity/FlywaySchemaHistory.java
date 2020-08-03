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
@Table(name = "tb_flyway_schema_history")
@JsonIgnoreProperties(ignoreUnknown = true, value={})
public class FlywaySchemaHistory implements Serializable {

	private static final long serialVersionUID =  2654437091387185692L;
	@Id
	@GeneratedValue( generator = "JDBC", strategy = GenerationType.IDENTITY)
	/**主键、安装等级*/
	@Column(name = "installed_rank")
	private Integer installedRank;

	/**版本*/
	private String version;

	/**描述*/
	private String description;

	/**类型*/
	private String type;

	/**脚本*/
	private String script;

	/**校验和*/
	private Integer checksum;

	/**安装者*/
	@Column(name = "installed_by")
	private String installedBy;

	/**安装时间*/
	@Column(name = "installed_on")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date installedOn;

	/**执行次数*/
	@Column(name = "execution_time")
	private Integer executionTime;

	/**是否成功（0：失败；1：成功）*/
	private Boolean success;

}
