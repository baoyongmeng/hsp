//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.hsp.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class R implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    private Map<String, Object> result = new HashMap();

    private R() {
    }

    public static R ok() {
        R r = new R();
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMsg(ResultCode.SUCCESS.getMsg());
        return r;
    }

    public static R error() {
        R r = new R();
        r.setCode(ResultCode.ERROR.getCode());
        r.setMsg(ResultCode.ERROR.getMsg());
        return r;
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static R error(String msg) {
        R r = error();
        r.setMsg(msg);
        return r;
    }

    public static R noAuthor() {
        R r = new R();
        r.setCode(ResultCode.NO_AUTHOR.getCode());
        r.setMsg(ResultCode.NO_AUTHOR.getMsg());
        return r;
    }

    public R put(String key, Object value) {
        this.result.put(key, value);
        return this;
    }

    public R message(String message) {
        this.setMsg(message);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value) {
        this.result.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setResult(map);
        return this;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public Map<String, Object> getResult() {
        return this.result;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof R)) {
            return false;
        } else {
            R other = (R)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label47;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label47;
                    }

                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$result = this.getResult();
                Object other$result = other.getResult();
                if (this$result == null) {
                    if (other$result != null) {
                        return false;
                    }
                } else if (!this$result.equals(other$result)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof R;
    }

    public int hashCode() {
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        return result;
    }

    public String toString() {
        return "R(code=" + this.getCode() + ", msg=" + this.getMsg() + ", result=" + this.getResult() + ")";
    }
}
