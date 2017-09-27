package com.com;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rui on 6/7/2016.
 */
public class DBTest {

    private static final int BATCH_SIZE = 200;
    private static final String DBURL = "jdbc:oracle:thin:@hz4dw3224:1521:O02DMHDEV";
    private static final String userName = "dmh";
    private static final String pwd = "dmh";

    @Test
    public void insertRecord() {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        String SQL = "INSERT INTO TEST1(JOB_CD,TEST_2) values (?,?)";
        try {
            preparedStatement = connection.prepareStatement(SQL);
            int bacthCount = 0;
            for (int i = 0; i < 10000; i++) {
                preparedStatement.clearParameters();
                preparedStatement.setString(1, "Value" + i);
                preparedStatement.setInt(2, i);
                preparedStatement.addBatch();
                if ((bacthCount++) / bacthCount == 0) {
                    preparedStatement.executeBatch();
                    bacthCount = 0;
                }

            }
            if (bacthCount != 0) {
                preparedStatement.executeBatch();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("completed");
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            connection = DriverManager.getConnection(DBURL, userName, pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Test
    public void testPerformance() {
        Connection connection = getConnection();
        String inSql = getSelectIn(connection, 500);
        String connnectSql = getConnctSql(connection);

        System.out.println("in SQL:" + inSql);
        System.out.println("connect SQL:" + connnectSql);

        Statement statement = null;
        ResultSet rs = null;

        try {
            int count = 0;
            statement = connection.createStatement();
            long start = System.currentTimeMillis();
            rs = statement.executeQuery(inSql);
            long end = System.currentTimeMillis();
            while (rs.next()) {
                count++;
            }

            System.out.println("Use in Sql ResultSet count:" + count + ",take time:" + (end - start) + "ms");

            start = end;
            rs = statement.executeQuery(connnectSql);
            end = System.currentTimeMillis();
            count = 0;
            while (rs.next()) {
                count++;
            }


            System.out.println("Use connect sql  ResultSet count:" + count + ",take time:" + (end - start) + "ms");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testBucketPerfmonce() {
        Connection connection = getConnection();
        String inSql1 = getSelectIn(connection, 100);
        String inSql2 = getSelectIn(connection, 200);

        System.out.println("inSql1:" + inSql1);
        System.out.println("inSql2:" + inSql2);

        Statement statement = null;
        ResultSet rs = null;

        try {
            int count = 0;
            statement = connection.createStatement();
            long start = System.currentTimeMillis();
            rs = statement.executeQuery(inSql1);
            long end = System.currentTimeMillis();
            while (rs.next()) {
                count++;
            }

            System.out.println("Use in Sql ResultSet count:" + count + ",take time:" + (end - start) + "ms");

            start = end;
            rs = statement.executeQuery(inSql2);
            end = System.currentTimeMillis();
            count = 0;
            while (rs.next()) {
                count++;
            }


            System.out.println("Use connect sql  ResultSet count:" + count + ",take time:" + (end - start) + "ms");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String getSelectIn(Connection connection, int bucketSize) {

        List<String> list = getValues(connection);
        StringBuilder sb = new StringBuilder(30000);
        sb.append("SELECT * FROM RTS_FUND_HEADER A WHERE ");
        for (int index = 1; index <= list.size(); index++) {

            String item = list.get(index - 1);
            if (index % bucketSize == 1) {
                sb.append(" A.FUND_ID IN('").append(item).append("','");
            } else if (index % bucketSize == 0) {
                sb.append(item).append("')").append("\n OR");
            } else {
                sb.append(item).append("','");
            }
        }
        if (list.size() % bucketSize != 0) {
            sb.delete(sb.length() - 3, sb.length());
            sb.append("')");
        } else {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.toString();
    }


    @Test
    public void testXXX() {
        Connection connection = getConnection();
        getConnctSql(connection);
    }

    public String getConnctSql(Connection connection) {
        List<String> list = getValues(connection);
        StringBuilder sb = new StringBuilder(30000);
        for (String fund : list) {
            sb.append(fund).append("|");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sql = "SELECT TO_CHAR(REGEXP_SUBSTR('" + sb.toString() + "', '[^|]+', 1, ROWNUM))FROM DUAL CONNECT BY TO_CHAR(REGEXP_SUBSTR('" + sb.toString()
                + "', '[^|]+', 1, ROWNUM))  IS NOT NULL";
        sql = "SELECT FUND_ID from RTS_FUND_HEADER WHERE FUND_ID IN(" + sql + ")";
        return sql;
    }

    private List<String> getValues(Connection connection) {
        String SQL = "SELECT FUND_ID from RTS_FUND_HEADER where rownum<=800";
        PreparedStatement preparedStatement = null;
        List<String> list = new ArrayList<String>(10000);
        try {
            preparedStatement = connection.prepareStatement(SQL);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                list.add(rs.getString("FUND_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
