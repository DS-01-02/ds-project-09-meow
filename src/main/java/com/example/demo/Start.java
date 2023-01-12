package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;

public class Start {
    @FXML
    private Button btn_start;

    @FXML
    private Label lbl1;

    @FXML
    private ImageView pic1;

    @FXML
    private Rectangle rectangle;

    @FXML
    void click_start(MouseEvent event) throws IOException {

        System.out.println("START");
        JFileChooser zip = new JFileChooser();
        zip.setFileSelectionMode(JFileChooser.FILES_ONLY);
        zip.showSaveDialog(null);
        Unzip.unzip(String.valueOf(zip.getSelectedFile()), zip.getSelectedFile().getParent() + "\\a");
        Unzip.dir=zip.getSelectedFile().getParent() + "\\a";
        FileManagement fileManagement = new FileManagement(Unzip.dir);
        phase_1 ph = new phase_1() ;
        ph.addtoDB();

        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("File Manger");
        stage.setScene(scene);
        stage.show();

    }


}
