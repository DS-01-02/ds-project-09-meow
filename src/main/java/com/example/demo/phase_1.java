package com.example.demo;


import java.io.File;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;

public class phase_1 {
    public void addtoDB() {
        for (MyFile1 a : FileManagement.files) {

                String SQLCom = String.format("INSERT  INTO filelist (Name, Year, Format, Parent) values ('%s', %d, '%s', '%s')",a.getName()
                        , a.getYear(), a.getFormat(), a.parent);
                MySqlConnection sql = new MySqlConnection();
                Boolean res = sql.connection(SQLCom);

        }
    }
}
