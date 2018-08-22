package org.lanqiao.oqaf.Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils {
    private static DataSource ds = null;
    static {
        ds = new ComboPooledDataSource("mysqlmvc");
    }
    public static void realseConn(Connection connection){

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static DataSource getDataSource(){
        return ds;
    }
}
