package org.lanqiao.oqaf.service.impl;

import org.lanqiao.oqaf.dao.ICollectionDao;
import org.lanqiao.oqaf.dao.impl.CollectionDaoImpl;
import org.lanqiao.oqaf.domain.Collection;
import org.lanqiao.oqaf.domain.Replay;
import org.lanqiao.oqaf.domain.UserInfoCollection;
import org.lanqiao.oqaf.service.ICollectionService;

import java.sql.SQLException;
import java.util.List;

public class CollectionServiceImpl implements ICollectionService {
    private ICollectionDao dao = new CollectionDaoImpl();
    @Override
    public void collectReplay(Collection collection) {
        try {
            dao.collectReplay(collection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelCollectReplay(Collection collection) {
        try {
            dao.cancelCollectReplay(collection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Replay getOneReplay(int pid, int uid) {
        Replay replay = null;
        try {
            replay = dao.getOneReplay(pid , uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replay;
    }

    @Override
    public List<UserInfoCollection> getUserInfoCollection(int collectionUserId) {
        List<UserInfoCollection> collections =null;
        try {
            collections = dao.getUserInfoCollection(collectionUserId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collections;
    }

    @Override
    public void deleteCollection(int problemId, int collectionUserId, int replayUserId) {
        try {
            dao.deleteCollection(problemId,collectionUserId,replayUserId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
