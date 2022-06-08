package com.lotushint.builder.improve;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/4 15:04
 * @package com.lotushint.builder.improve
 * @description 指挥者，这里去指定制作流程，返回产品
 */
public class HouseDirector {

    HouseBuilder houseBuilder = null;

    /**
     * 构造器传入 houseBuilder
     *
     * @param houseBuilder
     */
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }


    /**
     * 通过setter 传入 houseBuilder
     *
     * @param houseBuilder
     */
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    /**
     * 如何处理建造房子的流程，交给指挥者
     *
     * @return
     */
    public House constructHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
