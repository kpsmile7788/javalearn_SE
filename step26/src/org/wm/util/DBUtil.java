package org.wm.util;

import java.io.*;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Properties;

public class DBUtil {

    private static String DRIVER;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    static {
        File file = new File("sxtjdbc.properties");
        Properties properties = new Properties();
        if (!file.exists()){
            try {
                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);

                properties.setProperty("datatype","mysql");
                properties.setProperty("mysqlDRIVER","com.mysql.jdbc.Driver");
                properties.setProperty("mysqlURL","jdbc:mysql://localhost:3306/stumgr");
                properties.setProperty("mysqlUSER","root");
                properties.setProperty("mysqlPWD","root");

                properties.store(fos,null);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ("mysql".equals(properties.getProperty("datatype"))){
            DRIVER = properties.getProperty("mysqlDRIVER");
            URL = properties.getProperty("mysqlURL");
            USERNAME = properties.getProperty("mysqlUSER");
            PASSWORD = properties.getProperty("mysqlPWD");
        } else {
            DRIVER = properties.getProperty("oracleDRIVER");
            URL = properties.getProperty("oracleURL");
            USERNAME = properties.getProperty("oracleUSER");
            PASSWORD = properties.getProperty("oraclePWD");
        }
    }

    private static Connection conn = null;
    private static PreparedStatement ps = null;

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static int update(String sql,Object ...obj){
        int result = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i+1,obj[i]);
            }
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static void closeAll(ResultSet rs, Statement stmt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
