package top.guoshihua.blog.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import top.guoshihua.blog.entity.User;

/**
 * @author Administrator
 */
@Api(value = "用户api")
public interface UserApi {

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @ApiOperation(value = "获取用户信息", notes = "根据用户名获取用户信息")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String",
            dataTypeClass = String.class, paramType = "path")
    User findByUsername(String username);
}
