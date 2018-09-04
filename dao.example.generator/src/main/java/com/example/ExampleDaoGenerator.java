package com.example;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class ExampleDaoGenerator {
    private static final String packageName = "com.example.edu.mytest.dao";
    private static final String generatePath = "app/src/main/java";
    public  static void main(String[] args) throws  Exception{
        Schema schema = new Schema(1,packageName);

        //调用
        addRideRecord(schema);


        new DaoGenerator().generateAll(schema,generatePath);

    }

    private static void addRideRecord(Schema schema){
        Entity rideRecord = schema.addEntity("RideRecord");
        rideRecord.addIdProperty();
        rideRecord.addIntProperty("bike_id");
        rideRecord.addDateProperty("start_at");
        rideRecord.addDateProperty("end_at");
        rideRecord.addBooleanProperty("is_pay");
        rideRecord.addIntProperty("money");
    }



}

