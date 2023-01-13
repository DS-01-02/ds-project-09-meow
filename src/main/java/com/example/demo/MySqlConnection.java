package com.example.demo;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MySqlConnection {
    String url = "jdbc:mysql://localhost/files";
    String userName = "root";
    String passWord = "";

    public boolean connection(String cmd) {
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

    //

    List<Integer> returnYears (String SqlCmd) {
        try {
            List<Integer> list = new ArrayList<>();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con = DriverManager.getConnection(url, userName, passWord);

            Statement s = Con.prepareStatement(SqlCmd);
            ResultSet rs = s.executeQuery(SqlCmd);

            while(rs.next()) {
                list.add(Integer.valueOf(rs.getString("Year")) ) ;
            }

            for (int i=0 ; i<list.size() ; i++ ) {
                for (int j=i+1 ; j< list.size() ; j++) {
                    if (list.get(i)==list.get(j)){
                        list.remove(j) ;
                    }
                }
            }

            Collections.sort(list);

            return list;
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    List<String> returnFormats (String SqlCmd) {
        try {
            List<String> list = new ArrayList<>();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con = DriverManager.getConnection(url, userName, passWord);

            Statement s = Con.prepareStatement(SqlCmd);
            ResultSet rs = s.executeQuery(SqlCmd);

            while(rs.next()) {
                list.add( rs.getString("Format")) ;
            }

            for (int i=0 ; i<list.size() ; i++ ) {
                for (int j=i+1 ; j< list.size() ; j++) {
                    if (Objects.equals(list.get(i), list.get(j))){
                        list.remove(j) ;
                    }
                }
            }

            return list;
        }
        catch (Exception ex)
        {
            return null;
        }
    }



}
