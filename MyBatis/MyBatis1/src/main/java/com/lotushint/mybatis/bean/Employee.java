package com.lotushint.mybatis.bean;

/**
 * @author hefan
 * @package com.lotushint.com.lotushint.mybatis
 * @date 2022/1/12 15:52
 * @description
 */
public class Employee {
    private Integer id;
    private String email;
    private String last_name;
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
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
