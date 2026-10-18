package co.edu.uniquindio.poo.model;

public class EnvioNacional extends Envio {
    private String ciudadDestino;
    private boolean entregaDomicilio;

    public EnvioNacional(String codigo, float peso, float incremento, float valorFijo, String destinatario, String ciudadDestino, boolean entregaDomicilio) {
        super(codigo, peso, incremento, valorFijo, destinatario);
        this.ciudadDestino = ciudadDestino;
        this.entregaDomicilio = entregaDomicilio;
    }

    @Override
    public float calcularCostoTotal() {
        float costo=calcularCostoFijo();
        if(entregaDomicilio) {
            return costo+=3000f;
        }
        return costo;
    }
}
