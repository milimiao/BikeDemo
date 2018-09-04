package com.example.edu.mytest.dao;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "RIDE_RECORD".
 */
@Entity
public class RideRecord {

    @Id
    private Long id;
    private Integer bike_id;
    private java.util.Date start_at;
    private java.util.Date end_at;
    private Boolean is_pay;
    private Integer money;

    @Generated
    public RideRecord() {
    }

    public RideRecord(Long id) {
        this.id = id;
    }

    @Generated
    public RideRecord(Long id, Integer bike_id, java.util.Date start_at, java.util.Date end_at, Boolean is_pay, Integer money) {
        this.id = id;
        this.bike_id = bike_id;
        this.start_at = start_at;
        this.end_at = end_at;
        this.is_pay = is_pay;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBike_id() {
        return bike_id;
    }

    public void setBike_id(Integer bike_id) {
        this.bike_id = bike_id;
    }

    public java.util.Date getStart_at() {
        return start_at;
    }

    public void setStart_at(java.util.Date start_at) {
        this.start_at = start_at;
    }

    public java.util.Date getEnd_at() {
        return end_at;
    }

    public void setEnd_at(java.util.Date end_at) {
        this.end_at = end_at;
    }

    public Boolean getIs_pay() {
        return is_pay;
    }

    public void setIs_pay(Boolean is_pay) {
        this.is_pay = is_pay;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

}
