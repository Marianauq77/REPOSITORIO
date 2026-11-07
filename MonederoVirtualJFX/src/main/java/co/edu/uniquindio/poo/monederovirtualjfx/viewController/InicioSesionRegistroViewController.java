package co.edu.uniquindio.poo.monederovirtualjfx.viewController;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.monederovirtualjfx.app.Aplicacion;
import co.edu.uniquindio.poo.monederovirtualjfx.controller.InicioSesionRegistroController;
import co.edu.uniquindio.poo.monederovirtualjfx.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class InicioSesionRegistroViewController {

    private static final int MAX_INTENTOS = 3;

    private static final String ESTILO_TAB_ACTIVA =
            "-fx-background-color: #2563EB; -fx-text-fill: white; -fx-background-radius: 20; "
                    + "-fx-font-weight: bold; -fx-cursor: hand;";
    private static final String ESTILO_TAB_INACTIVA =
            "-fx-background-color: transparent; -fx-text-fill: #64748B; -fx-background-radius: 20; "
                    + "-fx-font-weight: bold; -fx-cursor: hand;";
    private static final String ESTILO_MENSAJE_ERROR = "-fx-text-fill: #EF4444; -fx-font-size: 12px;";
    private static final String ESTILO_MENSAJE_EXITO = "-fx-text-fill: #16A34A; -fx-font-size: 12px;";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox boxNombre;

    @FXML
    private VBox boxCorreo;

    @FXML
    private VBox boxTelefono;

    @FXML
    private VBox boxCodigoMonedero;

    @FXML
    private Button btnAccionPrincipal;

    @FXML
    private Button btnTabInicio;

    @FXML
    private Button btnTabRegistro;

    @FXML
    private Label lblMensaje;

    @FXML
    private TextField txtDocumento;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtCodigoMonedero;

    @FXML
    private PasswordField txtPassword;

    private Aplicacion aplicacion;
    private InicioSesionRegistroController inicioSesionRegistroController;
    private boolean modoRegistro;
    private int intentosFallidos;
    private String documentoIntentoActual;

    @FXML
    void ejecutarAccion(ActionEvent event) { //Es el boton de abajo de iniciar sesion o registrarse osea el grande
        // cuando ya estan los datos, tecnicmante son el mismo boton pero se ejecutan distinto segun el modo o sea la pestaña
        if (inicioSesionRegistroController == null) {
            mostrarMensaje("La aplicación no está inicializada.", true); //En caso de que el seApp no se haya ejecutado
            return;
        }

        if (modoRegistro) {
            registrarUsuario();
        } else {
            iniciarSesion();
        }
    }

    @FXML
    void mostrarModoInicio(ActionEvent event) {
        cambiarModo(false);
    }

    @FXML
    void mostrarModoRegistro(ActionEvent event) {
        cambiarModo(true);
    }

    private void iniciarSesion() {
        String documento = txtDocumento.getText().trim();
        String contrasenia = txtPassword.getText();

        if (documento.isEmpty() || contrasenia.isEmpty()) {
            mostrarMensaje("Ingrese su documento de identidad y su contraseña.", true);
            return;
        }

        Optional<Usuario> usuario = inicioSesionRegistroController.buscarUsuario(documento);
        if (usuario.isEmpty()) {
            mostrarMensaje("No se encontró un usuario con ese documento de identidad.", true);
            return;
        }

        if (!documento.equals(documentoIntentoActual)) {
            intentosFallidos = 0;
            documentoIntentoActual = documento;
        }

        if (!inicioSesionRegistroController.verificarContrasenia(usuario.get(), contrasenia)) {
            intentosFallidos++;
            int intentosRestantes = MAX_INTENTOS - intentosFallidos;

            if (intentosRestantes <= 0) {
                mostrarMensaje("Contraseña incorrecta. Ha superado los " + MAX_INTENTOS
                        + " intentos, vuelva a intentarlo.", true);
                intentosFallidos = 0;
            } else {
                mostrarMensaje("Contraseña incorrecta. Le quedan " + intentosRestantes + " intentos.", true);
            }

            txtPassword.clear();
            txtPassword.requestFocus();
            return;
        }

        intentosFallidos = 0;
        documentoIntentoActual = null;
        aplicacion.iniciarSesion(usuario.get());
    }

    private void registrarUsuario() {
        String documento = txtDocumento.getText().trim();
        String nombre = txtNombre.getText().trim();
        String correo = txtCorreo.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String contrasenia = txtPassword.getText();
        String codigoMonedero = txtCodigoMonedero.getText().trim();

        if (documento.isEmpty() || nombre.isEmpty() || correo.isEmpty()
                || telefono.isEmpty() || contrasenia.isEmpty() || codigoMonedero.isEmpty()) {
            mostrarMensaje("Complete todos los campos para crear su cuenta.", true);
            return;
        }

        if (inicioSesionRegistroController.existeUsuario(documento)) {
            mostrarMensaje("Ya existe un usuario con ese documento de identidad.", true);
            return;
        }

        if (inicioSesionRegistroController.existeCodigoMonedero(codigoMonedero)) {
            mostrarMensaje("Ese código de monedero ya existe, elija otro.", true);
            return;
        }

        Usuario usuario = inicioSesionRegistroController.registrarUsuario(
                documento, nombre, telefono, correo, contrasenia, codigoMonedero);

        if (usuario == null) {
            mostrarMensaje("No se pudo completar el registro. Verifique los datos.", true);
            return;
        }

        limpiarCampos();
        aplicacion.iniciarSesion(usuario);
    }

    private void cambiarModo(boolean registro) {
        this.modoRegistro = registro;

        boxNombre.setVisible(registro); // si es true (registro) los muestra si es false(inicio Sesion) los esconde
        boxNombre.setManaged(registro);
        boxCorreo.setVisible(registro);
        boxCorreo.setManaged(registro);
        boxTelefono.setVisible(registro);
        boxTelefono.setManaged(registro);
        boxCodigoMonedero.setVisible(registro);
        boxCodigoMonedero.setManaged(registro);

        btnAccionPrincipal.setText(registro ? "Crear cuenta" : "Ingresar al Monedero");
        btnTabInicio.setStyle(registro ? ESTILO_TAB_INACTIVA : ESTILO_TAB_ACTIVA);
        btnTabRegistro.setStyle(registro ? ESTILO_TAB_ACTIVA : ESTILO_TAB_INACTIVA);

        lblMensaje.setText("");
        intentosFallidos = 0;
        documentoIntentoActual = null;
    }

    private void limpiarCampos() {
        txtDocumento.clear();
        txtNombre.clear();
        txtCorreo.clear();
        txtTelefono.clear();
        txtPassword.clear();
        txtCodigoMonedero.clear();
    }

    private void mostrarMensaje(String mensaje, boolean error) {
        lblMensaje.setText(mensaje);
        lblMensaje.setStyle(error ? ESTILO_MENSAJE_ERROR : ESTILO_MENSAJE_EXITO);
    }

    public void setApp(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        this.inicioSesionRegistroController =
                new InicioSesionRegistroController(aplicacion.monederoVirtual);
    }

    @FXML
    void initialize() {
        assert boxNombre != null : "fx:id=\"boxNombre\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";
        assert boxCorreo != null : "fx:id=\"boxCorreo\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";
        assert boxTelefono != null : "fx:id=\"boxTelefono\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";
        assert boxCodigoMonedero != null : "fx:id=\"boxCodigoMonedero\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";
        assert btnAccionPrincipal != null : "fx:id=\"btnAccionPrincipal\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";
        assert btnTabInicio != null : "fx:id=\"btnTabInicio\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";
        assert btnTabRegistro != null : "fx:id=\"btnTabRegistro\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";
        assert lblMensaje != null : "fx:id=\"lblMensaje\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";
        assert txtDocumento != null : "fx:id=\"txtDocumento\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";
        assert txtCorreo != null : "fx:id=\"txtCorreo\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";
        assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";
        assert txtCodigoMonedero != null : "fx:id=\"txtCodigoMonedero\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'InicioSesionRegistro.fxml'.";

        cambiarModo(false);
    }
}
