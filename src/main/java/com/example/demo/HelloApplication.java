package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.sql.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FileManagement f = new FileManagement("C:\\Users\\Msi\\Documents\\New folder") ;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SortByDate.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 390);
        stage.setTitle("File Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        FileManagement fileManagement = new FileManagement("C:\\Users\\Msi\\Documents\\New folder");
        phase_1 ph = new phase_1() ;
        ph.addtoDB();
       // ph.sortbyDate();
        launch();
    }
}

