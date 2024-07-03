package org.example.linkedin3.Controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.linkedin3.DataBase.DataBase;
import org.example.linkedin3.Model.User;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditInfoPageController implements Initializable {
    @FXML
    private VBox vbox;
    @FXML
    private TextField AdditionalName;

    @FXML
    private TextField City;

    @FXML
    private TextField Country;

    @FXML
    private JFXTextArea Headlines;

    @FXML
    private ChoiceBox<?> Industry;

    @FXML
    private TextField LastName;

    @FXML
    private ChoiceBox<?> School;

    @FXML
    private JFXButton closeBTN;

    @FXML
    private TextField firstName;
    @FXML
    private JFXButton saveBTN;
    @FXML
    private JFXButton addNewPosition;
    @FXML
    private JFXButton addNewEducation;
    public static String email;
    public static String password;
    public static String username;
    public static int id;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        User user = findUserByEmail(email);
        firstName.setText(user.getName());
        LastName.setText(user.getLastname());

        saveBTN.setOnAction(e->{

        });
    }
    public void saveBTNHandler() throws SQLException {
        User user = new User(id,AdditionalName.getText(),Headlines.getText(),City.getText(),Country.getText(),firstName.getText(),LastName.getText(), email, password, username,
                null, null, null, null);
        DataBase.updateUser(user);
    }
    private User findUserByEmail(String email){
        for(User user : User.getAllUsers()){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
}
