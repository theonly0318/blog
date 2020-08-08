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
@Table(name = "tb_attachment")
@JsonIgnoreProperties(ignoreUnknown = true)
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Attachment implements Serializable {

	private static final long serialVersionUID =  8125302837527780183L;
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(length = 32)
	private String id;

	/**文件key；同path*/
	@Column(name = "file_key")
	private String fileKey;

	/**宽度（仅图片）*/
	private Integer width;

	/**高度（仅图片）*/
	private Integer height;

	/**文件类型；MIME类型：例image/jpeg*/
	@Column(name = "media_type")
	private String mediaType;

	/**文件名称*/
	private String name;

	/**文件路径*/
	private String path;

	/**文件大小*/
	private Long size;

	/**文件后缀*/
	private String suffix;

	/**文件压缩路径；文档文件同path*/
	@Column(name = "thumb_path")
	private String thumbPath;

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
