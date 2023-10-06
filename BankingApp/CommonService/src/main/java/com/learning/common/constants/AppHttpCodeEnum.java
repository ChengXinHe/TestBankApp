package com.learning.common.constants;

public enum AppHttpCodeEnum {

    // 成功段固定为200
    SUCCESS(200,"SUCCESS"),
    SUCCESSADDCUSTOMER(201,"SUCCESS ADD CUSTOMER"),

    // LOGIN1~50
    NEED_LOGIN(1,"NEED_LOGIN"),
    LOGIN_PASSWORD_ERROR(2,"LOGIN_PASSWORD_ERROR"),
    // TOKEN50~100
    TOKEN_INVALID(50,"TOKEN_INVALID"),
    TOKEN_EXPIRE(51,"TOKEN_EXPIRE"),
    TOKEN_REQUIRE(52,"TOKEN_REQUIRE"),
    // SIGN验签 100~120
    SIGN_INVALID(100,"SIGN_INVALID"),
    SIG_TIMEOUT(101," SIG_TIMEOUT"),
    // 参数错误 500~1000
    PARAM_REQUIRE(500,"PARAM_REQUIRE"),
    PARAM_INVALID(501,"PARAM_INVALID"),
    PARAM_IMAGE_FORMAT_ERROR(502,"PARAM_IMAGE_FORMAT_ERROR"),
    SERVER_ERROR(503,"SERVER_ERROR"),
    // 数据错误 1000~2000
    DATA_EXIST(1000,"DATA_EXIST"),
    AP_USER_DATA_NOT_EXIST(1001,"AP_USER_DATA_NOT_EXIST"),
    DATA_NOT_EXIST(1002,"DATA_NOT_EXIST"),
    // 数据错误 3000~3500
    NO_OPERATOR_AUTH(3000,"NO_OPERATOR_AUTH"),
    NEED_ADMIND(3001,"NEED_ADMIND");

    int code;
    String errorMessage;

    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
