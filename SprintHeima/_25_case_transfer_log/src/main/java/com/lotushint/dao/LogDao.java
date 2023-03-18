package com.lotushint.dao;

import org.apache.ibatis.annotations.Insert;

public interface LogDao {
    @Insert("insert into user_log (info,createDate) values(#{info},now())")
    void log(String info);
}
