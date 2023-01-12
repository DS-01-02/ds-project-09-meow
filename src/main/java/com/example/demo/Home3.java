package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Home3 {

    @FXML
    private Button btn_home;

    @FXML
    private Button btn_inorder;

    @FXML
    private Button btn_postorder;

    @FXML
    private Button btn_preorder;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl_action;

    @FXML
    private ListView<String> listview;

    @FXML
    private Rectangle rectangle;

    @FXML
    private AnchorPane scrpane;

    @FXML
    void click_home(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("File Manger");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_inorder(MouseEvent event) throws IOException {
        Traversal.traversal = selectedRoot.inorder().toString();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("Traversal.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("File Manger");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_postorder(MouseEvent event) throws IOException {
        Traversal.traversal = selectedRoot.postorder().toString();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("Traversal.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("File Manger");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_preorder(MouseEvent event) throws IOException {
        Traversal.traversal = selectedRoot.preorder().toString();
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("Traversal.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("File Manger");
        stage.setScene(scene);
        stage.show();
    }


    public void initialize() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (Tree a : Tree.folders) {
            observableList.add(a.Root().toString());
        }
        listview.setItems(observableList);
    }

    Tree<String> selectedRoot;

    @FXML
    void click_folder(MouseEvent event) {
        String folder = listview.getSelectionModel().getSelectedItem();
        for (Tree<String> a : Tree.folders) {
            if (a.Root().equals(folder))
                selectedRoot = a;
        }
    }
}