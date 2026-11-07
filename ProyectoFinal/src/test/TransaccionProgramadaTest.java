package co.edu.uniquindio.poo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.TransaccionProgramada;

/**
 * Pruebas unitarias de la clase Transferencia
 * Autores: Mariana Suárez Bran y Laura Camila Bautista 
 * Octubre del 2026
 */
public class TransaccionProgramadaTest {
    private Monedero monedero;
    private Transaccion deposito;
    private LocalDate fecha;
    private TransaccionProgramada programada;

    @BeforeEach
    public void setUp() {
        LOG.info("Inicio de configuración de TransaccionProgramadaTest...");
        fecha = LocalDate.of(2026, 11, 2);
        monedero = new Monedero("M001", "Ahorros", 50000, TipoMonedero.AHORROS);
        deposito = new Deposito("T1", fecha, 10000);
        programada = new TransaccionProgramada("TP1", fecha, Frecuencia.DIARIA, deposito, monedero);
    }

    //Estados de la transacción
    @Test
    @DisplayName("El estado de una transacción programada nueva queda pendiente")
    public void testVerificarEstadoPendiente(){
        LOG.info("Inicio de la prueba que verifica si el estado está pendiente");
        assertEquals(EstadoTransaccion.PENDIENTE, programada.getEstado());
        LOG.info("Fin de la prueba que verifica si el estado está pendiente");
    }

    //Guardado de la información
    @Test 
    @DisplayName("Los datos de la transacción programada se conservan correctamente")
    public void testConservarDatos(){
        LOG.info("Inicio de la prueba que verifica si los datos se guardan correctamente");
        assertEquals("TP1", programada.getCodigo());
        assertEquals(fecha, programada.getFechaEjecucion());
        assertEquals(Frecuencia.DIARIA, programada.getFrencuenciaProgramada());
        assertEquals(deposito, programada.getTransaccion());
        assertEquals(monedero, programada.getMonedero());
        LOG.info("Fin de la prueba que verifica si los datos se guardan correctamente");
    }

    //Setters
    @Test 
    @DisplayName("Los estados del set se actualizan correctamente")
    public void testActualizarSettersYGetters(){
        LOG.info("Inicio de la prueba que verifica que los estados de los sets se actualicen correctamente al programar la próxima transacción");
        LocalDate nuevaFecha= fecha.plusMonths(1);
        programada.setFechaEjecucion(nuevaFecha);
        programada.setFrencuenciaProgramada(Frecuencia.MENSUAL);
        programada.setEstado(EstadoTransaccion.COMPLETADA);
        assertEquals(nuevaFecha, programada.getFechaEjecucion());
        assertEquals(Frecuencia.MENSUAL, programada.getFrencuenciaProgramada());
        assertEquals(EstadoTransaccion.COMPLETADA);
        LOG.info("Fin de la prueba que verifica que los sets se actualicen correctamente");
    }
}
