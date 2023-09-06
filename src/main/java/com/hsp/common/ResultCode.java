//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.hsp.common;

public enum ResultCode {
    SUCCESS(0, "请求成功！"),
    ERROR(1, "请求错误！"),
    NO_AUTHOR(2, "没有权限！");

    private int code;
    private String msg;

    private ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
