package top.guoshihua.blog.exception;

import top.guoshihua.blog.common.response.ResultCode;

/**
 * @ClassName ExceptionCast
 * @Description: 异常抛出类
 * @Author guoshihua
 * @Date 2020/8/6 0006 上午 8:16
 * @Version V1.0
 * @See 版权声明
 **/
public class ExceptionCast {

    //使用此静态方法抛出自定义异常
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
