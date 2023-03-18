package com.lotushint.service;

import com.lotushint.entity.Hospital;

import java.util.List;

public interface HospitalService {
    public List<Hospital> findAll();


    public boolean add(Hospital hospital);


    public List<Hospital> findByName(String name);
    public boolean update(Hospital hospital);
}
