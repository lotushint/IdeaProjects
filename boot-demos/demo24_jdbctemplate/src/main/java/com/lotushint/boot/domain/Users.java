package com.lotushint.boot.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 9:49
 * @package com.lotushint.boot.domain
 * @description
 */
@Data
@ToString
public class Users {

    private Integer id;

    private String username;

    private String password;

}
