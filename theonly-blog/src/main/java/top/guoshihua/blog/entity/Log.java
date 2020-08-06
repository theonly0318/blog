package top.guoshihua.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "tb_log")
@JsonIgnoreProperties(ignoreUnknown = true)
// @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Log implements Serializable {

	private static final long serialVersionUID =  5168448980232866390L;
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(length = 32)
	private String id;

	/**操作内容*/
	private String content;

	/**ip地址*/
	@Column(name = "ip_address")
	private String ipAddress;

	/**key*/
	@Column(name = "log_key")
	private String logKey;

	/**类型（5、10、15...50）*/
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
