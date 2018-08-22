package org.lanqiao.oqaf.dao;
/**
 * 提问dao接口
 */

import org.lanqiao.oqaf.domain.Problem;

import java.sql.SQLException;

public interface IProblemDao {
    //插入一条内容
    public void  insertProblem(Problem pro) throws SQLException;

}
