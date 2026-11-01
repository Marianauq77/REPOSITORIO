package co.edu.uniquindio.poo.model;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;


public class EnvioTest {
    private static final Logger LOG = Logger.getLogger(EnvioTest.class.getName());

    @Test
    public void calcularCostoFijo() {
        LOG.info("Inicio de prueba nombrePrueba...");
        // codigo de la prueba
        Envio envio= new EnvioNacional("222", 20, 5000,7000, "Juan",
                "Armenia", true );
        float actual= envio.calcularCostoFijo();
        float esperado=

        LOG.info("Fin de prueba registrarJugadorEquipo...");

    }
}