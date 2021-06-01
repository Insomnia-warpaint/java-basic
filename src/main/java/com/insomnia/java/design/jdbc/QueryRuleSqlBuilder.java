package com.insomnia.java.design.jdbc;

import com.insomnia.java.HashMap;
import com.insomnia.java.design.jdbc.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author insomnia
 */
public class QueryRuleSqlBuilder {
    /**
     * 记录参数所在位置
     */
    private int CURRENT_INDEX = 0;
    /**
     * 保存列名列表
     */
    private List<String> properties;
    /**
     * 保存参数
     */
    private List<Object> values;
    /**
     * 排序规则
     */
    private List<Order> orders;
    private String whereSql = "";
    private String orderSql = "";
    private Object[] valueArr = new Object[]{};
    private Map<Object,Object> valueMap = new HashMap<>();


    private String getWhereSql(){
        return this.whereSql;
    }

    public String getOrderSql() {
        return this.orderSql;
    }

    public Object[] getValues() {
        return this.valueArr;
    }

    public Map<Object, Object> getValueMap() {
        return this.valueMap;
    }
    
    public QueryRuleSqlBuilder(QueryRule queryRule){
        CURRENT_INDEX = 0;
        properties = new ArrayList<>();
        values = new ArrayList<>();
        orders = new ArrayList<>();
        
        for (QueryRule.Rule rule : queryRule.getRuleList()){
            switch (rule.getType()){
                case QueryRule.BETWEEN:
                    processBetween(rule);
                    break;
                case QueryRule.EQ:
                    processEqual(rule);
                    break;
                case QueryRule.LIKE:
                    processLike(rule);
                    break;
                case QueryRule.NOT_EQ:
                    processNotEqual(rule);
                    break;
                case QueryRule.GT:
                    processGreaterThen(rule);
                    break;
                case QueryRule.GE:
                    processGreaterEqual(rule);
                    break;
                case QueryRule.LT:
                    processLessThen(rule);
                    break;
                case QueryRule.LE:
                    processLessEqual(rule);
                    break;
                case QueryRule.IN:
                    processIN(rule);
                    break;
                case QueryRule.NOT_IN:
                    processNotIN(rule);
                    break;
                case QueryRule.ISNULL:
                    processIsNull(rule);
                    break;
                case QueryRule.IS_NOT_NULL:
                    processIsNotNull(rule);
                    break;
                case QueryRule.IS_EMPTY:
                    processIsEmpty(rule);
                    break;
                case QueryRule.IS_NOT_EMPTY:
                    processIsNotEmpty(rule);
                    break;
                case QueryRule.ASC_ORDER:
                    processOrder(rule);
                    break;
                case QueryRule.DESC_ORDER:
                    processOrder(rule);
                    break;
                default:
                    throw new IllegalArgumentException("type" + rule.getType() + "not supported");
            }
        }
    }

    private void processOrder(QueryRule.Rule rule) {
    }

    private void processIsNotEmpty(QueryRule.Rule rule) {
    }

    private void processIsEmpty(QueryRule.Rule rule) {
    }

    private void processIsNotNull(QueryRule.Rule rule) {
    }

    private void processIsNull(QueryRule.Rule rule) {
    }

    private void processNotIN(QueryRule.Rule rule) {
    }

    private void processIN(QueryRule.Rule rule) {
    }

    private void processLessEqual(QueryRule.Rule rule) {
    }

    private void processLessThen(QueryRule.Rule rule) {
    }

    private void processGreaterEqual(QueryRule.Rule rule) {
    }

    private void processGreaterThen(QueryRule.Rule rule) {
    }

    private void processNotEqual(QueryRule.Rule rule) {
    }

    private void processLike(QueryRule.Rule rule) {
    }

    private void processEqual(QueryRule.Rule rule) {
    }

    private void processBetween(QueryRule.Rule rule) {
    }
}
