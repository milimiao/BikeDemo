package com.example.a91319.bikedemo.net.requests;

/**
 * Created by 黄君豪 on 2018/9/10.
 */

public class RefreshTokenRequest {

    private String grant_type="refresh_token";
    private int client_id=2;
    private String client_secret="";
    private String refresh_token;

    public RefreshTokenRequest() {
    }

    public RefreshTokenRequest(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
