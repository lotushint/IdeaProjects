package com.lotushint;

import com.lotushint.config.SpringConfig;
import com.lotushint.domain.Account;
import com.lotushint.service.AccountService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lotushint
 * @version 1.0
 * @date ${DATE} ${TIME}
 * @package com.lotushint
 * @description
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = ctx.getBean(AccountService.class);
        Account account = accountService.findById(5);
        System.out.println(account);
    }
}