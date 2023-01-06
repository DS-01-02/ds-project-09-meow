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
        listview.setItems(observableList);
    }

}
