/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import Models.Foyer;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FoyerController implements Initializable {

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
    private Button chercher1id;

     @FXML
    private TableView<Foyer> table_Foyer;

    @FXML
    private TableColumn<Foyer,String> txtadressef;

    @FXML
    private TableColumn<Foyer,String> txtnomf;

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
    void showinfosfoyer(ActionEvent event) throws SQLException {

          String region=txtpays.getValue();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projetjava","root","");
        ObservableList<Foyer> list = FXCollections.observableArrayList();
        PreparedStatement ps = conn.prepareStatement("select nomfoyer,adressfoyer from information where nompays =?");
        ps.setString(1,region);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            list.add(new Foyer(rs.getString("nomfoyer"),rs.getString("adressfoyer")));
        }
        
        
        txtnomf.setCellValueFactory(new PropertyValueFactory<Foyer,String>("Nom"));
        txtadressef.setCellValueFactory(new PropertyValueFactory<Foyer,String>("Adresse"));
        table_Foyer.setItems(list);
    }    
}
   
