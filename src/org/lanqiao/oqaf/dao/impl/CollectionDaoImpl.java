package org.lanqiao.oqaf.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.oqaf.Utils.JDBCUtils;
import org.lanqiao.oqaf.dao.ICollectionDao;
import org.lanqiao.oqaf.domain.Collection;
import org.lanqiao.oqaf.domain.Replay;
import org.lanqiao.oqaf.domain.UserInfoCollection;

import java.sql.SQLException;
import java.util.List;

public class CollectionDaoImpl implements ICollectionDao {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public void collectReplay(Collection collection) throws SQLException {
        String sql = "insert into collection values(?,?,?,?)";
        queryRunner.update(sql,collection.getProblemId(),collection.getCollectionUserId(),collection.getReplayUserId(),collection.getReplayContent());
    }

    @Override
    public void cancelCollectReplay(Collection collection) throws SQLException {
        String sql = "delete from collection where problemId = ? and replayUserId = ? and collectionUserId = ? ";
        queryRunner.update(sql,collection.getProblemId(),collection.getReplayUserId(),collection.getCollectionUserId());
    }

    @Override
    public Replay getOneReplay(int pid, int uid) throws SQLException {
        String sql = "select * from replay where problemId = ? and replayUserId = ?";
        Replay replay = queryRunner.query(sql,new BeanHandler<>(Replay.class),pid ,uid);
        return replay;
    }

    @Override
    public List<UserInfoCollection> getUserInfoCollection(int collectionUserId) throws SQLException {
        String sql = "SELECT problemId,replayUserId,collectionUserId,user_Name,replayDate,replayContent from userinfo u,\n" +
                "\t\t\t(SELECT r.problemId, r.replayUserId ,c.collectionUserId,r.replayContent,replayDate \n" +
                "\t\t\t\t\tfrom collection c ,replay r WHERE c.problemId=r.problemId and c.replayUserId=r.replayUserId and c.collectionUserId=?)r\n" +
                "\t\t\t\t\t where u.user_Id in (r.replayUserId);";
        List<UserInfoCollection> collections =queryRunner.query(sql,new BeanListHandler<>(UserInfoCollection.class),collectionUserId);
        return collections;
    }

    @Override
    public void deleteCollection(int problemId, int collectionUserId, int replayUserId) throws SQLException {
        String sql ="DELETE from collection where problemId =? and collectionUserId=? and replayUserId=?; ";
        queryRunner.update(sql,problemId,collectionUserId,replayUserId);

    }


}
