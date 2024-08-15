package org.example.springbootstudy.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * Response返回状态码枚举类
 */
@Getter
@AllArgsConstructor
public enum ResponseConstantEnum {
    /**
     * 操作成功
     */
    SUCCESS(200,"操作成功"),

    /**
     * 错误请求
     */
    ERROR(400,"错误请求"),

    /**
     * 请求页面未找到
     */
    NOT_FIND_ERROR(404,"请求页面未找到"),

    /**
     * 系统异常
     */
    SYS_ERROR(-1, "系统异常"),

    /**
     * 参数校验失败
     */
    VALIDATE_ERROR(1002,"参数校验失败"),
    ;

    //请求响应码
    private final Integer resultCode;

    //请求响应消息
    private final String resultMessage;


    public static ResponseConstantEnum get(Integer code) {
        //value()方法可以将枚举类转变为一个枚举类型的数组
        for (ResponseConstantEnum responseConstantEnum : ResponseConstantEnum.values()) {
            if (Objects.equals(code, responseConstantEnum.getResultCode())) {
                return responseConstantEnum;
            }
        }
        return ResponseConstantEnum.ERROR;
    }

}
