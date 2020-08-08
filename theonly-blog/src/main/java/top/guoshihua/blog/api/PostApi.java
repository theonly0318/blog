package top.guoshihua.blog.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import top.guoshihua.blog.common.response.PageResult;
import top.guoshihua.blog.common.response.ResponseResult;
import top.guoshihua.blog.entity.Post;

import java.util.List;

/**
 * @ClassName PostApi
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/8 0008 上午 11:22
 * @Version V1.0
 * @See 版权声明
 **/
@Api(value = "PostApi", tags = "博客文章API")
public interface PostApi {

    /**
     * 获取所有博客文章
     * @return List<Link>
     */
    @ApiOperation(value = "获取所有博客文章", notes = "获取所有博客文章")
    List<Post> list();

    /**
     * 根据主键id获取博客文章信息
     * @param id 友情链接主键id
     * @return
     */
    @ApiOperation(value = "获取博客文章信息", notes = "根据id获取博客文章信息")
    @ApiImplicitParam(name = "id", value = "博客文章id", required = true, dataType = "String",
            dataTypeClass = String.class, paramType = "path")
    Post findById(String id);

    /**
     * 分页获取所有博客文章
     * @param page 页码；默认值 1
     * @param rows 每页显示条数；默认值 10
     * @param sortBy 排序字段；默认 createTime
     * @param desc 是否降序；true：降序排序、false：升序排序
     * @return
     */
    @ApiOperation(value = "分页获取博客文章", notes = "分页获取博客文章信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1",
                    dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "rows", value = "每页显示条数", defaultValue = "10",
                    dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "sortBy", value = "排序字段", defaultValue = "createTime",
                    dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "desc", value = "排序方式", defaultValue = "true",
                    dataType = "Boolean", dataTypeClass = Boolean.class)
    })
    PageResult<Post> findByPage(Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 添加博客文章
     * @param post
     * @return
     */
    @ApiOperation(value = "新增博客文章", notes = "新增博客文章")
    ResponseResult save(Post post);

    /**
     * 更新博客文章
     * @param post
     * @return
     */
    @ApiOperation(value = "修改博客文章", notes = "修改博客文章")
    ResponseResult update(Post post);

    /**
     * 删除
     * @param id
     * @return
     */
    @ApiOperation(value = "删除链接", notes = "根据id删除友情链接")
    @ApiImplicitParam(name = "id", value = "博客文章id", required = true, dataType = "String", dataTypeClass =
            String.class, paramType = "path")
    ResponseResult delete(String id);


    /**
     * 修改博客文章类型
     * @param id
     * @return
     */
    @ApiOperation(value = "修改博客文章类型", notes="修改博客文章类型")
    @ApiImplicitParam(name = "id", value = "博客文章id", required = true, dataType = "String", dataTypeClass =
            String.class, paramType = "path")
    ResponseResult updateTypeById(String id);

    /**
     * 修改博客文章状态
     * @param id
     * @param status
     * @return
     */
    @ApiOperation(value = "修改博客文章状态", notes="修改博客文章状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "博客文章id", required = true, dataType = "String", dataTypeClass =
                    String.class, paramType = "path"),
            @ApiImplicitParam(name = "status", value = "博客文章状态", required = true, dataType = "Integer", dataTypeClass =
                    Integer.class)
    })
    ResponseResult updateStatusById(String id, Integer status);

    /**
     * 修改博客文章置顶优先级
     * @param id
     * @param priority
     * @return
     */
    @ApiOperation(value = "置顶博客", notes="修改博客文章置顶优先级")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "博客文章id", required = true, dataType = "String", dataTypeClass =
                    String.class, paramType = "path"),
            @ApiImplicitParam(name = "priority", value = "博客文章置顶优先级", required = true, dataType = "Integer",
                    dataTypeClass = Integer.class)
    })
    ResponseResult updateTopById(String id, Integer priority);

    /**
     * 修改博客文章访问密码
     * @param id
     * @param password
     * @return
     */
    @ApiOperation(value = "修改博客文章访问密码", notes="修改博客文章访问密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "博客文章id", required = true, dataType = "String", dataTypeClass =
                    String.class, paramType = "path"),
            @ApiImplicitParam(name = "password", value = "博客文章访问密码", required = true, dataType = "String",
                    dataTypeClass = String.class)
    })
    ResponseResult updatePasswordById(String id, String password);
}
