package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Deposito extends Transaccion{
    public Deposito(String codigo, LocalDate fecha, double monto){ //Parametros al crear el objeto
        super(codigo, fecha, monto); // llama al constructor de transaccion
    }

    @Override
    public void aplicar() {

    }

    @Override
    public int calcularPuntos() {
        return 0;
    }

    @Override
    public void determinarAtipica() {

    }
}
