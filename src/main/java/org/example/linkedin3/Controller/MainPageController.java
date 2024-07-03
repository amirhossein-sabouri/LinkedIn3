package org.example.linkedin3.Controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.linkedin3.Model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {
    @FXML
    private VBox center;
    @FXML
    private Label UsernameLBL;

    @FXML
    private JFXButton home;

    @FXML
    private JFXButton jobs;

    @FXML
    private JFXButton messaging;

    @FXML
    private JFXButton mynetwork;

    @FXML
    private Label nameLBL;

    @FXML
    private JFXButton notification;

    @FXML
    private ImageView photo;

    @FXML
    private JFXButton postBTN;

    @FXML
    private JFXTextArea postText;

    @FXML
    private JFXButton profile;

    @FXML
    private TextField searchField;
    public static Stage profileStage = null;
    public static String email;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       User user = findUserByEmail(email);
       nameLBL.setText("Welcome "+user.getName());
       UsernameLBL.setText(user.getUsername());
        profile.setOnAction(e->{
            try {
                ProfilePageController.email = user.getEmail();
                openProfile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }
    private void openProfile() throws IOException{
        if(profileStage == null){
            VBox root = FXMLLoader.load(this.getClass().getResource("/org/example/linkedin3/ProfilePage.fxml"));
            profileStage = new Stage();
            profileStage.setTitle("Profile Page");
            profileStage.setScene(new Scene(root));
            profileStage.show();
        }
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
