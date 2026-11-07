package co.edu.uniquindio.poo.proyectomonederovirtual.app;

import co.edu.uniquindio.poo.proyectomonederovirtual.model.MonederoVirtual;
import co.edu.uniquindio.poo.proyectomonederovirtual.viewController.InicioSesionViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * JavaFX App
 */
public class Aplicacion extends Application {

    private Stage primaryStage;
    public static MonederoVirtual monederoVirtual = new MonederoVirtual("MonederoVirtual", "79473939");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MonederoVirtual");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        inicializarData();

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/proyectoMonederoVirtual/inicioSesion.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            InicioSesionViewController = loader.getController();
            InicioSesionViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
