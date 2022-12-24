package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class AddFile {

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_home;

    @FXML
    private Button btn_redo;

    @FXML
    private Button btn_undo;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TextField txt_add;

    @FXML
    void click_add(MouseEvent event) {

    }

    @FXML
    void click_home(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("Home1.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("File Manger");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_redo(MouseEvent event) {

    }

    @FXML
    void click_undo(MouseEvent event) {

    }

}
