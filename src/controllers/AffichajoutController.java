package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AffichajoutController {

    private Stage stage;
     private Scene scene;
     private Parent root;
    @FXML
    void switchtoaffich(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/views/affichage_client.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchtoajout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/views/Ajout.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
