package com.lotushint.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Hospital implements Serializable {
    private int id;
    private String name;
    private String address;
    private int phone;
    public Hospital(String name){
        super();
        this.name=name;

    }
}
