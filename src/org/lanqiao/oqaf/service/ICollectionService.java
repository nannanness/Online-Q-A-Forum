package org.lanqiao.oqaf.service;

import org.lanqiao.oqaf.domain.Collection;
import org.lanqiao.oqaf.domain.Replay;
import org.lanqiao.oqaf.domain.UserInfoCollection;

import java.sql.SQLException;
import java.util.List;

public interface ICollectionService {
    // 收藏回答
    public void collectReplay(Collection collection) ;
    // 取消收藏
    public void cancelCollectReplay(Collection collection) ;
    // 获取一条回答
    public Replay getOneReplay(int pid , int uid)  ;
    // 获取用户信息资料上的收藏信息\
    public List<UserInfoCollection> getUserInfoCollection(int collectionUserId);

    //删除用户收藏的东西
    public void deleteCollection(int problemId,int collectionUserId,int replayUserId);
}
