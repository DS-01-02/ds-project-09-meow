package com.example.demo;

import java.sql.Connection;
import java.sql.*;
public class MySqlConnection {
    String url = "jdbc:mysql://localhost/files";
    String userName = "root";
    String passWord = "";

    public boolean ExecuteSQL(String cmd) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, passWord);
            Statement s = con.prepareStatement(cmd);
            s.execute(cmd);
            con.close();
            return true;

        } catch (Exception e) {
            System.out.println(  e.getMessage());
           return false;
        }
    }
}
