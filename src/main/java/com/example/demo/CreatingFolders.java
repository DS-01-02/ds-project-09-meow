package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CreatingFolders {

    void returnYears(String SqlCmd) {
        String SQLCom = "SELECT Year FROM `filelist`";
        MySqlConnection sql = new MySqlConnection();
        List<Integer> listYear = sql.returnYears(SQLCom);


        for (int i = 0; i < listYear.size(); i++) {
            String ss = String.format("SELECT  `Format` FROM `filelist` WHERE `Year`= %d ", listYear.get(i));
            List<String> listFormat = sql.returnFormats(ss);


            try {
                //ساخت پوشه سال
                Files.createDirectory(Path.of((Unzip.dir + listYear.get(i))));


                boolean photo = false;
                boolean movie = false;
                boolean music = false;
                boolean txt = false;
                boolean pdf = false;
                for (int j = 0; j < listFormat.size(); j++) {


                    if (listFormat.get(j).equals("png") || listFormat.get(j).equals("jpeg") || listFormat.get(j).equals("jpg") ||
                            listFormat.get(j).equals("gif") && !photo) {

                        Files.createDirectory(Path.of((Unzip.dir + listYear.get(i)) + "Photo"));
                        photo = true;
                    } else if (listFormat.get(j).equals("mp4") || listFormat.get(j).equals("mov") || listFormat.get(j).equals("mkv") ||
                            listFormat.get(j).equals("avl") && !movie) {
                        Files.createDirectory(Path.of((Unzip.dir + listYear.get(i)) + "Movie"));
                        movie = true;
                    } else if (listFormat.get(j).equals("wav") || listFormat.get(j).equals("aiff") && !music) {
                        Files.createDirectory(Path.of((Unzip.dir + listYear.get(i)) + "Music"));
                        music = true;
                    } else if (listFormat.get(j).equals("txt") && !txt) {
                        Files.createDirectory(Path.of((Unzip.dir + listYear.get(i)) + "Text"));
                        txt = true;
                    } else if (listFormat.get(j).equals("pdf") && !pdf) {
                        Files.createDirectory(Path.of((Unzip.dir + listYear.get(i)) + "PDF"));
                        pdf = true;

                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
