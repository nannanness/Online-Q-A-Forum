package org.lanqiao.oqaf.test;

import org.lanqiao.oqaf.service.IRemarkService;
import org.lanqiao.oqaf.service.impl.RemarkServiceImpl;

public class Test {
    public static void main(String[] args){
        IRemarkService iRemarkService = new RemarkServiceImpl();
        iRemarkService.getReplayUsers(1);
        System.out.println(iRemarkService.getReplayUsers(1));
    }
}
