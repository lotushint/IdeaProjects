package com.itheima.dao;

import com.itheima.pojo.OrderSetting;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderSettingDao {
    void add(OrderSetting orderSetting);

    void editNumberByOrderDate(OrderSetting orderSetting);

    long findCountByOrderDate(Date orderDate);

    List<OrderSetting> getOrderSettingByMonth(String date);

    OrderSetting findByOrderDate(Date date);

    /**
     * 更新已预约人数
     *
     * @param orderSetting
     */
    void editReservationsByOrderDate(OrderSetting orderSetting);
}