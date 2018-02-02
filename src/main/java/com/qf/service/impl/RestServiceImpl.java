package com.qf.service.impl;

import com.qf.dao.RestDao;
import com.qf.pojo.ReaList;
import com.qf.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestServiceImpl implements RestService {

    @Autowired
    private RestDao restDao;

    @Override
    public List<ReaList> getRest() {
        return restDao.getRest();
    }

    @Override
    public ReaList getRestById(int id) {
        return restDao.getRestById(id);
    }
}
