/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jejemusicstore;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JEJE
 */
public class adminpembeliController implements Initializable {

    @FXML
    private Button id_admin;
    @FXML
    private Button id_pembeli;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void klik_admin(ActionEvent event) {
    login admin = new login();
    admin.setVisible(true);
    ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void klik_pembeli(ActionEvent event) {
    try{
                //Hide this current window (if this is what you want)
                ((Node)(event.getSource())).getScene().getWindow().hide();
                //Load the new fxml
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("pembeli.fxml"));
                Scene scene = new Scene (fxmlLoader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
    }
    catch (IOException e){
                System.out.println("Failed to create Window." + e);
    }
    }
    
    
}
