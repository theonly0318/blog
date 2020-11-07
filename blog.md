# 一、数据库表



## 1、博客参数表

tb_options

| 字段         | 数据类型      | 描述   | 是否null | 默认值 | 其他              |
| ------------ | ------------- | ------ | -------- | ------ | ----------------- |
| id           | int(11)       | 主键id | no       |        | AUTO_INCREMENT    |
| option_key   | varchar(100)  | key    | no       |        | utf8mb4_bin       |
| option_value | varchar(1023) | value  | no       |        | utf8mb4_bin       |
| type         | int(11)       | 类型   | yes      | 0      |                   |
| create_time  | timestamp     |        | no       |        | CURRENT_TIMESTAMP |
| update_time  | timestamp     |        | no       |        | CURRENT_TIMESTAMP |
| deleted      | tinyint(4)    |        | yes      | 0      |                   |



```sql
CREATE TABLE `options` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `option_key` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `option_value` varchar(1023) COLLATE utf8mb4_bin NOT NULL,
  `type` int(11) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```



## 2、主题设置表

tb_theme_settings

| 字段          | 数据类型       | 描述   | 是否null | 默认值 | 其他              |
| ------------- | -------------- | ------ | -------- | ------ | ----------------- |
| id            | int(11)        | 主键id | no       |        | AUTO_INCREMENT    |
| setting_key   | varchar(255)   | key    | no       |        | utf8mb4_bin       |
| setting_value | varchar(10239) | value  | no       |        |                   |
| theme_id      | varchar(255)   | 主题id | no       |        |                   |
| create_time   | timestamp      |        | no       |        | CURRENT_TIMESTAMP |
| update_time   | timestamp      |        | no       |        | CURRENT_TIMESTAMP |
| deleted       | tinyint(4)     |        | yes      | 0      |                   |



```sql
CREATE TABLE `theme_settings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `setting_key` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `theme_id` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `setting_value` varchar(10239) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```





## 1、菜单表

tb_menu

| 字段        | 数据类型      | 描述           | 是否null | 默认值 | 其他                           |
| ----------- | ------------- | -------------- | -------- | ------ | ------------------------------ |
| id          | int(11)       | 主键id         | no       |        | AUTO_INCREMENT                 |
| name        | varchar(50)   | 名称           | no       |        | utf8mb4_bin                    |
| icon        | varchar(50)   | 图标           | yes      | ''     |                                |
| parent_id   | int(11)       | 父级菜单id     | yes      | 0      |                                |
| priority    | int(11)       | 优先级（排序） | yes      | 0      |                                |
| target      | varchar(20)   | 页面打开方式   | yes      | _self  | \_self、_black、\_parent、_top |
| team        | varchar(255)  | 分组           | yes      | ''     |                                |
| url         | varchar(1023) | url            | no       |        |                                |
| create_time | timestamp     |                | no       |        | CURRENT_TIMESTAMP              |
| update_time | timestamp     |                | no       |        | CURRENT_TIMESTAMP              |
| deleted     | tinyint(4)    |                | yes      | 0      |                                |



```sql
CREATE TABLE `menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `icon` varchar(50) COLLATE utf8mb4_bin DEFAULT '',
  `name` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `parent_id` int(11) DEFAULT '0',
  `priority` int(11) DEFAULT '0',
  `target` varchar(20) COLLATE utf8mb4_bin DEFAULT '_self',
  `team` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `url` varchar(1023) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```





## 1、用户表

tb_user

| 字段         | 数据类型      | 描述             | 是否null | 默认值            | 其他              |
| ------------ | ------------- | :--------------- | -------- | ----------------- | ----------------- |
| id           | int           | 主键id           | no       |                   |                   |
| username     | varchar(64)   | 用户名           | no       |                   | 编码：utf8mb4_bin |
| password     | varchar(64)   | 密码（加盐加密） | no       |                   | 编码：utf8mb4_bin |
| created_time | timestamp     | 创建时间         | no       | CURRENT_TIMESTAMP |                   |
| avatar       | varchar(1023) | 头像             | yes      | ''                | 编码：utf8mb4_bin |
| description  | varchar(1023) | 描述             | yes      | ''                | 编码：utf8mb4_bin |
| email        | varchar(127)  | 邮箱             | yes      | ''                | 编码：utf8mb4_bin |
| nickname     | varchar(255)  | 昵称             | no       |                   | 编码：utf8mb4_bin |
| update_time  | timestamp     | 最后修改时间     | no       | CURRENT_TIMESTAMP |                   |
| expire_time  | timestamp     | 过期时间         | no       | CURRENT_TIMESTAMP |                   |
| deleted      | tinyint(4)    | 是否已删除       | no       | 0                 |                   |



```sql
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `avatar` varchar(1023) COLLATE utf8mb4_bin DEFAULT '',
  `description` varchar(1023) COLLATE utf8mb4_bin DEFAULT '',
  `email` varchar(127) COLLATE utf8mb4_bin DEFAULT '',
  `expire_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nickname` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```





## 2、分类表

tb_categories

| 字段        | 数据类型     | 描述     | 是否null | 默认值            | 其他           |
| ----------- | ------------ | -------- | -------- | ----------------- | -------------- |
| id          | int(11)      | 主键id   | no       |                   | AUTO_INCREMENT |
| name        | varchar(50)  | 分类名称 | no       |                   | utf8mb4_bin    |
| parent_id   | int(11)      | 父类id   | yes      | 0                 |                |
| slug_name   | varchar(50)  | 别名     | no       |                   | utf8mb4_bin    |
| description | varchar(100) | 描述     | yes      | ‘’                | utf8mb4_bin    |
| create_time | timestamp    |          | no       | CURRENT_TIMESTAMP |                |
| update_time | timestamp    |          | no       | CURRENT_TIMESTAMP |                |
| deleted     | tinyint(4)   |          | no       | 0                 |                |



```sql
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(100) COLLATE utf8mb4_bin DEFAULT '',
  `name` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `parent_id` int(11) DEFAULT '0',
  `slug_name` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```



## 3、标签表

tb_tags

| 字段        | 数据类型     | 描述         | 是否null | 默认值            | 其他           |
| ----------- | ------------ | ------------ | -------- | ----------------- | -------------- |
| id          | int(11)      | 主键id       | no       |                   | AUTO_INCREMENT |
| name        | varchar(255) | 标签名称     | no       |                   | utf8mb4_bin    |
| slug_name   | varchar(255) | 标签别名     | no       |                   | utf8mb4_bin    |
| create_time | timestamp    | 创建时间     | no       | CURRENT_TIMESTAMP |                |
| update_time | timestamp    | 最后更新时间 | no       | CURRENT_TIMESTAMP |                |
| deleted     | tinyint(4)   | 是否已删除   | yes      | 0                 |                |

```sql
CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `slug_name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```



## 4、博客表

tb_posts

| 字段             | 数据类型      | 描述         | 是否null | 默认值   | 其他                                   |
| ---------------- | ------------- | ------------ | -------- | -------- | -------------------------------------- |
| id               | int(11)       | 主键id       | no       |          | AUTO_INCREMENT                         |
| type             | int(11)       | 类型         | yes      | 0        |                                        |
| create_from      | int(11)       | 类型         | yes      | 0        |                                        |
| title            | varchar(100)  | 标题         | no       |          | utf8mb4_bin                            |
| original_content | text          | 原始内容     | no       |          | utf8mb4_bin                            |
| format_content   | test          | 格式化内容   | no       |          | utf8mb4_bin                            |
| password         | varchar(255)  | 访问密码     | yes      | ''       | utf8mb4_bin                            |
| status           | int(11)       | 状态         | yes      | 1        | 0：草稿；1：已发布；2：回收站；3：私密 |
| summary          | varchar(500)  | 摘要总结     | yes      | ''       | utf8mb4_bin                            |
| template         | varchar(255)  | 模板         | yes      | ''       | utf8mb4_bin                            |
| thumbnail        | varchar(1023) | 缩略图       | yes      | ''       | utf8mb4_bin                            |
| top_priority     | int(11)       | 置顶顺序     | yes      | 0        | 0：不置顶                              |
| url              | varchar(255)  | 文章uri      | no       |          | utf8mb4_bin                            |
| visits           | bigint(20)    | 文章浏览次数 | yes      | 0        |                                        |
| likes            | bigint(20)    | 文章喜欢数   | yes      | 0        |                                        |
| disallow_comment | int(11)       | 是否不许评论 | yes      | 0        | 0：不许评论；1：允许                   |
| edit_time        | timestamp     | 编辑时间     | no       | 当前时间 | CURRENT_TIMESTAMP                      |
| create_time      | timestamp     | 创建时间     | no       | 当前时间 | CURRENT_TIMESTAMP                      |
| update_time      | timestamp     | 最后更新时间 | no       | 当前时间 | CURRENT_TIMESTAMP                      |
| deleted          | tinyint(4)    | 是否已删除   | yes      | 0        |                                        |



```sql
CREATE TABLE `posts` (
  `type` int(11) NOT NULL DEFAULT '0',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_from` int(11) DEFAULT '0',
  `disallow_comment` int(11) DEFAULT '0',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `format_content` text COLLATE utf8mb4_bin NOT NULL,
  `likes` bigint(20) DEFAULT '0',
  `original_content` text COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `status` int(11) DEFAULT '1',
  `summary` varchar(500) COLLATE utf8mb4_bin DEFAULT '',
  `template` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `thumbnail` varchar(1023) COLLATE utf8mb4_bin DEFAULT '',
  `title` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `top_priority` int(11) DEFAULT '0',
  `url` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `visits` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```



## 5、文章分类表

tb_post_categories

| 字段        | 数据类型   | 描述         | 是否null | 默认值   | 其他              |
| ----------- | ---------- | ------------ | -------- | -------- | ----------------- |
| id          | int(11)    | 主键id       | no       |          | AUTO_INCREMENT    |
| post_id     | int(11)    | 文章id       | no       |          |                   |
| category_id | int(11)    | 分类id       | no       |          |                   |
| create_time | timestamp  | 创建时间     | no       | 当前时间 | CURRENT_TIMESTAMP |
| update_time | timestamp  | 最后更新时间 | no       | 当前时间 | CURRENT_TIMESTAMP |
| deleted     | tinyint(4) | 是否已删除   | yes      | 0        |                   |



```sql
CREATE TABLE `post_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `category_id` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=FIXED;
```



## 6、文章标签表

tb_post_tags

| 字段        | 数据类型   | 描述         | 是否null | 默认值   | 其他              |
| ----------- | ---------- | ------------ | -------- | -------- | ----------------- |
| id          | int(11)    | 主键id       | no       |          | AUTO_INCREMENT    |
| post_id     | int(11)    | 文章id       | no       |          |                   |
| tag_id      | int(11)    | 标签id       | no       |          |                   |
| create_time | timestamp  | 创建时间     | no       | 当前时间 | CURRENT_TIMESTAMP |
| update_time | timestamp  | 最后更新时间 | no       | 当前时间 | CURRENT_TIMESTAMP |
| deleted     | tinyint(4) | 是否已删除   | yes      | 0        |                   |



```sql
CREATE TABLE `post_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `post_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=FIXED;
```



## 7、评论表

tb_comments

| 字段               | 数据类型      | 描述                              | 是否null | 默认值   | 其他               |
| ------------------ | ------------- | --------------------------------- | -------- | -------- | ------------------ |
| id                 | int(11)       | 主键id                            | no       |          | AUTO_INCREMENT     |
| type               | int(11)       | 类型                              | yes      | 0        |                    |
| author             | varchar(50)   | 评论者名称                        | no       |          | utf8mb4_bin        |
| author_url         | varchar(512)  | 评论者主页url                     | yes      | ''       | utf8mb4_bin        |
| content            | varchar(1023) | 评论内容                          | no       |          | utf8mb4_bin        |
| email              | varchar(255)  | 评论者邮箱                        | no       |          | utf8mb4_bin        |
| gravatar_md5       | varchar(128)  | 在Gravatar网站上注册的邮箱的MD5值 | yes      | ''       | utf8mb4_bin        |
| ip_address         | varchar(127)  | 评论者ip地址                      | yes      | ''       |                    |
| is_admin           | tinyint(4)    | 评论者是否是管理员                | yes      | 0        | 0：不是；1：是     |
| parent_id          | int(11)       | 上级评论id                        | yes      | 0        | 0：一级评论        |
| post_id            | int(11)       | 文章id                            | no       |          |                    |
| status             | int(11)       | 状态                              | yes      | 1        |                    |
| top_priority       | int(11)       | 置顶顺序                          | yes      | 0        | 0：不置顶          |
| user_agent         | varchar(512)  |                                   | yes      | ''       |                    |
| allow_notification | tinyint(4)    | 是否允许通知                      | yes      | 1        | 0：不允许；1：允许 |
| create_time        | timestamp     | 创建时间                          | no       | 当前时间 | CURRENT_TIMESTAMP  |
| update_time        | timestamp     | 最后更新时间                      | no       | 当前时间 | CURRENT_TIMESTAMP  |
| deleted            | tinyint(4)    | 是否已删除                        | yes      | 0        |                    |



```sql
CREATE TABLE `comments` (
  `type` int(11) NOT NULL DEFAULT '0',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `author` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `author_url` varchar(512) COLLATE utf8mb4_bin DEFAULT '',
  `content` varchar(1023) COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `gravatar_md5` varchar(128) COLLATE utf8mb4_bin DEFAULT '',
  `ip_address` varchar(127) COLLATE utf8mb4_bin DEFAULT '',
  `is_admin` tinyint(4) DEFAULT '0',
  `parent_id` bigint(20) DEFAULT '0',
  `post_id` int(11) NOT NULL,
  `status` int(11) DEFAULT '1',
  `top_priority` int(11) DEFAULT '0',
  `user_agent` varchar(512) COLLATE utf8mb4_bin DEFAULT '',
  `allow_notification` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```



## 8、图库表

tb_photos

| 字段        | 数据类型      | 描述         | 是否null | 默认值   | 其他              |
| ----------- | ------------- | ------------ | -------- | -------- | ----------------- |
| id          | int(11)       | 主键id       | no       |          | AUTO_INCREMENT    |
| name        | varchar(255)  | 图片名称     | no       |          | utf8mb4_bin       |
| team        | varchar(255)  | 分组名称     | yes      | ''       | utf8mb4_bin       |
| url         | varchar(1023) | 图片链接     | no       |          | utf8mb4_bin       |
| thumbnail   | varchar(1023) | 图片缩略图   | yes      | ''       |                   |
| location    | varchar(255)  | 本地地址     | yes      | ''       | utf8mb4_bin       |
| description | varchar(255)  | 图片描述     | yes      | ''       | utf8mb4_bin       |
| take_time   | timestamp     |              | no       | 当前时间 | CURRENT_TIMESTAMP |
| create_time | timestamp     | 创建时间     | no       | 当前时间 | CURRENT_TIMESTAMP |
| update_time | timestamp     | 最后更新时间 | no       | 当前时间 | CURRENT_TIMESTAMP |
| deleted     | tinyint(4)    | 是否已删除   | yes      | 0        |                   |



```sql
CREATE TABLE `photos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `location` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `take_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `team` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `thumbnail` varchar(1023) COLLATE utf8mb4_bin DEFAULT '',
  `url` varchar(1023) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```



## 9、附件表

tb_attachments

| 字段        | 数据类型      | 描述            | 是否null | 默认值   | 其他                                  |
| ----------- | ------------- | --------------- | -------- | -------- | ------------------------------------- |
| id          | int(11)       | 主键id          | no       |          | AUTO_INCREMENT                        |
| media_type  | varchar(50)   | 媒体类型        | no       |          | utf8mb4_bin；<br>MIME类型：image/jpeg |
| name        | varchar(255)  | 文件名称        | no       |          | utf8mb4_bin                           |
| path        | varchar(1023) | 文件路径        | no       |          | utf8mb4_bin                           |
| size        | bigint(20)    | 文件大小        | no       |          |                                       |
| suffix      | varchar(50)   | 文件后缀名      | yes      | ''       | utf8mb4_bin                           |
| thumb_path  | varchar(1023) | 图片缩略图      | yes      | ''       | utf8mb4_bin；<br>文档文件同path       |
| type        | int(11)       | 类型            | yes      | 0        |                                       |
| width       | int(11)       | 图片长度        |          | 0        | 仅图片                                |
| height      | int(11)       | 图片宽度        | yes      | 0        | 仅图片                                |
| file_key    | varchar(2047) | 文件key；同path | yes      | ''       | utf8mb4_bin;                          |
| create_time | timestamp     | 创建时间        | no       | 当前时间 | CURRENT_TIMESTAMP                     |
| update_time | timestamp     | 最后更新时间    | no       | 当前时间 | CURRENT_TIMESTAMP                     |
| deleted     | tinyint(4)    | 是否已删除      | yes      | 0        |                                       |



```sql
CREATE TABLE `attachments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `file_key` varchar(2047) COLLATE utf8mb4_bin DEFAULT '',
  `height` int(11) DEFAULT '0',
  `media_type` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `path` varchar(1023) COLLATE utf8mb4_bin NOT NULL,
  `size` bigint(20) NOT NULL,
  `suffix` varchar(50) COLLATE utf8mb4_bin DEFAULT '',
  `thumb_path` varchar(1023) COLLATE utf8mb4_bin DEFAULT '',
  `type` int(11) DEFAULT '0',
  `width` int(11) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```



## 10、连接表

tb_links

| 字段        | 数据类型      | 描述         | 是否null | 默认值   | 其他              |
| ----------- | ------------- | ------------ | -------- | -------- | ----------------- |
| id          | int(11)       | 主键id       | no       |          | AUTO_INCREMENT    |
| name        | varchar(255)  | 连接名称     | no       |          | utf8mb4_bin       |
| logo        | varchar(1023) | logo         | yes      | ''       | utf8mb4_bin       |
| url         | varchar(1023) | url          | no       |          | utf8mb4_bin       |
| team        | varchar(255)  | 分组         | yes      | ''       | utf8mb4_bin       |
| description | varchar(255)  | 描述         | yes      | ''       | utf8mb4_bin       |
| priority    | int(11)       | 是否置顶     | yes      | 0        | 0：不置顶         |
| create_time | timestamp     | 创建时间     | no       | 当前时间 | CURRENT_TIMESTAMP |
| update_time | timestamp     | 最后更新时间 | no       | 当前时间 | CURRENT_TIMESTAMP |
| deleted     | tinyint(4)    | 是否已删除   | yes      | 0        |                   |



```sql
CREATE TABLE `links` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `logo` varchar(1023) COLLATE utf8mb4_bin DEFAULT '',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `priority` int(11) DEFAULT '0',
  `team` varchar(255) COLLATE utf8mb4_bin DEFAULT '',
  `url` varchar(1023) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```



## 11、说说表

tb_journals

| 字段           | 数据类型      | 描述         | 是否null | 默认值   | 其他              |
| -------------- | ------------- | ------------ | -------- | -------- | ----------------- |
| id             | int(11)       | 主键id       | no       |          | AUTO_INCREMENT    |
| content        | text          | 日志内容     | no       |          | utf8mb4_bin       |
| likes          | bigint(20)    | 喜欢数       | yes      | 0        |                   |
| type           | int(11)       | 类型         | yes      | 1        | 0：公开；1：私密  |
| source_content | varchar(1023) |              | yes      | ''       | utf8mb4_bin       |
| create_time    | timestamp     | 创建时间     | no       | 当前时间 | CURRENT_TIMESTAMP |
| update_time    | timestamp     | 最后更新时间 | no       | 当前时间 | CURRENT_TIMESTAMP |
| deleted        | tinyint(4)    | 是否已删除   | yes      | 0        |                   |



```sql
CREATE TABLE `tb_journals` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `content` text COLLATE utf8mb4_bin NOT NULL,
  `likes` bigint(20) DEFAULT '0',
  `type` int(11) DEFAULT '1',
  `source_content` varchar(1023) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```



## 12、 操作记录表

tb_logs

| 字段        | 数据类型      | 描述         | 是否null | 默认值   | 其他              |
| ----------- | ------------- | ------------ | -------- | -------- | ----------------- |
| id          | int(11)       | 主键id       | no       |          | AUTO_INCREMENT    |
| content     | text          | 日志内容     | no       |          | utf8mb4_bin       |
| ip_address  | varchar(127)  | ip地址       | yes      | ''       |                   |
| type        | int(11)       | 类型         | no       |          | 5、10、15...50    |
| log_key     | varchar(1023) | key          | yes      | ''       | utf8mb4_bin       |
| create_time | timestamp     | 创建时间     | no       | 当前时间 | CURRENT_TIMESTAMP |
| update_time | timestamp     | 最后更新时间 | no       | 当前时间 | CURRENT_TIMESTAMP |
| deleted     | tinyint(4)    | 是否已删除   | yes      | 0        |                   |



```sql
CREATE TABLE `logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `content` varchar(1023) COLLATE utf8mb4_bin NOT NULL,
  `ip_address` varchar(127) COLLATE utf8mb4_bin DEFAULT '',
  `log_key` varchar(1023) COLLATE utf8mb4_bin DEFAULT '',
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```



## 13、历史版本

| 字段           | 数据类型      | 描述             | 是否null | 默认值            | 其他                 |
| -------------- | ------------- | ---------------- | -------- | ----------------- | -------------------- |
| installed_rank | int(11)       | 主键<br>安装等级 | no       |                   |                      |
| version        | varchar(50)   | 版本             | no       |                   | utf8mb4_bin          |
| description    | varchar(200)  | 描述             | no       |                   | utf8mb4_bin          |
| type           | varchar(20)   | 类型             | no       |                   | utf8mb4_bin          |
| script         | varchar(1000) | 脚本             | no       |                   | utf8mb4_bin          |
| checksum       | int(11)       | 校验和           |          | NULL              |                      |
| installed_by   | varchar(100)  | 安装的用户       | no       |                   | utf8mb4_bin          |
| installed_on   | timestamp     | 安装时间         | no       | CURRENT_TIMESTAMP |                      |
| execution_time | int(11)       | 执行次数         | no       |                   |                      |
| success        | tinyint(1)    | 是否成功         | no       |                   | 0：失败；<br>1：成功 |



```sql
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `description` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `type` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  `script` varchar(1000) COLLATE utf8mb4_bin NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
```



## 14、metas

```sql
CREATE TABLE `metas` (
  `type` int(11) NOT NULL DEFAULT '0',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint(4) DEFAULT '0',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `meta_key` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `post_id` int(11) NOT NULL,
  `meta_value` varchar(1023) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
```





# 二、前台接口

## 1、首页

url：/

method：GET

请求参数：

响应数据：JSON

```json
{
	blog_title: "",
	blog_logo: "",
	nickname: "",
	user_location: "",
	github_url: "",
	qq: "",
	weibo: "",
	email: "",
	postCount: 0,
	categoryCount: 0,
	tagCount: 0,
	tagPostCount: 0,
	menus: [{
		name: "",
		icon: "",
		target: "",
		url: "",
		subMenu: [name: "", icon: "", target: "", url: ""]
	}, {
		name: "",
		icon: "",
		target: "",
		url: "",
		subMenu: [name: "", icon: "", target: "", url: ""]
	}],
	categories: [{
		name: "",
		slugName: "",
		subCategory: [{
			name: "",
			slugName: ""
		}, {
			name: "",
			slugName: ""
		}]
	}, {
		name: "",
		slugName: "",
		subCategory: [{
			name: "",
			slugName: ""
		}, {
			name: "",
			slugName: ""
		}]
	}],
	tags: [{
		name: "",
		slugName: "",
		postCount: 0
	}, {
		name: "",
		slugName: "",
		postCount: 0
	}, ],
	pageResult: [total: 0, totlePage: 0, items: [{
		title: "",
		createTime: "2018年01月13日",
		content: "",
		visits: 0,
		likes: 0,
		tag: {
			name: "",
			slug_name: ""
		}
	}]]
}
```



## 2、分类博客文章

url：/category/{slugName}

method：GET

请求参数：Spring 

响应数据：JSON

```json
Category {
    name: "",
    slugName: "",
    description: "",
    pageResult: [total: 0, totlePage: 0, items: [{
		title: "",
		createTime: "2018年01月13日",
		content: "",
        url:"",
		visits: 0,
		likes: 0,
		tag: {
			name: "",
			slug_name: ""
		}
	}]]
}

```



## 3、标签博客文章

url：/tag/{slugName}

method：GET

请求参数：java

响应数据：JSON

```json
Tag {
    name: "",
    slugName: "",
    pageResult: [total: 0, totlePage: 0, items: [{
		title: "",
        url:"",
		createTime: "2018年01月13日",
		content: "",
		visits: 0,
		likes: 0,
		tag: {
			name: "",
			slug_name: ""
		}
	}]]
}
```



## 4、博客详情

url：/post/{url}

method：GET

请求参数：2018011219341828061

响应数据：JSON

```json
Post {
    id: "",
    summary:"",
    thumbnail:"",
    title:"",
    topPriority:"",
    url:"",
    formatContent:"",
    create_time:"",
    visits:"",
    likes:"",
    disallowComment:"",
    tagList: [
        {
            name: "",
            slugName: "",
        },
        {
            name: "",
            slugName: "",
        }
    ],
    recommendList: [
        {
            title: "",
        	url: ""
        },
        {
            title: "",
        	url: ""
        }
    ]
}
```



## 5、博客文章评论

url：/api/content/posts/comments

method：POST

请求参数：JSON

```json
{
    author: "theONLY08",
    authorUrl: null,
    email: "1164211667@qq.com",
    content: "不错",
    postId: ""
}
```

响应数据：JSON

```json
{
    success: true,
    code: 10000,
    message: "操作成功"
}
```



## 6、归档

url：/archive

method：GET

请求参数：

响应数据：JSON

```json
[
    {
        time: "2018年1月",
        postList: [
            {
                title: "Spring面试——基础篇",
                utl: "2018011020002642226",
                createTime: "2018年01月10日"
              
            },
            {
                title: "Spring面试——基础篇",
                utl: "2018011020002642226",
                createTime: "2018年01月10日"
              
            }
        ]
    }
]
```

## 7、友情链接

url：/link

method：GET

请求参数：

响应数据：JSON

```json
List:
[
    {
        name: "Spring官网",
        descript: "Spring官网",
        url: "https://spring.io",
        priority: 0,
        logo: ""
    },
    {
        name: "Spring官网",
        descript: "Spring官网",
        url: "https://spring.io",
        priority: 0,
        logo: ""
    }
]
```



## 8、图库

url：/photo

method：GET

请求参数：

响应数据：JSON

```json
PageResult:
{
    total: 0,
    totalPage: 0,
    items:[
        {
           id:"",
           description: "",
           location: "",
           name: "孟佳2020072401",
           take_time: "2020-07-24 15:26:08",
           team: "孟佳",
           thumbnail: "https://guoshihua.top/upload/2020/7/mj_2020073101-534d5d6ecc05438184cfdaabf0ddae82-thumbnail.jpg",
           url: "https://guoshihua.top/upload/2020/7/mj-f1e6ebabdfeb4540a8b216e76ed2ec75.jpg"
        }
	]
}
```



## 9、日志

url：/journal

method：GET

请求参数：

响应数据：JSON

```json
PageResult:
{
    total: 0,
    totalPage: 0,
    items:[
        {
            content: "",
  			likes: 0,
            createTime: ""
        },
        {
            content: "",
  			likes: 0,
            createTime: ""
        }
    ]
}
```



# 10、查询搜索

url：/search/{keyword}

method：GET

请求参数：spring

响应数据：JSON

```json
PageResult: {
    total: 0,
    totalPage: 0,
    items: [
        {
            title: "",
            createTime: "2018年01月13日",
            content: "",
            visits: 0,
            likes: 0,
            tagList: [
                {
                    name: "",
                    slug_name: ""
                },
                {
                    name: "",
                    slug_name: ""
                },
            ]
        },
        {
            title: "",
            createTime: "2018年01月13日",
            content: "",
            visits: 0,
            likes: 0,
            tagList: [
                {
                    name: "",
                    slug_name: ""
                },
                {
                    name: "",
                    slug_name: ""
                },
            ]
        }
    ]
}
```





# 三、后台

/api/admin

