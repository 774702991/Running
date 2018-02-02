package com.qf.service.impl;

import com.qf.dao.IndexDao;
import com.qf.pojo.Movement;
import com.qf.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexDao indexDao;

    @Override
    public List<Movement> getIndexWeek(String mon, String week) {
        return indexDao.getIndexWeek(mon,week);
    }

    @Override
    public void addIndexWeek(Movement movement) {
        indexDao.addIndexWeek(movement);
    }
}
