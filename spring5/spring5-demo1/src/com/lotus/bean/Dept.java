package com.lotus.bean;

/**
 * @author hefan
 * @package com.lotus.bean
 * @date 2021/8/16 11:44
 * @description 部门类
 */
public class Dept {
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
