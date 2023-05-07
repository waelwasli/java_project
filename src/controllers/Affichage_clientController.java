package controllers;

import Models.Client;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Affichage_clientController {

    @FXML
    private TableView<Client> table;

    @FXML
    private TableColumn<Client, String> txtdate;

    @FXML
    private TableColumn<Client, String> txtlevel;

    @FXML
    private TableColumn<Client, String> txtusername;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void pageprec(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/views/affichajout.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void logout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/views/adminuser.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
 }

    @FXML
    void refresh(ActionEvent event) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projetjava","root","");
        ObservableList<Client> list = FXCollections.observableArrayList();
        PreparedStatement ps = conn.prepareStatement("select username,level,datenaiss from user ");
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            list.add(new Client(rs.getString("username"),rs.getString("level"),rs.getString("datenaiss")));
        }
        
        
        txtusername.setCellValueFactory(new PropertyValueFactory<Client,String>("username"));
        txtlevel.setCellValueFactory(new PropertyValueFactory<Client,String>("level"));
        txtdate.setCellValueFactory(new PropertyValueFactory<Client,String>("datenaiss"));
        table.setItems(list);

    }

}
