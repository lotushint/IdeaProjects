package com.lotushint.factory.factorymethod.pizzastore.order;

import com.lotushint.factory.factorymethod.pizzastore.pizza.LDCheesePizza;
import com.lotushint.factory.factorymethod.pizzastore.pizza.LDPepperPizza;
import com.lotushint.factory.factorymethod.pizzastore.pizza.Pizza;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/19 13:19
 * @package com.lotushint.factory.factorymethod.pizzastore.order
 * @description
 */
public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
