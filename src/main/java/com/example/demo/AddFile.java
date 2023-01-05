package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class AddFile {

    @FXML
    private Button btn_back;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private TextField txt_parent;
    @FXML
    private ListView<String> listview;

    @FXML
    private MenuItem menu_aiff;

    @FXML
    private MenuItem menu_avl;

    @FXML
    private MenuItem menu_gif;

    @FXML
    private MenuItem menu_jpeg;

    @FXML
    private MenuItem menu_jpg;

    @FXML
    private MenuItem menu_mkv;

    @FXML
    private MenuItem menu_mov;

    @FXML
    private MenuItem menu_mp4;

    @FXML
    private MenuItem menu_pdf;

    @FXML
    private MenuItem menu_png;

    @FXML
    private MenuItem menu_txt;

    @FXML
    private MenuItem menu_wav;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private SplitMenuButton sp_music;

    @FXML
    private SplitMenuButton sp_photo;

    @FXML
    private SplitMenuButton sp_video;

    @FXML
    private ToolBar toolbar;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_year;

    FileManagement fileManagement = new FileManagement(Unzip.dir);
    String format;

    @FXML
    void act_aiff(ActionEvent event) throws IOException {

        // جای خالی پر باشد
        if (!txt_name.getText().equals("") && !txt_year.getText().equals("")) {

            format = "aiff";
        }
    }

    @FXML
    void act_avl(ActionEvent event) throws IOException {

        format = "avi";
    }

    @FXML
    void act_gif(ActionEvent event) throws IOException {

        format="gif";
    }

    @FXML
    void act_jpeg(ActionEvent event) throws IOException {

        format="jpeg";
    }

    @FXML
    void act_jpg(ActionEvent event) throws IOException {

        format="jpg";
    }

    @FXML
    void act_mkv(ActionEvent event) throws IOException {

        format="mkv";
    }

    @FXML
    void act_mov(ActionEvent event) throws IOException {
        format="mov";
    }

    @FXML
    void act_mp4(ActionEvent event) throws IOException {
        format="mp4";
    }

    @FXML
    void act_pdf(ActionEvent event) throws IOException {
        format="pdf";

    }

    @FXML
    void act_png(ActionEvent event) throws IOException {
        format="png";
    }

    @FXML
    void act_txt(ActionEvent event) throws IOException {
        format="txt";
    }

    @FXML
    void act_wav(ActionEvent event) throws IOException {
        format="wav";
    }

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

    public void initialize() {

        ObservableList<String> observableList = FXCollections.observableArrayList();
        for (MyFile1 a : fileManagement.files) {
            observableList.add(String.valueOf(a.getName() + "." + a.getYear() + "." + a.getFormat()));
        }
        listview.setItems(observableList);
    }


    @FXML
    void pressOnBtnAdd(ActionEvent event) throws IOException {
        if (!txt_name.getText().equals("") && !txt_year.getText().equals("") && !txt_parent.getText().equals("")) {
            //اد کردن به دیتابیس
            if(Integer.parseInt(txt_year.getText()) > 2023){
                //TODO
                //invalid year error
            }else {
                String SQLCom = String.format("INSERT INTO filelist (Name, Year, Format, Parent) values ('%s', %s, '%s', '%s')", txt_name.getText(), Integer.valueOf(txt_year.getText()), format, txt_parent.getText());
                MySqlConnection sql = new MySqlConnection();
                Boolean res = sql.ExecuteSQL(SQLCom);

                //
                ObservableList<String> observableList = FXCollections.observableArrayList();
                for (MyFile1 a : fileManagement.files) {
                    observableList.add(String.valueOf(a.getName() + "." + a.getYear() + "." + a.getFormat()));
                }
                listview.setItems(observableList);
                File.createTempFile(txt_name.getText() + txt_year.getText(), format, new File(txt_parent.getText()));
            }
        } else {
            Parent parent = FXMLLoader.load(HelloApplication.class.getResource("Error.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
            stage.setTitle("File Manger");
            stage.setScene(scene);
            stage.show();
        }
    }


    @FXML
    void pressOnBtnParent(ActionEvent event) {
        JFileChooser parent = new JFileChooser();
        parent.setFileSelectionMode(JFileChooser.FILES_ONLY);
        parent.showSaveDialog(null);
        txt_parent.setText(parent.getSelectedFile().getParent());
    }
}
