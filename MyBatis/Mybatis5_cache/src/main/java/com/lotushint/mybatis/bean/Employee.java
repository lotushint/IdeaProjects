package com.lotushint.mybatis.bean;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author hefan
 * @package com.lotushint.mybatis
 * @date 2022/1/12 15:52
 * @description
 */
@Alias("emp")
public class Employee implements Serializable {
    private Integer id;
    private String lastName;
    private String gender;
    private String email;
    private Department dept;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String gender, String email) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    public Employee(Integer id, String lastName, String gender, String email, Department dept) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dept = dept;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
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
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
