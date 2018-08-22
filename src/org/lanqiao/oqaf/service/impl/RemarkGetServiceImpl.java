package org.lanqiao.oqaf.service.impl;

import org.lanqiao.oqaf.dao.IRemarkDao;
import org.lanqiao.oqaf.dao.IRemarkGetDao;
import org.lanqiao.oqaf.dao.impl.RemarkDaoImpl;
import org.lanqiao.oqaf.dao.impl.RemarkGetDaoImpl;
import org.lanqiao.oqaf.domain.Remark;
import org.lanqiao.oqaf.domain.Remarks;
import org.lanqiao.oqaf.service.IRemarkGetService;
import org.lanqiao.oqaf.service.IRemarkService;

import java.sql.SQLException;
import java.util.List;

public class RemarkGetServiceImpl implements IRemarkGetService {
    private IRemarkGetDao iRemarkDao=new RemarkGetDaoImpl();

    @Override
    public List<Remarks> getRemarks(int problemId, int userId) {
        List<Remarks> iRemarks=null;
        try {
            iRemarks=iRemarkDao.getRemarks(problemId, userId);
            return iRemarks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
