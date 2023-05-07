package controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import controllers.LoginController;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SignupController implements Initializable {
    @FXML
    private ComboBox<String> comboBox ;  
    @FXML
    private TextField signupusername;
    @FXML
    private PasswordField signuppwd;
    @FXML
    private PasswordField signupcpwd;
    @FXML
    private Button btnsignup;
    @FXML
    private DatePicker datenaiss;


    @FXML
    public void signup(ActionEvent event) throws SQLException, IOException   {
        
        
        String sigupusername =(String) signupusername.getText();
        String pwdsigup =(String) signuppwd.getText();
        String csiguppwd =(String) signupcpwd.getText();
        String level =(String) comboBox.getValue();
        String datenais = datenaiss.getValue().toString();
        try {
       
        Connection conn =   DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava","root","");
        String sql = "INSERT INTO user (username,password,cpassword,level,datenaiss) VALUES(?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,sigupusername);
        statement.setString(2,pwdsigup);
        statement.setString(3,csiguppwd);
        statement.setString(4,level);
        statement.setString(5,datenais);
        statement.execute();
        JOptionPane.showMessageDialog(null, "Account Successfully added");
        btnsignup.getScene().getWindow().hide();
        Stage logp = new Stage();
        Parent roota = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
        Scene scn = new Scene(roota);
        logp.setScene(scn);
        logp.show();
            }catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
}
    } 

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox.setItems(FXCollections.observableArrayList("Baccalauréat","Licence","Master","Doctorat"));
    }   
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchToLogin(ActionEvent event) throws IOException {
        
        root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
 }
    
}
