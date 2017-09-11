package prod.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by e631876 on 6/9/2017.
 */
public class UnitTrustRateDao {
    private static final String SQL = "BEGIN RTS_NRM_PKG_549238.RTS_TRUST_RATE_PROD_CALC;END;";

    private Connection connection;

    public UnitTrustRateDao(Connection connection) {
        this.connection = connection;

    }


    public boolean calcRate() throws SQLException {
        CallableStatement cstmt = null;
        try {
            cstmt = connection.prepareCall(SQL);
            cstmt.execute();
            return true;
        } finally {
            if (cstmt !=null){
                cstmt.close();
            }
        }
    }
}
