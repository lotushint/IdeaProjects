package com.lotushint.mybatisplus2.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/7 20:20
 * @package com.lotushint.mybatisplus2.pojo
 * @description
 */
@Data
@TableName("t_user")
public class User {

    @TableId
    private Integer uid;

    private String userName;

    private Integer age;

    private Integer sex;

    private String email;

    private Integer isDeleted;

}
