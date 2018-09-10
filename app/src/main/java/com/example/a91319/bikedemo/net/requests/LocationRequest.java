package com.example.a91319.bikedemo.net.requests;

/**
 * Created by 黄君豪 on 2018/9/10.
 */

public class LocationRequest extends BaseGetRequest {

    private double lat;
    private double lng;

    public LocationRequest() {
    }

    public LocationRequest(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
