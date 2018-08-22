package org.lanqiao.oqaf.dao;

import org.lanqiao.oqaf.domain.Replay;

import java.sql.SQLException;
import java.util.List;

public interface IReplayDao {
    //插入一条回答导replay表中
    public void insertReplay(Replay replay) throws SQLException;

}
