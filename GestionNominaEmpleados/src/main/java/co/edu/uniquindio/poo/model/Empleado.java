package co.edu.uniquindio.poo.model;

public abstract class Empleado {
    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected CategoriaEmpleado categoria;
    protected float descuentoSalud;
    protected float descuentoPension;

    public Empleado(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension) {
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor a 0.");
        }
        if (salarioBase < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo.");
        }
        if (descuentoSalud < 0 || descuentoSalud > 100) {
            throw new IllegalArgumentException("El porcentaje de salud debe estar entre 0 y 100.");
        }
        if (descuentoPension < 0 || descuentoPension > 100) {
            throw new IllegalArgumentException("El porcentaje de pensión debe estar entre 0 y 100.");
        }
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.categoria = categoria;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public CategoriaEmpleado getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEmpleado categoria) {
        this.categoria = categoria;
    }

    public float getDescuentoSalud() {
        return descuentoSalud;
    }

    public void setDescuentoSalud(float descuentoSalud) {
        this.descuentoSalud = descuentoSalud;
    }

    public float getDescuentoPension() {
        return descuentoPension;
    }

    public void setDescuentoPension(float descuentoPension) {
        this.descuentoPension = descuentoPension;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", edad=" + edad +
                ", salarioBase=" + salarioBase +
                ", categoria=" + categoria +
                ", descuentoSalud=" + descuentoSalud +
                ", descuentoPension=" + descuentoPension +
                '}';
    }

    public abstract float calcularSalarioBruto();
    public float calcularBonificacionCategoria(){
        float resultado=0;
        if(this.categoria==CategoriaEmpleado.JUNIOR){
            resultado= salarioBase*0.05f;
        }
        if(this.categoria==CategoriaEmpleado.SEMI_SENIOR){
            resultado=salarioBase*0.1f;
        }
        if(this.categoria==CategoriaEmpleado.SENIOR){
            resultado= salarioBase*0.15f;
        }
        return resultado;
    }
    public void calcularDescuentos(){
    }
    public void calcularSalarioNeto(){
    }
    public void mostrarInformacion(){
    }
    public  abstract ResumenPago generarResumenPago();

}
