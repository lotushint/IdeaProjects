package com.lotushint.factory.factorymethod.pizzastore.pizza;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/19 13:04
 * @package com.lotushint.factory.factorymethod.pizzastore.pizza
 * @description
 */
public class BJPepperPizza extends Pizza{
    @Override
    public void prepare() {
        setName("北京的胡椒pizza");
        System.out.println("北京的胡椒pizza 准备原材料");
    }
}
