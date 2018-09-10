package com.example.a91319.bikedemo.net.requests;

/**
 * Created by 黄君豪 on 2018/9/10.
 */

public class IncludeRequest extends BaseGetRequest {

    private String include;

    public IncludeRequest(String include) {
        this.include = include;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }
}
