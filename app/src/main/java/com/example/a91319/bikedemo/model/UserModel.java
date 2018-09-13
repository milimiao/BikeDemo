package com.example.a91319.bikedemo.model;

import com.example.a91319.bikedemo.contract.UserContract;
import com.example.a91319.bikedemo.net.NetManager;
import com.example.a91319.bikedemo.net.responeses.BaseResponse;
import com.example.a91319.bikedemo.net.responeses.MyInfoResponese;
import com.example.a91319.bikedemo.net.services.UserService;

import retrofit2.Call;

/**
 * Created by 黄君豪 on 2018/9/13.
 */

public class UserModel implements UserContract.Model {
    @Override
    public Call<BaseResponse<MyInfoResponese>> getMyInfo() {
        return NetManager.getInstance().create(UserService.class).getMyinfo();
    }
}
