package top.guoshihua.blog.common.response;

/**
 * @ClassName ResultCode
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/6 0006 上午 8:20
 * @Version V1.0
 * @See 版权声明
 **/
public interface ResultCode {
    //操作是否成功,true为成功，false操作失败
    boolean success();
    //操作代码
    int code();
    //提示信息
    String message();

}
