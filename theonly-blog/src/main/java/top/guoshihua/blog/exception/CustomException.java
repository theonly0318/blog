package top.guoshihua.blog.exception;

import top.guoshihua.blog.common.response.ResultCode;

/**
 * @ClassName CustomException
 * @Description: 自定义异常类
 * @Author guoshihua
 * @Date 2020/8/6 0006 上午 8:15
 * @Version V1.0
 * @See 版权声明
 **/
public class CustomException extends RuntimeException {

    private ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        //异常信息为错误代码+异常信息
        super("错误代码："+resultCode.code()+"错误信息："+resultCode.message());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return this.resultCode;
    }
}
