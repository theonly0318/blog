package top.guoshihua.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
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
@Table(name = "tb_tag")
@JsonIgnoreProperties(ignoreUnknown = true)
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@ApiModel(value = "标签tag对象", description = "标签tag对象")
public class Tag implements Serializable {

	private static final long serialVersionUID =  3547899679415179613L;
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(length = 32)
	private String id;

	/**标签名称*/
	@ApiModelProperty(value = "标签名称", name = "name", required = true)
	private String name;

	/**标签别名*/
	@Column(name = "slug_name")
	@ApiModelProperty(value = "标签别名", name = "slugName", required = true)
	private String slugName;

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
	private List<Post> postList;

}
