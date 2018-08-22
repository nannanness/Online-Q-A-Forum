package org.lanqiao.oqaf.dao.impl;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.oqaf.Utils.JDBCUtils;
import org.lanqiao.oqaf.dao.ICareUserDao;
import org.lanqiao.oqaf.domain.CareUser;
import org.lanqiao.oqaf.domain.User;

import java.sql.SQLException;
import java.util.List;

public class CareUserDaoImpl implements ICareUserDao {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public List<CareUser> findIdol(int myId) throws SQLException {
        String sql = "select * from careuser where fansId = ?";
        List<CareUser> list = queryRunner.query(sql , new BeanListHandler<>(CareUser.class) ,myId);
        return list;
    }

    @Override
    public List<CareUser> findFans(int myId) throws SQLException {
        String sql = "select * from careuser where careUserId = ?";
        List<CareUser> list = queryRunner.query(sql , new BeanListHandler<>(CareUser.class) ,myId);
        return list;
    }

    @Override
    public void cancleSight(CareUser careUser) throws SQLException {
        String sql = "DELETE from careuser WHERE careuserId =? and fansId=?;";
        queryRunner.update(sql,careUser.getCareUserId(),careUser.getFansId());
    }

    @Override
    public void sightUser(User careUser, User fansUser) throws SQLException {
        String sql = "INSERT into careuser(careUserId,careUserName,careUserDetails,careUserImg,fansUsername,fansId,fansDetails,fansImg) \n" +
                "\tVALUES(?,?,?,?,?,?,?,?)";
        queryRunner.update(sql,careUser.getUser_Id(),careUser.getUser_Name(),careUser.getUser_Details(),careUser.getUser_Img(),fansUser.getUser_Name(), fansUser.getUser_Id(),fansUser.getUser_Details(),fansUser.getUser_Img());
    }
}
