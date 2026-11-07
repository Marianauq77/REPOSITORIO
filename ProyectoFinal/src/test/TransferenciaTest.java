package co.edu.uniquindio.poo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Transferencia;

/**
 * Pruebas unitarias de la clase Transferencia
 * Autores: Mariana Suárez Bran y Laura Camila Bautista 
 * Octubre del 2026
 */

public class TransferenciaTest {
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
    @DisplayName("aplicarComision() cobra el 1% si no tiene descuento")
    public void testAplicarComisionSinDescuento() {
        LOG.info("Inicio de la prueba para aplicarComision() de la clase Transferencia sin descuento");
        Transferencia transferencia = new Transferencia("0002", fecha, 10000, "M002", false);
        assertEquals(100, transferencia.aplicarComision());
        LOG.info("Fin de la prueba para aplicarComision() de la clase Transferencia sin descuento");
    }

    //Metodo de la clase
    @Test
    @DisplayName("aplicarComision() cobra el 1% y luego aplica el descuento del 10% si tiene descuento")
    public void testAplicarComisionConDescuento() {
        LOG.info("Inicio de la prueba para aplicarComision() de la clase Transferencia con descuento");
        Transferencia transferencia= new Transferencia("0003", fecha, 100000, "M003", true);
        assertEquals(900, transferencia.aplicarComision());
        LOG.info("Fin de la prueba aplicarComision() pero con descuento");
    }

    //Metodo de la clase 
    @Test 
    @DisplayName("aplicar() debe descontar del monedero y cobrar la comisión")
    public void testAplicarMenosMontoYComision(){
        LOG.info("Inicio de la prueba aplicar() para descontar saldo y la comision");
        Transferencia transferencia= new Transferencia("0004", fecha, 10000, "M004", false);
        transferencia.aplicar(monedero);
        //Saldo del monedero (500000)- monto(10000)- comision 1% (100)= 489900
        assertEquals(489900, monedero.getSaldo());
        LOG.info("Fin de la prueba aplicar() que descuenta el saldo y la comisión");
    }

    //Metodo de la clase 
    @Test 
    @DisplayName("aplicar() debe descontar del monedero y cobrar la comisión pero esta vez con el descuento")
    public void testAplicarMenosMontoYDescuentoComision(){
        LOG.info("Inicio de la prueba aplicar() para descontar saldo y la comision con el descuento");
        Transferencia transferencia= new Transferencia("0005", fecha, 100000, "M005", true);
        transferencia.aplicar(monedero);
        //Saldo del monedero (500000)- monto(100000)- (comision 1% (1000)- descuento de la comisión 10% (100))= 399100
        assertEquals(399100, monedero.getSaldo());
        LOG.info("Fin de la prueba aplicar() que descuenta el saldo y la comisión con descuento");
    }

    //Metodo de la clase 
    @Test 
    @DisplayName("calcularPuntos() debe dar 3 puntos por cada 100 monedas")
    public void testCalcularPuntos(){
        LOG.info("Inicio de la prueba calcularPuntos() que debe dar 3 puntos por cada 100 monedas");
        Transferencia transferencia= new Transferencia("0006", fecha, 300, "M006", false);
        assertEquals(9, transferencia.calcularPuntos());
        LOG.info("Fin de la prueba calcularPuntos() que da 3 por cada 100");
    }

    //Correcto guardado de la información
    @Test 
    @DisplayName("La transferencia debe guardar los datos correctamente")
    public void testGuardadoDeInfo(){
        LOG.info("Inicio de la prueba que permite verificar el guardado de la información/objeto");
        Transferencia transferencia= new Transferencia("0007", fecha, 300, "M007", false);
        assertEquals("0007", transferencia.getCodigo());
        assertEquals(fecha, transferencia.getFecha());
        assertEquals(300, transferencia.getMonto());
        assertEquals("M007", transferencia.getDestino());
        LOG.info("Fin de la prueba que permite verificar el guardado de la información");
    }

}
