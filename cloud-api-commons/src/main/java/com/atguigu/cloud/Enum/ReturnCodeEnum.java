package com.atguigu.cloud.Enum;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author CaiBowen
 * @date 2024/4/17 7:39
 */

@Getter
public enum ReturnCodeEnum {
        /*操作失败*/
        RC999("999","操作失败"),
        /*操作成功*/
        RC200("200","success"),
        /*服务降级*/
        RC201("201","服务开启降级保护,请稍后再试"),
        /*热点参数限流*/
        RC202("202","热点参数限流,请稍后再试"),
        /*系统规则不满足*/
        RC203("203","系统规则不满足,请稍后再试"),
        /*授权规则不通过*/
        RC204("204","授权规则不通过,请稍后再试"),
        /*access_denied*/
        RC403("403","无妨问权限,请联系管理员授予权限"),
        /*access_denied*/
        RC401("401","匿名用户访问无权限时的异常"),
        RC404("404","404页面找不到异常"),
        /*服务异常*/
        RC500("500","系统异常,请稍后再试"),
        RC357("357","数学运行异常,请稍后再试"),

        INVALID_T0KEN("2001","访问令牌不合法"),
        ACCESS_DENTED("2003","没有权限访问该资源"),
        CLIENT_AUTHENTICATION_FATLED("1001","客户端认证失败"),
        USERNAME_OR_PASSWORD_ERROR("1002","用户名或密码错误"),
        BUSINESS_ERROR("1004","业务逻辑异常"),
        UNSUPPORTED_GRANT_TYPE("1003","不支持的认证摸式");

    private final String code;//自定义状态码
    private final String message;//自定义描述性息

    ReturnCodeEnum(String code,String message){
        this.code = code;
        this.message = message;
    }

    /*遍历
    * 1.传统版
    * */
    public static ReturnCodeEnum getReturnCodeEnumV1(String code){
        for (ReturnCodeEnum element : ReturnCodeEnum.values()) {
            if (element.getCode().equalsIgnoreCase(code));
            {
                return element;
            }
        }
        return null;
    }

    /*
    * 2Stream流式计算
    *
    * */
    public static ReturnCodeEnum getReturnCodeEnumV2(String code){
        return Arrays.stream(ReturnCodeEnum.values()).filter(x -> x.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }

    public static void main(String[] args) {
        System.out.println();
    }






}
