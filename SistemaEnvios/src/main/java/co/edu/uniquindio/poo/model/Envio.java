package co.edu.uniquindio.poo.model;

public abstract class Envio {
    protected  String codigo;
    protected  String destinatario;
    protected  float peso;

    public Envio(String codigo, String destinatario, float peso) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Envio{" +
                "codigo='" + codigo + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", peso=" + peso +
                '}';
    }

    public abstract float calcularCosto();
}
