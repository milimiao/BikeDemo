package com.example.a91319.bikedemo.presenter;

import com.example.a91319.bikedemo.contract.AuthContract;
import com.example.a91319.bikedemo.managers.SpManager;
import com.example.a91319.bikedemo.model.AuthModel;
import com.example.a91319.bikedemo.net.requests.LoginRequest;
import com.example.a91319.bikedemo.net.requests.UserRegisterRequest;
import com.example.a91319.bikedemo.net.responeses.BaseResponse;
import com.example.a91319.bikedemo.net.responeses.OauthResponese;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 黄君豪 on 2018/9/13.
 */

public class AuthPresenter implements AuthContract.Presenter {

    private AuthModel authcModel;
    private AuthContract.View view;

    public AuthPresenter(AuthContract.View view) {
        this.view=view;
        this.authcModel = new AuthModel();
    }

    @Override
    public void doRegisterUser(UserRegisterRequest userRegisterRequest) {

        authcModel.postRegisterUser(userRegisterRequest).enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                view.onRegisterSuccess();
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                 view.showErrorMessahe("注册失败");
            }
        });

    }

    @Override
    public void doLoginUser(LoginRequest loginRequest) {
        authcModel.postLoginUser(loginRequest)
                .enqueue(new Callback<OauthResponese>() {
                    @Override
                    public void onResponse(Call<OauthResponese> call, Response<OauthResponese> response) {

                        try{
                            OauthResponese oauthResponese=response.body();
                            //将登录信息写入sp
                            SpManager.getDefaultSp().put("is login",true);
                            SpManager.getDefaultSp().put("access_token",oauthResponese.getAccess_token());
                            SpManager.getDefaultSp().put("refresh_token",oauthResponese.getRefresh_token());
                        }catch (NullPointerException e){
                            view.showErrorMessahe("出错了");
                        }

                    }

                    @Override
                    public void onFailure(Call<OauthResponese> call, Throwable t) {
                        view.showErrorMessahe("出错了");
                    }
                });
    }
}
