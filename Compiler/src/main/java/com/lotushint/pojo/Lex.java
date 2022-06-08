package com.lotushint.pojo;

/**
 * @author lotushint
 * @package com.lotushint.pojo
 * @date 2021/11/5 0:30
 * @description 保存格式化的词法分析数据和标识符表
 */
public class Lex {
    /**
     * 格式化的词法分析数据
     */
    public String data = "";
    /**
     * 标识符表
     */
    public String table = "";

    public Lex() {
    }

    public Lex(String data, String table) {
        this.data = data;
        this.table = table;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "Lex{" +
                "data='" + data + '\'' +
                ", table='" + table + '\'' +
                '}';
    }
}
