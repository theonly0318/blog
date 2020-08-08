package top.guoshihua.blog.common.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName QueryResult
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/6 0006 上午 8:25
 * @Version V1.0
 * @See 版权声明
 **/
@Data
@ToString
public class QueryResult<T> {
    //数据列表
    private List<T> list;
    //数据总数
    private long total;
}
