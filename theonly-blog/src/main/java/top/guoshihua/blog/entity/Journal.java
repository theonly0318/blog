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
@Table(name = "tb_journal")
@JsonIgnoreProperties(ignoreUnknown = true)
// @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Journal implements Serializable {

	private static final long serialVersionUID =  5310415413521456293L;
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(length = 32)
	private Integer id;

	/**说说内容*/
	private String content;

	/**说说源内容*/
	@Column(name = "source_content")
	private String sourceContent;

	/**喜欢数*/
	private Long likes;

	/**类型（0：公开；1：私密）*/
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
