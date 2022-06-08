package com.lotushint.factory.absfactory.pizzastore.order;

import com.lotushint.factory.absfactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/21 15:10
 * @package com.lotushint.factory.absfactory.pizzastore.order
 * @description
 */
public class OrderPizza {
    AbsFactory factory;

    public OrderPizza(AbsFactory factory){
        setAbsFactory(factory);
    }

    public void setAbsFactory(AbsFactory factory){
        Pizza pizza = null;
        String orderType = "";
        this.factory = factory;
        do{
            orderType = getType();
            pizza = factory.createPizza(orderType);
            if (pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购失败");
                break;
            }
        }while (true);
    }

    /**
     * 写一个方法，可以获取客户希望订购的披萨种类
     */
    private String getType() {
        try {
            BufferedReader string = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = string.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
