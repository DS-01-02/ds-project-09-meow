package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

         FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 390);
        stage.setTitle("File Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws Exception {

     /*   String SQLCom = "SELECT Year FROM `filelist`" ;
        MySqlConnection sql = new MySqlConnection();
        List<Integer> listYear = sql.returnYears(SQLCom);


/*
         for(int i=0 ; i<listYear.size() ; i++) {
            String ss = String.format("SELECT  `Format` FROM `filelist` WHERE `Year`",listYear.get(i));
           // MySqlConnection sql2 = new MySqlConnection();
            List<String> listFormat  = sql.returnFormats(ss);
            System.out.println(listFormat.get(i));

        }
*/






        launch();
    }
}

