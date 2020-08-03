SET NAMES utf8mb4; $$$
SET FOREIGN_KEY_CHECKS = 0;$$$
CREATE TABLE IF NOT EXISTS `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '昵称',
  `username` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `avatar` varchar(1023) COLLATE utf8mb4_bin DEFAULT '' COMMENT '头像',
  `email` varchar(127) COLLATE utf8mb4_bin DEFAULT '' COMMENT '邮箱',
  `description` varchar(1023) COLLATE utf8mb4_bin DEFAULT '' COMMENT '描述',
  `expire_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;$$$

CREATE TABLE IF NOT EXISTS `tb_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '分类名称',
  `slug_name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '分类别名（全英文）',
  `parent_id` int(11) DEFAULT '0' COMMENT '父级分类id；0：父级',
  `description` varchar(100) COLLATE utf8mb4_bin DEFAULT '' COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '分类表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '标签名称',
  `slug_name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '标签别名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '标签表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '类型',
  `create_from` int(11) DEFAULT '0' COMMENT '创建渠道',
  `title` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '文章标题',
  `original_content` text COLLATE utf8mb4_bin NOT NULL COMMENT '原始内容',
  `format_content` text COLLATE utf8mb4_bin NOT NULL COMMENT '格式化内容',
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '访问密码',
  `summary` varchar(500) COLLATE utf8mb4_bin DEFAULT '' COMMENT '摘要总结',
  `template` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '文章模板',
  `thumbnail` varchar(1023) COLLATE utf8mb4_bin DEFAULT '' COMMENT '文章缩略图',
  `url` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '文章url',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
  `status` int(11) DEFAULT '1' COMMENT '文章状态（0：草稿；1：已发布；2：回收站；3：私密）',
  `top_priority` int(11) DEFAULT '0' COMMENT '置顶顺序（0：不置顶）',
  `disallow_comment` int(11) DEFAULT '0' COMMENT '是否允许评论（0：不允许，1：允许）',
  `likes` bigint(20) DEFAULT '0' COMMENT '喜欢数',
  `visits` bigint(20) DEFAULT '0' COMMENT '浏览数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '文章表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_post_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) DEFAULT NULL COMMENT '文章id',
  `category_id` int(11) DEFAULT NULL COMMENT '分类id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '文章分类表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_post_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL COMMENT '文章id',
  `tag_id` int(11) NOT NULL COMMENT '标签id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '文章标签表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '类型（0：公开，1：私密）',
  `author` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '评论者',
  `author_url` varchar(512) COLLATE utf8mb4_bin DEFAULT '' COMMENT '评论者主页url',
  `content` varchar(1023) COLLATE utf8mb4_bin NOT NULL COMMENT '评论内容',
  `email` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '评论者邮箱',
  `gravatar_md5` varchar(128) COLLATE utf8mb4_bin DEFAULT '' COMMENT '评论者 在Gravatar网站上注册的邮箱的MD5值',
  `ip_address` varchar(127) COLLATE utf8mb4_bin DEFAULT '' COMMENT '评论者ip地址',
  `is_admin` tinyint(4) DEFAULT '0' COMMENT '评论者是否是管理员（0：不是，1：是）',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父级评论id（0：该评论是一级评论）',
  `post_id` int(11) NOT NULL COMMENT '文章id',
  `status` int(11) DEFAULT '1' COMMENT '评论状态',
  `top_priority` int(11) DEFAULT '0' COMMENT '制定顺序（0：不置顶）',
  `user_agent` varchar(512) COLLATE utf8mb4_bin DEFAULT '' COMMENT '浏览器user_agent',
  `allow_notification` tinyint(4) DEFAULT '1' COMMENT '是否允许通知（0：不允许；1：允许）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '文章评论表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '图片名称',
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '图片描述',
  `location` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '图片位置',
  `take_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  `team` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '图片分组',
  `thumbnail` varchar(1023) COLLATE utf8mb4_bin DEFAULT '' COMMENT '图片缩略图',
  `url` varchar(1023) COLLATE utf8mb4_bin NOT NULL COMMENT '图片url',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '图库表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_key` varchar(2047) COLLATE utf8mb4_bin DEFAULT '' COMMENT '文件key；同path',
  `width` int(11) DEFAULT '0' COMMENT '宽度（仅图片）',
  `height` int(11) DEFAULT '0' COMMENT '高度（仅图片）',
  `media_type` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '文件类型；MIME类型：例image/jpeg',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '文件名称',
  `path` varchar(1023) COLLATE utf8mb4_bin NOT NULL COMMENT '文件路径',
  `size` bigint(20) NOT NULL COMMENT '文件大小',
  `suffix` varchar(50) COLLATE utf8mb4_bin DEFAULT '' COMMENT '文件后缀',
  `thumb_path` varchar(1023) COLLATE utf8mb4_bin DEFAULT '' COMMENT '文件压缩路径；文档文件同path',
  `type` int(11) DEFAULT '0' COMMENT '类型（0：公开；1：私密）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '附件表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '链接名称',
  `url` varchar(1023) COLLATE utf8mb4_bin NOT NULL COMMENT '链接url',
  `logo` varchar(1023) COLLATE utf8mb4_bin DEFAULT '' COMMENT '链接logo',
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '链接描述',
  `priority` int(11) DEFAULT '0' COMMENT '链家优先级',
  `team` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '链接分组',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '链接表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_journal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text COLLATE utf8mb4_bin NOT NULL  COMMENT '说说内容',
  `source_content` varchar(1023) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '说说源内容',
  `likes` bigint(20) DEFAULT '0' COMMENT '喜欢数',
  `type` int(11) DEFAULT '1' COMMENT '类型（0：公开；1：私密）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '说说表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(1023) COLLATE utf8mb4_bin NOT NULL COMMENT '操作内容',
  `ip_address` varchar(127) COLLATE utf8mb4_bin DEFAULT '' COMMENT 'ip地址',
  `log_key` varchar(1023) COLLATE utf8mb4_bin DEFAULT '' COMMENT 'key',
  `type` int(11) NOT NULL COMMENT '类型（5、10、15...50）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '操作记录表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `option_key` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '参数key',
  `option_value` varchar(1023) COLLATE utf8mb4_bin NOT NULL COMMENT '参数value',
  `type` int(11) DEFAULT '0' COMMENT '类型',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '博客参数表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_theme_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `setting_key` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT 'key',
  `theme_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '主题',
  `setting_value` varchar(10239) COLLATE utf8mb4_bin NOT NULL COMMENT 'value',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '主题设置表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(50) COLLATE utf8mb4_bin DEFAULT '' COMMENT '菜单图标',
  `name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT '0' COMMENT '父级菜单（0：一级菜单）',
  `priority` int(11) DEFAULT '0' COMMENT '菜单优先级',
  `target` varchar(20) COLLATE utf8mb4_bin DEFAULT '_self' COMMENT '菜单打开方式（_self、_black、_parent、_top）',
  `team` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '菜单分组名称',
  `url` varchar(1023) COLLATE utf8mb4_bin NOT NULL COMMENT '菜单url',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '主题设置表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_flyway_schema_history` (
  `installed_rank` int(11) NOT NULL COMMENT '主键、安装等级',
  `version` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '版本',
  `description` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT '描述',
  `type` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '类型',
  `script` varchar(1000) COLLATE utf8mb4_bin NOT NULL COMMENT '脚本',
  `checksum` int(11) DEFAULT NULL COMMENT '校验和',
  `installed_by` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '安装者',
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '安装时间',
  `execution_time` int(11) NOT NULL COMMENT '执行次数',
  `success` tinyint(1) NOT NULL COMMENT '是否成功（0：失败；1：成功）',
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '历史版本表' ROW_FORMAT=DYNAMIC;$$$

CREATE TABLE IF NOT EXISTS `tb_meta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '类型',
  `post_id` int(11) NOT NULL COMMENT '文章id',
  `meta_key` varchar(100) COLLATE utf8mb4_bin NOT NULL  COMMENT 'key',
  `meta_value` varchar(1023) COLLATE utf8mb4_bin NOT NULL COMMENT 'value',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted` tinyint(4) DEFAULT '0' COMMENT '是否已删除（回收站）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '文章元数据表' ROW_FORMAT=DYNAMIC;$$$

SET FOREIGN_KEY_CHECKS = 1;$$$