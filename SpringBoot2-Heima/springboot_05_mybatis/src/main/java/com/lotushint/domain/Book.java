package com.lotushint.domain;

import lombok.Data;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/20 17:29
 * @package com.lotushint.pojo
 * @description
 */
@Data
public class Book {
    Integer id;
    String type;
    String name;
    String description;
}
