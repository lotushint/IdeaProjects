package com.lotus;

/**
 * @author hefan
 * @package com.lotus
 * @date 2021/8/13 14:52
 * @description 使用有参构造进行生成
 */
public class Orders {

  private String oname;
  private String address;

  public Orders(String oname, String address) {
    this.oname = oname;
    this.address = address;
  }

  public void ordersTest() {
    System.out.println(oname + "::" + address);
  }
}
