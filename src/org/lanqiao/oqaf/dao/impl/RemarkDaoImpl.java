package org.lanqiao.oqaf.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.oqaf.Utils.JDBCUtils;
import org.lanqiao.oqaf.dao.IRemarkDao;
import org.lanqiao.oqaf.domain.Problem_Replay;
import org.lanqiao.oqaf.domain.Remark;

import java.sql.SQLException;
import java.util.List;

public class RemarkDaoImpl implements IRemarkDao {
    private QueryRunner qur = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public void insertRemark(Remark remark) throws SQLException {
        //执行的sql语句
        String sql = "insert into remark values(?,?,?,?,?)";
        qur.update(sql,remark.getProblemId(),remark.getReplayUserId(),remark.getRemarkNumId(),remark.getRemarkContent(),remark.getRemarkDate());
    }

    @Override
    public List<Problem_Replay> getReplayUsers(int problemId) throws SQLException {
        String sql = "select p.problemId ,title,content,user_Img,user_Name,problemType, replayContent, replayUserId,remarkCount \n" +
                "\tfrom (select *from replay r,userinfo u where r.replayUserId=u.user_Id)rc ,problem p WHERE p.problemId=rc.problemId and p.problemId = ?;";
        List<Problem_Replay> list = qur.query(sql, new BeanListHandler<>(Problem_Replay.class),problemId);
        return list;
    }
}
