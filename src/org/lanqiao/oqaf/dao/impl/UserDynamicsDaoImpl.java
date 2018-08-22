package org.lanqiao.oqaf.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.oqaf.Utils.JDBCUtils;
import org.lanqiao.oqaf.dao.IUserDynamicsDao;
import org.lanqiao.oqaf.domain.UserArticle;
import org.lanqiao.oqaf.domain.UserQuestion;
import org.lanqiao.oqaf.domain.UserResponse;

import java.sql.SQLException;
import java.util.List;

public class UserDynamicsDaoImpl implements IUserDynamicsDao {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public List<UserResponse> queryUserResponse(int replayUserId) throws SQLException {
        String sql = "SELECT t1.problemId,replayUserId , t2.title , replayContent , replayDate FROM replay t1, problem t2 WHERE t1.problemId = t2.problemId AND t1.replayUserId = ? ORDER BY t1.replayDate desc\n";
        List<UserResponse> list = queryRunner.query(sql,new BeanListHandler<>(UserResponse.class), replayUserId);
        return list;
    }

    @Override
    public List<UserQuestion> queryUserQuestion(int problemUserId) throws SQLException {
        String sql = "select problemUserId ,problemId, title , content , problemDate from problem where problemUserId = ? ORDER BY problemDate desc";
        List<UserQuestion> list = queryRunner.query(sql , new BeanListHandler<>(UserQuestion.class) , problemUserId);
        return list;
    }

    @Override
    public List<UserArticle> queryUserArticle(int authorId) throws SQLException {
        String sql = "select authorId ,articleId, articleTitle , articleContent , articleDate from article where authorId = ? ORDER BY articleDate desc";
        List<UserArticle> list = queryRunner.query(sql , new BeanListHandler<>(UserArticle.class) , authorId);
        return list;
    }

    @Override
    public void deleteResponse(int problemId, int replayId) throws SQLException {
        String sql = "DELETE FROM replay where problemId =? AND replayUserId =?;";
        queryRunner.update(sql,problemId,replayId);
    }

    @Override
    public void deleteQuestion(int problemId, int problemUserId) throws SQLException {
        String sql ="DELETE FROM problem where problemId =? and problemUserId =? ; ";
        queryRunner.update(sql,problemId,problemUserId);
    }

    @Override
    public void deleteArticle(int articleId, int author) throws SQLException {
        String sql = "DELETE FROM article where articleId =? and authorId =? ;";
        queryRunner.update(sql,articleId,author);
    }


}
