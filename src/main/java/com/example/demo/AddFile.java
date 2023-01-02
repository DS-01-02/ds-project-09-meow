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

    FileManagement fileManagement = new FileManagement("C:\\Users\\TAK\\Downloads\\New folder");

    @FXML
    void act_aiff(ActionEvent event) throws IOException {

        // جای خالی پر باشد
        if (!txt_name.getText().equals("")  && !txt_year.getText().equals("")) {

            String add = txt_name.getText() + "." + txt_year.getText() + "." + "aiff";
            System.out.println(add);

            //اد به دیتابیس
            String SQLCom = String.format("INSERT INTO filelist (Name, Year, Format, Parent) values ('%s', %s, '%s', '%s')",txt_name.getText(),Integer.valueOf(txt_year.getText()),"aiff",  );
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.ExecuteSQL(SQLCom);

            //
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

    @FXML
    void act_avl(ActionEvent event) throws IOException {

        //جای خالی پر باشد
        if (!txt_name.getText().equals("")  && !txt_year.getText().equals("")) {

            String add = txt_name.getText() + "." + txt_year.getText() + "." + "avl";
            System.out.println(add);

            //اد به دیتابیس
            String SQLCom = String.format("INSERT INTO filelist (Name, Year, Format, Parent) values ('%s', %s, '%s', '%s')",txt_name.getText(),Integer.valueOf(txt_year.getText()),"avl" ,);
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.ExecuteSQL(SQLCom);

            //
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

    @FXML
    void act_gif(ActionEvent event) throws IOException {

        //جای خالی پر باشد
        if (!txt_name.getText().equals("")  && !txt_year.getText().equals("")) {

            String add = txt_name.getText() + "." + txt_year.getText() + "." + "gif";
            System.out.println(add);

            //اد به دیتابیس
            String SQLCom = String.format("INSERT INTO filelist (Name, Year, Format, Parent) values ('%s', %s, '%s', '%s')",txt_name.getText(),Integer.valueOf(txt_year.getText()),"gif",  );
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.ExecuteSQL(SQLCom);

            //
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

    @FXML
    void act_jpeg(ActionEvent event) throws IOException {

        // جای خالی پر باشد
        if (!txt_name.getText().equals("")  && !txt_year.getText().equals("")) {
            String add = txt_name.getText() + "." + txt_year.getText() + "." + "jpeg";
            System.out.println(add);

            //اد به دیتابیس
            String SQLCom = String.format("INSERT INTO filelist (Name, Year, Format, Parent) values ('%s', %s, '%s', '%s')",txt_name.getText(),Integer.valueOf(txt_year.getText()),"jpeg",  );
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.ExecuteSQL(SQLCom);

            //
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

    @FXML
    void act_jpg(ActionEvent event) throws IOException {

        // جای خالی پر باشد
        if (!txt_name.getText().equals("")  && !txt_year.getText().equals("")) {
            String add = txt_name.getText() + "." + txt_year.getText() + "." + "jpg";
            System.out.println(add);

            //اد به دیتابیس
            String SQLCom = String.format("INSERT INTO filelist (Name, Year, Format, Parent) values ('%s', %s, '%s', '%s')",txt_name.getText(),Integer.valueOf(txt_year.getText()),"jpg",  );
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.ExecuteSQL(SQLCom);

            //
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

    @FXML
    void act_mkv(ActionEvent event) throws IOException {

        //جای خالی پر باشد
        if (!txt_name.getText().equals("")  && !txt_year.getText().equals("")) {
            String add = txt_name.getText() + "." + txt_year.getText() + "." + "mkv";
            System.out.println(add);

            //اد به دیتابیس
            String SQLCom = String.format("INSERT INTO filelist (Name, Year, Format, Parent) values ('%s', %s, '%s', '%s')",txt_name.getText(),Integer.valueOf(txt_year.getText()),"mkv",  );
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.ExecuteSQL(SQLCom);

            //
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

    @FXML
    void act_mov(ActionEvent event) throws IOException {

        //جای خالی پر باشد
        if (!txt_name.getText().equals("")  && !txt_year.getText().equals("")) {
            String add = txt_name.getText() + "." + txt_year.getText() + "." + "mov";
            System.out.println(add);

            //اد کردن به دیتابیس
            String SQLCom = String.format("INSERT INTO filelist (Name, Year, Format, Parent) values ('%s', %s, '%s', '%s')",txt_name.getText(),Integer.valueOf(txt_year.getText()),"mov",  );
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.ExecuteSQL(SQLCom);

            //
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

    @FXML
    void act_mp4(ActionEvent event) throws IOException {

        //جای خالی پر باشد
        if (!txt_name.getText().equals("")  && !txt_year.getText().equals("")) {
            String add = txt_name.getText() + "." + txt_year.getText() + "." + "mp4";
            System.out.println(add);

            //اد کردن به دیتابیس
            String SQLCom = String.format("INSERT INTO filelist (Name, Year, Format, Parent) values ('%s', %s, '%s', '%s')",txt_name.getText(),Integer.valueOf(txt_year.getText()),"mp4",  );
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.ExecuteSQL(SQLCom);

            //
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

    @FXML
    void act_pdf(ActionEvent event) throws IOException {
        //جای خالی پر باشد
        if (!txt_name.getText().equals("")  && !txt_year.getText().equals("")) {
            String add = txt_name.getText() + "." + txt_year.getText() + "." + "pdf";
            System.out.println(add);

            //  اد کردن به دیتابیس

            String SQLCom = String.format("INSERT INTO filelist (Name, Year, Format, Parent) values ('%s', %s, '%s', '%s')",txt_name.getText(),Integer.valueOf(txt_year.getText()),"mp4", );
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.ExecuteSQL(SQLCom);

            //
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

    @FXML
    void act_png(ActionEvent event) throws IOException {
        //جای خالی پر باشد
        if (!txt_name.getText().equals("")  && !txt_year.getText().equals("")) {
            String add = txt_name.getText() + "." + txt_year.getText() + "." + "png";
            System.out.println(add);

            //اد کردن به دیتابیس
            String SQLCom = String.format("INSERT INTO filelist (Name, Year, Format, Parent) values ('%s', %s, '%s', '%s')",txt_name.getText(),Integer.valueOf(txt_year.getText()),"png",  );
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.ExecuteSQL(SQLCom);

            //
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

    @FXML
    void act_txt(ActionEvent event) throws IOException {
        //جای خالی پر باشد
        if (!txt_name.getText().equals("")  && !txt_year.getText().equals("")) {
            String add = txt_name.getText() + "." + txt_year.getText() + "." + "txt";
            System.out.println(add);


            //اد کردن به دیتابیس
            String SQLCom = String.format("INSERT INTO filelist (Name, Year, Format, Parent) values ('%s', %s, '%s', '%s')",txt_name.getText(),Integer.valueOf(txt_year.getText()),"txt",  );
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.ExecuteSQL(SQLCom);

            //
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

    @FXML
    void act_wav(ActionEvent event) throws IOException {
        //جای خالی پر باشد
        if (!txt_name.getText().equals("")  && !txt_year.getText().equals("")) {
            String add = txt_name.getText() + "." + txt_year.getText() + "." + "wav";
            System.out.println(add);

            //اد کردن به دیتابیس
            String SQLCom = String.format("INSERT INTO filelist (Name, Year, Format, Parent) values ('%s', %s, '%s', '%s')",txt_name.getText(),Integer.valueOf(txt_year.getText()),"wav",  );
            MySqlConnection sql = new MySqlConnection();
            Boolean res = sql.ExecuteSQL(SQLCom);

            //
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

        ObservableList<String> observableList = FXCollections.observableArrayList();
        for(MyFile1 a : fileManagement.files){
            observableList.add(String.valueOf(a.getName()+"."+a.getYear()+"."+a.getFormat()));
        }
        listview.setItems(observableList);
    }


}
