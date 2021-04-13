package com.insomnia.java.beans;

import java.util.Objects;

/**
 * @author insomnia
 * @date 2021/4/13 下午6:39
 * @effect
 */
public class User {
    private Integer userId;
    private String name;
    private String vip;
    private String vipType;

    public User() {
    }

    public User(Integer userId, String name, String vip, String vipType) {
        this.userId = userId;
        this.name = name;
        this.vip = vip;
        this.vipType = vipType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserId().equals(user.getUserId()) && Objects.equals(getName(), user.getName()) && Objects.equals(getVip(), user.getVip()) && Objects.equals(getVipType(), user.getVipType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getName(), getVip(), getVipType());
    }
}
