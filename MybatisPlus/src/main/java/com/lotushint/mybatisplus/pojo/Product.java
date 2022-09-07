package com.lotushint.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/7 15:58
 * @package com.lotushint.mybatisplus.pojo
 * @description
 */
@Data
public class Product {
    private Long id;

    private String name;

    private Integer price;

    @Version //标识乐观锁版本号字段
    private Integer version;
}
