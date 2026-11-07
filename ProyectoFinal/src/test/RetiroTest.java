package co.edu.uniquindio.poo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Retiro;

/**
 * Pruebas unitarias de la clase Retiro
 * Autores: Mariana Suárez Bran y Laura Camila Bautista 
 * Octubre del 2026
 */

public class RetiroTest {
    private static final Logger LOG = Logger.getLogger(RetiroTest.class.getName());
    private Monedero monedero;
    private LocalDate fecha;

    @BeforeEach
    public void setUp() {
        LOG.info("COnfiguración inicial para las pruebas unitarias de la clase Retiro");
        fecha = LocalDate.now();
        monedero = new Monedero("M001", "Monedero de ahorros", 500000, TipoMonedero.AHORROS);  
    }
    @AfterEach
    public void tearDown() {
        LOG.info("Fin de la prueba unitaria de la clase Retiro");
    }

    //Metodo de la clase
    @Test 
    @DisplayName("aplicar() debe disminuir el saldo del monedero de acuerdo con el monto del retiro")
    public void testAplicar() {
        LOG.info("Inicio de la prueba unitaria para el método aplicar() de la clase Retiro");
        Retiro retiro = new Retiro("0002", fecha, 100000, false);
        retiro.aplicar(monedero);
        assertEquals(400000, monedero.getSaldo());
        LOG.info("Fin de la prueba unitaria para el método aplicar() de la clase Retiro");
    }

    //Metodo de la clase: Cuando NO tiene cargo 
    @Test
    @DisplayName("calcularCargo() debe dar cero cuando el retiro es sin cargo")
    public void testCalcularCargoSinCargo() {
        LOG.info("Inicio de la prueba unitaria para el método calcularCargo() de la clase Retiro sin cargo");
        Retiro retiroSIncargo= new Retiro("0003", fecha, 10000, true);
        retiroSIncargo.calcularCargo();
        assertEquals(0, retiroSIncargo.calcularCargo());
        LOG.info("Fin de la prueba unitaria para el método calcularCargo() de la clase Retiro sin cargo");
    }

    //Metodo de la clase: Cuando SI tiene cargo
    @Test
    @DisplayName("calcularCargo() debe dar el 1% del monto cuando el retiro tiene cargo")
    public void testCalcularCargoConCargo() {
        LOG.info("Inicio de la prueba unitaria para el metodo calcularCrago() de la clase Retiro pero con cargo");
        Retiro retiroConCargo= new Retiro("0004", fecha, 10000, false);
        retiroConCargo.calcularCargo();
        assertEquals(100, retiroConCargo.calcularCargo());
        LOG.info("Fin de la prueba unitaria para el metodo calcularCrago() de la clase Retiro pero con cargo");
    }

    //Metodo de la clase: Para el calculo de puntos se usa un 2x100
    @Test 
    @DisplayName("calcularPuntos() debe dar dos puntos por cada 100 del monto del retiro")
    public void testCalcularPntos(){
        LOG.info("Inicio de la prueba que calcula los puntos del retiro (2 por cada 100)");
        Retiro retiroConPuntos= new Retiro("0005", fecha, 400, false);
        retiroConPuntos.calcularPuntos();
        assertEquals(8, retiroConPuntos.calcularPuntos());
        LOG.info("Fin de la prueba que calcula los puntos del retiro (2 por cada 100)");
    }
    

}

