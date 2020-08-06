package top.guoshihua.blog.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import top.guoshihua.blog.entity.Menu;

import java.util.List;

/**
 * @author Administrator
 */
@Api(value = "菜单Api", tags = "菜单Api")
public interface MenuApi {

    /**
     * 获取所有菜单的信息
     * @return
     */
    @ApiOperation(value = "获取所有菜单的信息", notes = "获取所有菜单的信息")
    List<Menu> findAll();

    /**
     * 根据id获取菜单信息
     * @param id 菜单id
     * @return
     */
    @ApiOperation(value = "获取菜单信息", notes = "根据id获取菜单信息")
    @ApiImplicitParam(name = "id", value = "菜单id", required = true, dataType = "String", paramType = "path")
    Menu findById(String id);

    /**
     * 分页获取所有菜单信息
     * @param page 页码
     * @param rows 每页显示条数
     * @param sortBy 排序字段
     * @param desc 是否倒序
     * @return
     */
    @ApiOperation(value = "分页获取所有菜单信息", notes = "分页获取所有菜单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", defaultValue = "1", dataType = "Integer"),
            @ApiImplicitParam(name = "rows", value = "每页显示条数", defaultValue = "10", dataType = "Integer"),
            @ApiImplicitParam(name = "sortBy", value = "排序字段", dataType = "String"),
            @ApiImplicitParam(name = "desc", value = "是否倒序", defaultValue = "true", dataType = "Boolean"),
    })
    Page<Menu> findByPage(Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    @ApiOperation(value = "新增菜单", notes = "新增菜单")
    Menu save(Menu menu);

    /**
     * 修改菜单
     * @param id 菜单id
     * @param menu 菜单实体类
     * @return
     */
    @ApiOperation(value = "修改菜单", notes = "修改菜单")
    @ApiImplicitParam(name = "id", value = "菜单id", required = true, dataType = "String", paramType = "path")
    Menu update(String id, Menu menu);

    /**
     * 回收菜单
     * @param id 菜单id
     */
    @ApiOperation(value = "回收菜单", notes = "回收菜单")
    @ApiImplicitParam(name = "id", value = "菜单id", required = true, dataType = "String", paramType = "path")
    void recovery(String id);

    /**
     * 删除菜单
     * @param id 菜单id
     */
    @ApiOperation(value = "删除菜单", notes = "删除菜单")
    @ApiImplicitParam(name = "id", value = "菜单id", required = true, dataType = "String", paramType = "path")
    void delete(String id);


}
