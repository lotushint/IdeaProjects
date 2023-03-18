package com.lotushint.service.impl;

import com.lotushint.dao.AccountDao;
import com.lotushint.service.AccountService;
import com.lotushint.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private LogService logService;

    @Override
    public void transfer(String out, String in, Double money) throws IOException {
        try {
            accountDao.outMoney(out, money);
            int i = 1 / 0;
//            if (true){
//                throw new IOException();
//            }
            accountDao.inMoney(in, money);
        } finally {
            logService.log(out, in, money);
        }
    }

}
