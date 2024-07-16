package trabajo.app;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.User;


public class JavaFXMLApplication extends Application {
    
    public static Stage stage;
  

    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        stage = primaryStage;
        //======================================================================
        // 1- creación del grafo de escena a partir del fichero FXML
        FXMLLoader loader= new  FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = loader.load();
        //======================================================================
        // 2- creación de la escena con el nodo raiz del grafo de escena
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
        //primaryStage.setScene(scene);
        //primaryStage.show();
        //======================================================================
        // 3- asiganación de la escena al Stage que recibe el metodo 
        //     - configuracion del stage
        //     - se muestra el stage de manera no modal mediante el metodo show()
        stage.setScene(scene);
        stage.setTitle("GastoGuard > Inicio de sesion");
        stage.show();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("../imagenes/icono_aplicacion.png")));
        stage.setOnCloseRequest(event -> {event.consume();bSalir(stage);});
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
    
    /*public static void setRoot(Parent root){

        stage.getScene().setRoot(root);
        stage.show();

    }*/
    
    private void bSalir(Stage stage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir de la aplicación");
        alert.setHeaderText("¿ Seguro que quieres salir de la aplicación ?");
        alert.setContentText("Esta acción cerrará tu sesión");
        if(alert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }
    }
    
    
    
    
    public static Stage getStage(){
        return stage;
    }
    
    
    


    
}
