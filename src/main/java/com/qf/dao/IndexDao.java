package com.qf.dao;

import com.qf.pojo.Movement;

import java.util.List;

public interface IndexDao {

    List<Movement> getIndexWeek(String mon, String week);

    void addIndexWeek(Movement movement);
}
