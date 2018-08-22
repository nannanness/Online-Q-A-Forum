package org.lanqiao.oqaf.service;

import org.lanqiao.oqaf.domain.Problem_Replay;

import java.sql.SQLException;
import java.util.List;

public interface IIndexCountService {
    public List<Problem_Replay> getIndexCountByIndex(int index);//获取首页核心块中的数据;
    public List<Problem_Replay> getIndexAll();//获取首页上所有的数据
    public List<Problem_Replay> getIndexCountByType(String type);//获取话题分类的信息
    public List<Problem_Replay> getIndexCountByTypeByPage(String type, int index) ;//获取话题分类
    public List<Problem_Replay> getAllProblemReplay(); //获取热门话题
    public List<Problem_Replay> getAllProblemReplayByPage(int index)  ;//热门话题
    public List<Problem_Replay> getIndexContentByLike(String like, String like1, int index);//根据用户的查找获取页面信息
    public List<Problem_Replay> getIndexContentByLikeByAll(String like, String like1)  ;//根据用户的查找获取页面信息
    public void clickZan(int pid , int uid ,  int zanCount);//点赞
    public void cancelZan(int pid , int uid , int zanCount);//取消赞
    public int getZanCount(int pid , int uid);//获得赞数
}
