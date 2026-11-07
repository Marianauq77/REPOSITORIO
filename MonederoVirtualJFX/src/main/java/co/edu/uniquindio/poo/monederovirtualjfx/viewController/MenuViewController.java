package co.edu.uniquindio.poo.monederovirtualjfx.viewController;

import co.edu.uniquindio.poo.monederovirtualjfx.app.Aplicacion;
import co.edu.uniquindio.poo.monederovirtualjfx.model.Monedero;
import co.edu.uniquindio.poo.monederovirtualjfx.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MenuViewController {

    @FXML
    private Label lblBienvenido;

    @FXML
    private Label lblPuntos;

    @FXML
    private Label lblRango;

    @FXML
    private Label lblMonederos;

    private Aplicacion aplicacion;

    public void setApp(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        cargarDatosUsuario();
    }

    private void cargarDatosUsuario() {
        Usuario usuario = Aplicacion.getUsuarioActual();
        if (usuario == null) {
            lblBienvenido.setText("No hay una sesión activa");
            lblPuntos.setText("0");
            lblRango.setText("SIN RANGO");
            lblMonederos.setText("Vuelva a iniciar sesión.");
            return;
        }

        lblBienvenido.setText("Bienvenido, " + usuario.getNombreCompleto());
        lblPuntos.setText(String.valueOf(usuario.getPuntosAcumulados()));
        lblRango.setText(usuario.getRango().name());

        StringBuilder monederos = new StringBuilder();
        for (Monedero monedero : usuario.getListaMonederos()) {
            monederos.append("• Código: ").append(monedero.getCodigo())
                    .append("  |  Saldo: $").append(monedero.getSaldo())
                    .append("  |  Tipo: ").append(monedero.getTipoMonedero())
                    .append("\n");
        }
        lblMonederos.setText(monederos.length() == 0
                ? "No tienes monederos registrados."
                : monederos.toString());
    }

    @FXML
    void cerrarSesion(ActionEvent event) {
        aplicacion.cerrarSesion();
    }

    @FXML
    void initialize() {
        assert lblBienvenido != null : "fx:id=\"lblBienvenido\" was not injected: check your FXML file 'Menu.fxml'.";
        assert lblPuntos != null : "fx:id=\"lblPuntos\" was not injected: check your FXML file 'Menu.fxml'.";
        assert lblRango != null : "fx:id=\"lblRango\" was not injected: check your FXML file 'Menu.fxml'.";
        assert lblMonederos != null : "fx:id=\"lblMonederos\" was not injected: check your FXML file 'Menu.fxml'.";
    }
}
