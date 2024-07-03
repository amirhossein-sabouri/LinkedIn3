package org.example.linkedin3.Controller;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.linkedin3.Model.User;
//
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
//
//public class LoginPageController implements Initializable {
//
//    @FXML
//    private TextField userField;
//
//    @FXML
//    private Button joinBut;
//
//    @FXML
//    private PasswordField passField;
//
//    @FXML
//    private Button signinBut;
//
//    @FXML
//    private BorderPane username;
//    @FXML
//    private Label errorLBL ;
//    //because we want to make only one registerPage when we click multipleTimes
//     public static Stage registerStage = null;
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        errorLBL.setText("");
//        joinBut.setOnAction(e->{
//            try {
//                openRegisterPage();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//        signinBut.setOnAction(e->{
//            try {
//                enterIn();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//    }
//    private void openRegisterPage() throws IOException {
//
//        if(registerStage == null){
//            AnchorPane root = FXMLLoader.load(this.getClass().getResource("/org/example/linkedin3/RegisterPage.fxml"));
//
//
//            registerStage = new Stage();
//
//            registerStage.setTitle("Register Page");
//            registerStage.setScene(new Scene(root));
//            registerStage.show();
//        }
//
//    }
//    private void enterIn() throws IOException {
//        if(checkAllField()){
//            User user = getUserWithUsername(userField.getText());
//            if(user!= null){
//                    if(checkPassWord(passField.getText(),user)){
//                            loadMainPage();
//                    }else{
//                        errorLBL.setText("Wrong Password for User");
//                    }
//            }else{
//                errorLBL.setText("User not found");
//            }
//        }
//    }
//    private boolean checkAllField(){
//        if(userField.getText().isEmpty()||passField.getText().isEmpty()){
//            errorLBL.setText("Please fill all parts");
//            return false;
//        }
//        return true;
//    }
//    private User getUserWithUsername(String username){
//        ArrayList<User> users = User.getAllUsers();
//        for(User user : users){
//            if(user.getUsername().equals(username)){
//                return user;
//            }
//        }
//        return null;
//
//    }
//    private boolean checkPassWord(String password,User user){
//        return password.equals(user.getPassword());
//    }
//    private void loadMainPage() throws IOException {
//        BorderPane root = FXMLLoader.load(this.getClass().getResource("/org/example/linkedin3/MainPage.fxml"));
//        Stage stage = (Stage)username.getScene().getWindow();
//        stage.setScene(new Scene(root));
//        stage.setFullScreen(true);
//
//    }
//
//}


import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class LoginPageController implements Initializable{
@FXML

    private Label errorLBL;

    @FXML
    private JFXButton joinBut;

    @FXML
    private TextField passField;

    @FXML
    private JFXButton signinBut;

    @FXML
    private TextField userField;

    @FXML
    private BorderPane username;
    public static Stage registerStage = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLBL.setText("");
        joinBut.setOnAction(e -> {
            try {
                openRegisterPage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        signinBut.setOnAction(e -> {
            try {
                enterIn();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void openRegisterPage() throws IOException {

        if (registerStage == null) {
            AnchorPane root = FXMLLoader.load(this.getClass().getResource("/org/example/linkedin3/RegisterPage.fxml"));


            registerStage = new Stage();

            registerStage.setTitle("Register Page");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }else{
            errorLBL.setText("check the checkbox please");
        }

    }

    private void enterIn() throws IOException {
        if (checkAllField()) {
            User user = getUserWithUsername(userField.getText());
            if (user != null) {
                if (checkPassWord(passField.getText(), user)) {
                    MainPageController.email = user.getEmail();
                    EditInfoPageController.email = user.getEmail();
                    EditInfoPageController.password = user.getPassword();
                    EditInfoPageController.username = user.getPassword();
                    EditInfoPageController.id = user.getId();
                    loadMainPage();
                } else {
                    errorLBL.setText("Wrong Password for User");
                }
            } else {
                errorLBL.setText("User not found");
            }
        }
    }

    private boolean checkAllField() {
        if (userField.getText().isEmpty() || passField.getText().isEmpty()) {
            errorLBL.setText("Please fill all parts");
            return false;
        }
        return true;
    }

    private User getUserWithUsername(String username) {
        ArrayList<User> users = User.getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;

    }

    private boolean checkPassWord(String password, User user) {
        return password.equals(user.getPassword());
    }

    private void loadMainPage() throws IOException {
        BorderPane root = FXMLLoader.load(this.getClass().getResource("/org/example/linkedin3/MainPage.fxml"));
        Stage stage = (Stage) username.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setFullScreen(true);
        stage.show();
    }
}


