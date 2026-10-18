package co.edu.uniquindio.poo.model;

public abstract class Envio {
    protected  String codigo;
    protected  float peso;
    protected float incremento;
    protected float valorFijo;
    protected  String destinatario;

    public Envio(String codigo, float peso, float incremento, float valorFijo, String destinatario) {
        this.codigo = codigo;
        this.peso = peso;
        this.incremento = incremento;
        this.valorFijo = valorFijo;
        this.destinatario = destinatario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getIncremento() {
        return incremento;
    }

    public void setIncremento(float incremento) {
        this.incremento = incremento;
    }

    public float getValorFijo() {
        return valorFijo;
    }

    public void setValorFijo(float valorFijo) {
        this.valorFijo = valorFijo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "Envio{" +
                "codigo='" + codigo + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", peso=" + peso +
                '}';
    }

    public  float calcularCostoFijo(){
        return valorFijo + (peso*incremento);
    }
    public abstract float calcularCostoTotal();
}
