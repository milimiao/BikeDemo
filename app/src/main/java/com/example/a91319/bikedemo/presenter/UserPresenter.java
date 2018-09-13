package com.example.a91319.bikedemo.presenter;

import com.example.a91319.bikedemo.contract.UserContract;
import com.example.a91319.bikedemo.model.UserModel;
import com.example.a91319.bikedemo.net.responeses.BaseResponse;
import com.example.a91319.bikedemo.net.responeses.MyInfoResponese;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 黄君豪 on 2018/9/13.
 */

public class UserPresenter implements UserContract.Presenter {

    private UserModel userModel;
    private UserContract.View view;

    public UserPresenter(UserContract.View view) {
        this.view = view;
        this.userModel = new UserModel();
    }

    @Override
    public void doGetMyInfo() {

        userModel.getMyInfo().enqueue(new Callback<BaseResponse<MyInfoResponese>>() {
            @Override
            public void onResponse(Call<BaseResponse<MyInfoResponese>> call, Response<BaseResponse<MyInfoResponese>> response) {
                try{
                    view.onLoadMyInfoSuccess(response.body().getData());

                }catch (NullPointerException e){
                    view.showErrorMessage("出错了");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<MyInfoResponese>> call, Throwable t) {
                     view.showErrorMessage("出错了");
            }
        });

    }
}
