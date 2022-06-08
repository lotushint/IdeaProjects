package com.lotushint.builder.improve;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/4 14:55
 * @package com.lotushint.builder.improve
 * @description
 */
public class HighBuilding extends HouseBuilder {

    @Override
    public void buildBasic() {
        System.out.println(" 高楼的打地基100米 ");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 高楼的砌墙20cm ");
    }

    @Override
    public void roofed() {
        System.out.println(" 高楼的透明屋顶 ");
    }

}