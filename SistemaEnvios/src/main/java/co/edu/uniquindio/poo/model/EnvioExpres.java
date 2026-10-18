package co.edu.uniquindio.poo.model;

public class EnvioExpres extends EnvioNacional {//hereda de nacional que hereda de envio
    private int cantidadHorasMaximaEntrega;

    public EnvioExpres(String codigo, float peso, float incremento, float valorFijo, String destinatario, String ciudadDestino, boolean entregaDomicilio, int cantidadHorasMaximaEntrega) {
        super(codigo, peso, incremento, valorFijo, destinatario, ciudadDestino, entregaDomicilio);
        this.cantidadHorasMaximaEntrega = cantidadHorasMaximaEntrega;
    }

    @Override
    public float calcularCostoTotal() {
        Float costo = super.calcularCostoTotal(); // es el costo que hereda de nacional, pero se sobre escribe
        if (cantidadHorasMaximaEntrega <= 24) {
            return costo + (costo * 0.3f) + 5000f;
        }
        return costo + (costo * 0.3f);
    }
}
