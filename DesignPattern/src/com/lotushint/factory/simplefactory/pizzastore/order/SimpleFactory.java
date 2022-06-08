package com.lotushint.factory.simplefactory.pizzastore.order;

import com.lotushint.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.lotushint.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.lotushint.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.lotushint.factory.simplefactory.pizzastore.pizza.Pizza;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/10 20:01
 * @package com.lotushint.factory.simplefactory.pizzastore.order
 * @description 简单工厂类
 */
public class SimpleFactory {
    /**
     * 根据 orderType 返回对应的Pizza对象
     *
     * @param orderType
     * @return
     */
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;

        System.out.println("使用简单工厂模式");

        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" 希腊披萨 ");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName(" 奶酪披萨 ");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName(" 胡椒披萨 ");
        }
        return pizza;
    }

    /**
     * 简单工厂模式也叫静态工厂模式
     *
     * @param orderType
     * @return
     */
    public static Pizza createPizza2(String orderType) {
        Pizza pizza = null;

        System.out.println("使用简单工厂模式2");

        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" 希腊披萨 ");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName(" 奶酪披萨 ");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName(" 胡椒披萨 ");
        }
        return pizza;
    }
}
