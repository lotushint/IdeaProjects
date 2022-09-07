package com.lotushint.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.lotushint.mybatisplus.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok注解
@AllArgsConstructor
@NoArgsConstructor
//@TableName("t_user") //设置实体类所对应的表名
public class User {
    // 将属性对应的字段指定为主键
    // @TableId 注解的 value 属性用于指定主键的字段
    // @TableId 注解的 value 属性设置主键生成策略
    //@TableId(value = "uid", type = IdType.AUTO)
    @TableId("uid")
    private Long id;
//    @TableId
//    private Long uid;

    // 指定属性对应的字段名
    @TableField("user_name")
    private String name;
//    private String userName;

    private Integer age;

    private String email;

    @TableLogic
    private String isDeleted;

    @EnumValue //将注解所标识的属性的值存储到数据库中
    private SexEnum sex;

    public User(Long id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}