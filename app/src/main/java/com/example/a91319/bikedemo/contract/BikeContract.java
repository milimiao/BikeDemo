package com.example.a91319.bikedemo.contract;

import com.example.a91319.bikedemo.net.requests.LocationRequest;
import com.example.a91319.bikedemo.net.responeses.BaseResponse;
import com.example.a91319.bikedemo.net.responeses.BikeResponese;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by 黄君豪 on 2018/9/10.
 */

public interface BikeContract {

    //返回一个call对象
    interface Model {
        Call<BaseResponse<ArrayList<BikeResponese>>> getNearBikess(LocationRequest locationRequest);
    }

    interface View {
        void showLoding();
        void hideLoding();
        void showErrorMessage(String message);
        void  onLoadNearBikesSuccess(ArrayList<BikeResponese> bikes);
    }

    interface Presenter {
        void doGetNearBikes(LocationRequest locationRequest);
    }
}
