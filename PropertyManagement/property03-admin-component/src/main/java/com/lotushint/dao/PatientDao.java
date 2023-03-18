package com.lotushint.dao;

import com.lotushint.entity.Base;
import com.lotushint.entity.Patient;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface PatientDao {
    @Select("SELECT baseId,symptoms,hospital,critical,note,infectionSource,onsetDate FROM patient  where baseId NOT IN(SELECT baseId FROM dead) AND baseId NOT IN(SELECT baseId FROM cure)")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "symptoms", column = "symptoms"),
            @Result(property = "hospital", column = "hospital"),
            @Result(property = "critical", column = "critical"),
            @Result(property = "infectionSource", column = "infectionSource"),
            @Result(property = "onsetDate", column = "onsetDate"),
            @Result(property = "note", column = "note"),
            @Result(property = "inspects", column = "baseId", javaType = List.class, many = @Many(select = "com.lotushint.dao.InspectDao.findById")),
            @Result(property = "base", column = "baseId", javaType = Base.class, one = @One(select = "com.lotushint.dao.BaseDao.findById"))
    })
    //查找所有现存确诊病人
    public List<Patient> findAll();

    //添加病人
    @Insert("insert into patient(baseId,symptoms,hospital,critical,infectionSource,onsetDate,note)values(#{baseId},#{symptoms},#{hospital},#{critical},#{infectionSource},#{onsetDate},#{note})")
    public void add(Patient patient);

    //更新病人信息
    @Update("update patient set symptoms=#{symptoms},hospital=#{hospital},critical=#{critical},infectionSource=#{infectionSource},onsetDate=#{onsetDate},note=#{note} where baseId=#{baseId}")
    public void update(Patient patient);

    @Select("SELECT baseId,symptoms,hospital,critical,note,infectionSource,onsetDate " +
            " FROM patient WHERE  baseId NOT IN(SELECT baseId FROM dead) AND baseId NOT IN(SELECT baseId FROM cure) and baseId in(select id from base where name like #{name})")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "symptoms", column = "symptoms"),
            @Result(property = "hospital", column = "hospital"),
            @Result(property = "critical", column = "critical"),
            @Result(property = "infectionSource", column = "infectionSource"),
            @Result(property = "onsetDate", column = "onsetDate"),
            @Result(property = "note", column = "note"),
            @Result(property = "inspects", column = "baseId", javaType = List.class, many = @Many(select = "com.lotushint.dao.InspectDao.findById")),
            @Result(property = "base", column = "baseId", javaType = Base.class, one = @One(select = "com.lotushint.dao.BaseDao.findById"))
    })
    //根据姓名查找病人
    public List<Patient> findByName(String name);

    //根据id查找病人
    @Select("select baseId,symptoms,hospital,critical,note,infectionSource,onsetDate from patient where baseId=#{baseId}")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "symptoms", column = "symptoms"),
            @Result(property = "hospital", column = "hospital"),
            @Result(property = "critical", column = "critical"),
            @Result(property = "infectionSource", column = "infectionSource"),
            @Result(property = "onsetDate", column = "onsetDate"),
            @Result(property = "note", column = "note"),
            @Result(property = "inspects", column = "baseId", javaType = List.class, many = @Many(select = "com.lotushint.dao.InspectDao.findById")),
            @Result(property = "base", column = "baseId", javaType = Base.class, one = @One(select = "com.lotushint.dao.BaseDao.findById"))
    })
    public Patient findById(int baseId);

    @Select("select sum(1) from patient")
    public int number();

    //现存人数
    @Select("select sum(1) from patient where baseId not in(select baseId from cure) and baseId not in(select baseId from dead)")
    public int currentNumber();

    //查找当日之前的确诊数
    @Select("select sum(1) from patient where onsetDate <#{date}")
    public int beforeDay(Date date);

}
