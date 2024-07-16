/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package trabajo.app;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
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
public class ModificarGastoController  {

    @FXML
    private TextField txtCoste;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDescripción;
    @FXML
    private Button btnGuardar;
    @FXML
    private DatePicker txtFecha;
    @FXML
    private ComboBox<String> Categoria_Combo;
    @FXML
    private TextField Cantidad_text;
    @FXML
    private ImageView imagen_select;
    Image im= null;
    Charge g= null;
    @FXML
    private Button Añadir_but;
    @FXML
    private Text titulo;
    @FXML
    private Button CambiarImagen;
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // TODO
        
        stage.setTitle("GastoGuard > Modificar gastos");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
        
         ObservableList<String> categorias; 
        List <Category> categ;
        try {
            categ = Acount.getInstance().getUserCategories();
             categorias = FXCollections.observableArrayList();
            for(Category c : categ){
                categorias.add(c.getName());}
            Categoria_Combo.setItems(categorias);
        } catch (AcountDAOException ex) {
            Logger.getLogger(Pantalla3_añadirController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pantalla3_añadirController.class.getName()).log(Level.SEVERE, null, ex);
        }
         Platform.runLater(()->titulo.requestFocus());
        
        
    }    
     public void initData(Charge gasto) {
         g= gasto;
        // Configurar los campos de la vista con la información del gasto seleccionado
        this.txtNombre.setText(gasto.getName());
        this.txtCoste.setText(Double.toString(gasto.getCost()));
        this.Cantidad_text.setText(Integer.toString(gasto.getUnits()));
        this.txtDescripción.setText(gasto.getDescription());
        this.txtFecha.setValue(gasto.getDate());
        try {
        Image url = gasto.getImageScan();
        if (url.equals(null)==false) {
            this.imagen_select.setImage(gasto.getImageScan());
        } else {
            throw new Exception("Image URL is null");
        }
    } catch (Exception e) {
        this.imagen_select.setImage(new Image("trabajo/imagenes/añadirImagen.png"));
    }
        
       
        
        // Configurar otros campos si es necesario
    }

    @FXML
    private void guardar(ActionEvent event) throws AcountDAOException, IOException {  
        if(Categoria_Combo.getValue()!=null&& txtNombre.getText().isEmpty()==false&& txtCoste.getText().isEmpty()==false&&txtFecha.getValue()!=null&& Cantidad_text.getText().isEmpty()==false&&txtDescripción.getText().isEmpty()
                ==false){
        String nombre = this.txtNombre.getText();
        Double coste = Double.parseDouble(this.txtCoste.getText());
        LocalDate f =  this.txtFecha.getValue();
        int i= Integer.parseInt(this.Cantidad_text.getText());
        String categoria = (String) this.Categoria_Combo.getValue();
        String descripcion = this.txtDescripción.getText();
        Category cat= null;
        
        
        List<Category>cate= Acount.getInstance().getUserCategories();
        for(Category c: cate){
            if(c.getName().equals(categoria)){cat= c;}
        }
        //TODO: falta meter unidades
        boolean cargo= Acount.getInstance().registerCharge(nombre, descripcion, coste, i, im, f, cat);
        boolean cargoac= Acount.getInstance().removeCharge(g);
        
        
        if(cargo==true && cargoac==true){
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Se ha actualizado correctamente");
            alert.showAndWait();
            
          Stage stage = (Stage)this.btnGuardar.getScene().getWindow();
           stage.close();
            
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se ha actualizado correctamente");
            alert.showAndWait();
        }}
        else{
        Alert a= new Alert(Alert.AlertType.WARNING);
        a.setContentText("Rellene todos los campos, menos la foto si no quisiera");
        a.show();
        }
                
    }

    @FXML
    private void Añadir_click(MouseEvent event) {  try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Añadir_Categoria.fxml"));
            
            Parent root = loader.load();
            
            Añadir_CategoriaController controlador = loader.getController();
            
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(Pantalla3_añadirController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
          ObservableList<String> categorias; 
        List <Category> categ;
        try {
            categ = Acount.getInstance().getUserCategories();
             categorias = FXCollections.observableArrayList();
            for(Category c : categ){
                categorias.add(c.getName());}
            Categoria_Combo.setItems(categorias);
        } catch (AcountDAOException ex) {
            Logger.getLogger(Pantalla3_añadirController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pantalla3_añadirController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
            }
    

    @FXML
    private void img_click(MouseEvent event) {
   String s="";
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Seleccionar imagen");

    // Filtrar solo archivos de imagen
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
            "Archivos de imagen", "*.png", "*.jpg", "*.gif");
    fileChooser.getExtensionFilters().add(extFilter);

    // Mostrar el cuadro de diálogo y obtener el archivo seleccionado
    File selectedFile = fileChooser.showOpenDialog(null);
    
    // Si se selecciona un archivo, obtener su ruta y asignarla a la variable 's'
    if (selectedFile != null) {
        s = selectedFile.getAbsolutePath(); // Obtener la ruta absoluta del archivo
        this.im=new Image(s);
        this.imagen_select.setImage(im);
        System.out.println("Archivo seleccionado: " + s);
    } else {
        System.out.println("Ningún archivo seleccionado.");
    }
    }

    @FXML
    private void CambiarImg(ActionEvent event) {
         String s="";
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Seleccionar imagen");

    // Filtrar solo archivos de imagen
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
            "Archivos de imagen", "*.png", "*.jpg", "*.gif");
    fileChooser.getExtensionFilters().add(extFilter);

    // Mostrar el cuadro de diálogo y obtener el archivo seleccionado
    File selectedFile = fileChooser.showOpenDialog(null);
    
    // Si se selecciona un archivo, obtener su ruta y asignarla a la variable 's'
    if (selectedFile != null) {
        s = selectedFile.getAbsolutePath(); // Obtener la ruta absoluta del archivo
        this.im=new Image(s);
        this.imagen_select.setImage(im);
        System.out.println("Archivo seleccionado: " + s);
    } else {
        System.out.println("Ningún archivo seleccionado.");
    }
    }
    
    
}
