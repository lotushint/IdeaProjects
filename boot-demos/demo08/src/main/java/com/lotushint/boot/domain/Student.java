package com.lotushint.boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/14 9:29
 * @package com.lotushint.boot.domain
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;

    private String name;

    private String sex;

}