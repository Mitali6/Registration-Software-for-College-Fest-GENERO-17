package register.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
    
    @Override
    public void start(Stage stage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(false);
            stage.show();
            
        } catch (IOException ex) {
            System.out.println(ex.getCause());
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
}