/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busterbox;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author VIKAS
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Double xOffset,yOffset;
    @FXML
    private JFXButton HomeSceneButton;
    @FXML
    private BorderPane titleBar;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        titleBar.setOnMousePressed((e)->{
            xOffset=BusterBox.getStage().getX()-e.getSceneX();
            yOffset=BusterBox.getStage().getY()-e.getSceneY();
            titleBar.setCursor(Cursor.CLOSED_HAND);
        });    
        titleBar.setOnMouseDragged(e->{
            BusterBox.getStage().setX( e.getSceneX()+xOffset );
            BusterBox.getStage().setY( e.getSceneY()+yOffset );
        });
        
        titleBar.setOnMouseReleased(e->{
            titleBar.setCursor( Cursor.DEFAULT );
        });
    }
    @FXML
    void loginButton(ActionEvent event) throws IOException {
        Stage stage=BusterBox.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene HomePage = new Scene(root);
        stage.setScene(HomePage);
        stage.show();
        
    }
    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void min(ActionEvent event) {
        BusterBox.getStage().setIconified(true);
    }

    @FXML
    void max(ActionEvent event) {
        BusterBox.getStage().setMaximized(true);
        //BusterBox.getStage().setFullScreen()
    }
    
}
