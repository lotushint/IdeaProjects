package com.lotushint.factory.factorymethod.pizzastore.order;

import com.lotushint.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/5 20:44
 * @package com.lotushint.factory.simplefactory.pizzastore.order
 * @description
 */
public abstract class OrderPizza {
    /**
     * 定义一个抽象方法，createPizza,让各个工厂子类自己实现
     *
     * @param orderType
     * @return
     */
    abstract Pizza createPizza(String orderType);

    public OrderPizza() {
        Pizza pizza = null;
        /**
         * 订购披萨的类型
         */
        String orderType;
        do {
            orderType = getType();
            pizza = createPizza(orderType);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
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
