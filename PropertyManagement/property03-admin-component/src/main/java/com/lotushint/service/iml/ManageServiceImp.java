package com.lotushint.service.iml;

import com.lotushint.dao.ManageDao;
import com.lotushint.entity.Manage;
import com.lotushint.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageServiceImp implements ManageService {
    @Autowired
    ManageDao dao;
    @Override
    public List<Manage> findAll() {
        return dao.findAll();
    }

    @Override
    public void add(Manage manage) {
        dao.add(manage);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public void update(Manage manage) {
        dao.update(manage);
    }

    @Override
    public Manage find(String id, String password) {
        return dao.find(id,password);
    }
}
