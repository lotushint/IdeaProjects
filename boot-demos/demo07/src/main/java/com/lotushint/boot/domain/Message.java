package com.lotushint.boot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/13 15:10
 * @package com.lotushint.boot.domain
 * @description
 */

/**
 * 采用lombok简化bean
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    /**
     *0表示成功,-1表示失败
     */
    int status;

    /**
     * 向前端返回的内容
     */
    String massage;

}