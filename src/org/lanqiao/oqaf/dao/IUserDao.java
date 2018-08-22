package org.lanqiao.oqaf.dao;

import org.lanqiao.oqaf.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    public List<User> getUserInfo() throws SQLException;//获取所有用户的信息
    public void insterUser(long phone) throws SQLException;//注册一个用户\
    public User getUserById (int id) throws SQLException;//通过id来查询用户
    public void updateUser(User user) throws SQLException;//修改用户数据（不包括头像和背景图）
    public void updateUserAvatar(int id , String avatar) throws SQLException;// 更新用户头像
    public void updateUserBGP(int id , String bgp) throws SQLException;// 更新用户背景图
}
