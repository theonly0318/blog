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
@Table(name = "tb_meta")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta implements Serializable {

	private static final long serialVersionUID =  6319594351772589046L;
	@Id
	@GeneratedValue(generator = "JDBC", strategy = GenerationType.IDENTITY)
	private Long id;

	/**类型*/
	private Integer type;

	/**文章id*/
	@Column(name = "post_id")
	private Integer postId;

	/**key*/
	@Column(name = "meta_key")
	private String metaKey;

	/**value*/
	@Column(name = "meta_value")
	private String metaValue;

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
