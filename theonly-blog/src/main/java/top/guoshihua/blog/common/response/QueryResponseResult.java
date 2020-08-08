package top.guoshihua.blog.common.response;

import lombok.Data;
import lombok.ToString;

/**
 * @author guoshihua
 */
@Data
@ToString
public class QueryResponseResult<T> extends ResponseResult {

    QueryResult queryResult;

    public QueryResponseResult(ResultCode resultCode, QueryResult queryResult){
        super(resultCode);
        this.queryResult = queryResult;
    }

}