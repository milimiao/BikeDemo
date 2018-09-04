package com.example.a91319.bikedemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    @BindView(R.id.map_View)
    MapView mapView;
    Unbinder unbinder;

    //AMap是地图的控制器类 用于地图图层的切换和改变地图的状态 添加标记 绘制几何图形
    AMap aMap;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        //创建地图
        mapView.onCreate(savedInstanceState);
        if(aMap==null){
            aMap=mapView.getMap();
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //销毁地图
        mapView.onDestroy();
        unbinder.unbind();
    }

    //重新加载地图
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    //保护地图当前的状态
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
