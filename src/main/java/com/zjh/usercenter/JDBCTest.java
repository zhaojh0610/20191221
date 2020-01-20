package com.zjh.usercenter;

import java.sql.*;

/**
 * @ClassName JDBCTest
 * @Author zhaojh
 * @Date 2020/1/15 17:32
 * @Version 1.0
 * @Description //TODO
 **/
public class JDBCTest {

    public static Connection mysqlConnection() {
        Connection con = null;
        String driverName = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driverName);
            String url = "jdbc:mysql://localhost:3306/user_center?serverTimezone=UTC";
            String user = "root";
            String passWord = "root123456";
            con = DriverManager.getConnection(url, user, passWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        Connection con = mysqlConnection();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");
            while (resultSet.next()) {
                int size = resultSet.getMetaData().getColumnCount();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < size; i++) {
                    stringBuffer.append(resultSet.getObject(i + 1)).append(",");
                }
                System.out.println(stringBuffer.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
