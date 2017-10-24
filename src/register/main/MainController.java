package register.main;

import register.login.LoginController;
import com.jfoenix.controls.JFXRadioButton;
import database.*;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.lang.reflect.*;
import java.time.LocalDate;

public class MainController implements Initializable{

    Database data;
    public static int recNum  = 15000;
    public String member1 = LoginController.member;
    
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField branch;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField contact;
    @FXML
    private JFXTextField receipt;
    @FXML
    private JFXTextField adm_num;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXTextField regNum;
    @FXML
    private JFXTextField choice;
    @FXML
    private JFXTextField size;
    @FXML
    private ToggleGroup radio;
    @FXML
    private ToggleGroup siz;
    @FXML
    private JFXTextField register;
    @FXML
    private JFXTextField amount;
    @FXML
    private JFXTextField date;
    @FXML
    private JFXTextField member;
    @FXML
    private JFXTextField registration;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            data = Database.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    
    
    @FXML
    private void info(MouseEvent event){
        read();
    }
    
    @FXML
    private void cancel(ActionEvent event) {
        close();
    }

    @FXML
    private void submit(ActionEvent event) {
        sub();
    }

    @FXML
    private void reset(ActionEvent event) {
        clear();
    }
    
    public void close()
    {
        Stage stage = (Stage)rootPane.getScene().getWindow();
        stage.close();
    }
    
    public void clear()
    {
    
        receipt.clear();
        regNum.clear();
        register.clear();
        name.clear();
        email.clear();
        contact.clear();
        receipt.clear();
        branch.clear();
        adm_num.clear();
        size.clear();
        choice.clear();
        member.clear();
        amount.clear();
        date.clear();
        registration.clear();
                
        JFXRadioButton chk1 = (JFXRadioButton)siz.getSelectedToggle(); // Cast object to radio button
        chk1.setSelected(false);
        
        JFXRadioButton chk2 = (JFXRadioButton)radio.getSelectedToggle(); // Cast object to radio button
        chk2.setSelected(false);
    }
    
    public void sub()
    {
        try {
            
            data.st= data.con.createStatement();
            member.setText(member1);
            String Admi = adm_num.getText();
            String Nam = name.getText();
            String Bran = branch.getText();
            String Ema = email.getText();
            String Con = contact.getText();
            String Reg = register.getText();
            String Rec = receipt.getText();
            String Cho = choice.getText();
            String Siz = size.getText();
            String Amo = amount.getText();
            
            
            if(Amo.isEmpty()||member1.isEmpty()||Admi.isEmpty()||Nam.isEmpty()||Bran.isEmpty()||Ema.isEmpty()||Con.isEmpty()||Reg.isEmpty()||Rec.isEmpty()||Cho.isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Fill all the fields");
                alert.showAndWait();
                return;
            }
            
            int amoun = Integer.parseInt(Amo);
            String date = LocalDate.now().toString();
            System.out.println(date);
            
            String cmd = "INSERT into REGISTER(admissionNumber, name, registrationNumber, receiptNumber, amount, branch, emailId, contact,  choice, size, member, date) values("
                    + "'" + Admi + "',"
                    + "'" + Nam + "',"
                    + "'" + Reg + "',"
                    + "'" + Rec + "',"
                    + amoun + "," 
                    + "'" + Bran + "',"
                    + "'" + Ema + "',"
                    + "'" + Con + "',"
                    + "'" + Cho + "',"
                    + "'" + Siz + "'," 
                    + "'" + member1 + "'," 
                    + "'" + date + "')";
            
            data.st.executeUpdate(cmd);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Registration Successful!!");
            alert.showAndWait();
            
            clear();
            
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("" + ex);
            alert.showAndWait();
            return;
        }
    }
    
     
    public void read() 
    {
        member.setText(member1);

        try{
            JFXRadioButton chk = (JFXRadioButton)radio.getSelectedToggle(); // Cast object to radio button
            choice.setText("" + chk.getText());
            
            switch ("" + chk.getText()) {
                case "Single Event (120)":
                    amount.setText("120");
                    break;
                case "Only T Shirt (250)":
                    amount.setText("250");
                    break;
                case "T-Shirt + 2 Events (380)":
                    amount.setText("380");
                    break;
                case "T-Shirt + Concert (450)":
                    amount.setText("450");
                    break;
                case "Only Concert (300)":
                    amount.setText("300");
                    break;
                case "All Events (300)":
                    amount.setText("300");
                    break;
                case "T-Shirt + All Events + Concert (650)":
                    amount.setText("650");
                    break;
                case "Group Dance (600)":
                    amount.setText("600");
                    break;
                case "Nukkad (500)":
                    amount.setText("500");
                    break;
                case "T-Shirt + All Events (450)":
                    amount.setText("450");
                    break;
                case "Blind Meet (80)":
                    amount.setText("80");
                    break;
                default:
                    break;
            }
            
            
            JFXRadioButton chk1 = (JFXRadioButton)siz.getSelectedToggle(); // Cast object to radio button
            size.setText("" + chk1.getText());
            }//catch(InvocationTargetException e)
            
        catch(NullPointerException ex){}
        try
        {
            data.st= data.con.createStatement();
            String am = adm_num.getText();
            String cmd= "select * from data where admission =" + "'" + am + "'";
            data.rs = data.st.executeQuery(cmd);
            data.rs.next();
            
            name.setText(data.rs.getString("name"));
            email.setText(data.rs.getString("email"));
            contact.setText(data.rs.getString("contact"));
            branch.setText(data.rs.getString("branch"));
            register.setText(registration.getText());
            
            receipt.setText(regNum.getText());
            
            
            date.setText(LocalDate.now().toString());
            JFXRadioButton chk = (JFXRadioButton)radio.getSelectedToggle(); // Cast object to radio button
            choice.setText("" + chk.getText());
            JFXRadioButton chk1 = (JFXRadioButton)siz.getSelectedToggle(); // Cast object to radio button
            size.setText("" + chk1.getText());
            
        }
        catch(SQLException ex)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("" + ex);
            date.setText(LocalDate.now().toString());
            alert.showAndWait();
            return;
        }
}
}