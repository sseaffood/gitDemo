/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 84904
 */
public class DBUtils {
    private static final String DB_NAME="human";
    private static final String USER_NAME="sa";
    private static final String PASSWORD="12345";
    private static final String DRIVER_LOADER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL="jdbc:sqlserver://localhost:1433;databaseName=";
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn= null;
        Class.forName(DRIVER_LOADER);
        String url= URL+ DB_NAME;
        conn= DriverManager.getConnection(url, USER_NAME, PASSWORD);
        return conn;
    }   
}
