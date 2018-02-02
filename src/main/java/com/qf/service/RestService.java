package com.qf.service;

import com.qf.pojo.ReaList;

import java.util.List;

public interface RestService {

    List<ReaList> getRest();

    ReaList getRestById(int id);
}
