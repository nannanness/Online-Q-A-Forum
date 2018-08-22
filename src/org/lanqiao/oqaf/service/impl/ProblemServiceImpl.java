package org.lanqiao.oqaf.service.impl;

import org.lanqiao.oqaf.dao.IProblemDao;
import org.lanqiao.oqaf.dao.impl.ProblemDaoImpl;
import org.lanqiao.oqaf.domain.Problem;
import org.lanqiao.oqaf.service.IProblemService;

import java.sql.SQLException;

public class ProblemServiceImpl implements IProblemService {
    //创建ProblemDao对象
    private IProblemDao dao = new ProblemDaoImpl();
    @Override
    public void insertProblem(Problem pro) {
        try {
            dao.insertProblem(pro);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
