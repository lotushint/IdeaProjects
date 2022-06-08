package com.lotushint.factory.factorymethod.pizzastore.order;

import com.lotushint.factory.factorymethod.pizzastore.pizza.BJCheesePizza;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/19 13:27
 * @package com.lotushint.factory.factorymethod.pizzastore.order
 * @description
 */
public class PizzaStore {
    public static void main(String[] args) {
        String loc = new Scanner(System.in).nextLine();

        if (loc.equals("bj")) {
            //创建北京口味的各种pizza
            new BJOrderPizza();
        } else if (loc.equals("ld")) {
            //创建伦敦口味的各种pizza
            new LDOrderPizza();
        }
    }
}
