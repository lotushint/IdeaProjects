package com.lotushint.mp.beans;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/23 15:06
 * @package com.lotushint.mp.beans
 * @description
 */

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * javaBean
 * <p>
 * 定义JavaBean中成员变量时所用的类型：
 * 因为每个基本类型都有一个默认值：
 * int ==> 0
 * boolean ==> false
 */

/**
 * MybatisPlus会默认使用实体类的类名到数据库中找对应的表
 * @TableName可以更改要查找的表
 */
//@TableName("tbl_employee")
public class Employee {
    //推荐使用引用包装类型，这样有一个统一的值NULL
    /**
     * @TableId:
     *  value:指定表中的主键列的列名，如果实体属性名与列名一致，可以省略不指定
     *  type:指定主键策略
     */
//    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "last_name")
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;
    /**
     * 该字段在表中不存在，设置@TableField(exist = false)会忽略这个字段，插入操作不会报错
     */
    @TableField(exist = false)
    private Double salary;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
