package trabajo.app;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Acount;
import model.AcountDAOException;
import model.Category;
import model.Charge;

public class visualizarGastosController implements Initializable {

    @FXML
    private ComboBox<String> mesComboBox;
    @FXML
    private ComboBox<Integer> anioComboBox;
    @FXML
    private ComboBox<String> categoriaComboBox;
    @FXML
    private ComboBox<String> comparacionComboBox;
    @FXML
    private Label totalGastoLabel;
    @FXML
    private TableView<Charge> tablaGastosCategoria;
    @FXML
    private TableColumn<Charge, String> categoriaColumn;
    @FXML
    private TableColumn<Charge, Double> montoColumn;
    @FXML
    private LineChart<String, Number> comparativaGastosChart;

    private List<Charge> lista;
    private ObservableList<Charge> l;

    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;
    @FXML
    private Button atras;
    @FXML
    private TableColumn<Charge, String> mesColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        categoriaColumn.setCellValueFactory(cellData -> {
            Charge charge = cellData.getValue();
            String categoryName = charge.getCategory().getName();
            return new SimpleStringProperty(categoryName);
        });
        montoColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Configurar la nueva columna de meses
        mesColumn.setCellValueFactory(cellData -> {
            Charge charge = cellData.getValue();
            String mes = obtenerNombreMes(charge.getDate().getMonthValue());
            return new SimpleStringProperty(mes);
        });

        ObservableList<String> meses = FXCollections.observableArrayList("Vaciar",
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        );
        mesComboBox.setItems(meses);

        ObservableList<Integer> anios = FXCollections.observableArrayList(2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024);
        anioComboBox.setItems(anios);

        ObservableList<String> comparaciones = FXCollections.observableArrayList(
                "Comparar meses del año seleccionado", "Comparar meses de años anteriores"
        );
        comparacionComboBox.setItems(comparaciones);

        try {
            List<Category> categoriasList = Acount.getInstance().getUserCategories();
            ObservableList<String> categorias = FXCollections.observableArrayList();
            for (Category categoria : categoriasList) {
                categorias.add(categoria.getName());
            }
            categoriaComboBox.setItems(categorias);
        } catch (AcountDAOException | IOException ex) {
            Logger.getLogger(Pantalla3_añadirController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            l = FXCollections.observableArrayList();
            tablaGastosCategoria.setItems(l);
            lista = Acount.getInstance().getUserCharges();
            l.addAll(lista);
            actualizarLineChartPorMeses(lista, LocalDate.now().getYear());
            actualizarTableView(lista);
        } catch (AcountDAOException | IOException ex) {
            Logger.getLogger(visualizarGastosController.class.getName()).log(Level.SEVERE, null, ex);
        }

        mesComboBox.setOnAction(this::mesComboBoxChanged);
    }

    private String obtenerNombreMes(int mes) {
        List<String> meses = Arrays.asList(
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        );
        return meses.get(mes - 1);
    }

    private void mesComboBoxChanged(ActionEvent event) {
        if (mesComboBox.getValue().equals("Vaciar")) {
            anioComboBox.setValue(null);
            categoriaComboBox.setValue(null);
            comparacionComboBox.setValue(null);
            l.clear();
            l.addAll(lista);
            totalGastoLabel.setText("0.00");
            actualizarLineChartPorMeses(lista, LocalDate.now().getYear());
        }
        actualizarTableView(l);
    }

    @FXML
    private void aplicarFiltros(ActionEvent event) {
        String mesSeleccionado = mesComboBox.getValue();
        Integer anioSeleccionado = anioComboBox.getValue();
        String categoriaSeleccionada = categoriaComboBox.getValue();
        String comparacionSeleccionada = comparacionComboBox.getValue();
        l.clear();

        List<Charge> listaFiltrada = lista.stream()
                .filter(c -> (mesSeleccionado == null || obtenerNombreMes(c.getDate().getMonthValue()).equalsIgnoreCase(mesSeleccionado)))
                .filter(c -> (anioSeleccionado == null || c.getDate().getYear() == anioSeleccionado))
                .filter(c -> (categoriaSeleccionada == null || c.getCategory().getName().equalsIgnoreCase(categoriaSeleccionada)))
                .collect(Collectors.toList());

        if (listaFiltrada.isEmpty()) {
            totalGastoLabel.setText("0.00");
            comparativaGastosChart.getData().clear();
        } else {
            actualizarTableView(listaFiltrada);
            if ("Comparar meses del año seleccionado".equals(comparacionSeleccionada)) {
                actualizarLineChartPorMeses(listaFiltrada, anioSeleccionado != null ? anioSeleccionado : LocalDate.now().getYear());
            } else if ("Comparar meses de años anteriores".equals(comparacionSeleccionada)) {
                actualizarLineChartPorAnios(listaFiltrada, anioSeleccionado != null ? anioSeleccionado : LocalDate.now().getYear());
            }
        }
    }

    private void actualizarTableView(List<Charge> listaFiltrada) {
        l.setAll(listaFiltrada);
        double totalGasto = listaFiltrada.stream().mapToDouble(Charge::getCost).sum();
        totalGastoLabel.setText(String.format("%.2f", totalGasto));
    }

    private void actualizarLineChartPorMeses(List<Charge> listaFiltrada, int anioSeleccionado) {
        comparativaGastosChart.getData().clear();
        x.getCategories().clear();

        Map<String, Double> gastosPorMes = listaFiltrada.stream()
                .filter(c -> c.getDate().getYear() == anioSeleccionado)
                .collect(Collectors.groupingBy(
                        c -> obtenerNombreMes(c.getDate().getMonthValue()),
                        Collectors.summingDouble(Charge::getCost)
                ));

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Gastos por Mes - " + anioSeleccionado);

        List<String> mesesOrdenados = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");

        mesesOrdenados.forEach(mes -> {
            Double total = gastosPorMes.getOrDefault(mes, 0.0);
            series.getData().add(new XYChart.Data<>(mes, total));
        });

        x.getCategories().addAll(mesesOrdenados);

        comparativaGastosChart.getData().add(series);
        x.setTickLabelRotation(45);
        x.setTickLabelGap(10);
    }

    private void actualizarLineChartPorAnios(List<Charge> listaFiltrada, int anioSeleccionado) {
        comparativaGastosChart.getData().clear();

        Map<Integer, Map<String, Double>> gastosPorAnioYMes = listaFiltrada.stream()
                .collect(Collectors.groupingBy(
                        c -> c.getDate().getYear(),
                        Collectors.groupingBy(
                                c -> obtenerNombreMes(c.getDate().getMonthValue()),
                                Collectors.summingDouble(Charge::getCost)
                        )
                ));

        for (Map.Entry<Integer, Map<String, Double>> entry : gastosPorAnioYMes.entrySet()) {
            Integer anio = entry.getKey();
            Map<String, Double> gastosPorMes = entry.getValue();

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Gastos por Mes - " + anio);

            Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                          "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")
                  .forEach(mes -> {
                      Double total = gastosPorMes.getOrDefault(mes, 0.0);
                      series.getData().add(new XYChart.Data<>(mes, total));
                  });

            comparativaGastosChart.getData().add(series);
        }
    }

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
            Logger.getLogger(visualizarGastosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
