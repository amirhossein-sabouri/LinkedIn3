package org.example.linkedin3;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.sql.SQLException;



public class LinkedIn extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("LoinPage.fxml"));
        loader.load();
        stage.setScene(new Scene(loader.getRoot()));
        stage.show();


    }
public static void main(String[] args) throws SQLException, ClassNotFoundException {
        launch(args);
}
}
