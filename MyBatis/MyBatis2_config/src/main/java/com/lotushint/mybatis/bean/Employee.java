package com.lotushint.mybatis.bean;

import org.apache.ibatis.type.Alias;

/**
 * @author hefan
 * @package com.lotushint.mybatis
 * @date 2022/1/12 15:52
 * @description
 */
@Alias("emp")
public class Employee {
    private Integer id;
    private String email;
    private String lastName;
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", last_name='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
