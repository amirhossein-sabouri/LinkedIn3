package org.example.linkedin3.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.linkedin3.Model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfilePageController implements Initializable {
    @FXML
    private JFXButton closeBTN;
    @FXML
    private JFXButton editTop;
@FXML
private VBox vbox;
    @FXML
    private Button AddProfileSection;

    @FXML
    private Label Adrress;

    @FXML
    private JFXButton ContactInfo;

    @FXML
    private Label JobPos;

    @FXML
    private Label NameAndLastname;

    @FXML
    private Button openTO;

    @FXML
    private JFXButton setImage;
    public static String email;
    public static Stage editStage = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        NameAndLastname.setText(""+findUserByEmail(email).getName() + " "+findUserByEmail(email).getLastname());
        JobPos.setText("--");
        Adrress.setText("--");
        editTop.setOnAction(e->{
            try {
                openEdit();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        closeBTN.setOnAction(e->{
            closeStage();
        });

    }
    private User findUserByEmail(String email){
        for(User user : User.getAllUsers()){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
    private void openEdit() throws IOException {
        if (editStage == null) {
            VBox root = FXMLLoader.load(this.getClass().getResource("/org/example/linkedin3/EditInfo.fxml"));
            editStage = new Stage();
            editStage.setTitle("Edit Page");
            editStage.setScene(new Scene(root));
            editStage.show();
        }
    }
    private void closeStage() {
//        (((Stage)cancelBut).getScene().getWindow()).close();
        MainPageController.profileStage.close();
        MainPageController.profileStage = null;
    }

}


