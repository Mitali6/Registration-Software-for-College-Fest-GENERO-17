package register.search;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

public class SearchController implements Initializable {

    Database data;
    
    @FXML
    private JFXTextField admissionNumber;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField branch;
    @FXML
    private JFXTextField emailId;
    @FXML
    private JFXTextField contact;
    @FXML
    private JFXTextField receiptNumber;
    @FXML
    private JFXTextField size;
    @FXML
    private JFXTextField choice;
    @FXML
    private JFXTextField amount;
    @FXML
    private JFXTextField registrationNumber;
    @FXML
    private JFXTextField member;
    @FXML
    private JFXTextField date;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            data = Database.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void registration()
    {
        try
            {
                data.st= data.con.createStatement();
                String am = admissionNumber.getText();
                String cmd= "select * from register where admissionNumber=" + "'" + am + "'";
                data.rs = data.st.executeQuery(cmd);
                while(data.rs.next())
                {
                    name.setText("'" + data.rs.getString("name") + "'   ");
                    emailId.setText("'" + data.rs.getString("emailId") + "'   ");
                    contact.setText("'" + data.rs.getString("contact") + "'   ");
                    receiptNumber.appendText("'" + data.rs.getString("receiptNumber") + "'   ");
                    branch.setText("'" + data.rs.getString("branch") + "'   ");
                    registrationNumber.appendText("'" + data.rs.getString("registrationNumber") + "'   ");
                    amount.appendText("'" + data.rs.getString("amount") + "'   ");
                    choice.appendText("'" + data.rs.getString("choice") + "'   ");
                    size.appendText("'" + data.rs.getString("size") + "'   ");
                    member.appendText("'" + data.rs.getString("member") + "'   ");
                    date.appendText("'" + data.rs.getString("date") + "'   ");
                }
                     
            }
            catch(SQLException ex)
            {    
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("" + ex);
                alert.showAndWait();
                clear();
                return;
            }
        
    }
    
    public void gaming()
    {
        try
            {
                data.st= data.con.createStatement();
                String am = admissionNumber.getText();
                String cmd= "select * from gaming where admissionNumber=" + "'" + am + "'";
                data.rs = data.st.executeQuery(cmd);
                while(data.rs.next())
                {
                    name.setText("'" + data.rs.getString("name") + "'   ");
                    emailId.setText("'" + data.rs.getString("emailId") + "'   ");
                    contact.setText("'" + data.rs.getString("contact") + "'   ");
                    receiptNumber.appendText("'" + data.rs.getString("receiptNumber") + "'   ");
                    branch.setText("'" + data.rs.getString("branch") + "'   ");
                    registrationNumber.appendText("'" + data.rs.getString("registrationNumber") + "'   ");
                    amount.appendText("'" + data.rs.getString("amount") + "'   ");
                    choice.appendText("'" + data.rs.getString("choice") + "'   ");
                    member.appendText("'" + data.rs.getString("member") + "'   ");
                    date.appendText("'" + data.rs.getString("date") + "'   ");
                }
                     
            }
            catch(SQLException ex)
            {    
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("" + ex);
                alert.showAndWait();
                clear();
                return;
            }
        
    }
    
    
    public void clear()
    {
        receiptNumber.clear();
        registrationNumber.clear();
        name.clear();
        emailId.clear();
        contact.clear();
        branch.clear();
        size.clear();
        choice.clear();
        member.clear();
        amount.clear();
        date.clear();
    }

    @FXML
    private void regular(ActionEvent event) {
        clear();
        registration();
    }
    

    @FXML
    private void gaming(ActionEvent event) {
        clear();
        gaming();
    }
    
}
