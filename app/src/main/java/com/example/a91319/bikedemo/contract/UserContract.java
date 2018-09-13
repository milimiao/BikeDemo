package com.example.a91319.bikedemo.contract;

import com.example.a91319.bikedemo.net.responeses.BaseResponse;
import com.example.a91319.bikedemo.net.responeses.MyInfoResponese;

import retrofit2.Call;

/**
 * Created by 黄君豪 on 2018/9/13.
 */

public interface UserContract {

    interface Model {

        Call<BaseResponse<MyInfoResponese>> getMyInfo();

    }

    interface View {

        void onLoadMyInfoSuccess(MyInfoResponese myInfoResponese);

        void showErrorMessage(String message);

    }

    interface Presenter {
        void doGetMyInfo();
    }
}
