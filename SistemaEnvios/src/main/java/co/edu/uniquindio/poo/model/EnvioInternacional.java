package co.edu.uniquindio.poo.model;

public class EnvioInternacional extends Envio {
    private String paisDestino;
    private boolean necesitaSeguro;

    public EnvioInternacional(String codigo, float peso, float incremento, float valorFijo, String destinatario, String paisDestino, boolean necesitaSeguro) {
        super(codigo, peso, incremento, valorFijo, destinatario);
        this.paisDestino = paisDestino;
        this.necesitaSeguro = necesitaSeguro;
    }

    @Override
    public float calcularCostoTotal() {
        float costo= calcularCostoFijo();
            if(necesitaSeguro) {
                return costo+=20000f;
            }
            return costo;
        }
}
