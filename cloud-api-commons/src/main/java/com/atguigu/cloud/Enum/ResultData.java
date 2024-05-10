package com.atguigu.cloud.Enum;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author CaiBowen
 * @date 2024/4/17 8:22
 */

@Data
@Accessors(chain = true)
public class ResultData<T> {
    private String code;
    private String message;
    private T date;
    private long timestamp;

    public ResultData(){
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data){
        ResultData resultData = new ResultData<>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        resultData.setDate(data);

        return resultData;
    }

    public static <T> ResultData<T> fail(String code , String message){
        ResultData resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        resultData.setDate(null);

        return resultData;
    }
}
