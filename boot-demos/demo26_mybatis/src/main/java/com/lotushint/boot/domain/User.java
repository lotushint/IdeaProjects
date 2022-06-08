package com.lotushint.boot.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 14:26
 * @package com.lotushint.boot.domain
 * @description
 */
@Data
@ToString
public class User {

    private Long id;

    private String username;

    private String birthday;

    private String sex;

    private String address;

}
