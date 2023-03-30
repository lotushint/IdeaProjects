package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.OrderSettingDao;
import com.itheima.pojo.OrderSetting;
import com.itheima.service.OrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/29 16:19
 * @package com.itheima.service.impl
 * @description 预约设置服务
 */
@Service(interfaceClass = OrderSettingService.class)
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService {
    @Autowired
    private OrderSettingDao orderSettingDao;

    /**
     * 批量导入预约数据
     *
     * @param data
     */
    @Override
    public void add(List<OrderSetting> data) {
        // 不要直接插入，可能会有重复的，用日期判断
        if (data != null && data.size() > 0) {
            for (OrderSetting orderSetting : data) {
                // 判断当前日期是否已经进行了预约设置
                long countByOrderDate = orderSettingDao.findCountByOrderDate(orderSetting.getOrderDate());
                if (countByOrderDate > 0) {
                    // 已经进行了预约设置，执行更新操作
                    orderSettingDao.editNumberByOrderDate(orderSetting);
                } else {
                    // 没有进行预约设置，执行插入操作
                    orderSettingDao.add(orderSetting);
                }
            }
        }

    }

    @Override
    public List<Map> getOrderSettingByMonth(String date) {//2019-3
        // 转化格式为 2019-03
        String format = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            Date formatDate = sdf.parse(date);
            format = sdf.format(formatDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // 调用 dao，根据日期范围查询预约设置数据
        List<OrderSetting> list = orderSettingDao.getOrderSettingByMonth(format);

        List<Map> result = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (OrderSetting orderSetting : list) {
                Map<String, Object> orderSettingMap = new HashMap<>();
                orderSettingMap.put("date", orderSetting.getOrderDate().getDate());//获得日期（几号）
                orderSettingMap.put("number", orderSetting.getNumber());//可预约人数
                orderSettingMap.put("reservations", orderSetting.getReservations());//已预约人数
                result.add(orderSettingMap);
            }
        }
        return result;
    }

    /**
     * 根据日期修改可预约人数
     *
     * @param orderSetting
     */
    @Override
    public void editNumberByDate(OrderSetting orderSetting) {
        long count = orderSettingDao.findCountByOrderDate(orderSetting.getOrderDate());
        if (count > 0) {
            //当前日期已经进行了预约设置，需要进行修改操作
            orderSettingDao.editNumberByOrderDate(orderSetting);
        } else {
            //当前日期没有进行预约设置，进行添加操作
            orderSettingDao.add(orderSetting);
        }
    }
}
