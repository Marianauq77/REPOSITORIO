package co.edu.uniquindio.poo.model;

public class EnvioInternacional extends Envio {
    private String paisDestino;
    private boolean necesitaSeguro;

    public EnvioInternacional(String codigo, String destinatario, float peso, String paisDestino, boolean necesitaSeguro) {
        super(codigo, destinatario, peso);
        this.paisDestino = paisDestino;
        this.necesitaSeguro = necesitaSeguro;
    }

    @Override
    public float calcularCosto() {
            if(necesitaSeguro) {
                return 15000f + (9000f *peso)+2000f;
            }
            return 15000f + (9000f *peso);
        }
}
