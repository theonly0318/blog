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
@Table(name = "tb_option")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Option implements Serializable {

	private static final long serialVersionUID =  4480870356544076101L;
	@Id
	@GeneratedValue(generator = "JDBC", strategy = GenerationType.IDENTITY)
	private Integer id;

	/**参数key*/
	@Column(name = "option_key")
	private String optionKey;

	/**参数value*/
	@Column(name = "option_value")
	private String optionValue;

	/**类型*/
	private Integer type;

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
