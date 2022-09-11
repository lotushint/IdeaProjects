package com.lotushint.boot.bean;

import lombok.*;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/9 16:11
 * @package com.lotushint.boot.controller
 * @description 用户
 */
@NoArgsConstructor
//@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class User {

    private String name;
    private Integer age;

    private Pet pet;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


}
