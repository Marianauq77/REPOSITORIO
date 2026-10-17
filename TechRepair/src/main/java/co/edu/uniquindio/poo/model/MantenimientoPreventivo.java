package co.edu.uniquindio.poo.model;

public class MantenimientoPreventivo extends Servicio{
    private String dispositivoMantenimiento;

    public MantenimientoPreventivo(String codigo, String nombre, String descripcion, String dispositivoMantenimiento) {
        super(codigo, nombre, descripcion, 50000f);
        this.dispositivoMantenimiento = dispositivoMantenimiento;
    }

    @Override
    public float calcularCostoFinal() {
        return 0;
    }
}
