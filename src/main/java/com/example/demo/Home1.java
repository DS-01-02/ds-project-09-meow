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
import java.util.ArrayList;

public class Home1 {

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_home;

    @FXML
    private Button btn_redo;

    @FXML
    private Button btn_sortdate;

    @FXML
    private Button btn_sortformat;

    @FXML
    private Button btn_undo;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl_action;

    @FXML
    private ListView<String> list_action;

    @FXML
    private ListView<String> list_main;

    @FXML
    private Rectangle rectangle;

    @FXML
    private Rectangle rectangle2;

    @FXML
    private Rectangle rectangle3;

    @FXML
    private AnchorPane scr1;

    @FXML
    private AnchorPane scr2;

    FileManagement fileManagement3 = new FileManagement(Unzip.dir);

    @FXML
    void click_add(MouseEvent event) throws IOException {

        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("AddFile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("File Manger");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void click_delete(MouseEvent event) throws IOException {
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("DeleteFile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("File Manger");
        stage.setScene(scene);
        stage.show();
    }

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
    void click_sortdate(MouseEvent event) {
        lbl_action.setText("Files sorted by their date :");
        FileManagement fileManagement2 = new FileManagement(Unzip.dir);

        //سورت می شوند
        for (int i = 0; i < fileManagement2.files .size(); i++) {
            for (int j = i + 1; j < fileManagement2.files.size(); j++)
                if (fileManagement2.files.get(i).getYear() > fileManagement2.files.get(j).getYear()) {
                    MyFile1 obj = fileManagement2.files.get(i);
                    fileManagement2.files.set(i, fileManagement2.files.get(j));
                    fileManagement2.files.set(j, obj);
                }
        }

        //
        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(MyFile1 a : fileManagement2.files){
            observableList.add(String.valueOf(a.getName()+"."+a.getYear()+"."+a.getFormat()));
        }
        list_action.setItems(observableList);
    }

    @FXML
    void click_sortformat(MouseEvent event) {
        lbl_action.setText("Files sorted by their format :");
        ArrayList<MyFile1> photo = new ArrayList<>();
        ArrayList<MyFile1> video = new ArrayList<>();
        ArrayList<MyFile1> voice = new ArrayList<>();
        ArrayList<MyFile1> txt = new ArrayList<>();
        ArrayList<MyFile1> pdf = new ArrayList<>() ;

        FileManagement fileManagement = new FileManagement(Unzip.dir);

        //سورت می شوند
        for (int i = 0; i < fileManagement.files .size(); i++) {
            if (fileManagement.files.get(i).getFormat().equals("png") || fileManagement.files.get(i).getFormat().equals("jpeg") || fileManagement.files.get(i).getFormat().equals("jpg") || fileManagement.files.get(i).getFormat().equals("gif") ) {
                photo.add(fileManagement.files.get(i)) ;
            }
            else if ( fileManagement.files.get(i).getFormat().equals("mp4") || fileManagement.files.get(i).getFormat().equals("mov") || fileManagement.files.get(i).getFormat().equals("mkv") || fileManagement.files.get(i).getFormat().equals("avl") ) {
                video.add(fileManagement.files.get(i)) ;
            }
            else if ( fileManagement.files.get(i).getFormat().equals("wav") || fileManagement.files.get(i).getFormat().equals("aiff")) {
                voice.add(fileManagement.files.get(i)) ;
            }
            else if (fileManagement.files.get(i).getFormat().equals("txt")) {
                txt.add(fileManagement.files.get(i)) ;
            }
            else if (fileManagement.files.get(i).getFormat().equals("pdf")) {
                pdf.add(fileManagement.files.get(i)) ;
            }
        }


        int j=0 ;

        for (int i=0 ; i<photo.size() ; i++ ,j++) {
            fileManagement.files.set(j,photo.get(i)) ;
        }

        for (int i=0 ; i<video.size() ; i++ ,j++) {
            fileManagement.files.set(j,video.get(i)) ;
        }

        for (int i=0 ; i<voice.size() ; i++,j++ ) {
            fileManagement.files.set(j,voice.get(i)) ;
        }

        for (int i=0 ; i<txt.size() ; i++,j++ ) {
            fileManagement.files.set(j,txt.get(i)) ;
        }

        for (int i=0 ; i<pdf.size() ; i++ ,j++ ) {
            fileManagement.files.set(j,pdf.get(i)) ;
        }

        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(MyFile1 a : fileManagement.files){
            observableList.add(String.valueOf(a.getName()+"."+a.getYear()+"."+a.getFormat()));
        }
        list_action.setItems(observableList);
    }

    @FXML
    void click_redo(MouseEvent event) {

    }

    @FXML
    void click_undo(MouseEvent event) {

    }

    public void initialize(){

        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(MyFile1 a : fileManagement3.files){
            observableList.add(String.valueOf(a.getName()+"."+a.getYear()+"."+a.getFormat()));
        }
        list_main.setItems(observableList);
    }

}
