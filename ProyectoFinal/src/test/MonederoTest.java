package co.edu.uniquindio.poo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Monedero;

/**
 * Pruebas unitarias de la clase Transferencia
 * Autores: Mariana Suárez Bran y Laura Camila Bautista 
 * Octubre del 2026
 */
public class MonederoTest {
    private static final Logger LOG = Logger.getLogger(MonederoTest.class.getName());
    private Monedero monedero;
    private LocalDate fecha;

    @BeforeEach
    public void setUp() {
        LOG.info("Inicio de configuración de MonederoTest...");
        fecha = LocalDate.of(2026, 11, 2);
        // Se crea sin usuario para que no intente mostrar notificaciones con JOptionPane.
        monedero = new Monedero("M001", "Ahorros", 50000, TipoMonedero.AHORROS);
    }

    @AfterEach
    public void tearDown() {
        LOG.info("Fin de la prueba de Monedero...");
    }

    //Guardado de la información
    @Test
    @DisplayName("Los datos del monedero se guardan correctamente")
    public void testGuardarDatos(){
        LOG.info("Inicio de la prueba que verifica si los datos se están guardando correctamente");
        assertEquals("M001", monedero.getCodigo());
        assertEquals("Ahorros", monedero.getNombre());
        assertEquals(50000, monedero.getSaldo());
        assertEquals(TipoMonedero.AHORROS, monedero.getTipoMonedero());
        LOG.info("Fin de la prueba que verifica si los datos se están guardando correctamente");
    }

    //Verificar que sí haga los setSaldo
    @Test 
    @DisplayName("setSaldo() cambia el saldo del monedero")
    public void testCambiarSaldo(){
        LOG.info("Inicio de la prueba que cambia el saldo del monedero");
        monedero.setSaldo(250000);
        assertEquals(25000, monedero.getSaldo());
        LOG.info("Fin de la prueba que cambia el saldo del monedero");
    }

    @Test
    @DisplayName("aplicarBeneficio1000() debe sumar 50 al saldo")
    public void testAplicarBeneficio(){
        LOG.info("Inicio de la prueba que aplica el beneficio");
        monedero.aplicarbeneficio1000();
        assertEquals(50050, monedero.getSaldo());
        LOG.info("Fin de la prueba que aplica el beneficio");
    }
     @Test
    @DisplayName("agregarTransaccion() guarda la transacción en la lista")
    public void agregarTransaccion() {
        LOG.info("Inicio de prueba agregarTransaccion...");
        Deposito deposito = new Deposito("T1", fecha, 10000);
        monedero.agregarTransaccion(deposito);
        assertEquals(1, monedero.getListaTransacciones().size());
        assertEquals("T1", monedero.getListaTransacciones().get(0).getCodigo());
        LOG.info("Fin de prueba agregarTransaccion...");
    }

    @Test
    @DisplayName("agregarTransaccionProgramada() guarda la transacción programada")
    public void agregarTransaccionProgramada() {
        LOG.info("Inicio de prueba agregarTransaccionProgramada...");
        Deposito deposito = new Deposito("T1", fecha, 10000);
        TransaccionProgramada programada = new TransaccionProgramada("TP1", fecha, Frecuencia.DIARIA, deposito, monedero);
        monedero.agregarTransaccionProgramada(programada);
        assertEquals(1, monedero.getListaTransaccionesProgramadas().size());
        assertEquals("TP1", monedero.getListaTransaccionesProgramadas().get(0).getCodigo());
        LOG.info("Fin de prueba agregarTransaccionProgramada...");
    }

    @Test
    @DisplayName("verificarSaldoBajo() no falla cuando no hay observadores")
    public void verificarSaldoBajoSinObservadores() {
        LOG.info("Inicio de prueba verificarSaldoBajoSinObservadores...");
        Monedero monederoSinUsuario = new Monedero("M002", "Ahorros", 5000, TipoMonedero.AHORROS);
        assertDoesNotThrow(monederoSinUsuario::verificarSaldoBajo);
        assertEquals(5000.0, monederoSinUsuario.getSaldo(), 0.001);
        LOG.info("Fin de prueba verificarSaldoBajoSinObservadores...");
    }

    @Test
    @DisplayName("recordarTransaccionesProgramadas() no falla con fechas lejanas")
    public void recordarTransaccionesLejanasNoFalla() {
        LOG.info("Inicio de prueba recordarTransaccionesLejanasNoFalla...");
        Deposito deposito = new Deposito("T1", fecha, 10000);
        TransaccionProgramada programada = new TransaccionProgramada(
                "TP1", LocalDate.now().plusDays(10), Frecuencia.DIARIA, deposito, monedero);
        monedero.agregarTransaccionProgramada(programada);
        assertDoesNotThrow(() -> monedero.recordarTransaccionesProgramadas(
                monedero.getListaTransaccionesProgramadas(), LocalDate.now(), 3));
        LOG.info("Fin de prueba recordarTransaccionesLejanasNoFalla...");
    }
}
