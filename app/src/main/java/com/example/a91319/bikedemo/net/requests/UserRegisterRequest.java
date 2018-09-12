package com.example.a91319.bikedemo.net.requests;

/**
 * Created by 黄君豪 on 2018/9/12.
 */

public class UserRegisterRequest {

    private String name;
    private String password;
    private String password_confirmation;

    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String name, String password, String password_confirmation) {
        this.name = name;
        this.password = password;
        this.password_confirmation = password_confirmation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirmation() {
        return password_confirmation;
    }

    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }
}
