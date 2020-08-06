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
@Table(name = "tb_user")
@JsonIgnoreProperties(ignoreUnknown = true, value={"password"})
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User implements Serializable {

	private static final long serialVersionUID =  1503648493417714349L;
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(length = 32)
	private String id;

	/**昵称*/
	private String nickname;

	/**用户名*/
	private String username;

	/**密码*/
	private String password;

	/**盐*/
	private String salt;

	/**头像*/
	private String avatar;

	/**邮箱*/
	private String email;

	/**描述*/
	private String description;

	/**过期时间*/
	@Column(name = "expire_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date expireTime;

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
