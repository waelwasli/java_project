/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import Models.Ecole;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EcoleController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Stage stage;
     private Scene scene;
     private Parent root;
    public void pageprec(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/views/affichage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
 }
    public void deconnect(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/views/adminuser.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
 }
    
    
    
    
    @FXML
    private Button chercherid;
    @FXML
    private TableColumn<Ecole,String> txtadresse;

    @FXML
    private TableColumn<Ecole,String> txtnom;
    @FXML
    private ComboBox<String> txtpays;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                ObservableList<String> cities = FXCollections.observableArrayList();
     

                String[] locales1 = Locale.getISOCountries();
                for (String countrylist : locales1) {
                    Locale obj = new Locale("", countrylist);
                    String[] city = { obj.getDisplayCountry() };
                    for (int x = 0; x < city.length; x++) {
                        cities.add(obj.getDisplayCountry());
                    }
                }
                txtpays.setItems(cities);
 }  
    
    @FXML
    private TableView<Ecole> table_ecole;
    @FXML
    void showinfos(ActionEvent event) throws SQLException {
        String region=txtpays.getValue();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projetjava","root","");
        ObservableList<Ecole> list = FXCollections.observableArrayList();
        PreparedStatement ps = conn.prepareStatement("select nomecole,adressecole from information where nompays =?");
        ps.setString(1,region);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            list.add(new Ecole(rs.getString("nomecole"),rs.getString("adressecole")));
        }
        
        
        txtnom.setCellValueFactory(new PropertyValueFactory<Ecole,String>("Nom"));
        txtadresse.setCellValueFactory(new PropertyValueFactory<Ecole,String>("Adress"));
        table_ecole.setItems(list);
    }
    
    
    
    
    
    
   
       
    
}
