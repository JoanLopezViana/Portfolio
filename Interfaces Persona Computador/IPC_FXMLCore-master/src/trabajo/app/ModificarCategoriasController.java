/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package trabajo.app;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Acount;
import model.AcountDAOException;
import model.Category;
import static trabajo.app.JavaFXMLApplication.stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class ModificarCategoriasController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDescripción;
    @FXML
    private Button btnGuardar;
    Category g;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        stage.setTitle("GastoGuard > Modificar categorías");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
        
    }    

    void initData(Category selectedGasto) {
        g= selectedGasto;
        // Configurar los campos de la vista con la información del gasto seleccionado
        this.txtNombre.setText(g.getName());
        
        this.txtDescripción.setText(g.getDescription());
          }

    @FXML
    private void guardar(ActionEvent event) throws AcountDAOException, IOException {
        if(this.txtDescripción.getText().isEmpty()==false && this.txtNombre.getText().isEmpty()==false){
            List<Category> cat= Acount.getInstance().getUserCategories();
            Category res=null;
            for(Category c: cat){
            if(c.getName().equals(g.getName())){res=c;}
            if(res!=null){
            res.setDescription(txtDescripción.getText());
            res.setName(txtNombre.getText());
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Se ha modificado correctamente");
            alert.showAndWait();
            
            Stage stage = (Stage)this.btnGuardar.getScene().getWindow();
            stage.close();
            }
            }
        }
    }
    
}
