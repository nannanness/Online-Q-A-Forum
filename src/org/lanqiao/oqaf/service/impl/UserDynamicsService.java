package org.lanqiao.oqaf.service.impl;

import org.lanqiao.oqaf.dao.IUserDynamicsDao;
import org.lanqiao.oqaf.dao.impl.UserDynamicsDaoImpl;
import org.lanqiao.oqaf.domain.UserArticle;
import org.lanqiao.oqaf.domain.UserQuestion;
import org.lanqiao.oqaf.domain.UserResponse;
import org.lanqiao.oqaf.service.IUserDynamicsService;

import java.sql.SQLException;
import java.util.List;

public class UserDynamicsService implements IUserDynamicsService {
    private IUserDynamicsDao dao = new UserDynamicsDaoImpl();
    @Override
    public List<UserResponse> queryUserResponse(int replayUserId)   {
        List<UserResponse> list = null;
        try {
            list = dao.queryUserResponse(replayUserId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<UserQuestion> queryUserQuestion(int problemUserId)   {
        List<UserQuestion> list = null;
        try {
            list = dao.queryUserQuestion(problemUserId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<UserArticle> queryUserArticle(int authorId)   {
        List<UserArticle> list = null;
        try {
            list = dao.queryUserArticle(authorId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteResponse(int problemId, int replayId) {
        try {
            dao.deleteResponse(problemId,replayId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteQuestion(int problemId, int problemUserId) {
        try {
            dao.deleteQuestion(problemId,problemUserId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArticle(int articleId, int author) {
        try {
            dao.deleteArticle(articleId,author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
