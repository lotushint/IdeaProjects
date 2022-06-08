package com.lotushint.builder.improve;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/4 14:28
 * @package com.lotushint.builder.improve
 * @description
 */
public class House {
    String base;
    String wall;
    String roofed;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }

    @Override
    public String toString() {
        return "House{" +
                "base='" + base + '\'' +
                ", wall='" + wall + '\'' +
                ", roofed='" + roofed + '\'' +
                '}';
    }
}
