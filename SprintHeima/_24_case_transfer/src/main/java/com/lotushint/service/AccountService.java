package com.lotushint.service;

import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.IOException;

@Transactional
public interface AccountService {
    /**
     * 转账操作
     *
     * @param out   传出方
     * @param in    转入方
     * @param money 金额
     */
    //配置当前接口方法具有事务
//    @Transactional //还可以加在类上
    public void transfer(String out, String in, Double money);
}
