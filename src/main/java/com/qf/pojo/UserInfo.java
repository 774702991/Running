package com.qf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserInfo {

    private Integer id;
    private String nickname;
    private String img;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date brithday;
    private String sex;
    private String city;
    private String summary;
    private String walking = "暂无";
    private String running = "暂无";
    private String grade = "暂无";
    private String recently = "暂无";
    private String cycling = "暂无";
    private String fitness = "暂无";
    private String latestCycling = "暂无";
    private String latestFitness = "暂无";
    private User user = new User();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getWalking() {
        return walking;
    }

    public void setWalking(String walking) {
        this.walking = walking;
    }

    public String getRunning() {
        return running;
    }

    public void setRunning(String running) {
        this.running = running;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRecently() {
        return recently;
    }

    public void setRecently(String recently) {
        this.recently = recently;
    }

    public String getCycling() {
        return cycling;
    }

    public void setCycling(String cycling) {
        this.cycling = cycling;
    }

    public String getFitness() {
        return fitness;
    }

    public void setFitness(String fitness) {
        this.fitness = fitness;
    }

    public String getLatestCycling() {
        return latestCycling;
    }

    public void setLatestCycling(String latestCycling) {
        this.latestCycling = latestCycling;
    }

    public String getLatestFitness() {
        return latestFitness;
    }

    public void setLatestFitness(String latestFitness) {
        this.latestFitness = latestFitness;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", img='" + img + '\'' +
                ", brithday=" + brithday +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                ", summary='" + summary + '\'' +
                ", user=" + user +
                '}';
    }
}
