package org.lanqiao.oqaf.service;

import org.lanqiao.oqaf.domain.Remark;
import org.lanqiao.oqaf.domain.Remarks;

import java.util.List;

public interface IRemarkGetService {
    public List<Remarks> getRemarks(int problemId, int userId);//根据问题id获取评论内容
}
