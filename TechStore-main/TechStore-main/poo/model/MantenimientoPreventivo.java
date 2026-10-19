package co.edu.uniquindio.poo.model;

public class MantenimientoPreventivo extends Servicio{
    private TipoEquipo tipoDispositivoMantenimiento;
    public MantenimientoPreventivo(String codigo,String nombre, String descripcion, TipoEquipo tipoDispositivoMantenimiento) {
        super(codigo, nombre, descripcion, 50000f);
        this.tipoDispositivoMantenimiento = tipoDispositivoMantenimiento;
    }

    @Override
    public float calcularCostoFinal() {
        return 0;
    }

    public TipoEquipo getTipoDispositivoMantenimiento() {
        return tipoDispositivoMantenimiento;
    }

    public void setTipoDispositivoMantenimiento(TipoEquipo tipoDispositivoMantenimiento) {
        this.tipoDispositivoMantenimiento = tipoDispositivoMantenimiento;
    }

    @Override
    public float calcularManoDeObra() {
        return tarifaBase;
    }

    public float calcularCostoFinal() {          // solucion para mantenimiento
        switch (tipoDispositivoMantenimiento) {
            case COMPUTADOR_PORTATIL:
                return 60000f;
            case COMPUTADOR_ESCRITORIO:
                return 70000f;
            case TELEFONO_INTELIGENTE:
                return 40000f;
            default:
                return 0f;
        }
    }
}

