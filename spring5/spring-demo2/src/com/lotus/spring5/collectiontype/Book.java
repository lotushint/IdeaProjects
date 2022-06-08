package com.lotus.spring5.collectiontype;

import java.util.List;

/**
 * @author hefan
 * @package com.lotus.spring5.collectiontype
 * @date 2021/8/17 16:28
 * @description
 */
public class Book {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void test(){
        System.out.println(list);
    }
}
