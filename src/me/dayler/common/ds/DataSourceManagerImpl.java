/**
 * 
 */
package me.dayler.common.ds;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jolbox.bonecp.BoneCP;

/**
 * @author asalazar
 *
 */
public class DataSourceManagerImpl implements DataSourceManager {

    private static final SimpleDataSourceManager dsManager = new SimpleDataSourceManager();

    private synchronized SimpleDataSourceManager getDsManager() {
        return dsManager;
    }

    void setBoneCP(BoneCP boneCP) {
        getDsManager().setBoneCP(boneCP);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connection getConnection() throws SQLException {
        return getDsManager().getConnection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CallableStatement makeStatement(Connection conn, String query, Object... values) throws SQLException {
        return getDsManager().makeStatement(conn, query, values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultSet execute(Connection conn, String query, Object... values) throws SQLException {
        return getDsManager().execute(conn, query, values);
    }

    @Override
    public void shutdownConnPool() {
        getDsManager().shutdownConnPool();
    }
}
