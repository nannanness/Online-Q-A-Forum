package org.lanqiao.oqaf.service;

import org.lanqiao.oqaf.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public List<User> getUserInfo();//获取所有用户
    public void insterUser(String phone);//注册用户
    public User getUserById(int id);//用id获取用户
    public void updateUser(User user);//修改用户数据
    public void updateUserAvatar(int id , String avatar);// 更新用户头像
    public void updateUserBGP(int id , String bgp);// 更新用户背景图
}
