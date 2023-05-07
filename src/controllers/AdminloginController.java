/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AdminloginController {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnlogin;
    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtusername;

    Connection conn ; 
     PreparedStatement  pst;
     ResultSet res ;
    @FXML
    public void login(ActionEvent event) throws  SQLException, IOException {
        
        String username=txtusername.getText();
        String password=txtpassword.getText();
        if (username.equals("") && password.equals(""))
        {
            JOptionPane.showMessageDialog(null, "username or password blank");
            
        }
        else{
            try {
                
                 conn =   DriverManager.getConnection("jdbc:mysql://localhost/projetjava","root","");
                 String sql = "select * from admin where name=? and password=?";
                 
                 pst = conn.prepareStatement(sql);
                 pst.setString(1,username);
                 pst.setString(2,password);
                 res = pst.executeQuery();
                 
                 if (res.next())
                 {
                      JOptionPane.showMessageDialog(null, "login success");
                      Stage logp = new Stage();
                      btnlogin.getScene().getWindow().hide();
                      Parent rootA;
                      rootA = FXMLLoader.load(getClass().getResource("/views/affichajout.fxml"));
                      Scene scene = new Scene(rootA);
                      logp.setScene(scene);
                      logp.show();
                      logp.setTitle("Acceuil");
                      
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "login failed");
                 }
                 
                
            
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
    }
     private Stage stage;
     private Scene scene;
     private Parent root;
    public void pageprec(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/views/adminuser.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
 }
}
