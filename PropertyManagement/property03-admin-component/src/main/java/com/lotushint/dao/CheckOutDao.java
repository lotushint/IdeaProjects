package com.lotushint.dao;

import com.lotushint.entity.CheckOut;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: bonbon
 * @Date: 2021/4/15 12:59
 */
@Mapper
public interface CheckOutDao {

    /**
     * 打卡
     * @param checkOut
     */
    @Insert("insert into checkout(baseId,currentPosition,bodyTemperature,healthState,isToHighArea,isTouch,remarks,name,checkOutDate)values(#{baseId},#{currentPosition},#{bodyTemperature},#{healthState},#{isToHighArea},#{isTouch},#{remarks},#{name},#{checkOutDate})")
    void add(CheckOut checkOut);

    /**
     * 查看打卡记录
     * @return
     */
    @Select("select currentPosition,bodyTemperature,healthState,isToHighArea,isTouch,remarks,name,checkOutDate from checkout ")
    @Results({
            @Result(property = "currentPosition", column = "currentPosition"),
            @Result(property = "bodyTemperature", column = "bodyTemperature"),
            @Result(property = "healthState", column = "healthState"),
            @Result(property = "isToHighArea", column = "isToHighArea"),
            @Result(property = "isTouch", column = "isTouch"),
            @Result(property = "remarks", column = "remarks"),
            @Result(property = "name", column = "name"),
            @Result(property = "checkOutDate", column = "checkOutDate"),
    })
    List<CheckOut> findAll();

    //查找
    @Select("select * from checkout where name like #{name}")
    @Results({
            @Result(property = "currentPosition", column = "currentPosition"),
            @Result(property = "bodyTemperature", column = "bodyTemperature"),
            @Result(property = "healthState", column = "healthState"),
            @Result(property = "isToHighArea", column = "isToHighArea"),
            @Result(property = "isTouch", column = "isTouch"),
            @Result(property = "remarks", column = "remarks"),
            @Result(property = "name", column = "name"),
            @Result(property = "checkOutDate", column = "checkOutDate"),
    })
    List<CheckOut> findByName(String name);
}
