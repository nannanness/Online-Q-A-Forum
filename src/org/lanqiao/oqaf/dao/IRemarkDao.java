package org.lanqiao.oqaf.dao;

import org.lanqiao.oqaf.domain.Problem_Replay;
import org.lanqiao.oqaf.domain.Remark;

import java.sql.SQLException;
import java.util.List;

/**
    针对发现页的问题的评论
 */
public interface IRemarkDao {
    //插入一条数据到数据库中
    public void insertRemark(Remark remark) throws SQLException;
    //通过问题id查询到所有回答者
    public List<Problem_Replay> getReplayUsers(int problemId) throws SQLException;
}
