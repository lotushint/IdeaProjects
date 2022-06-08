package com.lotushint.prototype.deepclone;

import java.io.Serializable;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/22 14:28
 * @package com.lotushint.prototype.deepclone
 * @description
 */
public class DeepCloneableTarget implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private String cloneName;
    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
