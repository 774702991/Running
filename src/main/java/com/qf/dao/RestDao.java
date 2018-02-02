package com.qf.dao;

import com.qf.pojo.ReaList;

import java.util.List;

public interface RestDao {

    List<ReaList> getRest();

    ReaList getRestById(int id);
}
