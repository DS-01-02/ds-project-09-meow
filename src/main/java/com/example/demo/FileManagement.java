package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class



FileManagement {
    public int size = 0;
   public static ArrayList<MyFile1> files = new ArrayList<>();

    public FileManagement(String dir) {
        moveAllFile(dir);
    }

    void moveAllFile(String dir) {
        File file = new File(dir);
        File[] tempArr = file.listFiles();
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i].isFile()) {
                MyFile1 myFile = new MyFile1(tempArr[i].getName(),tempArr[i].getParent(),tempArr[i].getPath());
                files.add(myFile);
                try {
                    if (!tempArr[i].getParent().equals(Unzip.dir))
                        Files.move(Paths.get(tempArr[i].getPath()), Paths.get(Unzip.dir+"\\"+tempArr[i].getName()));
                  } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                size++;
            } else {
                moveAllFile(tempArr[i].getPath());
            }
        }
        for (int i = 0; i < tempArr.length; i++){
            if (!tempArr[i].isFile()) {
                tempArr[i].delete();
            }
        }

    }


}

