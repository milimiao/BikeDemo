package com.example.a91319.bikedemo;


import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.MyLocationStyle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements AMap.OnMyLocationChangeListener {


    @BindView(R.id.map_View)
    MapView mapView;
    Unbinder unbinder;

    //AMap是地图的控制器类 用于地图图层的切换和改变地图的状态 添加标记 绘制几何图形
    AMap aMap;
    MyLocationStyle mylocationstyle;
    //ArrayList<Marker> arr = new ArrayList<Marker>();

    public AMapLocationClient mapLocationClient = null;
    public AMapLocationClientOption aMapLocationClientOption = null;
    public AMapLocationListener aMapLocationListener = new AMapLocationListener() {


        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {



                if(aMapLocation.getErrorCode()==0){
                    Toast.makeText(getContext(), "定位成功", Toast.LENGTH_LONG).show();
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
                    Toast.makeText(getContext(), "定位失败", Toast.LENGTH_LONG).show();

                }

        }
    };

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

        //设置定位蓝点的样式
        mylocationstyle = new MyLocationStyle();
        aMap.setMyLocationStyle(mylocationstyle);
        aMap.getUiSettings().setMyLocationButtonEnabled(true);
        //aMap.setOnMyLocationChangeListener(this);
        aMap.setMyLocationEnabled(true);
        mylocationstyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE);
        //对定位进行初始化
        mapLocationClient = new AMapLocationClient(getContext());
        //设置一个定位回调的监听器
        mapLocationClient.setLocationListener(aMapLocationListener);
        init();
        return view;
    }

   /*private void addData(LatLng latlng) {
        for (int m = 0; m<arr.size(); m++) {
            arr.get(m).destroy();
        }
        arr.clear();
        for (int i = 0; i < 10; i++) {
            LatLng postion = new LatLng(latlng.latitude+Math.random()/1000,latlng.longitude+Math.random()/1000);
            Marker marker = aMap.addMarker(new MarkerOptions().position(postion).title("marker"+i));
            arr.add(marker);
        }

    }*/


    private void init() {
        aMapLocationClientOption = new AMapLocationClientOption();
        //选择定位模式
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Device_Sensors);
        //设置单次定位
        aMapLocationClientOption.setOnceLocation(true);
        aMapLocationClientOption.setOnceLocationLatest(true);
        //设置是否允许模拟器模拟位置
        aMapLocationClientOption.setMockEnable(true);
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
        //addData(new LatLng(location.getLatitude(),location.getLongitude()));
    }
}
