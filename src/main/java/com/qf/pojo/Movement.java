package com.qf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Movement {

    private Integer id;
    private String num;
    private String percentage;
    private Date week;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getWeek() {
        return week;
    }

    public void setWeek(Date week) {
        this.week = week;
    }
}
