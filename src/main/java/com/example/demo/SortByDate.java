package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.shape.Rectangle;

public class SortByDate {

    @FXML
    private Button btn_back;

    @FXML
    private ListView<String> listview;

    @FXML
    private Rectangle rectangle;

    @FXML
    private ScrollBar scrollbar;

    public void initialize(){
        FileManagement fileManagement = new FileManagement("C:\\Users\\Msi\\Documents\\New folder");
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(MyFile1 a : fileManagement.files){
            observableList.add(String.valueOf(a));
        }
        listview.setItems(observableList);
    }
}
