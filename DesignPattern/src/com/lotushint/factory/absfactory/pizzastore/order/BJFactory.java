package com.lotushint.factory.absfactory.pizzastore.order;

import com.lotushint.factory.absfactory.pizzastore.pizza.BJCheesePizza;
import com.lotushint.factory.absfactory.pizzastore.pizza.BJPepperPizza;
import com.lotushint.factory.absfactory.pizzastore.pizza.Pizza;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/21 15:04
 * @package com.lotushint.factory.absfactory.pizzastore.order
 * @description
 */
public class BJFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
