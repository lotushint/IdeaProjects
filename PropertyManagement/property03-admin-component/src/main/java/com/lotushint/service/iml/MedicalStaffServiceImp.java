package com.lotushint.service.iml;

import com.github.pagehelper.PageHelper;
import com.lotushint.dao.MedicalStaffDao;
import com.lotushint.entity.MedicalStaff;
import com.lotushint.service.MedicalStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Service
public class MedicalStaffServiceImp implements MedicalStaffService {
    @Autowired
    MedicalStaffDao dao;
    @Override
    public void add(MedicalStaff medicalStaff) {
        dao.add(medicalStaff);
    }

    @Override
    public List<MedicalStaff> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return dao.findAll();
    }


    @Override
    public MedicalStaff get(int id) {

        MedicalStaff medicalStaff = dao.findById(id);
        return medicalStaff;
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
    public List<MedicalStaff> findByName(String name) {
        return dao.findByName(name);
    }


}
