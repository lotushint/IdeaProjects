package com.lotushint.boot.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lotushint.boot.json.CustomJackson;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/14 14:05
 * @package com.lotushint.boot.domain
 * @description
 */
/**
 * @NoArgsConstructor
 * @AllArgsConstructor 表示序列化时忽略的属性
 */
@Data
@ToString
@JsonIgnoreProperties(value = {"word"})/**在json序列化时将Java bean中的某些属性忽略掉，序列化和反序列化都受影响*/
public class User {

    /**
     * 注意:在进行JSON序列化和反序列化时,要么提供一个无参的构造方法,要么在其他构造方法上添加@JsonCreator注解.
     */
    private String name;
    private int age;
    private boolean sex;
    private Date birthday;
    private String word;
    private double salary;

    /**
     * 当json在反序列化时，默认选择类的无参构造函数创建类对象，当没有无参构造函数时则会报错，
     * @JsonCreator注解的作用就是指定反序列化时用的无参构造函数。构造方法的参数前面需要加上@JsonProperty,否则会报错！
     * @param name
     * @param age
     * @param sex
     * @param birthday
     * @param word
     * @param salary
     */
    @JsonCreator/**@JsonCreator与@JsonProperty:该注解的作用就是指定反序列化时替代无参构造函数，构造方法的参数前面需要加上@JsonProperty注解。*/
    public User(@JsonProperty("name") String name, @JsonProperty("age") int age, @JsonProperty("sex") boolean sex, @JsonProperty("birthday") Date birthday,
                @JsonProperty("word") String word, @JsonProperty("salary") double salary) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.word = word;
        this.salary = salary;
    }

    /**
     * 反序列化一个固定格式的Date
     * @param birthday
     */
    @JsonDeserialize(using = CustomJackson.MyDeserializer.class)/**此注解用于属性或者setter方法上，用于在反序列化时嵌入我们自定义的反序列化器，比如反序列化一个Date类型的时间字符串。*/
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 序列化指定格式的double格式
     * @return
     */
    @JsonSerialize(using = CustomJackson.MySerializer.class)/**此注解用于属性或者getter方法上，用于在序列化时嵌入我们自定义的序列化器，比如序列化一个double时在其后面限制两位小数点。*/
    public double getSalary() {
        return salary;
    }

}