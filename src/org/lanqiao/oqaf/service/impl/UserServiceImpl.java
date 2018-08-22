package org.lanqiao.oqaf.service.impl;

import org.lanqiao.oqaf.dao.IUserDao;
import org.lanqiao.oqaf.dao.impl.UserDaoImpl;
import org.lanqiao.oqaf.domain.User;
import org.lanqiao.oqaf.service.IUserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl  implements IUserService {
    private IUserDao iUserDao = new UserDaoImpl();
    @Override
    public List<User> getUserInfo() {
        List<User> userList = new ArrayList<>();
        try {
            userList = iUserDao.getUserInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void insterUser(String phone) {
        long longPhone = Long.valueOf(phone);
        try {
            iUserDao.insterUser(longPhone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        User userInfo = null;
        try {
            userInfo = iUserDao.getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    @Override
    public void updateUser(User user) {
        try {
            iUserDao.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserAvatar(int id, String avatar) {
        try {
            iUserDao.updateUserAvatar(id , avatar);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserBGP(int id, String bgp) {
        try {
            iUserDao.updateUserBGP(id , bgp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
