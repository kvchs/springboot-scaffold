package com.charleychen.demo.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Results<T> implements Serializable {

    int count; // 数据数量
    Integer code;  // 代码
    String msg; // 信息
    List<T> datas;  // 返回数据
    T data; // 任何类型条件
    public Results(Integer code, String msg){
        super();
        this.code = code;
        this.msg = msg;
    }

    /* 无数据传输的成功返回 */
    public static <T> Results<T> success(){
        return new Results<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    public static <T> Results<T> success(String msg){
        return new Results<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> Results<T> success(ResponseCode responseCode){
        return new Results<T>(responseCode.getCode(), responseCode.getMessage());
    }

    public static <T> Results<T> success(T data){
        return new Results<T>(0, ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), null, data);
    }

    public static <T> Results<T> success(String msg, T data){
        return new Results<T>(0, ResponseCode.SUCCESS.getCode(), msg, null, data);
    }

    public static <T> Results<T> success(ResponseCode responseCode, T data){
        return new Results<T>(0, responseCode.getCode(), responseCode.getMessage(), null, data);
    }

    /* 分页数据的成功返回 */
    public static <T> Results<T> success(Integer count, List<T> datas){
        return new Results<T>(count, ResponseCode.TABLE_SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), datas,
                null);
    }

    public static <T> Results<T> success(String msg, Integer count, List<T> datas){
        return new Results<T>(count, ResponseCode.TABLE_SUCCESS.getCode(), msg, datas, null);
    }

    public static <T> Results<T> success(ResponseCode responseCode, Integer count, List<T> datas){
        return new Results<T>(count, responseCode.getCode(), responseCode.getMessage(), datas, null);
    }

    /* 无数据传输的失败返回 */
    public static <T> Results<T> failure(){
        return new Results<T>(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMessage());
    }
}
