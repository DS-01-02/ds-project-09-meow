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
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SortByFormat {

    @FXML
    private ListView<String> listview;

    @FXML
    private Rectangle rectangle;

    @FXML
    private ScrollBar scrollbar;

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


    public void initialize(){

        ArrayList<MyFile1> photo = new ArrayList<>();
        ArrayList<MyFile1> video = new ArrayList<>();
        ArrayList<MyFile1> voice = new ArrayList<>();
        ArrayList<MyFile1> txt = new ArrayList<>();
        ArrayList<MyFile1> pdf = new ArrayList<>() ;


        //سورت می شوند
        for (int i = 0; i < FileManagement.files .size(); i++) {
            if (FileManagement.files.get(i).getFormat().equals("png") || FileManagement.files.get(i).getFormat().equals("jpeg") || FileManagement.files.get(i).getFormat().equals("jpg") || FileManagement.files.get(i).getFormat().equals("gif") ) {
                photo.add(FileManagement.files.get(i)) ;
            }
            else if ( FileManagement.files.get(i).getFormat().equals("mp4") || FileManagement.files.get(i).getFormat().equals("mov") || FileManagement.files.get(i).getFormat().equals("mkv") || FileManagement.files.get(i).getFormat().equals("avl") ) {
                video.add(FileManagement.files.get(i)) ;
            }
            else if ( FileManagement.files.get(i).getFormat().equals("wav") || FileManagement.files.get(i).getFormat().equals("aiff")) {
                voice.add(FileManagement.files.get(i)) ;
            }
            else if (FileManagement.files.get(i).getFormat().equals("txt")) {
                txt.add(FileManagement.files.get(i)) ;
            }
            else if (FileManagement.files.get(i).getFormat().equals("pdf")) {
                pdf.add(FileManagement.files.get(i)) ;
            }
        }


        int j=0 ;

        for (int i=0 ; i<photo.size() ; i++ ,j++) {
            FileManagement.files.set(j,photo.get(i)) ;
        }

        for (int i=0 ; i<video.size() ; i++ ,j++) {
            FileManagement.files.set(j,video.get(i)) ;
        }

        for (int i=0 ; i<voice.size() ; i++,j++ ) {
            FileManagement.files.set(j,voice.get(i)) ;
        }

        for (int i=0 ; i<txt.size() ; i++,j++ ) {
            FileManagement.files.set(j,txt.get(i)) ;
        }

        for (int i=0 ; i<pdf.size() ; i++ ,j++ ) {
            FileManagement.files.set(j,pdf.get(i)) ;

        }

        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(MyFile1 a : FileManagement.files){
            observableList.add(String.valueOf(a.getName()+"."+a.getYear()+"."+a.getFormat()));
        }
        listview.setItems(observableList);
    }

}
