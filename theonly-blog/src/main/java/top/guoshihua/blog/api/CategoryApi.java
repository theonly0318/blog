package top.guoshihua.blog.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import top.guoshihua.blog.bo.CategoryBo;
import top.guoshihua.blog.common.response.PageResult;
import top.guoshihua.blog.common.response.ResponseResult;
import top.guoshihua.blog.entity.Category;

import java.util.List;

/**
 * @author guoshihua
 */
@Api(value = "分类API", tags = "分类API")
public interface CategoryApi {

    /**
     * 获取所有分类
     * @return List<Link>
     */
    @ApiOperation(value = "获取所有分类", notes = "获取所有分类")
    List<Category> list();

    /**
     * 分页获取所有分类
     * @param page 页码；默认值 1
     * @param rows 每页显示条数；默认值 10
     * @param sortBy 排序字段；默认 createTime
     * @param desc 是否降序；true：降序排序、false：升序排序
     * @return
     */
    @ApiOperation(value = "分页获取分类", notes = "分页获取分类信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1",
                    dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "rows", value = "每页显示条数", defaultValue = "10",
                    dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "sortBy", value = "排序字段", defaultValue = "create_time",
                    dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "desc", value = "排序方式", defaultValue = "true",
                    dataType = "Boolean", dataTypeClass = Boolean.class)
    })
    Page<Category> findByPage(Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 根据分类别名获取博客文章
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param slugName
     * @return
     */
    @ApiOperation(value = "根据分类别名获取博客文章", notes = "根据分类别名获取博客文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1",
                    dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "rows", value = "每页显示条数", defaultValue = "10",
                    dataType = "Integer", dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "sortBy", value = "排序字段", defaultValue = "create_time",
                    dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "desc", value = "排序方式", defaultValue = "true",
                    dataType = "Boolean", dataTypeClass = Boolean.class),
            @ApiImplicitParam(name = "slugName", value = "分类别名", required = true,
                    dataType = "String", dataTypeClass = String.class)
    })
    PageResult<CategoryBo> findPostByCategorySlugName(Integer page, Integer rows, String sortBy, Boolean desc,
                                                String slugName);
}
