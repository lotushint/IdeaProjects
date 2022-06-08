package com.lotushint.boot.repository;

import com.lotushint.boot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/2/16 11:30
 * @package com.lotushint.boot.repository
 * @description
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
