package com.lotushint.service;

import com.lotushint.entity.MedicalStaff;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface MedicalStaffService {

    void add(MedicalStaff resident);

    List<MedicalStaff> findAll(int page, int size);

    MedicalStaff get(int id);

    void update(int baseId, String current);

    int number();

    List<Map<Integer, Date>> group();

    int beforeDay(Date date);

    List<MedicalStaff> findByName(String name);

}
