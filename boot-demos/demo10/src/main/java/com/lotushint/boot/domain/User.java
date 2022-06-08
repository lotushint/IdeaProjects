package com.lotushint.boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/14 11:55
 * @package com.lotushint.boot.domain
 * @description
 */

@Data
@AllArgsConstructor
public class User {

    private String name;

    private String address;

}
