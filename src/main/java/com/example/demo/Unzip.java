package com.example.demo;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.shape.Rectangle;
        import javafx.stage.Stage;

        import java.io.IOException;

public class Unzip {

    @FXML
    private Button btn_done;

    @FXML
    private Label lbl1;

    @FXML
    private ImageView pic1;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TextField txt_address;

    @FXML
    void click_done(MouseEvent event) throws IOException {

        System.out.println("DONE");

        Parent parent = FXMLLoader.load(HelloApplication.class.getResource("Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setResizable(false);    //وقتی این فرم ایجاد شده کسی اجازه بزرگتر یا کوچکتر کردن اون رو نداشته باشه
        stage.setTitle("File Manger");
        stage.setScene(scene);
        stage.show();
    }

}
