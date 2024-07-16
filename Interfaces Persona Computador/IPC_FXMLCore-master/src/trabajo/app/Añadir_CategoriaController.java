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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Category;
import model.Acount;
import model.AcountDAOException;
import static trabajo.app.JavaFXMLApplication.stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class Añadir_CategoriaController implements Initializable {

    @FXML
    private AnchorPane Nombre;
    @FXML
    private Button butt_guard;
    @FXML
    private TextField Nom_text;
    @FXML
    private TextField Desc_text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stage.setTitle("GastoGuard > Añadir categoría");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
    }    

    @FXML
    private void guardar(ActionEvent event) throws AcountDAOException, IOException {
        boolean b= true;
        for(Category c : Acount.getInstance().getUserCategories()){
        if(c.getName().equals(Nom_text.getText())){
        b=false;
        }
        }
        if(b){
        boolean cat= Acount.getInstance().registerCategory(Nom_text.getText(), Desc_text.getText());
        if(cat==true){Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("ok");}
       Stage stage = (Stage)this.butt_guard.getScene().getWindow();
            stage.close();}
        else{
              Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La Categoria ya existe");
            Nom_text.clear();
            alert.showAndWait();
            
        //alert
        }
    }
    
}
