package org.lanqiao.oqaf.service;

import org.lanqiao.oqaf.domain.CareUser;
import org.lanqiao.oqaf.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface ICareUserService {

    // 查询我关注的人
    public List<CareUser> findIdol(int myId)  ;
    // 查询关注我的人
    public List<CareUser> findFans(int myId)  ;
    // 取消当前用户关注的人
    public void cancleSight(CareUser careUser);
    // 关注用户
    public void sightUser(User careUser, User fansUser);
}
