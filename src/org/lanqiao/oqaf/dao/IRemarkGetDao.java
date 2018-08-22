package org.lanqiao.oqaf.dao;

import org.lanqiao.oqaf.domain.Remark;
import org.lanqiao.oqaf.domain.Remarks;

import java.sql.SQLException;
import java.util.List;

public interface IRemarkGetDao {
    public List<Remarks> getRemarks(int problemId, int userId) throws SQLException;//根据问题id获得评论内容
}
