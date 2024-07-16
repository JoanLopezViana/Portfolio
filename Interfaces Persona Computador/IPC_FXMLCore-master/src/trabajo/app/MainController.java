/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package trabajo.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;
import static trabajo.app.JavaFXMLApplication.stage;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class MainController  {

    @FXML
    private TextField txtUsuario;
    @FXML
    private Button btnIniciar;
    
    @FXML
    private PasswordField txtcontraseña;
    @FXML
    private Label Error;
    @FXML
    private Button btnRegistrarse;
    
     private Stage dialogStage;
    @FXML
    private Button focusButton;
    @FXML
    private Text titulo;
    @FXML
    private Label nick;
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // TODO
            
        
        
        
        txtcontraseña.setOnKeyPressed(e -> {
            if(!txtcontraseña.getText().equals("") && e.getCode() == KeyCode.ENTER) {
               //fieldPassword.requestFocus();
                txtcontraseña.requestFocus();
            }
        });
        //Al pulsar enter en el campo de contraseña se ejecuta el metodo btnEnterOnAction
        txtcontraseña.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                btnIniciarOnAction(new ActionEvent());
            }
        });
        Platform.runLater(()->nick.requestFocus());
    }    



    @FXML
    private void btnIniciarOnAction(ActionEvent event) {
         if(txtUsuario.getText().isEmpty()==false && txtcontraseña.getText().isEmpty()==false){
        try {
           
            String nickname = txtUsuario.getText().trim();
            String password = txtcontraseña.getText();
            
            //Verificar las credenciales del usuario
            boolean loginSuccessful = Acount.getInstance().logInUserByCredentials(nickname, password);
            
            if(loginSuccessful){
                
                //Si se encuentra el usuario pasa a la pantalla principal
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaPrincipal.fxml"));
                Parent root = loader.load();
                
                PantallaPrincipalController controlador = loader.getController();
                
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("PantallaPrincipal.css").toExternalForm());
                Stage stage = new Stage();
                stage.setTitle("GastoGuard > Menú principal");
                stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
                Stage stage2 = (Stage)  btnIniciar.getScene().getWindow();
                stage2.close();
                //stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.show();
               
              
            }else{
                apareceError();
            }
            
            
        } catch (AcountDAOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }}
         else{apareceError();}
        
        
        
    }
    
    public void apareceError(){
        Error.setVisible(true);
        FadeTransition ft = new FadeTransition(Duration.millis(600), Error);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }
    
    public void remarcarError(){
        FadeTransition ft = new FadeTransition(Duration.millis(200), Error);
        ft.setFromValue(1.0);
        ft.setToValue(0.7);
        ft.play();
        FadeTransition fd = new FadeTransition(Duration.millis(400), Error);
        fd.setFromValue(0.7);
        fd.setToValue(1.0);
        fd.play();
    }

    @FXML
    private void btnRegistrarseOnAction(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pantalla_registro.fxml"));
            Parent root = loader.load();
            
            Pantalla_registroController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("pantalla_registro.css").toExternalForm());
            Stage stage = new Stage();
            stage.setTitle("GastoGuard > Registrarse");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
            Stage stage2 = (Stage) btnRegistrarse.getScene().getWindow();
            stage2.hide();
            stage.setScene(scene);
            stage.show();
            
            Stage currentStage = (Stage) btnRegistrarse.getScene().getWindow();
            currentStage.close();
            
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    
    
    
}
