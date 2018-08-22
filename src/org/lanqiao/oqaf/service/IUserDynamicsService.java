package org.lanqiao.oqaf.service;

import org.lanqiao.oqaf.domain.UserArticle;
import org.lanqiao.oqaf.domain.UserQuestion;
import org.lanqiao.oqaf.domain.UserResponse;

import java.sql.SQLException;
import java.util.List;

public interface IUserDynamicsService {
    // 用户页面回答查询
    public List<UserResponse> queryUserResponse(int replayUserId)  ;

    // 用户页面提问查询
    public List<UserQuestion> queryUserQuestion(int problemUserId)  ;

    // 用户页面文章查询
    public List<UserArticle> queryUserArticle(int authorId)  ;

    // 删除用户的回答
    public void deleteResponse(int problemId,int replayId ) ;

    //删除用户的提问
    public void deleteQuestion(int problemId,int problemUserId);

    //删除用户的文章
    public void deleteArticle(int articleId,int author) ;

}
