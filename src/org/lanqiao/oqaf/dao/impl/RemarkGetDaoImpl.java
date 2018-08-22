package org.lanqiao.oqaf.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.oqaf.Utils.JDBCUtils;
import org.lanqiao.oqaf.dao.IRemarkGetDao;
import org.lanqiao.oqaf.domain.Remark;
import org.lanqiao.oqaf.domain.Remarks;

import java.sql.SQLException;
import java.util.List;

public class RemarkGetDaoImpl implements IRemarkGetDao {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public List<Remarks> getRemarks(int problemId, int userId) throws SQLException {
        String sql="SELECT remark.*,userinfo.user_Name from remark,userinfo where userinfo.user_Id=remark.remarkNumId and remark.problemId = ? and remark.replayUserId=?;";
        List<Remarks> remarks=queryRunner.query(sql,new BeanListHandler<>(Remarks.class),problemId , userId);
        return  remarks;
    }
}
