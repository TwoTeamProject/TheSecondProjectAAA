package com.pro.two.service.member;

import com.pro.two.dao.member.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:MemberServiceImpl
 * discription:
 * author:赵一凡
 * createTime:2018-11-24 10:19
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<Map> memberLogin(Map map) {
        return memberDao.memberLogin(map);
    }

    @Override
    public int memberRegister(Map map) {
        return memberDao.memberRegister(map);
    }

    @Override
    public List<Map> getSelect() {
        return memberDao.getSelect();
    }
}
