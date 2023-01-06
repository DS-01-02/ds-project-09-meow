package com.example.demo;

import java.io.File;
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
                Files.createDirectory(Path.of((Unzip.dir+ "\\"+listYear.get(i))));


                boolean photo = false;
                boolean movie = false;
                boolean music = false;
                boolean txt = false;
                boolean pdf = false;
                for (int j = 0; j < listFormat.size(); j++) {


                    if (listFormat.get(j).equals("png") || listFormat.get(j).equals("jpeg") || listFormat.get(j).equals("jpg") ||
                            listFormat.get(j).equals("gif") && !photo) {

                        Files.createDirectory(Path.of((Unzip.dir +"\\"+ listYear.get(i)) + "\\"+"Photo"));
                        photo = true;
                    } else if (listFormat.get(j).equals("mp4") || listFormat.get(j).equals("mov") || listFormat.get(j).equals("mkv") ||
                            listFormat.get(j).equals("avl") && !movie) {
                        Files.createDirectory(Path.of((Unzip.dir + "\\"+listYear.get(i))+ "\\" + "Movie"));
                        movie = true;
                    } else if (listFormat.get(j).equals("wav") || listFormat.get(j).equals("aiff") && !music) {
                        Files.createDirectory(Path.of((Unzip.dir +"\\"+ listYear.get(i)) + "\\"+ "Music"));
                        music = true;
                    } else if (listFormat.get(j).equals("txt") && !txt) {
                        Files.createDirectory(Path.of((Unzip.dir + "\\"+listYear.get(i))+ "\\" + "Text"));
                        txt = true;
                    } else if (listFormat.get(j).equals("pdf") && !pdf) {
                        Files.createDirectory(Path.of((Unzip.dir +  "\\"+ listYear.get(i))+"\\" + "PDF"));
                        pdf = true;

                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void movefiles(){
        String target = null;
       // FileManagement fm = new FileManagement(Unzip.dir);
        for(MyFile1 a : FileManagement.files){
            if(a.format.equals("png") || a.format.equals("jpg") || a.format.equals("jpeg")){
                target = Unzip.dir+"\\"+a.year+"\\Photo"+"\\" + a.name+"."+a.year+"."+a.format;
            }
            else if(a.format.equals("mp4") || a.format.equals("mov") || a.format.equals("mkv")){
                target = Unzip.dir+"\\"+a.year+"\\Movie"+"\\" + a.name+"."+a.year+"."+a.format;
            }else if(a.format.equals("wav") || a.format.equals("aiff") ){
                target = Unzip.dir+"\\"+a.year+"\\Music"+"\\" + a.name+"."+a.year+"."+a.format;
            }else if(a.format.equals("txt")  ){
                target = Unzip.dir+"\\"+a.year+"\\Text"+"\\" + a.name+"."+a.year+"."+a.format;
            }else if(a.format.equals("pdf")  ){
                target = Unzip.dir+"\\"+a.year+"\\PDF"+"\\" + a.name+"."+a.year+"."+a.format;
            }

            try {
                System.out.println(target);
                String source = Unzip.dir+"\\" + a.name+"."+a.year+"."+a.format;
                System.out.println(source);
                Files.move(Path.of(source), Path.of(target));
            } catch (IOException e) {
                //throw new RuntimeException(e);
            }

        }
    }
}






















