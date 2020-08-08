package top.guoshihua.blog.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import top.guoshihua.blog.common.response.PageResult;
import top.guoshihua.blog.common.response.ResponseResult;
import top.guoshihua.blog.entity.Tag;

import java.util.List;

/**
 * @ClassName TagApi
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/8 0008 上午 11:22
 * @Version V1.0
 * @See 版权声明
 **/
@Api(value = "TagApi", tags = "标签API")
public interface TagApi {

    /**
     * 获取所有标签
     * @return List<Link>
     */
    @ApiOperation(value = "获取所有标签", notes = "获取所有标签")
    List<Tag> list();

    /**
     * 根据主键id获取标签信息
     * @param id 友情链接主键id
     * @return
     */
    @ApiOperation(value = "获取标签信息", notes = "根据id获取标签信息")
    @ApiImplicitParam(name = "id", value = "标签id", required = true, dataType = "String",
            dataTypeClass = java.lang.String.class, paramType = "path")
    Tag findById(String id);

    /**
     * 分页获取所有标签
     * @param page 页码；默认值 1
     * @param rows 每页显示条数；默认值 10
     * @param sortBy 排序字段；默认 createTime
     * @param desc 是否降序；true：降序排序、false：升序排序
     * @return
     */
    @ApiOperation(value = "分页获取标签", notes = "分页获取标签信息")
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
    PageResult<Tag> findByPage(Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 添加标签
     * @param tag
     * @return
     */
    @ApiOperation(value = "新增标签", notes = "新增标签")
    ResponseResult save(Tag tag);

    /**
     * 更新标签
     * @param tag
     * @return
     */
    @ApiOperation(value = "修改标签", notes = "修改标签")
    ResponseResult update(Tag tag);

    /**
     * 删除
     * @param id
     * @return
     */
    @ApiOperation(value = "删除链接", notes = "根据id删除友情链接")
    @ApiImplicitParam(name = "id", value = "标签id", required = true, dataType = "String", dataTypeClass =
            String.class, paramType = "path")
    ResponseResult delete(String id);
}
