package com.example.a91319.bikedemo.net;

import android.support.annotation.Nullable;

import com.example.a91319.bikedemo.managers.SpManager;
import com.example.a91319.bikedemo.net.requests.RefreshTokenRequest;
import com.example.a91319.bikedemo.net.responeses.OauthResponese;
import com.example.a91319.bikedemo.net.services.AuthService;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * Created by 黄君豪 on 2018/9/13.
 */

public class MyAuthenticator implements Authenticator {
    @Nullable
    @Override
    //当服务器端返回401 表示用户授权不通过时调用 发生在token失效后
    public Request authenticate(Route route, Response response) throws IOException {
        String refreshToken = SpManager.getDefaultSp().getString("refresh_token");
        if(refreshToken.equals("")){
            //// TODO: 2018/9/13 跳转到登录页面 因为本地没有refreshToken
            return null;
        }else {
            RefreshTokenRequest refreshtokenrequest = new RefreshTokenRequest();
            refreshtokenrequest.setRefresh_token(refreshToken);
            OauthResponese oauthResponese = NetManager.getInstance().create(AuthService.class).postRefreshToken(refreshtokenrequest).execute().body();
            if(oauthResponese==null){
                //// TODO: 2018/9/13 跳转到登录页面 因为本地没有refreshToken
                SpManager.getDefaultSp().clear();
                return null;
            }else {
                //将信息写入到sp
                SpManager.getDefaultSp().put("is login",true);
                SpManager.getDefaultSp().put("access_token",oauthResponese.getAccess_token());
                SpManager.getDefaultSp().put("refresh_token",oauthResponese.getRefresh_token());
                return response.request().newBuilder().header("Authorization","Bearer "+oauthResponese.getAccess_token()).build();
            }

        }
    }
}
