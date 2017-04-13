package com.android.benben.retrofitrxjava.http.bean;

/**
 * Time      2017/4/10 13:34 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class BaseEntity <T>{


    private static int SUCCESS_CODE=0;//成功的code
    private int error_code;
    private String reason;
    private T result;


    public boolean isSuccess(){
        return getCode()==SUCCESS_CODE;
    }
    public int getCode() {
        return error_code;
    }

    public void setCode(int error_code) {
        this.error_code = error_code;
    }

    public String getMsg() {
        return reason;
    }

    public void setMsg(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
