package com.lotushint.factory.absfactory.pizzastore.pizza;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/18 13:03
 * @package com.lotushint.factory.factorymethod.pizzastore.pizza
 * @description
 */
public abstract class Pizza {
    /**
     * pizza名字
     */
    protected String name;

    /**
     * 准备原材料，不同的披萨不一样，因此，我们做成抽象方法
     */
    public abstract void prepare();

    public void bake() {
        System.out.println(name + " baking;");
    }

    public void cut() {
        System.out.println(name + " cutting;");
    }

    public void box() {
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }
}

