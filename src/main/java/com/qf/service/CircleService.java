package com.qf.service;

import com.qf.pojo.Circle;

import java.util.List;

public interface CircleService {

    List<Circle> getCircle();

    void addCircle(Circle circle);

    List<Circle> getCircleAndUser();

    void delCircle(int id);
}
