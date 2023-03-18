package com.lotushint.service;
import com.lotushint.entity.Manage;

import java.util.List;

public interface ManageService {
     List<Manage> findAll();


    public void add(Manage manage);

    public void delete(String id);

    public void update(Manage manage);

    public Manage find(String id,String password);
}
