package com.itheima.service;

import com.itheima.entity.Result;

import java.util.Map;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/1 13:34
 * @package com.itheima.service
 * @description
 */
public interface OrderService {
    Result order(Map map) throws Exception;

    Map findById(Integer id) throws Exception;
}
