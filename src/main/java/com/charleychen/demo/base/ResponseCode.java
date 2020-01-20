package com.charleychen.demo.base;


public enum ResponseCode {

    // 公共请求信息
    SUCCESS(200, "请求成功"),

    TABLE_SUCCESS(0, "请求成功"),
    FAIL(500, "请求失败，请联系管理员"),
    PARAMETER_MISSING(600, "缺少参数"),
    UNAUTHORIZED(401, "未授权"),
    USERNAME_REPEAT(50001, "用户名已存在"),
    PHONE_REPEAT(600001, "手机号已存在"),
    EMAIL_REPEAT(700001, "邮箱已存在"),
    UER_ROLE_NO_CLEAR(90001, "该角色存在用户关联，无法删除");

    private Integer code;
    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String getMessage(String name){
        for (ResponseCode item : ResponseCode.values()){
            if (item.name().equals(name)){
                return item.message;
            }
        }
        return null;
    }

    public static Integer getCode(String name){
        for (ResponseCode item : ResponseCode.values()){
            if (item.name().equals(name)){
                return item.code;
            }
        }
        return null;
    }
}
