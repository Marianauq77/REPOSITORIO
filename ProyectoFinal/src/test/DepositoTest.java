package co.edu.uniquindio.poo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Deposito;

/**
 * Pruebas unitarias de la clase Deposito
 * Autores: Mariana Suárez Bran y Laura Camila Bautista 
 * Octubre del 2026
 */

public class DepositoTest {
    private static final Logger LOG = Logger.getLogger(DepositoTest.class.getName());
    private Monedero monedero;
    private LocalDate fecha;

    @BeforeEach
    public void setUp() {
        LOG.info("COnfiguración inicial para las pruebas unitarias de la clase Deposito");
        fecha = LocalDate.now();
        monedero = new Monedero("M001", "Monedero de ahorros", 500000, TipoMonedero.AHORROS);  
    }
    @AfterEach
    public void tearDown() {
        LOG.info("Fin de la prueba unitaria de la clase Deposito");
    }

    //Metodo de la clase
    @Test
    @DisplayName("aplicar() aumenta el saldo del monedero en el monto del depósito")
    public void testAplicar() {
        LOG.info("Inicio de la prueba unitaria para el método aplicar() de la clase Deposito");
        Deposito deposito = new Deposito("0001", LocalDate.now(), 100000);
        deposito.aplicar(monedero);
        assertEquals(600000, monedero.getSaldo());
        LOG.info("Fin de la prueba unitaria para el método aplicar() de la clase Deposito");
    }

    //Metodo de la clase
    @Test 
    @DisplayName("calcularPuntos() devuelve los puntos correctos según el monto del depósito")
    public void testCalcularPuntos() {
        LOG.info("Inicio de la prueba unitaria para el método calcularPuntos() de la clase Deposito");
        Deposito depositoPuntos = new Deposito("0002", LocalDate.now(), 99);
        int puntos = depositoPuntos.calcularPuntos();
        assertEquals(0, puntos);
        LOG.info("Fin de la prueba unitaria para el método calcularPuntos() de la clase Deposito");
    }

    //Aegura que los depositos estén quedando bien guardados y que se marquen como completados
    @Test 
    @DisplayName("El deposito debe conservar sus datos y marcarse como completado")
        public void testDepositoConservarDatos() {
        LOG.info("Inicio de la prueba unitaria para verificar que el depósito conserva sus datos");
        Deposito deposito = new Deposito("0003", LocalDate.now(), 50000);
        assertEquals("0003", deposito.getCodigo());
        assertEquals(LocalDate.now(), deposito.getFecha());
        assertEquals(50000, deposito.getMonto());
        assertEquals(EstadoTransaccion.COMPLETADA, deposito.getEstado());
        LOG.info("Fin de la prueba unitaria para verificar que el depósito conserva sus datos");
    }
}
