package com.lotushint.service.iml;

import com.github.pagehelper.PageHelper;
import com.lotushint.dao.TouchDao;
import com.lotushint.entity.Touch;
import com.lotushint.service.TouchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouchServiceImp implements TouchService {
    @Autowired
    TouchDao dao;


    @Override
    public List<Touch> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }

    @Override
    public void add(Touch touch) {
        dao.add(touch);
    }

    @Override
    public List<Touch> findByName(String name) {
        return dao.findByName("%"+name+"%");
    }

    @Override
    public Touch findById(int baseId) {
        return dao.findById(baseId);
    }

    @Override
    public void toSafe(int baseId) {
        dao.toSafe(baseId);
    }

    @Override
    public Integer number() {
        Integer i = dao.number();
        if (i==null){
            return 0;
        }
        return i;
    }

    @Override
    public Integer currentNumber() {
        Integer i = dao.currentNumber();
        if (i==null){
            return 0;
        }
        return i;
    }
}
