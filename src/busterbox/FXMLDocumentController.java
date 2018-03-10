/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busterbox;
import java.awt.Dimension;
import java.awt.Toolkit;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author VIKAS
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private  BorderPane titleBar,spbp;
    private ScrollPane contentPane;
    @FXML
    private VBox bpcspvb,TopMenuVbox,vboxtopMainContainer;
    private Double xOffset,yOffset;
    TranslateTransition t=new TranslateTransition();
    TranslateTransition contentPaneTranslation=new TranslateTransition();
    JFXButton blbpvbsp,brbpvbsp;
    @FXML
    private ImageView imgmain;
    private TranslateTransition TopMenuVboxTranslate=new TranslateTransition();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        /**/
        contentPaneTranslation.setDuration(Duration.millis(150));
        contentPaneTranslation.setNode(contentPane);
        TopMenuVboxTranslate.setDuration(Duration.millis(150));
        TopMenuVboxTranslate.setNode(TopMenuVbox);
        /*TopMenuVbox.setOnMouseEntered((event) -> {
            menuDisplay();
        });
        TopMenuVbox.setOnMouseExited((event) -> {
            menuHide();
        });
        /**/
        
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
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        System.err.println( width+"x"+height );
        bpcspvb .setPrefSize( width-width*0.01 , height*4   );
        //blbpvbsp.setPrefSize( width*0.1        , height-100 );
        //brbpvbsp.setPrefSize( width-width*0.9        , height-100 );
        //System.err.println(width-ourSpecialMovie.getFitWidth()+2*blbpvbsp.getWidth());
        //imgmain.setLayoutX(width-imgmain.getFitWidth()+2*blbpvbsp.getWidth());
        vboxtopMainContainer.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
              contentPaneDown();
              menuDisplay();
           
          }
        });
        TopMenuVbox.addEventHandler(MouseEvent.MOUSE_EXITED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
              contentPaneUp();
              menuHide();
           
          }
        });
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

    @FXML
    void logout(ActionEvent event) {
        
    }
     @FXML
    void previousMovieOnOurSpecialMovies(ActionEvent event) {
        
    }
    void contentPaneDown(){
        contentPaneTranslation.setToY(0);
        
        contentPaneTranslation.play();
    }
    void contentPaneUp(){
        contentPaneTranslation.setToY(-110);
        System.err.println("whatecet");
        contentPaneTranslation.play();  
        //System.err.println(contentPane.getHvalue());
    }
    void menuDisplay(){
        TopMenuVboxTranslate.setToY(0);
        TopMenuVboxTranslate.play();
        
    }
    void menuHide(){
        TopMenuVboxTranslate.setToY(-250);
        TopMenuVboxTranslate.play();
        
    }
    /*@FXML
    void TopMenuVboxTranslateEnter(ActionEvent event) {
        menuDisplay();
    }
    @FXML
    void TopMenuVboxTranslateExit(ActionEvent event) {
        menuHide();
    }*/
    
}


















