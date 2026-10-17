package co.edu.uniquindio.poo.model;

public class EnvioNacional extends Envio {
    private String ciudadDestino;
    private boolean entregaDomicilio;

    public EnvioNacional(String codigo, String destinatario, float peso, String ciudadDestino, boolean entregaDomicilio) {
        super(codigo, destinatario, peso);
        this.ciudadDestino = ciudadDestino;
        this.entregaDomicilio = entregaDomicilio;
    }

    @Override
    public float calcularCosto() {
        if(entregaDomicilio) {
            return 6000f + (2000f *peso)+3000f;
        }
        return 6000f + (2000f *peso);
    }
}
