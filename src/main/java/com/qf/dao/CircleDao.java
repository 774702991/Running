package com.qf.dao;

import com.qf.pojo.Circle;

import java.util.List;

public interface CircleDao {

   List<Circle> getCircle();

   void addCircle(Circle circle);

   List<Circle> getCircleAndUser();

   void delCircle(int id);
}
