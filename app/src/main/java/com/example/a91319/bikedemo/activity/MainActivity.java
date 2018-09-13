package com.example.a91319.bikedemo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.a91319.bikedemo.R;
import com.example.a91319.bikedemo.contract.BikeContract;
import com.example.a91319.bikedemo.contract.UserContract;
import com.example.a91319.bikedemo.net.requests.LocationRequest;
import com.example.a91319.bikedemo.net.responeses.BikeResponese;
import com.example.a91319.bikedemo.net.responeses.MyInfoResponese;
import com.example.a91319.bikedemo.presenter.BikePresenter;
import com.example.a91319.bikedemo.presenter.UserPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BikeContract.View, UserContract.View {

    private BikePresenter bikePresenter=null;

    private UserPresenter userPresenter=null;

    private ArrayList<BikeResponese> bikeResponeses = new ArrayList<>();

    private MyInfoResponese myInfoResponese=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bicycle");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.arrow_left);


        bikePresenter = new BikePresenter(this);

        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setLat(24.5328410);
        locationRequest.setLng(118.1687860);
        bikePresenter.doGetNearBikes(locationRequest);


        userPresenter = new UserPresenter(this);
        userPresenter.doGetMyInfo();


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

    @Override
    public void showLoding() {

    }

    @Override
    public void hideLoding() {

    }

    @Override
    public void onLoadMyInfoSuccess(MyInfoResponese myInfoResponese) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void onLoadNearBikesSuccess(ArrayList<BikeResponese> bikes) {
          bikeResponeses=bikes;
    }

    @Override
    public void onGrenerateBikeSuccess() {

    }
}
