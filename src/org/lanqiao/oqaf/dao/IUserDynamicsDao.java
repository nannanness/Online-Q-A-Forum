package org.lanqiao.oqaf.dao;

import org.lanqiao.oqaf.domain.UserArticle;
import org.lanqiao.oqaf.domain.UserQuestion;
import org.lanqiao.oqaf.domain.UserResponse;

import java.sql.SQLException;
import java.util.List;

public interface IUserDynamicsDao {
    // 用户页面回答查询
    public List<UserResponse> queryUserResponse(int replayUserId) throws SQLException;

    // 用户页面提问查询
    public List<UserQuestion> queryUserQuestion(int problemUserId) throws SQLException;

    // 用户页面文章查询
    public List<UserArticle> queryUserArticle(int authorId) throws SQLException;

    // 删除用户的回答
    public void deleteResponse(int problemId,int replayId ) throws SQLException;

    //删除用户的提问
    public void deleteQuestion(int problemId,int problemUserId) throws SQLException;

    //删除用户的文章
    public void deleteArticle(int articleId,int author) throws SQLException;
}
