package com.lotushint.pojo;

/**
 * @author lotushint
 * @package com.lotushint.pojo
 * @date 2021/11/5 0:30
 * @description 保存格式化的first集和first算法
 */
public class First {
    /**
     * first集
     */
    public String data = "";
    /**
     * first算法
     */
    public String track = "";

    public First() {

    }

    public First(String data, String track) {
        this.track = track;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    @Override
    public String toString() {
        return "First{" +
                "data='" + data + '\'' +
                ", track='" + track + '\'' +
                '}';
    }
}
