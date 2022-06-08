package com.lotushint.builder;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/4 14:04
 * @package com.lotushint.builder
 * @description
 */
public class CommonHouse extends AbstractHouse {

    @Override
    public void buildBasic() {
        System.out.println(" 普通房子打地基 ");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 普通房子砌墙 ");
    }

    @Override
    public void roofed() {
        System.out.println(" 普通房子封顶 ");
    }

}