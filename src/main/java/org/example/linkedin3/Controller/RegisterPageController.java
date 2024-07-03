package org.example.linkedin3.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.linkedin3.Model.User;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegisterPageController implements Initializable {

    @FXML
    private Button cancelBut;

    @FXML
    private PasswordField confirmPass;
    @FXML
    private TextField lastname;

    @FXML
    private TextField emailField;

    @FXML
    private Label error;

    @FXML
    private TextField Username;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Button registerBut;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        error.setText("");
        cancelBut.setOnAction(e -> closeStage());
        registerBut.setOnAction(e -> createUser());

    }

    private void closeStage() {
//        (((Stage)cancelBut).getScene().getWindow()).close();

        LoginPageController.registerStage.close();
        LoginPageController.registerStage = null;
    }

    private void createUser() {
        error.setText("");
        error.setTextFill(Color.RED);
        if (checkAllFields()) {
            if (checkUserEmail()) {
            User user = new User(name.getText(),lastname.getText(), emailField.getText(), password.getText(), Username.getText(),
                    null, null, null, null);
            error.setTextFill(Color.GREEN);
            error.setText("User Saved Successfully");
           user.save();
            cleanPage();
        }
        }
    }

    private boolean checkAllFields() {
        String pattern = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]+$";
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        String lastNameRegex = "^[a-zA-Z\\s]+$";
        if (emailField.getText().isEmpty() || Username.getText().isEmpty() ||
                lastname.getText().isEmpty()||name.getText().isEmpty() || password.getText().isEmpty() ||
                confirmPass.getText().isEmpty()) {
            error.setText("please fill all parts");
            return false;
        } else if (!emailField.getText().matches(emailRegex)) {
            error.setText("email wrong format");
            return false;
        } else if (!Username.getText().matches(pattern)) {
            error.setText("username must contain num & char");
            return false;
        } else if (!name.getText().matches(lastNameRegex)) {
            error.setText("name most contain only char");
            return false;
        }else if(!lastname.getText().matches(lastNameRegex)){
            error.setText("lasname most contain only char");
            return false;
        }
        else if (!password.getText().matches(pattern)) {
            error.setText("password must contain num & char");
            return false;
        } else if (password.getText().length() < 8) {
            error.setText("password must at least be 8 digit");
            return false;
        } else if (!password.getText().equals(confirmPass.getText())) {
            error.setText("pass and confirm pass not equal");
            return false;
        } else {
            return true;
        }
    }

    private boolean checkUserEmail() {
        ArrayList<User>users = User.getAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(emailField.getText())) {
                error.setText("you have registered before");
                return false;
            }

        }
        return true;
    }
private void cleanPage(){
    Username.setText("");
    emailField.setText("");
    password.setText("");
    lastname.setText("");
    confirmPass.setText("");
    name.setText("");
}


}

