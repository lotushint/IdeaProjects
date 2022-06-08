package com.lotushint.student.entity;

import javax.persistence.*;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/11 13:30
 * @package com.lotushint.student.entity
 * @description
 */
@Entity //告诉springboot这是实体类，有需要，来这找
@Table(name = "student") //对应数据库中的表，配合application.properties可以自动生成student表
public class Student {

    @Id //设置主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) /**自增*/
    private Integer id;
    private String name;
    private int age;
    private String sex;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}


