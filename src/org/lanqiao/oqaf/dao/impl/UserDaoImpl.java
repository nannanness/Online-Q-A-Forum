package org.lanqiao.oqaf.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.oqaf.Utils.JDBCUtils;
import org.lanqiao.oqaf.dao.IUserDao;
import org.lanqiao.oqaf.domain.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public List<User> getUserInfo() throws SQLException {
       String sql = "SELECT * FROM userinfo;";
       List<User> userList = queryRunner.query(sql,new BeanListHandler<>(User.class));
        return userList;
    }

    @Override
    public void insterUser(long phone) throws SQLException {
        String sql = "INSERT INTO userinfo(user_phone,pass_Word)VALUES(?,\"123456\");";
        queryRunner.update(sql,phone);
    }

    @Override
    public User getUserById(int id) throws SQLException {
        String sql = "select * from userinfo where user_id=?";
        User userInfo =queryRunner.query(sql,new BeanHandler<>(User.class),id);
        return userInfo;
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String sql = "update userinfo set user_Name = ? , user_Details = ? , user_Sex = ?, user_school = ? where user_Id = ?";
        queryRunner.update(sql,user.getUser_Name() , user.getUser_Details() , user.getUser_Sex() , user.getUser_school() , user.getUser_Id());
    }

    @Override
    public void updateUserAvatar(int id, String avatar) throws SQLException {
        String sql = "update userinfo set user_img = ? where user_Id = ?";
        queryRunner.update(sql , avatar , id);
    }

    @Override
    public void updateUserBGP(int id, String bgp) throws SQLException {
        String sql = "update userinfo set user_bgc = ? where user_Id = ?";
        queryRunner.update(sql , bgp , id);
    }
}
