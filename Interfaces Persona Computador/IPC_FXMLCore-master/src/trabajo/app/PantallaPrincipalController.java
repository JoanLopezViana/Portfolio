/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package trabajo.app;

import com.sun.javafx.scene.control.skin.Utils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.ButtonType;
import trabajo.utils.Cosas;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.*;
import static trabajo.app.JavaFXMLApplication.stage;
import trabajo.utils.Cosas;


/**
 * FXML Controller class
 *
 * @author Victor
 */
public class PantallaPrincipalController  {
    

    private Button image;
    private ImageView changePhoto;
    @FXML
    private Label labelNickName;
    //private ImageView MyPhoto;
    @FXML
    private Button btnPerfil;
    @FXML
    private Button btnVerCuenta;
    @FXML
    private Button btnAtras;
    @FXML
    private Button btnGenerarInforme;
    @FXML
    private ImageView Image;
    @FXML
    private Button btnGestionarCategorias;

    /**
     * Initializes the controller class.
     */
    public void initialize(){
        
                
        
        try {
            Acount account = Acount.getInstance();
        User currentUser = account.getLoggedUser();

        if (currentUser != null) {
            Image foto = currentUser.getImage();
            if (foto != null) {
                this.Image.setImage(foto);
            }}
            
            showNickName();
         
          
        } catch (AcountDAOException ex) {
            Logger.getLogger(PantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       Platform.runLater(() -> {
            Stage stage = (Stage) labelNickName.getScene().getWindow();
            stage.setOnCloseRequest(this::handleWindowCloseRequest);
        });
            
        
        
    }    

    private void imagenOnAction(ActionEvent event) throws AcountDAOException, IOException {
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecciona una imagen");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Imagenes", "*.png", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(JavaFXMLApplication.getStage());
        // Se establece la imagen tanto en el menú como en el miembro
        if (selectedFile != null) {
        Image image = new Image(selectedFile.toURI().toString());
        Image.setImage(image);
        //Cosas.circularCutout(Image);
        User currentUser = Acount.getInstance().getLoggedUser();
       
        currentUser.setImage(image);
        }
        
        // no puedo hacerlo porque la clase user es protected.
        
    }

    @FXML
    private void PerfilOnAction(ActionEvent event)  throws IOException{
        
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Perfil.fxml"));
        Parent root = loader.load();

        PerfilController controlador = loader.getController();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Perfil.css").toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("GastoGuard > Perfil");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
        
        Stage stage2 = (Stage)btnPerfil.getScene().getWindow();
        stage2.hide();
        
        //stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setOnCloseRequest(e ->primaryStage.show());
        stage.show();
        primaryStage.close();
        
    }
    
    public void showNickName() throws AcountDAOException, IOException{
        
        Acount acount = Acount.getInstance();
        
        if(acount != null && acount.getLoggedUser() != null){
            String nickname = acount.getLoggedUser().getNickName();
            labelNickName.setText("Nickname: " + nickname);
        }else{
            labelNickName.setText("Nickname: No disponible");
        }
        
    }
    
    public void showImage() throws AcountDAOException, IOException{
     Acount account = Acount.getInstance();
        User currentUser = account.getLoggedUser();

        if (currentUser != null) {
            Image foto = currentUser.getImage();
            if (foto != null) {
                Image.setImage(foto);
            }}
    }
        
    

    @FXML
    private void VerCuentaOnAction(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Pantalla3_principal.fxml"));
            Parent root = loader.load();
            
            Pantalla3_principalController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("Pantalla3_principal.css").toExternalForm());
            Stage stage = new Stage();
            stage.setTitle("GastoGuard > Cuenta");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
           Stage stage2 = (Stage) btnVerCuenta.getScene().getWindow();
           stage2.close();
            //stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();
           
            
        } catch (IOException ex) {
            Logger.getLogger(PantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void atrasOnAction(ActionEvent event) throws IOException {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("¿Está seguro de que quiere salir?");
        alert.setContentText("Esta acción cerrará tu sesión y le devolverá a la pantalla de inicio de sesión.");

        // Obtener la respuesta del usuario
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                // Si el usuario confirma, abrir la pantalla principal (Main.fxml)
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage newStage = new Stage();
                newStage.setTitle("GastoGuard > Inicio de sesión");
                newStage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
                newStage.setScene(scene);
                newStage.show();

                // Cerrar la ventana actual
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.close();
            } catch (IOException ex) {
                Logger.getLogger(PantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @FXML
    private void GenerarInformeOnAction(ActionEvent event) {
         
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("visualizarGastos.fxml"));
            Parent root = loader.load();
            
            visualizarGastosController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("visualizarGastos.css").toExternalForm());
            Stage stage = new Stage();
            stage.setTitle("GastoGuard > Estadísticas de los gastos");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
            
            Stage stage2 = (Stage) btnGenerarInforme.getScene().getWindow();
            stage2.hide();
            stage.setScene(scene);
            stage.show();
            
            Stage currentStage = (Stage)btnGenerarInforme.getScene().getWindow();
            currentStage.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(PantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void imagenOnAction(MouseEvent event) throws AcountDAOException, IOException {
          FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecciona una imagen");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Imagenes", "*.png", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(JavaFXMLApplication.getStage());
        // Se establece la imagen tanto en el menú como en el miembro
        if (selectedFile != null) {
        Image image = new Image(selectedFile.toURI().toString());
        Image.setImage(image);
        Cosas.circularCutout(Image);
        User currentUser = Acount.getInstance().getLoggedUser();
        Acount.getInstance().getLoggedUser().setImage(image);
       // currentUser.setImage(image);
        }
        
    }

    @FXML
    private void GestionarCategoriasOnAction(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GestionarCategorias.fxml"));
            Parent root = loader.load();
            
            //GestionarCategoriasController controlador = loader.getController();

            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("GestionarCategorias.css").toExternalForm());
            Stage stage = new Stage();
            stage.setTitle("GastoGuard > Gestionar categorías");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
            
            Stage stage2 = (Stage) btnGenerarInforme.getScene().getWindow();
            stage2.hide();
            stage.setScene(scene);
            stage.show();
            
            Stage currentStage = (Stage)btnGestionarCategorias.getScene().getWindow();
            currentStage.close();
        } catch (IOException ex) {
            Logger.getLogger(PantallaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    
    private void handleWindowCloseRequest(WindowEvent event) {
        // Mostrar un cuadro de diálogo de confirmación
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir de la aplicación");
        alert.setHeaderText("¿ Seguro que quieres salir de la aplicación ?");
        alert.setContentText("Esta acción cerrará tu sesión");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Platform.exit();
        } else {
            event.consume();
        }
    }
    
}
