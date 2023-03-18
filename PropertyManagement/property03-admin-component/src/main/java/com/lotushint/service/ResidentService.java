package com.lotushint.service;

import com.lotushint.entity.Resident;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface ResidentService {

    void add(Resident resident);

    List<Resident> findAll(int page, int size);

    Resident get(int id);

    void update(int baseId, String current);

    int number();

    List<Map<Integer, Date>> group();

    int beforeDay(Date date);

    List<Resident> findByName(String name);

}
