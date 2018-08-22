package org.lanqiao.oqaf.service;

import org.lanqiao.oqaf.domain.Problem;
import org.lanqiao.oqaf.domain.Replay;

import java.util.List;

/**
 * 回答表插入
 */
public interface IReplayService {
    //插入一条数据到数据表中
    public void insertReplay(Replay replay);

}
