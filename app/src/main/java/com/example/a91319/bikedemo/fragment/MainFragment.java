package com.example.a91319.bikedemo.fragment;


import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.example.a91319.bikedemo.R;
import com.example.a91319.bikedemo.contract.BikeContract;
import com.example.a91319.bikedemo.net.requests.LocationRequest;
import com.example.a91319.bikedemo.net.responeses.BikeResponese;
import com.example.a91319.bikedemo.presenter.BikePresenter;
import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MainFragment extends Fragment implements AMap.OnMyLocationChangeListener, AMapLocationListener, View.OnClickListener, BikeContract.View {


    @BindView(R.id.map_View)
    MapView mapView;
    Unbinder unbinder;

    //AMap是地图的控制器类 用于地图图层的切换和改变地图的状态 添加标记 绘制几何图形
    AMap aMap;
    MyLocationStyle mylocationstyle;
    //标记数组
    ArrayList<Marker> markerArrayList = new ArrayList<Marker>();

    public AMapLocationClient mapLocationClient = null;
    public AMapLocationClientOption aMapLocationClientOption = null;
    @BindView(R.id.qrcode)
    ImageButton qrcode;
    @BindView(R.id.floatingActionButton)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.refreshDataProgressBar)
    CircleProgressBar refreshDataProgressBar;
    @BindView(R.id.generateBikeButton)
    FloatingActionButton generateBikeButton;

    private LatLng currentLatLng = null;

    private BikePresenter bikepresenter = null;

    private ArrayList<BikeResponese> bikeResponseArrayList = new ArrayList<>();

    private LocationRequest mylocationRequest = new LocationRequest();

   /* public AMapLocationListener aMapLocationListener = new AMapLocationListener() {

        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {

                if(aMapLocation.getErrorCode()==0){
                    //Toast.makeText(getContext(), "定位成功", Toast.LENGTH_LONG).show();
                    //获取经纬度
                    aMapLocation.getLatitude();
                    aMapLocation.getLongitude();
                    aMapLocation.getAddress();
                    aMapLocation.getAccuracy();
                    aMapLocation.getLocationType();
                    onLocationChanged(aMapLocation);
                }else{
                    //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + aMapLocation.getErrorCode() + ", errInfo:"
                            + aMapLocation.getErrorInfo()+aMapLocation.getLatitude()+" "+aMapLocation.getLongitude()+" "+aMapLocation.getLocationType());
                    //Toast.makeText(getContext(), "定位失败", Toast.LENGTH_LONG).show();

                }

        }
    };*/

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        initMap(savedInstanceState);
        initLayout();

        bikepresenter = new BikePresenter(this);


        return view;
    }

    private void initLayout() {
        generateBikeButton.setOnClickListener(this);
        floatingActionButton.setOnClickListener(this);
        refreshDataProgressBar.setOnClickListener(this);
        qrcode.setOnClickListener(this);
    }

    private void addData(LatLng latlng) {
      /*  for (int m = 0; m<arr.size(); m++) {
            arr.get(m).destroy();
        }
        arr.clear();
        for (int i = 0; i < 10; i++) {
            LatLng postion = new LatLng(latlng.latitude+Math.random()/1000,latlng.longitude+Math.random()/1000);
            Marker marker = aMap.addMarker(new MarkerOptions().position(postion).title("marker"+i));
            arr.add(marker);
        }*/

    }

    // TODO: 2018/9/13 初始化地图 
    private void initMap(Bundle savedInstanceState) {
        //创建地图
        mapView.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = mapView.getMap();
        }

        //设置定位蓝点的样式
        mylocationstyle = new MyLocationStyle();
        mylocationstyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE);
        aMap.setMyLocationStyle(mylocationstyle);


        aMap.setOnMyLocationChangeListener(this);
        aMap.setMyLocationEnabled(true);

        //对定位进行初始化
        mapLocationClient = new AMapLocationClient(getContext());
        //设置一个定位回调的监听器
        mapLocationClient.setLocationListener(this);


        aMapLocationClientOption = new AMapLocationClientOption();
        //选择定位模式
        //aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Device_Sensors);
        //使用高精度定位模式
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置单次定位
        aMapLocationClientOption.setOnceLocation(true);
        //aMapLocationClientOption.setOnceLocationLatest(true);
        //设置是否允许模拟器模拟位置
        //aMapLocationClientOption.setMockEnable(true);
        //给客户端设置定位参数
        mapLocationClient.setLocationOption(aMapLocationClientOption);
        //mapLocationClient.stopLocation();
        mapLocationClient.startLocation();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //销毁地图
        mapView.onDestroy();
        unbinder.unbind();
        mapLocationClient.onDestroy();
    }


    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapLocationClient.stopLocation();
    }

    //保护地图当前的状态
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }


    @Override
    public void onMyLocationChange(Location location) {
        //addData(new LatLng(location.getLatitude(), location.getLongitude()));
        //当前位置
        mylocationRequest.setLat(location.getLatitude());
        mylocationRequest.setLng(location.getLongitude());
        bikepresenter.doGetNearBikes(mylocationRequest);
        currentLatLng = new LatLng(location.getLatitude(),location.getLongitude());
        //定位到当前的点 定义缩放级别
        aMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng,19));
    }




    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
         if(aMapLocation.getErrorCode()==0){
             //定位成功
             onMyLocationChange(aMapLocation);
         }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.qrcode:
                // TODO: 2018/9/13 扫码开锁

                break;
            case R.id.generateBikeButton:
                // TODO: 2018/9/13  随机生成一台单车
                if(mylocationRequest!=null){
                    bikepresenter.doGenerateBikeByLocation(mylocationRequest);
                }
                break;

            case R.id.floatingActionButton:
                // TODO: 2018/9/13 刷新我的位置 
                mapLocationClient.startLocation();
                break;
            
            case R.id.refreshDataProgressBar:
                // TODO: 2018/9/13 刷新附近单车
                if(mylocationRequest!=null){
                    bikepresenter.doGetNearBikes(mylocationRequest);
                }
                break;
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void showLoding() {

    }

    @Override
    public void hideLoding() {

    }

    @Override
    public void showErrorMessage(String message) {

    }


    // TODO: 2018/9/13 向服务器发送请求 获取附近单车
    @Override
    public void onLoadNearBikesSuccess(ArrayList<BikeResponese> bikes) {

        for (int i = 0; i < markerArrayList.size(); i++) {
            markerArrayList.get(i).destroy();
        }
        markerArrayList.clear();
        bikeResponseArrayList=bikes;
        for (int i = 0; i < bikeResponseArrayList.size(); i++) {
            Marker marker = aMap.addMarker(
                    new MarkerOptions()
                            .position(new LatLng(
                                    bikeResponseArrayList.get(i).getLat(),
                                    bikeResponseArrayList.get(i).getLng()))
                            .icon(BitmapDescriptorFactory.fromBitmap
                                    (BitmapFactory.decodeResource(getResources(),R.drawable.bike)))
                            .title(String.valueOf(bikeResponseArrayList.get(i).getId()))
            );
            markerArrayList.add(marker);
        }
    }

    
    @Override
    public void onGrenerateBikeSuccess() {
        //添加单车成功后刷新数据
        bikepresenter.doGetNearBikes(mylocationRequest);
    }
}
