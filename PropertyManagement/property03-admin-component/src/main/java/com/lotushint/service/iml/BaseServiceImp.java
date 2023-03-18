package com.lotushint.service.iml;

import com.lotushint.dao.BaseDao;
import com.lotushint.entity.Base;
import com.lotushint.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseServiceImp implements BaseService {

    @Autowired
    BaseDao dao;

    @Override
    public List<com.lotushint.entity.Base> findAll() {
        return null;
    }

    @Override
    public com.lotushint.entity.Base findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void add(Base base) {
        dao.add(base);
    }

    @Override
    public Base findByIdCard(String idCard) {
        return dao.findByIdCard(idCard);
    }

    @Override
    public void update(Base base) {
        dao.update(base);
    }
}
