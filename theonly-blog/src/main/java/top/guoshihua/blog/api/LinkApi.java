package top.guoshihua.blog.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import top.guoshihua.blog.entity.Link;

import java.util.List;

/**
 * @Author guoshihua
 **/
@Api(value = "友情链接API")
public interface LinkApi {

    /**
     * 获取所有友情链接
     * @return List<Link>
     */
    @ApiOperation(value = "获取所有友情链接", notes = "获取所有友情链接")
    List<Link> list();

    /**
     * 根据主键id获取友情链接信息
     * @param id 友情链接主键id
     * @return
     */
    @ApiOperation(value = "友情链接信息", notes = "根据id友情链接信息")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer",
            dataTypeClass = java.lang.Integer.class, paramType = "path")
    Link findById(Integer id);

    /**
     * 分页获取所有友情链接
     * @param page 页码；默认值 1
     * @param rows 每页显示条数；默认值 10
     * @param sortBy 排序字段；默认 createTime
     * @param desc 是否降序；true：降序排序、false：升序排序
     * @return
     */
    @ApiOperation(value = "分页获取友情链接", notes = "分页获取友情链接信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1",
                    dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "rows", value = "每页显示条数", defaultValue = "10",
                    dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "sortBy", value = "排序字段", required = false, defaultValue = "create_time",
                    dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "desc", value = "排序方式", required = false, defaultValue = "true",
                    dataType = "Boolean", dataTypeClass = Boolean.class)
    })
    Page<Link> findByPage(Integer page, Integer rows, String sortBy, Boolean desc);
}
