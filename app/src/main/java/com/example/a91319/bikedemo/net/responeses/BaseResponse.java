package com.example.a91319.bikedemo.net.responeses;

/**
 * Created by 黄君豪 on 2018/9/10.
 */

public class BaseResponse<T> {

    private T data;
    private Meta meta;
    private String message;
    private boolean success;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
