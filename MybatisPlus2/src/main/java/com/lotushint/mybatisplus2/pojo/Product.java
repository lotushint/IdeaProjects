package com.lotushint.mybatisplus2.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/7 20:20
 * @package com.lotushint.mybatisplus2.pojo
 * @description
 */
@Data
@TableName("product")
public class Product {

    private Integer id;

    private String name;

    private Integer price;

    private Integer version;

}
