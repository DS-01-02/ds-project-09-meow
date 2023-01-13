package com.example.demo;


import java.io.File;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;

public class phase_1 {
    public void addtoDB() {
        for (int i = 0; i < FileManagement.files.size(); i++) {

            String SQLCom = String.format("INSERT  INTO filelist (Name, Year, Format, Parent) values ('%s', %d, '%s', '%s')", FileManagement.files.get(i).getName()
                    , FileManagement.files.get(i).getYear(), FileManagement.files.get(i).getFormat(), FileManagement.files.get(i).parent);
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.connection(SQLCom);

        }
    }
}
