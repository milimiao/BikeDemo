package com.example.a91319.bikedemo;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by 黄君豪 on 2018/9/13.
 */

public class BikeApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
