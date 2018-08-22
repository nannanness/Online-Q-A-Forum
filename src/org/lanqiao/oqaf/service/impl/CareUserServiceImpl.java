package org.lanqiao.oqaf.service.impl;

import org.lanqiao.oqaf.dao.ICareUserDao;
import org.lanqiao.oqaf.dao.impl.CareUserDaoImpl;
import org.lanqiao.oqaf.domain.CareUser;
import org.lanqiao.oqaf.domain.User;
import org.lanqiao.oqaf.service.ICareUserService;

import java.sql.SQLException;
import java.util.List;

public class CareUserServiceImpl implements ICareUserService {
    private ICareUserDao dao = new CareUserDaoImpl();
    @Override
    public List<CareUser> findIdol(int myId)   {
        List<CareUser> list = null;
        try {
            list = dao.findIdol(myId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<CareUser> findFans(int myId)   {
        List<CareUser> list = null;
        try {
            list = dao.findFans(myId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void cancleSight(CareUser careUser) {
        try {
            dao.cancleSight(careUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sightUser(User careUser, User fansUser) {
        try {
            dao.sightUser(careUser,fansUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
