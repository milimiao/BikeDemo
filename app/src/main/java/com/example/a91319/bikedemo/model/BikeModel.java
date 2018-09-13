package com.example.a91319.bikedemo.model;

import com.example.a91319.bikedemo.contract.BikeContract;
import com.example.a91319.bikedemo.net.NetManager;
import com.example.a91319.bikedemo.net.requests.LocationRequest;
import com.example.a91319.bikedemo.net.responeses.BaseResponse;
import com.example.a91319.bikedemo.net.responeses.BikeResponese;
import com.example.a91319.bikedemo.net.services.BikeService;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by 黄君豪 on 2018/9/10.
 */

public class BikeModel implements BikeContract.Model {
    @Override
    public Call<BaseResponse<ArrayList<BikeResponese>>> getNearBikess(LocationRequest locationRequest) {
        return NetManager.getInstance().create(BikeService.class).getNearBikes(locationRequest.toMap());
    }

    @Override
    public Call<BaseResponse<String>> generateBikeByLocation(LocationRequest locationRequest) {
        return NetManager.getInstance().create(BikeService.class).generateBikeByLocation(locationRequest);
    }
}
