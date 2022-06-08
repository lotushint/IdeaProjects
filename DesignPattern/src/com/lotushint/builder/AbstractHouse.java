package com.lotushint.builder;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/4 14:02
 * @package com.lotushint.builder
 * @description
 */

public abstract class AbstractHouse {

    /**
     * 打地基
     */
    public abstract void buildBasic();

    /**
     * 砌墙
     */
    public abstract void buildWalls();

    /**
     * 封顶
     */
    public abstract void roofed();

    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }

}
