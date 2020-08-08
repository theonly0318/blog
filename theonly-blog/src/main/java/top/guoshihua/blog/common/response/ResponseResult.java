package top.guoshihua.blog.common.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import top.guoshihua.blog.common.response.enums.CommonCode;

/**
 * @ClassName ResponseResult
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/6 0006 上午 8:22
 * @Version V1.0
 * @See 版权声明
 **/
@Data
@ToString
@NoArgsConstructor
public class ResponseResult implements Response {
    //操作是否成功
    boolean success = SUCCESS;

    //操作代码
    int code = SUCCESS_CODE;

    //提示信息
    String message;

    public ResponseResult(ResultCode resultCode) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static ResponseResult SUCCESS() {
        return new ResponseResult(CommonCode.SUCCESS);
    }

    public static ResponseResult FAIL() {
        return new ResponseResult(CommonCode.FAIL);
    }
}
