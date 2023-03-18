package com.lotushint.dao;

import com.lotushint.entity.Base;
import com.lotushint.entity.MedicalStaff;
import com.lotushint.entity.Patient;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface MedicalStaffDao {
    @Select("select baseId,dischargeDate, current from medical_staff")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "patient",column = "baseId",javaType = Patient.class,one = @One(select = "com.lotushint.dao.PatientDao.findById")),
            @Result(property = "dischargeDate", column = "dischargeDate"),
            @Result(property = "current", column = "current"),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.lotushint.dao.BaseDao.findById"))

    })
    //查看所有治愈病人
    public List<MedicalStaff> findAll( );
    //添加治愈病人
    @Insert("insert into MedicalStaff(baseId,dischargeDate,current)values(#{baseId},#{dischargeDate},#{current})")
    public void add(MedicalStaff medicalStaff);

    //根据id查找治愈病人
    @Select("select baseId,dischargeDate, current from medical_staff where baseId = #{id}")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "dischargeDate", column = "dischargeDate"),
            @Result(property = "current", column = "current"),
            @Result(property = "patient",column = "baseId",javaType = Patient.class,one = @One(select = "com.lotushint.dao.PatientDao.findById")),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.lotushint.dao.BaseDao.findById"))
    })
    public MedicalStaff findById(int id);
    @Update("update  medical_staff set current=#{current} where baseId=#{baseId}")
    public void update(int baseId,String current);

    @Select("select sum(1) from medical_staff")
    public int number();

    @Select(" SELECT SUM(1),dischargeDate  FROM medical_staff GROUP BY dischargeDate;")
    public List<Map<Integer, Date>> group();
    @Select("select sum(1) from medical_staff where dischargeDate <#{date}")
    public int beforeDay(Date date);

    @Select("select baseId,dischargeDate, current from medical_staff WHERE baseId in(select id from base where name like #{name})")
    @Results({
            @Result(id = true, property = "baseId", column = "baseId"),
            @Result(property = "patient",column = "baseId",javaType = Patient.class,many = @Many(select = "com.lotushint.dao.PatientDao.findById")),
            @Result(property = "dischargeDate", column = "dischargeDate"),
            @Result(property = "current", column = "current"),
            @Result(property = "base",column = "baseId",javaType = Base.class,one = @One(select = "com.lotushint.dao.BaseDao.findById"))

    })
    public List<MedicalStaff> findByName(String name);

}
