package com.example.a91319.bikedemo.managers;

import com.blankj.utilcode.util.SPUtils;

/**
 * Created by 黄君豪 on 2018/9/13.
 */

public class SpManager {

    private SpManager() {
    }

    private static SPUtils defaultSp=null;

    public static SPUtils getDefaultSp(){

        return SPUtils.getInstance("com.example.edu.BikeDemo_default_sp");

    }


}
