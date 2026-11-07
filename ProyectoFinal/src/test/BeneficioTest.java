package co.edu.uniquindio.poo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Beneficio;

/**
 * Pruebas unitarias de la clase Beneficio
 * Autores: Mariana Suárez Bran y Laura Camila Bautista 
 * Octubre del 2026
 */
public class BeneficioTest {
    private static final Logger LOG = Logger.getLogger(BeneficioTest.class.getName());
    @Test 
    @DisplayName("Prueba unitaria para el método calcularBeneficio. Debe contener nombre, puntos y descripción del beneficio")
    public void conservarBeneficio(){
        LOG.info("Inicio de la prueba que conserva el beneficio");
        Beneficio beneficio= new Beneficio("Descuento", 100, "10% menos en comisión");
        assertEquals("Descuento", beneficio.getNombre());
        assertEquals(100, beneficio.getPuntosRequeridos());
        assertEquals("10% menos en comisión", beneficio.getDescripcion());
        LOG.info("Fin de la prueba que conserva el beneficio");
    }
}
