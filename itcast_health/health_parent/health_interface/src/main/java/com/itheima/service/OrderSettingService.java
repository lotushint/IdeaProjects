package com.itheima.service;

import com.itheima.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/29 16:12
 * @package com.itheima.service
 * @description
 */
public interface OrderSettingService {
    void add(List<OrderSetting> data);

    List<Map> getOrderSettingByMonth(String date);

    void editNumberByDate(OrderSetting orderSetting);
}
