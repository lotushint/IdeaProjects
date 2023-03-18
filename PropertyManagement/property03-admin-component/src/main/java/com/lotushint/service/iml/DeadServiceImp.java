package com.lotushint.service.iml;

import com.github.pagehelper.PageHelper;
import com.lotushint.dao.DeadDao;
import com.lotushint.entity.Dead;
import com.lotushint.service.DeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeadServiceImp implements DeadService {
    @Autowired
    DeadDao dao;
    @Override
    public void add(Dead dead) {
        dao.add(dead);
    }

    @Override
    public List<Dead> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public Dead get(int id) {
       return dao.findById(id);
    }

    @Override
    public int number() {
        return dao.number();
    }

    @Override
    public List<Dead> findByName(String name) {
        return dao.findByName(name);
    }
}
