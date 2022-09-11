package com.lotushint.mybatisplus2.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lotushint.mybatisplus2.mapper.ProductMapper;
import com.lotushint.mybatisplus2.pojo.Product;
import com.lotushint.mybatisplus2.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/7 20:20
 * @package com.lotushint.mybatisplus2.pojo
 * @description
 */
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
