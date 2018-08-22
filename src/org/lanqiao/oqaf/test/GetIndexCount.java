package org.lanqiao.oqaf.test;

import org.junit.Test;
import org.lanqiao.oqaf.service.IIndexCountService;
import org.lanqiao.oqaf.service.impl.CareUserServiceImpl;
import org.lanqiao.oqaf.service.impl.IndexCountServiceImpl;

public class GetIndexCount {
    private  IIndexCountService indexCountService = new IndexCountServiceImpl();
    @Test
    public void getIndexCount(){
        System.out.println(indexCountService.getIndexCountByIndex(0));
    }
    @Test
    public void getTypeCountList(){
        System.out.println( indexCountService.getIndexCountByType("编程类"));
    }
    @Test
    public void findIdol(){
        CareUserServiceImpl careUserService= new CareUserServiceImpl();
        System.out.println(careUserService.findIdol(5));
    }
}
