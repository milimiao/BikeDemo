package com.example.a91319.bikedemo.net.responeses;

/**
 * Created by 黄君豪 on 2018/9/10.
 */

public class RideRecordResponese {

    private int id;
    private int user_id;
    private int bike_id;
    private String star_at;
    private String end_at;
    private int money;
    private boolean is_pay;
    private String created_at;
    private String updated_at;
    private int time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBike_id() {
        return bike_id;
    }

    public void setBike_id(int bike_id) {
        this.bike_id = bike_id;
    }

    public String getStar_at() {
        return star_at;
    }

    public void setStar_at(String star_at) {
        this.star_at = star_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean is_pay() {
        return is_pay;
    }

    public void setIs_pay(boolean is_pay) {
        this.is_pay = is_pay;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
