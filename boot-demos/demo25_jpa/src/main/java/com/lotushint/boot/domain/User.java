package com.lotushint.boot.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 11:23
 * @package com.lotushint.boot.domain
 * @description
 */
@Data
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String birthday;

    @Column
    private String sex;

    @Column
    private String address;

}