package org.lanqiao.oqaf.service;

import org.lanqiao.oqaf.domain.Problem_Replay;
import org.lanqiao.oqaf.domain.Remark;

import java.sql.SQLException;
import java.util.List;

/**
 * 针对话题页的评论框
 */
public interface IRemarkService {
    public void insertRemark(Remark remark);
    //通过问题id查询到所有回答者
    public List<Problem_Replay> getReplayUsers(int problemId);
}
