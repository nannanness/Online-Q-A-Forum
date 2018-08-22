package org.lanqiao.oqaf.service.impl;

import org.lanqiao.oqaf.dao.IRemarkDao;
import org.lanqiao.oqaf.dao.impl.RemarkDaoImpl;
import org.lanqiao.oqaf.domain.Problem_Replay;
import org.lanqiao.oqaf.domain.Remark;
import org.lanqiao.oqaf.service.IRemarkService;

import java.sql.SQLException;
import java.util.List;

public class RemarkServiceImpl implements IRemarkService {
    private IRemarkDao dao = new RemarkDaoImpl();
    @Override
    public void insertRemark(Remark remark) {
        try {
            dao.insertRemark(remark);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Problem_Replay> getReplayUsers(int problemId) {
        List<Problem_Replay> list = null;
        try {
            list = dao.getReplayUsers(problemId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
