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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
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
public class Pantalla_registroController /*implements Initializable*/ {

    @FXML
    private TextField fieldName;
    @FXML
    private Label labelNombre;
    @FXML
    private TextField fieldNickname;
    @FXML
    private Label labelNickname;
    @FXML
    private TextField fieldCorreo;
    @FXML
    private Label labelCorreo;
    @FXML
    private TextField fieldContraseña;
    @FXML
    private Label labelContraseña;
    @FXML
    private VBox vBoxNombre;
    @FXML
    private VBox vBoxNickname;
    @FXML
    private VBox vBoxCorreo;
    @FXML
    private VBox vBoxContraseña;
    @FXML
    private VBox vBoxContraseña1;
    @FXML
    private TextField fieldRepiteContraseña;
    @FXML
    private Label labelContraseña1;
    
    
    BooleanProperty errorName = new SimpleBooleanProperty(true);
    BooleanProperty errorNickname = new SimpleBooleanProperty(true);
    BooleanProperty errorCorreo = new SimpleBooleanProperty(true);
    BooleanProperty errorContraseña = new SimpleBooleanProperty(true);
    BooleanProperty errorRepetirContraseña = new SimpleBooleanProperty(true);
    
    BooleanProperty imageSelected = new SimpleBooleanProperty(false);
    
    Image defaulImage = new Image("trabajo/imagenes/añadirImagen.png");
    boolean firstTry = true; 
    boolean configMode = false; 
    
    
    @FXML
    private Button btnRegistrarse;
    @FXML
    private VBox vboxText2;
    @FXML
    private ImageView imageUserImage;
    @FXML
    private Button btnAñadirImagen;
    @FXML
    private Hyperlink linkEliminarImagen;
    @FXML
    private Button btnAtras;
    
    
   

    /**
     * Initializes the controller class.
     */
    public void initialize(/*URL url, ResourceBundle rb*/) {
        // TODO
        
        linkEliminarImagen.visibleProperty().bind(imageSelected);
        
        errorName.addListener((observable, oldValue, newValue) -> {

            if (newValue) {
                vBoxNombre.setStyle("-fx-background-color: rgb(251, 255, 182) ; -fx-background-radius: 10");
                labelNombre.setOpacity(1);
            } else {
                vBoxNombre.setStyle("-fx-background-color: null");
                labelNombre.setOpacity(0);
            }

        });
        
        errorNickname.addListener((observable, oldValue, newValue) -> {

            if (newValue) {
                vBoxNickname.setStyle("-fx-background-color: rgb(251, 255, 182) ; -fx-background-radius: 10");
                labelNickname.setOpacity(1);
            } else {
                vBoxNickname.setStyle("-fx-background-color: null");
                labelNickname.setOpacity(0);
            }

        });
        
        errorCorreo.addListener((observable, oldValue, newValue) -> {

            if (newValue) {
                vBoxCorreo.setStyle("-fx-background-color: rgb(251, 255, 182) ; -fx-background-radius: 10");
                labelCorreo.setOpacity(1);
            } else {
                vBoxCorreo.setStyle("-fx-background-color: null");
                labelCorreo.setOpacity(0);
            }

        });
        
        errorContraseña.addListener((observable, oldValue, newValue) -> {

            if (newValue) {
                vBoxContraseña.setStyle("-fx-background-color: rgb(251, 255, 182) ; -fx-background-radius: 10");
                labelContraseña.setOpacity(1);
            } else {
                vBoxContraseña.setStyle("-fx-background-color: null");
                labelContraseña.setOpacity(0);
            }

        });
        
        errorRepetirContraseña.addListener((observable, oldValue, newValue) -> {

            if (newValue) {
                vBoxContraseña1.setStyle("-fx-background-color: rgb(251, 255, 182) ; -fx-background-radius: 10");
                labelContraseña1.setOpacity(1);
            } else {
                vBoxContraseña1.setStyle("-fx-background-color: null");
                labelContraseña1.setOpacity(0);
            }

        });
        
        
        
         fieldName.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!firstTry) {
                if (newValue != null && !newValue.isEmpty()) {
                    errorName.setValue(false);
                } else {
                    errorName.setValue(true);
                }
            }
        });
         
         fieldNickname.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!firstTry) {
                if (newValue != null && !newValue.isEmpty()) {
                    errorNickname.setValue(false);
                } else {
                    errorNickname.setValue(true);
                }
            }
        });
         
         fieldCorreo.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!firstTry) {
                if (newValue != null && !newValue.isEmpty()) {
                    errorCorreo.setValue(false);
                } else {
                    errorCorreo.setValue(true);
                }
            }
        });
         
        fieldContraseña.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!firstTry) {
                if (newValue != null && !newValue.isEmpty()) {
                    errorContraseña.setValue(false);
                } else {
                    errorContraseña.setValue(true);
                }
            }
        });
        
         
         
        fieldRepiteContraseña.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!firstTry) {
                if (newValue != null && !newValue.isEmpty()) {
                    errorRepetirContraseña.setValue(false);
                } else {
                    errorRepetirContraseña.setValue(true);
                }
            }
        });
        
        
         errorName.setValue(false);
         errorNickname.setValue(false);
         errorCorreo.setValue(false);
         errorContraseña.setValue(false);
         errorRepetirContraseña.setValue(false);
         
    }
         
    
    /**
     *
     * @param name
     * @param nickname
     * @param correo
     * @param contraseña
     */
    public void activateConfigMode(String name, String nickname, String correo, String contraseña) {
        
        this.configMode = true;
        fieldName.setText("nombre");
        fieldNickname.setText("nickname");
        fieldCorreo.setText("correo");
        fieldContraseña.setText("contraseña");
        


    }
    
    public String getName() {
        firstTry = false;
        String name = fieldName.getText();
        if (name != null && !name.isEmpty()) {
            errorName.setValue(false);
            return name;
        } else {
            errorName.setValue(true);
            return null;
        }
    }
    
    public String getNickname() {
        firstTry = false;
        String nickname = fieldNickname.getText();
        if (nickname != null && !nickname.isEmpty()) {
            errorNickname.setValue(false);
            return nickname;
        } else {
            errorNickname.setValue(true);
            return null;
        }
    }
    
    public String getCorreo(){
        firstTry = false;
        String correo = fieldCorreo.getText();
        if (correo != null && !correo.isEmpty() && correo.contains("@")) {
            errorCorreo.setValue(false);
            return correo;
        } else {
            errorCorreo.setValue(true);
            return null;
        }
    }
    
    public String getPassword(){
        firstTry = false;
        String password = fieldContraseña.getText();
        String repeatPassword = fieldRepiteContraseña.getText();
        if (password != null && !password.isEmpty()) {
            errorContraseña.setValue(false);
            if (repeatPassword != null && !repeatPassword.isEmpty() && password.equals(repeatPassword)) {

            
                    errorRepetirContraseña.setValue(false);
                    return password;
                } else {
                    errorRepetirContraseña.setValue(true);
                    return null;
                }
            } else {
                errorRepetirContraseña.setValue(true);
                return null;
            }
    }

    @FXML
    private void RegistrarseOnAction(ActionEvent event) {
        
        String name = getName();
        
        String nickname = getNickname();
        String correo = getCorreo();
        String password = getPassword();
    
    if (name == null || nickname == null || correo == null || password == null ||nickname.contains(" ")||password.length()<6 ) {
        // Mostrar mensajes de error si algún campo está vacío o incorrecto
        if (name == null) {
            labelNombre.setText("Introduce tu nombre"); 
            errorName.setValue(true);
            this.fieldContraseña.setText("");
            this.fieldCorreo.setText("");
             this.fieldName.setText(""); this.fieldRepiteContraseña.setText(""); this.fieldNickname.setText("");
            // this.imageUserImage.setImage(null);
             
        }
        if (nickname == null || nickname.contains(" ")) {
            if(nickname==null){labelNickname.setText("Introduzca tu nickname");}
            else{labelNickname.setText("Introduzca tu nickname sin espacios");}
            errorNickname.setValue(true);
             this.fieldContraseña.setText("");
            this.fieldCorreo.setText("");
             this.fieldName.setText(""); this.fieldRepiteContraseña.setText(""); this.fieldNickname.setText("");//this.imageUserImage.setImage(null);}
        if (correo == null) {
            labelCorreo.setText("Introduzca tu correo");
            errorCorreo.setValue(true);
             this.fieldContraseña.setText("");
            this.fieldCorreo.setText("");
             this.fieldName.setText(""); this.fieldRepiteContraseña.setText(""); this.fieldNickname.setText("");//this.imageUserImage.setImage(null);}
        if (password == null|| password.length()<6) {
            if(password==null){
            labelContraseña.setText("Introduzca tu contraseña");
            labelContraseña1.setText("Repita la contraseña");}
            else{labelContraseña.setText("La contraseña debe contener mas de 5 caractéres");
            labelContraseña1.setText("Repita la contraseña");this.imageUserImage.setImage(null);}
            errorContraseña.setValue(true);
            errorRepetirContraseña.setValue(true);
             this.fieldContraseña.setText("");
            this.fieldCorreo.setText("");
             this.fieldName.setText(""); this.fieldRepiteContraseña.setText(""); this.fieldNickname.setText("");//this.imageUserImage.setImage(null);
        }
    } }}
    else {
            try {
                // Registro del usuario en la base de datos
                boolean registrationSuccess = Acount.getInstance().registerUser(name, "", correo, nickname, password, this.imageUserImage.getImage(), LocalDate.EPOCH);
                
                
                if (registrationSuccess) {
                    Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    successAlert.setTitle("Registro exitoso");
                    successAlert.setHeaderText("¡Usuario registrado exitosamente!");
                    successAlert.setContentText("¡Para acceder a la cuenta de gastos debes iniciar sesión!");
                    
                    Optional<ButtonType> result = successAlert.showAndWait();
                    
                    if(result.isPresent() && result.get() == ButtonType.OK){
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage newStage = new Stage();
                    newStage.setTitle("GastoGuard > Inicio de Sesión");
                    newStage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
                    newStage.setScene(scene);
                    newStage.show();
                    }
                    
                } else {
                    
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Error de registro");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("Error al registrar el usuario. Por favor, inténtelo de nuevo más tarde.");

                    // Mostrar el mensaje de error
                    errorAlert.showAndWait();
                    
                }   } catch (AcountDAOException ex) {
                        if(ex.getMessage().contains("UNIQUE constraint failed: user.nickName")){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error de registro");
                        alert.setHeaderText("El apodo ya está en uso");
                        alert.setContentText("Por favor, elija otro apodo.");
                        alert.showAndWait();
                        }else{
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error de registro");
                            alert.setHeaderText("Error al registrar el usuario");
                            alert.setContentText("Por favor, inténtelo de nuevo más tarde.");
                            alert.showAndWait();
                        }
            } catch (IOException ex) {
                Logger.getLogger(Pantalla_registroController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
         
        
        }

    @FXML
    private void btnAñadirImagenOnAction(ActionEvent event) {
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecciona una imagen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagenes", "*.png", "*.jpg"));
        File file = fileChooser.showOpenDialog(JavaFXMLApplication.getStage());
        //cojemos la imagen la recortamos de manera circular

        Image image = new Image(file.toURI().toString());

        imageSelected.setValue(true);


        imageUserImage.setImage(image);
        //imageUserImage.setFitWidth(135);


        //Cosas.circularCutout(imageUserImage);
        
    }

    @FXML
    private void linkEliminarImagenOnAction(ActionEvent event) {
        
        imageUserImage.setImage(defaulImage);
        imageUserImage.setClip(null);
        imageSelected.setValue(false);
        
    }

    @FXML
    private void atrasOnAction(ActionEvent event) {
        
        
        try {
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("GastoGuard > Inicio de sesión");
            newStage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
            newStage.setScene(scene);
            newStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(Pantalla_registroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
       
}
