package com.lotus.bean;

/**
 * @author hefan
 * @package com.lotus.bean
 * @date 2021/8/16 11:44
 * @description 员工类
 */
public class Emp {
  private String ename;
  private String gender;

  // 员工属于某一个部门，使用对象形式进行表示
  private Dept dept;

  public Dept getDept() {
    return dept;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setDept(com.lotus.bean.Dept dept) {
    this.dept = dept;
  }

  public void add() {
    System.out.println(ename + "::" + gender + "::" + dept);
  }
}
