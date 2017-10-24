package register.analysis;

import com.jfoenix.controls.JFXTextField;
import database.Database;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class AnalysisController implements Initializable {

    Database data;
    @FXML
    private JFXTextField date;
    @FXML
    private JFXTextField registration;
    @FXML
    private JFXTextField amount;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            data = Database.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(AnalysisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void reset(ActionEvent event) {
        clear();
    }
    
    public void clear()
    {
        date.clear();
        registration.clear();
        amount.clear();
    }

    @FXML
    private void regular(ActionEvent event) {
        details("register");
    }

    @FXML
    private void gaming(ActionEvent event) {
         details("gaming");
    }
    
    private void details(String name)
    {
         try {
            String date1 = date.getText();
            data.st= data.con.createStatement();
            String cmd= "select count(admissionNumber) from " + name + " where date=" + "'" + date1 +  "'";
            data.rs= data.st.executeQuery(cmd);
            data.rs.next();
            int count = data.rs.getInt(1);
            registration.setText("" + count);
            
            
            String cmd1= "select SUM(amount) from " + name + " where date=" + "'" + date1 +  "'";
            data.rs = data.st.executeQuery(cmd1);
            data.rs.next();
            int count1 = data.rs.getInt(1);
            amount.setText("" + count1);
        } catch (SQLException ex) {
            Logger.getLogger(AnalysisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}