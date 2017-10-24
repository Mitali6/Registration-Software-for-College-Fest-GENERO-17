/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register.login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import register.front.FrontController;

/**
 * FXML Controller class
 *
 * @author MITALI
 */
public class LoginController implements Initializable {
    
    public static String member;

    @FXML
    private JFXTextField name;
    @FXML
    private JFXPasswordField password;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    

    @FXML
    private void login(ActionEvent event) {
        submit();
    }
    
    void loadWindow(String loc, String title) 
    {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close()
    {
        Stage stage = (Stage)rootPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    /*private void login(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
        {
            submit();
        }
            
    }*/
    
    public void submit()
    {
        if(password.getText().equals("Registration"))
        {
            loadWindow("/register/front/front.fxml", "Registration");
            member = name.getText();
            close();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Incorrect Password");
            alert.showAndWait();
        }
    }

}
