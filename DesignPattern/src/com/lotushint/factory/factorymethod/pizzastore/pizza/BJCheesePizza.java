package com.lotushint.factory.factorymethod.pizzastore.pizza;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/19 13:04
 * @package com.lotushint.factory.factorymethod.pizzastore.pizza
 * @description
 */
public class BJCheesePizza extends Pizza{
    @Override
    public void prepare() {
        setName("北京的奶酪pizza");
        System.out.println("北京的奶酪pizza 准备原材料");
    }
}
