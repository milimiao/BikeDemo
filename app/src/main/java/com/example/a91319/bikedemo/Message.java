package com.example.a91319.bikedemo;

/**
 * Created by 黄君豪 on 2018/8/31.
 */

public class Message {

    private String My_time;
    private String Bike_number;
    private String Cycling_time;
    private String Cycling_money;

    public Message(String my_time, String bike_number, String cycling_time, String cycling_money) {
        My_time = my_time;
        Bike_number = bike_number;
        Cycling_time = cycling_time;
        Cycling_money = cycling_money;
    }

    public String getMy_time() {
        return My_time;
    }

    public void setMy_time(String my_time) {
        My_time = my_time;
    }

    public String getBike_number() {
        return Bike_number;
    }

    public void setBike_number(String bike_number) {
        Bike_number = bike_number;
    }

    public String getCycling_time() {
        return Cycling_time;
    }

    public void setCycling_time(String cycling_time) {
        Cycling_time = cycling_time;
    }

    public String getCycling_money() {
        return Cycling_money;
    }

    public void setCycling_money(String cycling_money) {
        Cycling_money = cycling_money;
    }
}
