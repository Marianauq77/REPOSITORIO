package co.edu.uniquindio.poo.empresajfx.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.empresajfx.App;
import co.edu.uniquindio.poo.empresajfx.controller.EmpleadoController;
import co.edu.uniquindio.poo.empresajfx.model.Empleado;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmpleadoViewController {

    EmpleadoController empleadoController;
    ObservableList<Empleado> listEmpleados;
    Empleado selectedEmpleado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Empleado> tblListEmpleado;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizarEmpleado;

    @FXML
    private TableColumn<Empleado, String> tbcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TableColumn<Empleado, String> tbcApellido;

    @FXML
    private Button btbAgregarCliente;

    @FXML
    private TableColumn<Empleado, String> tbcCedula;

    @FXML
    private TextField txtCedula;
    private App app;

    @FXML
    void onAgregarEmpleado() {
        agregarEmpleado();
    }

    @FXML
    void onActualizarEmpleado() {
        actualizarEmpleado();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar() {
        eliminarEmpleado();
    }

    @FXML
    void initialize() {
        this.app=app;
        empleadoController = new EmpleadoController(app.empresa);
        initView();
    }
    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerEmpleados();

        // Limpiar la tabla
        tblListEmpleado.getItems().clear();

        // Agregar los elementos a la tabla
        tblListEmpleado.setItems(listEmpleados);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }
    private void initDataBinding() {
        tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerEmpleados() {
        listEmpleados.addAll(empleadoController.obtenerListaEmpleados());
    }

    private void listenerSelection() {
        tblListEmpleado.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedEmpleado = newSelection;
            mostrarInformacionEmpleado(selectedEmpleado);
        });
    }

    private void mostrarInformacionEmpleado(Empleado empleado) {
        if (empleado != null) {
            txtCedula.setText(empleado.getCedula());
            txtNombre.setText(empleado.getNombre());
            txtApellido.setText(empleado.getApellido());
        }
    }

    private void agregarEmpleado() {
        Empleado empleado = buildEmpleado();
        if (empleadoController.crearEmpleado(empleado)) {
            listEmpleados.add(empleado);
            limpiarCamposEmpleado();
        }
    }

    private Empleado buildEmpleado() {
        Empleado empleado = new Empleado(txtCedula.getText(), txtNombre.getText(), txtApellido.getText());
        return empleado;
    }

    private void eliminarEmpleado() {
        if (empleadoController.eliminarEmpleado(txtCedula.getText())) {
            listEmpleados.remove(selectedEmpleado);
            limpiarCamposEmpleado();
            limpiarSeleccion();
        }
    }

    private void actualizarEmpleado() {

        if (selectedEmpleado != null &&
                empleadoController.actualizarEmpleado(selectedEmpleado.getCedula(), buildEmpleado())) {

            int index = listEmpleados.indexOf(selectedEmpleado);
            if (index >= 0) {
                listEmpleados.set(index, buildEmpleado());
            }

            tblListEmpleado.refresh();
            limpiarSeleccion();
            limpiarCamposEmpleado();
        }
    }

    private void limpiarSeleccion() {
        tblListEmpleado.getSelectionModel().clearSelection();
        limpiarCamposEmpleado();
    }

    private void limpiarCamposEmpleado() {
        txtCedula.clear();
        txtNombre.clear();
        txtApellido.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}

