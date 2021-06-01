package com.insomnia.java.service;

import com.alibaba.fastjson.JSONObject;
import com.insomnia.java.db.BackSet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.CheckedOutputStream;

/**
 * @author insomnia
 */
public class MessageService {


    private static final  String COUNT = "count";
    private static Map<String,Integer> currentMap;

    static{
        currentMap = new ConcurrentHashMap<>();
    }

    public static void resetCount(){

        if (currentMap.containsKey(COUNT)){
            currentMap.replace(COUNT,BackSet.everyDayMessageCount);
        }else{
            currentMap.put(COUNT , BackSet.everyDayMessageCount);
        }

    }

    public static Map<String,Integer> getCurrentMap(){
        return currentMap;
    }

    public static void main(String[] args) {
            Integer count = currentMap.get(COUNT);
            System.out.println("发送短信之前" + count);
            System.out.println("发送一条短信 " );
            currentMap.replace(COUNT,--count);
            System.out.println("发送短信之后的次数" + currentMap.get(COUNT));

    }


}
