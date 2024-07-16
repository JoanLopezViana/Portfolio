/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package trabajo.app;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Acount;
import model.AcountDAOException;
import model.Category;
import model.Charge;
import static trabajo.app.JavaFXMLApplication.stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class GestionarCategoriaController implements Initializable {

    @FXML
    private TableView<Category> tabla;
    @FXML
    private TableColumn<Category, String> columna_cat;
    @FXML
    private TableColumn<Category, String> columna_desc;
    @FXML
    private Button eliminar;
    @FXML
    private Button añadir;
    @FXML
    private Button editar;
 private ObservableList<Category> anadir; 
    @FXML
    private Button btnAtras;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
       anadir = FXCollections.observableArrayList();
        try {
            List<Category> l= Acount.getInstance().getUserCategories();
            anadir.addAll(l);
        } catch (AcountDAOException ex) {
            Logger.getLogger(GestionarCategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionarCategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        this.tabla.setItems(anadir); 
        this.columna_cat.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.columna_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        // Deshabilitar los botones de borrar y modificar al inicio
        this.eliminar.setDisable(true);
        this.editar.setDisable(true);

        // Añadir listener para habilitar/deshabilitar botones según la selección
        tabla.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            boolean seleccionVacia = newSelection == null;
            eliminar.setDisable(seleccionVacia);
            editar.setDisable(seleccionVacia);
        });
// TODO
    }    

    @FXML
    private void eliminar_click(MouseEvent event) {
        Category a = tabla.getSelectionModel().getSelectedItem();
        if (a != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("¿Está seguro de que desea borrar?");
            alert.setContentText("Esta acción no se puede deshacer.");
            alert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    try {
                        boolean b = Acount.getInstance().removeCategory(a);
                        if (b) {
                            anadir.remove(a);
                            tabla.refresh();
                        }
                    } catch (AcountDAOException | IOException ex) {
                        Logger.getLogger(Pantalla3_principalController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
    }

    @FXML
    private void añadir_click(MouseEvent event) throws AcountDAOException {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Añadir_Categoria.fxml"));
            
            Parent root = loader.load();
            
            Añadir_CategoriaController controlador = loader.getController();
            
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("Añadir_Categoria.css").toExternalForm());
            Stage stage = new Stage();
            stage.setTitle("GastoGuard > Añadir categoría");
            
            stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            anadir.clear();
                List<Category> client = Acount.getInstance().getUserCategories();
                anadir.addAll(client);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Pantalla3_añadirController.class.getName()).log(Level.SEVERE, null, ex);
        }
     ObservableList<String> categorias; 
        List <Category> categ;
        try {
            categ = Acount.getInstance().getUserCategories();
             categorias = FXCollections.observableArrayList();
            for(Category c : categ){
                categorias.add(c.getName());}}
            catch(Exception e){}
    }

    @FXML
    private void editar_click(MouseEvent event) {
         Category selectedGasto = tabla.getSelectionModel().getSelectedItem();
        if (selectedGasto != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificarCategorias.fxml"));
                Parent root = loader.load();
                ModificarCategoriasController modificarGastoController = loader.getController();
                modificarGastoController.initData(selectedGasto);

                Stage stage = new Stage();
                stage.setTitle("GastoGuard > Editar categoría");
                stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("ModificarCategorias.css").toExternalForm());
                stage.setScene(scene);
               
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                stage.showAndWait();
                
                tabla.refresh();
                anadir.clear();
                List<Category> client = Acount.getInstance().getUserCategories();
                anadir.addAll(client);
            } catch (IOException | AcountDAOException ex) {
                Logger.getLogger(Pantalla3_principalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }

    @FXML
    private void AtrasOnAction(ActionEvent event) {
        
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaPrincipal.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("PantallaPrincipal.css").toExternalForm());
            Stage newStage = new Stage();
            newStage.setTitle("GastoGuard > Menú principal");
            newStage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(GestionarCategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
