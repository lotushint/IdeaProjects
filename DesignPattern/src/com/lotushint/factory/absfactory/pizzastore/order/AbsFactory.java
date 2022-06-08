package com.lotushint.factory.absfactory.pizzastore.order;

import com.lotushint.factory.absfactory.pizzastore.pizza.Pizza;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/21 15:01
 * @package com.lotushint.factory.absfactory.pizzastore.order
 * @description 一个抽象工厂模式的抽象层（接口）
 */
public interface AbsFactory {
    //让下面的工厂子类来具体实现

    public Pizza createPizza(String orderType);
}
