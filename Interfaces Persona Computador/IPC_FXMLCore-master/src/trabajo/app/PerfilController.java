/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package trabajo.app;


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;
import trabajo.utils.Cosas;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class PerfilController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtNickname;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtContraseña;
    @FXML
    private Button btnAtras;
    @FXML
    private Button btnGuardar;
    @FXML
    private ImageView Imagen;
    @FXML
    private Button Button_img;
    @FXML
    private Label perfil;

    /**
     * Initializes the controller class.
     */
    public void initialize() throws AcountDAOException, IOException {
        txtNickname.requestFocus();
        txtNickname.setEditable(false);
        JavaFXMLApplication.getStage().setTitle("GastoGuard -> Perfil");
        txtNombre.setPromptText(Acount.getInstance().getLoggedUser().getName());
        txtNickname.setText(Acount.getInstance().getLoggedUser().getNickName());
        txtCorreo.setPromptText(Acount.getInstance().getLoggedUser().getEmail());
        txtContraseña.setPromptText(Acount.getInstance().getLoggedUser().getPassword());
        //JavaFXMLApplication.getStage().setMinHeight(600);
        //JavaFXMLApplication.getStage().setMinWidth(600);
        Imagen.setImage(Acount.getInstance().getLoggedUser().getImage());
        Platform.runLater(()->perfil.requestFocus());
        
    }    

    @FXML
    private void AtrasOnAction(ActionEvent event) {
        
        try {
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaPrincipal.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("PantallaPrincipal.css").toExternalForm());
            Stage newStage = new Stage();
            stage.setTitle("GastoGuard > Menú principal");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void GuardarOnAction(ActionEvent event) {
        
        actualizarDatosUsuario();
        
    }
    
    private void actualizarDatosUsuario(){
        if(txtContraseña.getText().length()<6){  Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Contraseña Incorrecta");
        alert.setHeaderText(null);
        alert.setContentText("La contraseña debe tener más de 5 caracteres");
        alert.showAndWait();
        
        }
        else {
        try {
            String nuevoNombre = txtNombre.getText();
            String nuevoCorreo = txtCorreo.getText();
            String nuevaContraseña = txtContraseña.getText();
            
            // Validar los nuevos valores (aquí puedes agregar tus propias validaciones)
            
            
            // Obtener el usuario actualmente autenticado
            User usuario = Acount.getInstance().getLoggedUser();
            
            // Actualizar los datos del usuario
            if(nuevoNombre.isEmpty()){}
            else{usuario.setName(nuevoNombre);}
            if(nuevoCorreo.isEmpty()){}
            else{usuario.setEmail(nuevoCorreo);}
            if(nuevaContraseña.isEmpty()){}
            else{usuario.setPassword(nuevaContraseña);}
            usuario.setImage(Imagen.getImage());
            // Mostrar mensaje de éxito
            mostrarAlerta("Éxito", "Los datos del usuario han sido actualizados correctamente");
             FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaPrincipal.fxml"));
            
            Parent root = loader.load();
            
            PantallaPrincipalController controlador = loader.getController();
            
            
            Scene scene = new Scene(root);
             
            scene.getStylesheets().add(getClass().getResource("PantallaPrincipal.css").toExternalForm());
            Stage stage = new Stage();
          //  stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("GastoGuard > Pantalla Principal");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
             Stage stage2 = (Stage) this.btnGuardar.getScene().getWindow();
            stage2.hide();
            stage.setScene(scene);
            stage.show();
        } catch (AcountDAOException ex) {
            Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
        }}
        
    }
    
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    private void showUserInfo(){
        try {
            User usuario = Acount.getInstance().getLoggedUser();
            
            if(usuario != null){
                
                txtNombre.setText(usuario.getName());
                txtNickname.setText(usuario.getNickName());
                txtCorreo.setText(usuario.getEmail());
                txtContraseña.setText(usuario.getPassword());
                
            }
        } catch (AcountDAOException ex) {
            Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PerfilController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void button_cambiarImg(ActionEvent event) throws AcountDAOException, IOException {
        
         FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecciona una imagen");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Imagenes", "*.png", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(JavaFXMLApplication.getStage());
        // Se establece la imagen tanto en el menú como en el miembro
        if (selectedFile != null) {
        Image image = new Image(selectedFile.toURI().toString());
        Imagen.setImage(image);
        //Cosas.circularCutout(Imagen);
       // User currentUser = Acount.getInstance().getLoggedUser();
        //Acount.getInstance().getLoggedUser().setImage(image);
    }}
    
      
}

