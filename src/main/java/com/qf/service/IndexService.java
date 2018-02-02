package com.qf.service;

import com.qf.pojo.Movement;

import java.util.List;

public interface IndexService {

    List<Movement> getIndexWeek(String mon, String week);

    void addIndexWeek(Movement movement);
}
