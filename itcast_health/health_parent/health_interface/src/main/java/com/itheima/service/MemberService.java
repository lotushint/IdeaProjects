package com.itheima.service;

import com.itheima.pojo.Member;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/2 10:55
 * @package com.itheima.service
 * @description
 */
public interface MemberService {
    Member findByTelephone(String telephone);

    void add(Member member);

    List<Integer> findMemberCountByMonth(List<String> months);
}
