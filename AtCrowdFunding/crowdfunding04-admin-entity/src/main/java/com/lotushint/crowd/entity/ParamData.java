package com.lotushint.crowd.entity;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/5/14 13:42
 * @package com.lotushint.crowd.entity
 * @description
 */

public class ParamData {

    private List<Integer> array;

    public ParamData() {

    }

    public ParamData(List<Integer> array) {
        super();
        this.array = array;
    }

    @Override
    public String toString() {
        return "ParamData [array=" + array + "]";
    }

    public List<Integer> getArray() {
        return array;
    }

    public void setArray(List<Integer> array) {
        this.array = array;
    }

}
