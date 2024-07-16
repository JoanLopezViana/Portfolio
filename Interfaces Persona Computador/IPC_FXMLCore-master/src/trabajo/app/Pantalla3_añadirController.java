/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package trabajo.app;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Acount;
import model.AcountDAOException;
import model.Charge;
import model.Category;
import static trabajo.app.JavaFXMLApplication.stage;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class Pantalla3_añadirController {

    private TextField tctCategoria;
    @FXML
    private TextField txtCoste;
    @FXML
    private DatePicker txtFecha;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDescripción;
    @FXML
    private Button btnGuardar;
    
    private ObservableList<Charge> anadir;
    
    private Charge añadir;
    @FXML
    private Button Añadir_but;
    @FXML
    private ComboBox<String> Categoria_Combo;
    @FXML
    private TextField Cantidad_text;
    @FXML
    private ImageView imagen_select;
    Image im= null;
    @FXML
    private Text titulo;

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // TODO
        
        txtFecha.setDayCellFactory(new Callback<DatePicker, DateCell>() {
        @Override
        public DateCell call(final DatePicker datePicker) {
            return new DateCell() {
                @Override
                public void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item.isAfter(LocalDate.now())) {
                        setDisable(true);
                        setStyle("-fx-background-color: #ffc0cb;"); // Estilo opcional para deshabilitar celdas
                    }
                }
            };
        }
    });
    //txtFecha.setValue(LocalDate.now()); // Inicializa con la fecha actual
        stage.setTitle("GastoGuard > Cuenta");
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
    
        
    
    public void initAttributes(ObservableList<Charge> anadir){
        this.anadir = anadir;
    }

    @FXML
    private void guardar(ActionEvent event) throws AcountDAOException, IOException {
       Double coste = null;
           int i = 0;
       if(Categoria_Combo.getValue()!=null&& txtNombre.getText().isEmpty()==false&& txtCoste.getText().isEmpty()==false&&txtFecha.getValue()!=null&& Cantidad_text.getText().isEmpty()==false&&txtDescripción.getText().isEmpty()
                ==false){   
          
        String nombre = this.txtNombre.getText();
        try{ coste = Double.parseDouble(this.txtCoste.getText());}
        catch(NumberFormatException s){ Alert a= new Alert(Alert.AlertType.WARNING);
        a.setContentText("El campo coste no es un número");
        a.show();
        }
        LocalDate f =  this.txtFecha.getValue();
        try{i= Integer.parseInt(this.Cantidad_text.getText());}
        catch(NumberFormatException e){
         Alert a= new Alert(Alert.AlertType.WARNING);
        a.setContentText("El campo cantidad no es un número");
        a.show();
        }
        String categoria = this.Categoria_Combo.getValue();
        String descripcion = this.txtDescripción.getText();
        Category cat= null;
        
        
        List<Category>cate= Acount.getInstance().getUserCategories();
        for(Category c: cate){
            if(c.getName().equals(categoria)){cat= c;}
        }
        //TODO: falta meter unidades
        boolean cargo= Acount.getInstance().registerCharge(nombre, descripcion, coste, i, im, f, cat);
        
        
        if(cargo==true){
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText("Se ha añadido correctamente");
            alert.showAndWait();
            
            Stage stage = (Stage)this.btnGuardar.getScene().getWindow();
            stage.close();
            
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La persona ya existe");
            alert.showAndWait();
        }}
        else{
        Alert a= new Alert(Alert.AlertType.WARNING);
        a.setContentText("Rellene todos los campos, menos la foto si no quisiera");
        a.show();
        }
         
        
    }
    
    public Charge getAñadir(){
        return añadir;
    }

    @FXML
    private void Añadir_click(MouseEvent event) throws AcountDAOException, IOException  {
         
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Añadir_Categoria.fxml"));
            
            Parent root = loader.load();
            
            Añadir_CategoriaController controlador = loader.getController();
            
            
            Scene scene = new Scene(root);
             
            scene.getStylesheets().add(getClass().getResource("Añadir_Categoria.css").toExternalForm());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("GastoGuard > Añadir categoría");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
            stage.setScene(scene);
            stage.showAndWait();
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
    private void img_click(MouseEvent event) {
          // Crear un FileChooser
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


    


