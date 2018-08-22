package org.lanqiao.oqaf.dao;

import org.lanqiao.oqaf.domain.Problem_Replay;

import java.sql.SQLException;
import java.util.List;

public interface IIndexCountDao {
    public List<Problem_Replay> getIndexCountByIndex(int index) throws SQLException;//获取首页核心板块的内容根据id
    public List<Problem_Replay> getIndexCountAll() throws SQLException;//获取所有的问答
    public List<Problem_Replay> getIndexCountByType(String type) throws SQLException;//获取话题分类的信息
    public List<Problem_Replay> getIndexCountByTypeByPage(String type, int index) throws SQLException;//获取话题分类
    public List<Problem_Replay> getAllProblemReplay() throws SQLException;//热门话题
    public List<Problem_Replay> getAllProblemReplayByPage(int index) throws SQLException;//热门话题
    public List<Problem_Replay> getIndexContentByLike(String like, String like1, int index) throws SQLException;//根据用户的查找获取页面信息
    public List<Problem_Replay> getIndexContentByLikeByAll(String like, String like1) throws SQLException;//根据用户的查找获取页面信息
    public void clickZan(int pid , int uid ,  int zanCount);//点赞
    public void cancelZan(int pid , int uid , int zanCount);//取消赞
    public int getZanCount(int pid , int uid);//获得赞数
}
