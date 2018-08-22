package org.lanqiao.oqaf.service.impl;

import org.lanqiao.oqaf.dao.IIndexCountDao;
import org.lanqiao.oqaf.dao.impl.IndexCountImpl;
import org.lanqiao.oqaf.dao.impl.IndexCountImpl;
import org.lanqiao.oqaf.domain.Problem_Replay;
import org.lanqiao.oqaf.service.IIndexCountService;

import java.sql.SQLException;
import java.util.List;


public class IndexCountServiceImpl implements IIndexCountService {
    private IIndexCountDao iIndexCountDao = new IndexCountImpl();
    @Override
    public List<Problem_Replay> getIndexCountByIndex(int index) {
        List<Problem_Replay> problem_replays = null;
        try {
            problem_replays = iIndexCountDao.getIndexCountByIndex(index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problem_replays;
    }

    @Override
    public List<Problem_Replay> getIndexAll() {
        List<Problem_Replay> problem_replaysAll =null;
        try {
            problem_replaysAll = iIndexCountDao.getIndexCountAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problem_replaysAll;
    }

    @Override
    public List<Problem_Replay> getIndexCountByType(String type) {
        List<Problem_Replay> typeCount = null;
        try {
            typeCount = iIndexCountDao.getIndexCountByType(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeCount;
    }

    @Override
    public List<Problem_Replay> getIndexCountByTypeByPage(String type, int index)   {
        List<Problem_Replay> problem_replays = null;
        try {
            problem_replays = iIndexCountDao.getIndexCountByTypeByPage(type,index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problem_replays;
    }

    @Override
    public List<Problem_Replay> getAllProblemReplay() {
        List<Problem_Replay> prList = null;
        try {
           prList = iIndexCountDao.getAllProblemReplay();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prList;
    }

    @Override
    public List<Problem_Replay> getAllProblemReplayByPage(int index) {
        List<Problem_Replay> prList = null;
        try {
            prList = iIndexCountDao.getAllProblemReplayByPage(index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prList;
    }

    @Override
    public List<Problem_Replay> getIndexContentByLike(String like, String like1, int index) {
        List<Problem_Replay> problem_replays = null;
        try {
            problem_replays = iIndexCountDao.getIndexContentByLike(like,like1, index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problem_replays;
    }

    @Override
    public List<Problem_Replay> getIndexContentByLikeByAll(String like, String like1) {
        List<Problem_Replay> problem_replays = null;
        try {
            problem_replays = iIndexCountDao.getIndexContentByLikeByAll(like,like1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problem_replays;
    }

    @Override
    public void clickZan(int pid, int uid, int zanCount) {

    }

    @Override
    public void cancelZan(int pid, int uid, int zanCount) {

    }

    @Override
    public int getZanCount(int pid, int uid) {
        return 0;
    }
}
