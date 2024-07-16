package trabajo.app;

import trabajo.app.Pantalla3_añadirController;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Acount;
import model.AcountDAOException;
import model.Charge;

import javafx.collections.ObservableList;
import javafx.print.Paper;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Pantalla3_principalController implements Initializable {

    @FXML
    private TableColumn<Charge, String> colCategoria;
    @FXML
    private TableColumn<Charge, Integer> colCoste;
    @FXML
    private TableColumn<Charge, Date> ColFecha;
    @FXML
    private TableColumn<Charge, String> ColNombre;
    @FXML
    private TableColumn<Charge, String> ColDescripcion;
    @FXML
    private Button btnAñadir;
    private ObservableList<Charge> anadir; 
    @FXML
    private TableView<Charge> tblAñadir;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnmodif;
    @FXML
    private TableColumn<Charge, Double> ColCantidad;
    @FXML
    private TableColumn<Charge, Image> ColImagen;
    @FXML
    private Button btnAtras;
    @FXML
    private Button Imprimir;

    @FXML
    private void Imprimir_click(MouseEvent event) {
             Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            File file = showSaveDialog(stage);
            if (file != null) {
                printToPdf(tblAñadir, file);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de errores
        }
    }
   
    private File showSaveDialog(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar PDF");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        return fileChooser.showSaveDialog(stage);
    }

    public static void printToPdf(TableView<Charge> tableView, File file) throws IOException {
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null && printerJob.showPrintDialog(tableView.getScene().getWindow())) {
            double totalWidth = 0;
            for (TableColumn<Charge, ?> column : tableView.getColumns()) {
                totalWidth += column.getWidth();
            }

            double scaleFactor = Paper.A4.getWidth() / totalWidth;
            Scale scale = new Scale(scaleFactor, scaleFactor);
            tableView.getTransforms().add(scale);

            for (TableColumn<Charge, ?> column : tableView.getColumns()) {
                column.setPrefWidth(column.getWidth() * scaleFactor);
            }

            if (printerJob.printPage(tableView)) {
                printerJob.endJob();
            }

            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.close();
        }}
public class ImageLoadingThread extends Thread {
    private Charge charge;
    
    public ImageLoadingThread(Charge charge) {
        this.charge = charge;
    }
    
    @Override
    public void run() {
        // Aquí realizas la carga de la imagen
        // Supongamos que tienes un método getImagePath() en la clase Charge que devuelve la ruta de la imagen
        String imagePath = charge.getImageScan().getUrl();
        if (imagePath != null && !imagePath.isEmpty()) {
            // Carga la imagen desde la ruta
            Image image = new Image(imagePath);
            // Establece la imagen cargada en el objeto Charge
            charge.setImageScan(image);
        }
    }
}
   @Override
public void initialize(URL url, ResourceBundle rb) {
    
    
    anadir = FXCollections.observableArrayList();
    this.tblAñadir.setItems(anadir);

    try {
        List<Charge> client = Acount.getInstance().getUserCharges();
        anadir.addAll(client);
        
        // Iniciar un hilo para cargar las imágenes en segundo plano
        for (Charge charge : client) {
            ImageLoadingThread thread = new ImageLoadingThread(charge);
            thread.start();
        }
    } catch (AcountDAOException | IOException ex) {
        Logger.getLogger(Pantalla3_principalController.class.getName()).log(Level.SEVERE, null, ex);
    }

    ColCantidad.setCellValueFactory(new PropertyValueFactory<>("units"));
    ColDescripcion.setCellValueFactory(new PropertyValueFactory<>("description"));
    ColFecha.setCellValueFactory(new PropertyValueFactory<>("date"));
    ColNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
    colCategoria.setCellValueFactory(cellData -> {
        Charge charge = cellData.getValue();
        String categoryName = charge.getCategory().getName();
        return new SimpleStringProperty(categoryName);
    });
    colCoste.setCellValueFactory(new PropertyValueFactory<>("cost"));

    // Setting the cell factory for the image column
    ColImagen.setCellFactory(column -> new TableCell<Charge, Image>() {
        private final ImageView imageView = new ImageView();

        @Override
        protected void updateItem(Image image, boolean empty) {
            super.updateItem(image, empty);

            if (empty || image == null) {
                setText(null);
                setGraphic(null);
            } else {
                imageView.setImage(image);
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
                setGraphic(imageView);
            }
        }
    });
    ColImagen.setCellValueFactory(new PropertyValueFactory<>("ImageScan")); // Suponiendo que el método que devuelve la imagen se llama "getScanImage()"
     // Deshabilitar los botones de borrar y modificar al inicio
        btnBorrar.setDisable(true);
        btnmodif.setDisable(true);

        // Añadir listener para habilitar/deshabilitar botones según la selección
        tblAñadir.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            boolean seleccionVacia = newSelection == null;
            btnBorrar.setDisable(seleccionVacia);
            btnmodif.setDisable(seleccionVacia);
        });
}

    @FXML
    private void añadir(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Pantalla3_añadir.fxml"));
            Parent root = loader.load();
            Pantalla3_añadirController controlador = loader.getController();
            controlador.initAttributes(anadir);

            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("Pantalla3_añadir.css").toExternalForm());
            Stage stage = new Stage();
            stage.setTitle("GastoGuard > Añadir gasto");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false); // Hace que la ventana no se pueda redimensionar
     
            stage.setScene(scene);
            stage.showAndWait();
             tblAñadir.refresh();
                anadir.clear();
                List<Charge> client = Acount.getInstance().getUserCharges();
             anadir.addAll(client);

            Charge a = controlador.getAñadir();
            if (a != null) {
                List<Charge> cliente = Acount.getInstance().getUserCharges();
                anadir.addAll(cliente);
            }
        } catch (IOException | AcountDAOException ex) {
            Logger.getLogger(Pantalla3_principalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void borrar(ActionEvent event) {
        Charge a = tblAñadir.getSelectionModel().getSelectedItem();
        if (a != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("¿Está seguro de que desea borrar?");
            alert.setContentText("Esta acción no se puede deshacer.");
            alert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    try {
                        boolean b = Acount.getInstance().removeCharge(a);
                        if (b) {
                            anadir.remove(a);
                            tblAñadir.refresh();
                        }
                    } catch (AcountDAOException | IOException ex) {
                        Logger.getLogger(Pantalla3_principalController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
    }

   /* private void modificar(ActionEvent event) {
        Charge selectedGasto = tblAñadir.getSelectionModel().getSelectedItem();
        if (selectedGasto != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("modificarGasto.fxml"));
                Parent root = loader.load();
                ModificarGastoController modificarGastoController = loader.getController();
                modificarGastoController.initData(selectedGasto);
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("ModificarGasto.css").toExternalForm());
                Stage stage = new Stage();
                stage.setTitle("GastoGuard > Modificar gasto");
                stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
                stage.setScene(scene);
                
                stage.initModality(Modality.APPLICATION_MODAL);
               
                stage.showAndWait();
                tblAñadir.refresh();
                anadir.clear();
                List<Charge> client = Acount.getInstance().getUserCharges();
                anadir.addAll(client);
            } catch (IOException | AcountDAOException ex) {
                Logger.getLogger(Pantalla3_principalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/

    @FXML
    private void atrasOnAction(ActionEvent event) {
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
            Logger.getLogger(Pantalla3_principalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void S(MouseEvent event) {
    }

    @FXML
    private void borrar(MouseEvent event) {
        Charge a = tblAñadir.getSelectionModel().getSelectedItem();
        if (a != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("¿Está seguro de que desea borrar?");
            alert.setContentText("Esta acción no se puede deshacer.");
            alert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    try {
                        boolean b = Acount.getInstance().removeCharge(a);
                        if (b) {
                            anadir.remove(a);
                            tblAñadir.refresh();
                        }
                    } catch (AcountDAOException | IOException ex) {
                        Logger.getLogger(Pantalla3_principalController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
    }

    @FXML
    private void bntmod(MouseEvent event) {
        Charge selectedGasto = tblAñadir.getSelectionModel().getSelectedItem();
        if (selectedGasto != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("modificarGasto.fxml"));
                Parent root = loader.load();
                ModificarGastoController modificarGastoController = loader.getController();
                modificarGastoController.initData(selectedGasto);
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("ModificarGasto.css").toExternalForm());
               
                Stage stage = new Stage();
                stage.setTitle("GastoGuard > Modificar gasto");
                stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                 stage.setResizable(false);
                stage.showAndWait();
                tblAñadir.refresh();
                anadir.clear();
                List<Charge> client = Acount.getInstance().getUserCharges();
                anadir.addAll(client);
            } catch (IOException | AcountDAOException ex) {
                Logger.getLogger(Pantalla3_principalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }       
}
