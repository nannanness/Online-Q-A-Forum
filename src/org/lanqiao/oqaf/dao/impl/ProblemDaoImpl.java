package org.lanqiao.oqaf.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.lanqiao.oqaf.Utils.JDBCUtils;
import org.lanqiao.oqaf.dao.IProblemDao;
import org.lanqiao.oqaf.domain.Problem;

import java.sql.SQLException;

public class ProblemDaoImpl implements IProblemDao {
    //创建QueryRunner对象，使用DBUtils
    private QueryRunner qur = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public void insertProblem(Problem pro) throws SQLException {
        //执行的sql语句
        String sql = "insert into problem(problemUserId,title,content,problemType,problemDate) values(?,?,?,?,?)";
        qur.update(sql,pro.getProblemUserId(),pro.getTitle(),pro.getContent(),pro.getProblemType(),pro.getProblemDate());
    }

//
}
