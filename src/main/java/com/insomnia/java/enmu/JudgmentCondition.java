package com.insomnia.java.enmu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author insomnia
 */
public enum JudgmentCondition {
    /**
     * vip 根据 vip 判断
     * vipType 根据 vipType 判断
     */
    VIP(1,"vip"),
    VIP_TYPE(2,"vipType");

    private int index;
    private String value;


    JudgmentCondition(int index ,String value){
        this.index = index;
        this.value = value;
    }

   private static Map<Integer,String> currentMap;

    static {
        currentMap = new HashMap<>();
        JudgmentCondition[] values = JudgmentCondition.values();
        for (JudgmentCondition value : values){
            currentMap.put(value.index,value.value);
        }
    }



}
