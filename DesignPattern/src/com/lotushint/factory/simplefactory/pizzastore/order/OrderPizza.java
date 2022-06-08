package com.lotushint.factory.simplefactory.pizzastore.order;

import com.lotushint.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.lotushint.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.lotushint.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.lotushint.factory.simplefactory.pizzastore.pizza.Pizza;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/5 20:44
 * @package com.lotushint.factory.simplefactory.pizzastore.order
 * @description
 */
public class OrderPizza {
//    public OrderPizza() {
//        Pizza pizza = null;
//        /**
//         * 订购披萨的类型
//         */
//        String orderType;
//        do {
//            orderType = getType();
//            if (orderType.equals("greek")) {
//                pizza = new GreekPizza();
//                pizza.setName(" 希腊披萨 ");
//            } else if (orderType.equals("cheese")) {
//                pizza = new CheesePizza();
//                pizza.setName(" 奶酪披萨 ");
//            } else if (orderType.equals("pepper")) {
//                pizza = new PepperPizza();
//                pizza.setName(" 胡椒披萨 ");
//            } else {
//                break;
//            }
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//        } while (true);
//    }

    //定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public OrderPizza(SimpleFactory simpleFactory){
        setSimpleFactory(simpleFactory);
    }

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        //用户输入的
        String orderType = "";
        //设置简单工厂对象
        this.simpleFactory = simpleFactory;

        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);

            //输出pizza
            if (pizza != null) {
                //订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购披萨失败");
                break;
            }
        } while (true);
    }

    /**
     * 写一个方法，可以获取客户希望订购的披萨种类
     */
    private String getType() {
        try {
            BufferedReader string = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = string.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
