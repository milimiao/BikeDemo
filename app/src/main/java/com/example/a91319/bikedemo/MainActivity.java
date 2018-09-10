package com.example.a91319.bikedemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.a91319.bikedemo.net.NetManager;
import com.example.a91319.bikedemo.net.requests.LocationRequest;
import com.example.a91319.bikedemo.net.responeses.BaseResponse;
import com.example.a91319.bikedemo.net.responeses.BikeResponese;
import com.example.a91319.bikedemo.net.services.BikeService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bicycle");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_left);


        //网路测试
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setLat(24.5328410);
        locationRequest.setLng(118.1687860);
        NetManager.getInstance()
                .create(BikeService.class)
                .getNearBikes(locationRequest.toMap())
                .enqueue(new Callback<BaseResponse<ArrayList<BikeResponese>>>() {
            @Override
            public void onResponse(Call<BaseResponse<ArrayList<BikeResponese>>> call, Response<BaseResponse<ArrayList<BikeResponese>>> response) {
                 ArrayList<BikeResponese> bikeResponeseArrayList=response.body().getData();
            }

            @Override
            public void onFailure(Call<BaseResponse<ArrayList<BikeResponese>>> call, Throwable t) {
                 String errorMessage = t.getLocalizedMessage();
            }
        });

        //这是一条更新



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
