package org.example.springbootstudy.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbootstudy.utils.ResponseConstantEnum;
import org.example.springbootstudy.utils.TraceIdUtils;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE) //禁止自行new R类
public class R<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //响应码
    private Integer code;

    //返回消息
    private String message;

    //返回数据
    private T data;

    //整合TraceID
    public String traceId = TraceIdUtils.getTraceId();


    /**
     * 操作成功ok方法
     */

    public static <T> R<T> ok() {

        R<T> response = new R<>();
        response.setCode(ResponseConstantEnum.SUCCESS.getResultCode());
        response.setMessage(ResponseConstantEnum.SUCCESS.getResultMessage());
        return response;
    }
    public static <T> R<T> ok(T data) {

        R<T> response = new R<>();
        response.setCode(ResponseConstantEnum.SUCCESS.getResultCode());
        response.setMessage(ResponseConstantEnum.SUCCESS.getResultMessage());
        response.setData(data);
        return response;
    }

    /**
     * 编译失败方法
     */
    public static <T> R<T> error() {
        R<T> response = new R<>();
        response.setCode(ResponseConstantEnum.SYS_ERROR.getResultCode());
        response.setMessage(ResponseConstantEnum.SYS_ERROR.getResultMessage());
        return response;
    }


    public static <T> R<T> error(ResponseConstantEnum errorEnum){

        R<T> response = new R<>();
        response.setCode(errorEnum.getResultCode());
        response.setMessage(errorEnum.getResultMessage());
        return response;
    }

    public static <T> R<T> error(ResponseConstantEnum errorEnum, String errorMsg){

        R<T> response = new R<>();
        response.setCode(errorEnum.getResultCode());
        response.setMessage(errorMsg);
        return response;
    }


    public static <T> R<T> error(String s) {
        R<T> response = new R<>();
        response.setCode(ResponseConstantEnum.ERROR.getResultCode());
        response.setMessage(s);
        return response;
    }
}
