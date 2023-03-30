package com.itheima.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/27 22:20
 * @package com.itheima.redis.pojo
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
}
