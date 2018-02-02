package com.qf.service.impl;

import com.qf.dao.CircleDao;
import com.qf.pojo.Circle;
import com.qf.service.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircleServiceImpl implements CircleService {

    @Autowired
    private CircleDao circleDao;

    @Override
    public List<Circle> getCircle() {
        return circleDao.getCircle();
    }

    @Override
    public void addCircle(Circle circle) {
        circleDao.addCircle(circle);
    }

    @Override
    public List<Circle> getCircleAndUser() {
        return circleDao.getCircleAndUser();
    }

    @Override
    public void delCircle(int id) {
        circleDao.delCircle(id);
    }
}
