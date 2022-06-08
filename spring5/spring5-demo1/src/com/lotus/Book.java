package com.lotus;

/**
 * @author hefan
 * @package com.lotus
 * @date 2021/8/13 14:33
 * @description
 */
public class Book {
  private String bname;
  private String bauthor;
  private String address;
  // set方法注入
  public void setBname(String bname) {
    this.bname = bname;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setBauthor(String bauthor) {
    this.bauthor = bauthor;
  }

  public void testDemo() {
    System.out.println(bname + "::" + bauthor + "::" + address);
  }
}
