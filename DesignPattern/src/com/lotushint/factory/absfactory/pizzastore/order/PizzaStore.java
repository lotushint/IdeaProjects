package com.lotushint.factory.absfactory.pizzastore.order;

import java.util.Scanner;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/21 15:19
 * @package com.lotushint.factory.absfactory.pizzastore.order
 * @description
 */
public class PizzaStore {
    public static void main(String[] args) {
        String loc = new Scanner(System.in).nextLine();

        if (loc.equals("bj")) {
            //创建北京口味的各种pizza
            new OrderPizza(new BJFactory());
        } else if (loc.equals("ld")) {
            //创建伦敦口味的各种pizza
            new OrderPizza(new LDFactory());
        }

    }
}
