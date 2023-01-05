package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class SortByDate {

    @FXML
    private Button btn_back;

    @FXML
    private ListView<String> listview;

    @FXML
    private Rectangle rectangle;

    @FXML
    private ScrollBar scrollbar;

    //

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

    //



    //

    public void initialize(){

        FileManagement fileManagement = new FileManagement(Unzip.dir);

        //سورت می شوند
        for (int i = 0; i < fileManagement.files .size(); i++) {
            for (int j = i + 1; j < fileManagement.files.size(); j++)
                if (fileManagement.files.get(i).getYear() > fileManagement.files.get(j).getYear()) {
                    MyFile1 obj = fileManagement.files.get(i);
                    fileManagement.files.set(i, fileManagement.files.get(j));
                    fileManagement.files.set(j, obj);
                }
        }

        //
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(MyFile1 a : fileManagement.files){
            observableList.add(String.valueOf(a.getName()+"."+a.getYear()+"."+a.getFormat()));
        }
        listview.setItems(observableList);
    }
}
