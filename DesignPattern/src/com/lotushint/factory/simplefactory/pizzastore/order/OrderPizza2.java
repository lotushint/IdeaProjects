package com.lotushint.factory.simplefactory.pizzastore.order;

import com.lotushint.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/10 20:25
 * @package com.lotushint.factory.simplefactory.pizzastore.order
 * @description 用静态工厂模式
 */
public class OrderPizza2 {
    String orderType = "";
    Pizza pizza = null;

    public OrderPizza2() {
        do {
            orderType = getType();
            pizza = SimpleFactory.createPizza2(orderType);

            //输出pizza
            if (pizza != null) {
                //订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购披萨失败");
                break;
            }
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
