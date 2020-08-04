package top.guoshihua.blog.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
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
     * 根据主键id获取分类信息
     * @param id 分类主键id
     * @return
     */
    @ApiOperation(value = "分类信息", notes = "根据id获取分类信息")
    @ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "1",
            dataType = "Integer", paramType = "path")
    Category findById(Integer id);

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
     * 添加分类
     * @param category
     */
    @ApiOperation(value = "新增分类", notes = "新增分类")
    void save(Category category);

    /**
     * 更新分类
     * @param category
     */
    @ApiOperation(value = "修改分类", notes = "修改分类")
    @ApiImplicitParam(name = "id", value = "分类id", required = true, defaultValue = "1",
            dataType = "Integer", dataTypeClass = Integer.class, paramType = "path")
    void update(Integer id, Category category);

    /**
     * 删除
     * @param id
     */
    @ApiOperation(value = "删除分类", notes = "根据id删除分类")
    @ApiImplicitParam(name = "id", value = "分类id", required = true, dataType = "Integer", dataTypeClass =
            Integer.class, paramType = "path")
    void delete(Integer id);
}
