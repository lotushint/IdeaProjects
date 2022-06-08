package com.lotushint.builder.improve;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/4 14:55
 * @package com.lotushint.builder.improve
 * @description
 */
public class CommonHouse extends HouseBuilder {

    @Override
    public void buildBasic() {
        System.out.println(" 普通房子打地基5米 ");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 普通房子砌墙10cm ");
    }

    @Override
    public void roofed() {
        System.out.println(" 普通房子屋顶 ");
    }

}
