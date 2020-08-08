package top.guoshihua.blog.common.response.enums;

import lombok.ToString;
import top.guoshihua.blog.common.response.ResultCode;

/**
 * @ClassName CommonCode
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/6 0006 上午 8:23
 * @Version V1.0
 * @See 版权声明
 **/
@ToString
public enum CommonCode implements ResultCode {
    INVALID_PARAM(false,10003,"非法参数异常"),
    SUCCESS(true,10000,"操作成功！"),
    FAIL(false,11111,"操作失败！"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    UNAUTHORISE(false,10002,"权限不足，无权操作！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！"),
    LINK_INVALID_PARAMETER(false, 24000, "非法参数异常！"),
    LINK_ADD_EXISTSNAME(false, 24001, "链接名称已存在！"),
    LINK_UPDATE_NOTEXISTS(false, 24002, "链接不存在！"),
    CATEGORY_INVALID_PARAMETER(false, 34000, "非法参数异常！"),
    CATEGORY_ADD_EXISTSNAME(false, 34001, "分类名称已存在！"),
    CATEGORY_UPDATE_NOTEXISTS(false, 34002, "分类不存在！"),
    MENU_INVALID_PARAMETER(false, 44000, "非法参数异常！"),
    MENU_ADD_EXISTSNAME(false, 44001, "分类名称已存在！"),
    MENU_UPDATE_NOTEXISTS(false, 44002, "分类不存在！"),
    TAG_INVALID_PARAMETER(false, 54000, "非法参数异常！"),
    TAG_ADD_EXISTSNAME(false, 54001, "标签名称已存在！"),
    TAG_UPDATE_NOTEXISTS(false, 54002, "标签不存在！"),
    POST_INVALID_PARAMETER(false, 54000, "非法参数异常！"),
    POST_ADD_EXISTSNAME(false, 54001, "博客文章名称已存在！"),
    POST_UPDATE_NOTEXISTS(false, 54002, "博客文章不存在！"),
    POST_UPDATE_INVALID_STATUS(false, 54003, "博客文章状态参数无效"),
    POST_UPDATE_INVALID_PRIORITY(false, 54003, "博客文章置顶优先级参数无效");
    //    private static ImmutableMap<Integer, CommonCode> codes ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private CommonCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
