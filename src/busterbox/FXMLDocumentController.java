/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package busterbox;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.*;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author VIKAS
 */
public class FXMLDocumentController implements Initializable {
    int firstTime=0,TotalMoviesMovie=0;
    String[] MoviePaths;
    @FXML
    private  BorderPane titleBar;
    private ScrollPane contentPane;
    @FXML
    private VBox bpcspvb,TopMenuVbox,vboxtopMainContainer;
    private Double xOffset,yOffset;
    TranslateTransition t=new TranslateTransition();
    TranslateTransition contentPaneTranslation=new TranslateTransition();
    JFXButton blbpvbsp,brbpvbsp,specialNextMovieB;
    @FXML
    private ImageView imgmain;
    private TranslateTransition TopMenuVboxTranslate=new TranslateTransition();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        MoviePaths=AvailableMoviesFinder.find("F:\\F\\Entertainment\\Movies");
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
    void logout(ActionEvent event) throws IOException {
        //Stage MainStage
        /*
        Stage stage1=BusterBox.getStage();
        stage1.close();
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene HomePage = new Scene(root);
        stage.setScene(HomePage);
        stage.show();
        */
        System.exit(0);
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
        contentPaneTranslation.play();  
    }
    void menuDisplay(){
        TopMenuVboxTranslate.setToY(0);
        TopMenuVboxTranslate.play();
        
    }
    void menuHide(){
        TopMenuVboxTranslate.setToY(-250);
        TopMenuVboxTranslate.play();
        
    }
    private int specialNextMovieCounter=1;
    @FXML
    void specialNextMovieB(ActionEvent event) {
        System.out.println("nextMovieImage");
        imgmain.setImage(new Image("file:/F:\\F\\Entertainment\\wallpapers\\"+(specialNextMovieCounter++)+".jpg"));
    }
    @FXML
    void AvailableMoviesPlayFunction(ActionEvent event) {
        System.out.println("PlayMovie");
        System.out.println("1");
        Scanner s=new Scanner(System.in);
        System.out.println("2");
        for (int i = 0; i< MoviePaths.length; i++) {
            if(MoviePaths[i]==null){
                TotalMoviesMovie=i;
                break;
            }
            System.out.println(i+": "+MoviePaths[i]);
        }
        System.out.print("Enter the index of the movie: ");
        int movieIndex=s.nextInt();
        System.out.println("The movie is:::::::::::::::::::::::"+MoviePaths[movieIndex]);
        String MoviePath="\""+MoviePaths[movieIndex]+"\"";
        System.out.println(MoviePaths[movieIndex]+"              yes          "+MoviePath);
        LaunchingExternalApps.runMedia(MoviePath);
    }
}