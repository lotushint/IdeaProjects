package com.lotushint.pojo;
import java.io.Serializable;

/**
 * @author lotushint
 * @package com.lotushint.pojo
 * @date 2021/10/14 上午10:07
 * @description 分析过程bean
 */
public class AnalyzeProduce implements Serializable{
    private static final long serialVersionUID = 10L;
    private Integer index;
    private String analyzeStackStr;
    private String str;
    private String useExpStr;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getAnalyzeStackStr() {
        return analyzeStackStr;
    }

    public void setAnalyzeStackStr(String analyzeStackStr) {
        this.analyzeStackStr = analyzeStackStr;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getUseExpStr() {
        return useExpStr;
    }

    public void setUseExpStr(String useExpStr) {
        this.useExpStr = useExpStr;
    }

}