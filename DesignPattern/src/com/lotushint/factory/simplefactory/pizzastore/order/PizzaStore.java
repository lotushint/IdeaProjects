package com.lotushint.factory.simplefactory.pizzastore.order;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/5 20:52
 * @package com.lotushint.factory.simplefactory.pizzastore.order
 * @description
 */
public class PizzaStore {
    public static void main(String[] args) {
//        new OrderPizza();

        //使用简单工厂模式
//        new OrderPizza(new SimpleFactory());
//        System.out.println("--退出程序--");

        new OrderPizza2();
    }
}
