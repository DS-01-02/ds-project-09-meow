package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteFile {

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_delete;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private ListView<String> listview;

    @FXML
    private Rectangle rectangle;

    @FXML
    private ScrollPane scrolpane;


    @FXML
    private TextField txt_filename;

    @FXML
    void click_back(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("Home1.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("File Manger");
        stage.setScene(scene);
        stage.show();
    }

    FileManagement fileManagement = new FileManagement("C:\\Users\\TAK\\Downloads\\New folder");

    @FXML
    void click_delete(MouseEvent event) throws IOException {
        if (!txt_filename.getText().equals("")) {
            //حذف کردن از دیتابیس
            String ss = String.format("DELETE FROM `filelist` WHERE Name = '%s'", txt_filename.getText());

            MySqlConnection sql = new MySqlConnection();
            Boolean rs = sql.ExecuteSQL(ss);


            if (!rs) {
                Parent parent = FXMLLoader.load(HelloApplication.class.getResource("Error.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(parent);
                stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
                stage.setTitle("File Manger");
                stage.setScene(scene);
                stage.show();
            }

            //حذف از اری لیست
            // حذف از فولدر


            for (int i = 0; i < fileManagement.files.size(); i++) {
                if (fileManagement.files.get(i).getName().equals(txt_filename.getText())) {
                    File file = new File(fileManagement.files.get(i).dir);
                    file.delete();
                    fileManagement.files.remove(i);
                    break;
                }
            }

            ObservableList<String> observableList = FXCollections.observableArrayList();
            for (MyFile1 a : fileManagement.files) {
                observableList.add(String.valueOf(a.getName() + "." + a.getYear() + "." + a.getFormat()));
            }
            listview.setItems(observableList);
        }
        else {
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("Error.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("File Manger");
            stage.setScene(scene);
            stage.show();
        }

    }

    public void initialize(){

        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(MyFile1 a : fileManagement.files){
            observableList.add(String.valueOf(a.getName()+"."+a.getYear()+"."+a.getFormat()));
        }
        listview.setItems(observableList);
    }
}
