package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CreatingFolders {
    String url = "jdbc:mysql://localhost/files";
    String userName = "root";
    String passWord = "";
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
                for (int j=1 ; j< list.size() ; j++) {
                    if (Objects.equals(list.get(i), list.get(j))){
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
}
