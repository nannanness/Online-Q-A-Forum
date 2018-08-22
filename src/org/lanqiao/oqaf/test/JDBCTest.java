package org.lanqiao.oqaf.test;

import org.junit.Test;
import org.lanqiao.oqaf.Utils.JDBCUtils;

import java.sql.SQLException;

public class JDBCTest {
    @Test
    public void getJDBc() throws SQLException {
        System.out.println(JDBCUtils.getConnection());
    }
}
