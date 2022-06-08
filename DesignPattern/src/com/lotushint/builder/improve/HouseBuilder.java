package com.lotushint.builder.improve;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/4 14:53
 * @package com.lotushint.builder.improve
 * @description 抽象的建造者
 */
public abstract class HouseBuilder {
    protected House house = new House();

    /*
    将建造的流程写好, 抽象的方法
     */

    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void roofed();

    /**
     * 建造房子好， 将产品(房子) 返回
     */
    public House buildHouse() {
        return house;
    }

}
