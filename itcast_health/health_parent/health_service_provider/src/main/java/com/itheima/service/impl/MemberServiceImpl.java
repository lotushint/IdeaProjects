package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.MemberDao;
import com.itheima.pojo.Member;
import com.itheima.service.MemberService;
import com.itheima.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/2 11:12
 * @package com.itheima.service.impl
 * @description 会员服务
 */
@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public Member findByTelephone(String telephone) {
        return memberDao.findByTelephone(telephone);
    }

    @Override
    public void add(Member member) {
        if (member.getPassword() != null) {
            // 使用 Md5 对明文密码进行加密
            member.setPassword(MD5Utils.md5(member.getPassword()));
        }
        memberDao.add(member);
    }

    /**
     * 根据月份查询会员数量
     *
     * @param months
     * @return
     */
    @Override
    public List<Integer> findMemberCountByMonth(List<String> months) {
        List<Integer> memberCount = new ArrayList<>();
        for (String m : months) {
            Integer count = memberDao.findMemberCountBeforeDate(m);
            memberCount.add(count);
        }
        return memberCount;
    }
}
