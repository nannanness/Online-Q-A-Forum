package org.lanqiao.oqaf.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.oqaf.Utils.JDBCUtils;
import org.lanqiao.oqaf.dao.IIndexCountDao;
import org.lanqiao.oqaf.domain.Problem_Replay;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IndexCountImpl implements IIndexCountDao {
    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public List<Problem_Replay> getIndexCountByIndex(int index) throws SQLException {
        index = (index - 1) * 10;
        String sql = "select p.problemId ,title,content,user_Img,user_Name,problemType, replayContent, replayUserId,remarkCount\n" +
                "                from (select *from replay r,userinfo u where r.replayUserId=u.user_Id)rc ,problem p WHERE p.problemId=rc.problemId LIMIT ?,10;";
        List<Problem_Replay> problem_replays = queryRunner.query(sql,new BeanListHandler<>(Problem_Replay.class),index);
        return problem_replays;
    }

    @Override
    public List<Problem_Replay> getIndexCountAll() throws SQLException {
        String sql = "select p.problemId ,title,content,user_Img,user_Name,problemType, replayContent, replayUserId,remarkCount \n" +
                "\tfrom (select *from replay r,userinfo u where r.replayUserId=u.user_Id)rc ,problem p WHERE p.problemId=rc.problemId ;";
        List<Problem_Replay> problem_replaysAll = queryRunner.query(sql,new BeanListHandler<>(Problem_Replay.class));
        return problem_replaysAll;
    }

    @Override
    public List<Problem_Replay> getIndexCountByType(String type) throws SQLException {
        String sql = "select p.problemId ,title,content,user_Img,user_Name,problemType, replayContent, replayUserId,remarkCount\n" +
                "         from (select *from replay r,userinfo u where r.replayUserId=u.user_Id)rc ,problem p WHERE p.problemId=rc.problemId AND p.problemType=?";
        List<Problem_Replay> typeCountList = queryRunner.query(sql,new BeanListHandler<>(Problem_Replay.class),type);//执行sql语句获取类型属性
        return typeCountList;
    }

    @Override
    public List<Problem_Replay> getIndexCountByTypeByPage(String type,int index) throws SQLException {
        index = (index - 1) * 10;
        String sql = "select p.problemId ,title,content,user_Img,user_Name,problemType, replayContent, replayUserId,remarkCount\n" +
                "         from (select *from replay r,userinfo u where r.replayUserId=u.user_Id)rc ,problem p WHERE p.problemId=rc.problemId AND p.problemType=? LIMIT ? , 10";
        List<Problem_Replay> typeCountList = queryRunner.query(sql,new BeanListHandler<>(Problem_Replay.class),type,index);//执行sql语句获取类型属性
        return typeCountList;
    }

    @Override
    public List<Problem_Replay> getAllProblemReplay() throws SQLException {
        String sql = "select p.problemId ,title,content,user_Img,user_Name,problemType, replayContent, replayUserId,remarkCount\n" +
                "         from (select *from replay r,userinfo u where r.replayUserId=u.user_Id)rc ,problem p WHERE p.problemId=rc.problemId order by remarkCount desc ";
        List<Problem_Replay> prList = queryRunner.query(sql,new BeanListHandler<>(Problem_Replay.class));
        return prList;
    }

    @Override
    public List<Problem_Replay> getAllProblemReplayByPage(int index) throws SQLException {
        index = (index - 1) * 10;
        String sql = "select p.problemId ,title,content,user_Img,user_Name,problemType, replayContent, replayUserId,remarkCount\n" +
                "         from (select *from replay r,userinfo u where r.replayUserId=u.user_Id)rc ,problem p WHERE p.problemId=rc.problemId order by remarkCount desc limit ? , 10";
        List<Problem_Replay> prList = queryRunner.query(sql,new BeanListHandler<>(Problem_Replay.class) , index);
        return prList;
    }

    @Override
    public List<Problem_Replay> getIndexContentByLike(String like, String like1 ,int index) throws SQLException {
        index = (index - 1) * 10;
        String likeSql = "%"+like+"%";
        String likeSql1 = "%"+like1+"%";
        String sql = "select p.problemId ,title,content,user_Img,user_Name,problemType, replayContent, replayUserId,remarkCount\n" +
                "                from (select *from replay r,userinfo u where r.replayUserId=u.user_Id)\n" +
                "\t\t\t\trc ,problem p WHERE p.problemId=rc.problemId AND (title LIKE ? OR title Like ? ) LIMIT ?,10 ;";
        List<Problem_Replay> problem_replays = queryRunner.query(sql,new BeanListHandler<>(Problem_Replay.class),likeSql,likeSql1 ,index);
        return problem_replays;
    }

    @Override
    public List<Problem_Replay> getIndexContentByLikeByAll(String like, String like1 ) throws SQLException {
        String likeSql = "%"+like+"%";
        String likeSql1 = "%"+like1+"%";
        String sql = "select p.problemId ,title,content,user_Img,user_Name,problemType, replayContent, replayUserId,remarkCount\n" +
                "                from (select *from replay r,userinfo u where r.replayUserId=u.user_Id)\n" +
                "\t\t\t\trc ,problem p WHERE p.problemId=rc.problemId AND (title LIKE ? OR title Like ? );";
        List<Problem_Replay> problem_replays = queryRunner.query(sql,new BeanListHandler<>(Problem_Replay.class),likeSql,likeSql1);
        return problem_replays;
    }

    @Override
    public void clickZan(int pid, int uid, int zanCount) {

    }

    @Override
    public void cancelZan(int pid, int uid, int zanCount) {

    }

    @Override
    public int getZanCount(int pid, int uid) {
        return 0;
    }

}
