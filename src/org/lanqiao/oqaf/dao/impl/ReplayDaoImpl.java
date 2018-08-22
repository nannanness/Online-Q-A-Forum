package org.lanqiao.oqaf.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.oqaf.Utils.JDBCUtils;
import org.lanqiao.oqaf.dao.IReplayDao;
import org.lanqiao.oqaf.domain.Replay;

import java.sql.SQLException;
import java.util.List;

public class ReplayDaoImpl implements IReplayDao {
    QueryRunner qur = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public void insertReplay(Replay replay) throws SQLException {
        String sql = "insert into replay(problemId,replayUserId,zanCount,replayContent,replayDate,remarkCount) values(?,?,?,?,?,?)";
        qur.update(sql,replay.getProblemId(),replay.getReplayUserId(),replay.getZanCount(),replay.getReplayContent(),replay.getReplayDate(),replay.getRemarkCount());
    }
}
