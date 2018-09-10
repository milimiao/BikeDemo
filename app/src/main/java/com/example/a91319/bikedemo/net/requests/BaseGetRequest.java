package com.example.a91319.bikedemo.net.requests;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 黄君豪 on 2018/9/10.
 *
 */


//将getrequest中所有定义属性转换成map
public abstract class BaseGetRequest {

    public Map<String,Object> toMap(){
        HashMap<String,Object> hashMap=new HashMap<>();
        Field[] fields=this.getClass().getDeclaredFields();
        for (int i=0;i<fields.length;i++){
            Field field=fields[i];
            field.setAccessible(true);
            try {
                if(field.get(this)!=null){

                    hashMap.put(field.getName(),field.get(this));



                }
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }

        }
        return hashMap;
    }



}
