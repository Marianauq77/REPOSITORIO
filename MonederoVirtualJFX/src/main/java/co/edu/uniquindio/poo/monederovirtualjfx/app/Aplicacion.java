package co.edu.uniquindio.poo.monederovirtualjfx.app;

import co.edu.uniquindio.poo.monederovirtualjfx.model.Beneficio;
import co.edu.uniquindio.poo.monederovirtualjfx.model.MonederoVirtual;
import co.edu.uniquindio.poo.monederovirtualjfx.model.TipoMonedero;
import co.edu.uniquindio.poo.monederovirtualjfx.model.Usuario;
import co.edu.uniquindio.poo.monederovirtualjfx.viewController.InicioSesionRegistroViewController;
import co.edu.uniquindio.poo.monederovirtualjfx.viewController.MenuViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class Aplicacion extends Application {

    private Stage primaryStage;
    public static MonederoVirtual monederoVirtual = new MonederoVirtual("MonederoVirtual", "79473939");
    private static Usuario usuarioActual;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MonederoVirtual");
        inicializarData();
        openViewPrincipal();
    }

    /**
     * Abre la vista de inicio de sesión y registro.
     * También se usa para volver a esta vista cuando el usuario cierra sesión.
     */
    public void openViewPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/monederovirtualjfx/InicioSesionRegistro.fxml"));
            Parent rootLayout = loader.load();
            InicioSesionRegistroViewController inicioSesionRegistroViewController = loader.getController();
            inicioSesionRegistroViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Abre el menú del usuario después de iniciar sesión o registrarse.
     */
    public void openViewMenu() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/monederovirtualjfx/Menu.fxml"));
            Parent rootLayout = loader.load();
            MenuViewController menuViewController = loader.getController();
            menuViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Guarda el usuario que acaba de iniciar sesión o registrarse y muestra el menú.
     */
    public void iniciarSesion(Usuario usuario) {
        usuarioActual = usuario;
        openViewMenu();
    }

    /**
     * Cierra la sesión actual y regresa a la pantalla de inicio de sesión.
     */
    public void cerrarSesion() {
        usuarioActual = null;
        openViewPrincipal();
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    private void inicializarData() {
        Usuario usuario = new Usuario("10793898", "Sara Velzquez Sapo", "31990038",
                "sapitoSaragmail@.com", "98804HJ");
        monederoVirtual.crearUsuario(usuario);
        monederoVirtual.crearMonedero(usuario, "290830", "PRINCIPAL", TipoMonedero.AHORROS, 0);

        Usuario usuario2 = new Usuario("10213778", "Valentina Mosquera", "319574788",
                "ValMosquito@.com", "98JHH679");
        monederoVirtual.crearUsuario(usuario2);
        monederoVirtual.crearMonedero(usuario2, "9489250", "PRINCIPAL", TipoMonedero.AHORROS, 0);

        Usuario usuario3 = new Usuario("1084Y898", "Robinson Velzquez Verruga", "31970938",
                "Rbverru@gmail.com", "97473RT");
        monederoVirtual.crearUsuario(usuario3);
        monederoVirtual.crearMonedero(usuario3, "748507", "PRINCIPAL", TipoMonedero.AHORROS, 0);

        monederoVirtual.crearBeneficios(new Beneficio("Beneficio100", 100,
                "Reducción del 10% en la comisión por transferencias"));
        monederoVirtual.crearBeneficios(new Beneficio("Beneficio500", 500,
                "Un mes sin cargos por retiro"));
        monederoVirtual.crearBeneficios(new Beneficio("Beneficio1000", 1000,
                "Bono de saldo de 50 unidades en el monedero"));
    }

    public static void main(String[] args) {
        launch();
    }
}
