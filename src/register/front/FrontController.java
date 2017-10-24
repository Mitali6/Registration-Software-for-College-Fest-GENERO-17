
package register.front;

import com.jfoenix.controls.JFXButton;
import database.Database;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FrontController implements Initializable {

    @FXML
    private AnchorPane root;
    Database data;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
               data = Database.getInstance();
            } catch (SQLException ex) {
                Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        Stage stage = (Stage)root.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void register(ActionEvent event) {
        loadWindow("/register/main/main.fxml", "Register");
    }

    @FXML
    private void analysis(ActionEvent event) {
        loadWindow("/register/analysis/analysis.fxml", "Analysis");
    }

    @FXML
    private void search(ActionEvent event) {
        loadWindow("/register/search/search.fxml", "Search");
    }

    @FXML
    private void total(ActionEvent event) {
        try {
            data.st= data.con.createStatement();
            String cmd= "select COUNT(admissionNumber) from register";
            data.rs = data.st.executeQuery(cmd);
            data.rs.next();
            int a = data.rs.getInt(1);
            
            String cmd2= "select COUNT(admissionNumber) from gaming";
            data.rs = data.st.executeQuery(cmd2);
            data.rs.next();
            int b = data.rs.getInt(1);
            
            String cmd1= "select SUM(amount) from register";
            data.rs = data.st.executeQuery(cmd1);
            data.rs.next();
            int c = data.rs.getInt(1);
            
            String cmd3= "select SUM(amount) from gaming";
            data.rs = data.st.executeQuery(cmd3);
            data.rs.next();
            int d = data.rs.getInt(1);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Congratulaions!! You have " + (a+b) + " registrations. Total amount is Rs. " + (c+d) + 
                                 "\nRegular Registrations are " + a + " summing upto Rs. "+ c + 
                                 "\nE-Gaming registrations are "+ b + " summing upto Rs. "+ d);
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logout(ActionEvent event) {
        close();
    }

    @FXML
    private void gaming(ActionEvent event) {
        loadWindow("/register/eGaming/eGaming.fxml","E-Gaming");
    }
}
