package org.lanqiao.oqaf.dao;

import org.lanqiao.oqaf.domain.Collection;
import org.lanqiao.oqaf.domain.Replay;
import org.lanqiao.oqaf.domain.UserInfoCollection;

import java.sql.SQLException;
import java.util.List;

public interface ICollectionDao {
    // 收藏回答
    public void collectReplay(Collection collection) throws SQLException;
    // 取消收藏
    public void cancelCollectReplay(Collection collection) throws SQLException;
    // 获取一条回答
    public Replay getOneReplay(int pid , int uid) throws SQLException;
    // 获取用户信息资料上的收藏信息\
    public List<UserInfoCollection> getUserInfoCollection(int collectionUserId) throws SQLException;
    //删除用户收藏的东西
    public void deleteCollection(int problemId,int collectionUserId,int replayUserId) throws SQLException;
}
