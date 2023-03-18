package com.lotushint.service.iml;

import com.github.pagehelper.PageHelper;
import com.lotushint.dao.ResidentDao;
import com.lotushint.entity.Resident;
import com.lotushint.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class ResidentServiceImp implements ResidentService {
    @Autowired
    ResidentDao dao;
    @Override
    public void add(Resident resident) {
        dao.add(resident);
    }

    @Override
    public List<Resident> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }


    @Override
    public Resident get(int id) {

        Resident resident = dao.findById(id);
        return resident;
    }

    @Override
    public void update(int baseId, String current) {
        dao.update(baseId,current);
    }

    @Override
    public int number() {
        return dao.number();
    }

    @Override
    public List<Map<Integer,Date>> group() {
        return dao.group();
    }

    @Override
    public int beforeDay(Date date) {
        return dao.beforeDay(date);
    }

    @Override
    public List<Resident> findByName(String name) {
        return dao.findByName(name);
    }


}
