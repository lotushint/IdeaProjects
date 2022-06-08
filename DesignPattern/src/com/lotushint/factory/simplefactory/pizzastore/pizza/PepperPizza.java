package com.lotushint.factory.simplefactory.pizzastore.pizza;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/10 19:52
 * @package com.lotushint.factory.simplefactory.pizzastore.pizza
 * @description
 */
public class PepperPizza extends Pizza{

    @Override
    public void prepare() {
        System.out.println("给胡椒披萨准备原材料");
    }
}
