package com.insomnia.java.design.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author insomnia
 */
public class QueryRule implements Serializable {
    private static final long serialVersionUID = 7546241555558L;

    public static final int ASC_ORDER = 101;
    public static final int DESC_ORDER = 102;
    public static final int LIKE = 1;
    public static final int IN = 2;
    public static final int NOT_IN = 3;
    public static final int BETWEEN = 4;
    public static final int EQ= 5;
    public static final int NOT_EQ = 6;
    public static final int GT = 7;
    public static final int GE = 8;
    public static final int LT = 9;
    public static final int LE = 10;
    public static final int ISNULL = 11;
    public static final int IS_NOT_NULL = 12;
    public static final int IS_EMPTY = 13;
    public static final int IS_NOT_EMPTY = 14;
    public static final int AND = 201;
    public static final int OR = 202;

    private List<Rule> ruleList = new ArrayList<>();
    private List<QueryRule> queryRuleList = new ArrayList<>();
    private String propertyName;

    private QueryRule(){}

    private QueryRule(String propertyName){
        this.propertyName = propertyName;
    }

    public static QueryRule getInstance(){
        return new QueryRule();
    }

    /**
     * 添加降序规则
     * @param propertyName
     * @return
     */
    public QueryRule addAscOrder(String propertyName){
        this.ruleList.add(new Rule(ASC_ORDER,propertyName));
        return this;
    }

    public QueryRule addIsNull(String propertyName){
        this.ruleList.add(new Rule(ISNULL,propertyName).setAndOr(AND));
        return this;
    }

    public QueryRule addIsNotNull(String propertyName){
        this.ruleList.add(new Rule(IS_NOT_NULL,propertyName).setAndOr(AND));
        return this;
    }

    public QueryRule addIsEmpty(String propertyName){
        this.ruleList.add(new Rule(IS_EMPTY,propertyName).setAndOr(AND));
        return this;
    }

    public QueryRule addIsNotEmpty(String propertyName){
        this.ruleList.add(new Rule(IS_NOT_EMPTY,propertyName).setAndOr(AND));
        return this;
    }

    public QueryRule andLike(String propertyName,Object value){
        this.ruleList.add(new Rule(LIKE,propertyName,new Object[]{value}).setAndOr(AND));
        return this;
    }

    public QueryRule andEqual(String propertyName,Object value){
        this.ruleList.add(new Rule(EQ,propertyName,new Object[]{value}).setAndOr(AND));
        return this;
    }

    public QueryRule andBetween(String propertyName,Object ... values){
        this.ruleList.add(new Rule(BETWEEN,propertyName,values).setAndOr(AND));
        return this;
    }

    public QueryRule andIn(String propertyName,Object ... values){
        this.ruleList.add(new Rule(IN,propertyName,values).setAndOr(AND));
        return this;
    }

    public QueryRule andNotIn(String propertyName,Object ... values){
        this.ruleList.add(new Rule(NOT_IN,propertyName,values).setAndOr(AND));
        return this;
    }

    public List<Rule> getRuleList(){
        return this.ruleList;
    }

    public List<QueryRule> getQueryRuleList() {
        return this.queryRuleList;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    protected class Rule implements Serializable{
        private static final long serialVersionUID = 7546241455558L;
        private int type;
        private String property_name;
        private Object[] values;
        private int andOr = AND;

        public Rule(int paramInt,String paramStr){
            this.property_name = paramStr;
            this.type = paramInt;
        }

        public Rule(int paramInt , String paramStr , Object[] paramArrayOfObject){
            this.property_name = paramStr;
            this.type = paramInt;
            this.values = paramArrayOfObject;
        }

        public Rule setAndOr(int andOr){
            this.andOr = andOr;
            return this;
        }

        public int getAndOr(){
           return this.andOr;
        }

        public Object[] getValues() {
            return this.values;
        }

        public int getType() {
            return this.type;
        }

        public String getPropertyName() {
            return this.property_name;
        }
    }

}
