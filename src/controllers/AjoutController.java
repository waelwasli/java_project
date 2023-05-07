package controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AjoutController implements Initializable {

    /**
     * Initializes the controller class.
     */ 
    private Stage stage;
     private Scene scene;
     private Parent root;
    public void pageprec(ActionEvent event) throws IOException {
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
    private ComboBox<String> nompays ;
    @FXML
    private TextField nomecole;
    @FXML
    private TextField adressecole;
    @FXML
    private TextField nombibliotheque;
    @FXML
    private TextField adressbibliotheque;
    @FXML
    private TextField nomfoyer;
    @FXML
    private TextField adressfoyer;
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
                nompays.setItems(cities);
 }  
     
     @FXML
    public void Ajout(ActionEvent event) throws SQLException, IOException   {
        
        
        String npays =(String) nompays.getValue();
        String necole =(String) nomecole.getText();
        String adecole =(String) adressecole.getText();
        String nbib =(String) nombibliotheque.getText();
        String adbib =(String) adressbibliotheque.getText();
        String nfoyer = (String) nomfoyer.getText();
        String adfoyer = (String) adressfoyer.getText();
        try {
       
        Connection conn =   DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava","root","");
        String sql = "INSERT INTO information (nompays,nomecole,adressecole,nombib,adressbib,nomfoyer,adressfoyer) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,npays);
        statement.setString(2,necole);
        statement.setString(3,adecole);
        statement.setString(4,nbib);
        statement.setString(5,adbib);
        statement.setString(6,nfoyer);
        statement.setString(7,adfoyer);
        statement.execute();
        JOptionPane.showMessageDialog(null, "Information Successfully added");
        nomecole.setText("");
        adressecole.setText("");
        nombibliotheque.setText("");
        adressbibliotheque.setText("");
        nomfoyer.setText("");
        adressfoyer.setText("");
            }catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
}
    } 
    
}
