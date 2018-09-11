package com.example.a91319.bikedemo.presenter;

import com.example.a91319.bikedemo.contract.BikeContract;
import com.example.a91319.bikedemo.model.BikeModel;
import com.example.a91319.bikedemo.net.requests.LocationRequest;
import com.example.a91319.bikedemo.net.responeses.BaseResponse;
import com.example.a91319.bikedemo.net.responeses.BikeResponese;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 黄君豪 on 2018/9/10.
 */

public class BikePresenter implements BikeContract.Presenter {

    private BikeModel bikeModel;
    private BikeContract.View view;

    public BikePresenter(BikeContract.View view) {
        this.view = view;
        this.bikeModel = new BikeModel();
    }

    @Override
    public void doGetNearBikes(LocationRequest locationRequest) {

        view.showLoding();
        bikeModel.getNearBikess(locationRequest).enqueue(new Callback<BaseResponse<ArrayList<BikeResponese>>>() {
            @Override
            public void onResponse(Call<BaseResponse<ArrayList<BikeResponese>>> call, Response<BaseResponse<ArrayList<BikeResponese>>> response) {
                view.hideLoding();
                try{
                    view.onLoadNearBikesSuccess(response.body().getData());
                }catch (Exception e){
                    view.showErrorMessage("出现错误");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<ArrayList<BikeResponese>>> call, Throwable t) {
                     view.hideLoding();
                     view.showErrorMessage("服务器出现错误");
            }
        });

    }
}
