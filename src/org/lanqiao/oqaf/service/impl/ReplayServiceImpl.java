package org.lanqiao.oqaf.service.impl;

import org.lanqiao.oqaf.dao.IReplayDao;
import org.lanqiao.oqaf.dao.impl.ReplayDaoImpl;
import org.lanqiao.oqaf.domain.Replay;
import org.lanqiao.oqaf.service.IReplayService;

import java.sql.SQLException;
import java.util.List;

public class ReplayServiceImpl implements IReplayService {
    private static IReplayDao dao = new ReplayDaoImpl();
    @Override
    public void insertReplay(Replay replay) { ;
        try {
            dao.insertReplay(replay);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
