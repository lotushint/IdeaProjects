package com.lotushint.service;

import com.lotushint.entity.Inspect;

import java.util.List;

public interface InspectService {
    public List<Inspect> find(int baseId);
    public void add(Inspect inspect);
}
