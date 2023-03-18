package com.lotushint.service;

import com.lotushint.entity.Source;

import java.util.List;

public interface SourceService {
    //根据医院id寻找物资
    public List<Source> findByHospitalId(int hospitalId);
    //删除物资
    public void deleteByid(int id);
    //更新物资
    public void update(Source source);
    //添加物资
    public void addSource(Source source);
}
