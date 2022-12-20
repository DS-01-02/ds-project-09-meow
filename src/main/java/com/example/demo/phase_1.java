package com.example.demo;


import java.io.File;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;

public class phase_1 {
    public void addtoDB() {
        FileManagement fileManagement = new FileManagement("C:\\Users\\ALFA\\Documents\\New folder");
        for (int i = 0; i < fileManagement.size; i++) {
            String SQLCom = String.format("INSERT  INTO filelist (Name, Year, Format, Parent) values ('%s', %d, '%s', '%s')", fileManagement.files.get(i).getName()
                    , fileManagement.files.get(i).getYear(), fileManagement.files.get(i).getFormat(), fileManagement.files.get(i).parent);
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.connection(SQLCom);
            ;

        }
    }
}
