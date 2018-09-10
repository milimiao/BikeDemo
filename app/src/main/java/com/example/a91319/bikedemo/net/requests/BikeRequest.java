package com.example.a91319.bikedemo.net.requests;

/**
 * Created by 黄君豪 on 2018/9/10.
 */

public class BikeRequest extends BaseGetRequest {

    private int bike_id;

    public BikeRequest() {
    }

    public BikeRequest(int bike_id) {
        this.bike_id = bike_id;
    }

    public int getBike_id() {
        return bike_id;
    }

    public void setBike_id(int bike_id) {
        this.bike_id = bike_id;
    }
}
