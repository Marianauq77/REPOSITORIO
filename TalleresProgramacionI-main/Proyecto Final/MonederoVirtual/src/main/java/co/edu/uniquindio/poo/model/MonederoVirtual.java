package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Optional;
import java.time.LocalDate;      

public class MonederoVirtual {
    private final String nombre;
    private final String nit;
    private ArrayList<Monedero> listaTodosMonederos;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Beneficio> listaBeneficios;
    private int contadorTransacciones;

    public MonederoVirtual(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.listaTodosMonederos = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.listaBeneficios = new ArrayList<>();
        this.contadorTransacciones = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Usuario> getListaClientes() {
        return listaUsuarios;
    }

    public void setListaClientes(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    //CRUD USUARIO
    public String crearUsuario(Usuario usuario) {
        if (buscarUsuarioDocumentoIdentidad(usuario.getDocumentoIdentidad()).isEmpty()) {
            listaUsuarios.add(usuario);
            return "Cliente registrado con exito";
        }
        return "Ya hay un cliente con esa información, por favor verifique el documento de identidad";
    }

    public Optional<Usuario> buscarUsuarioDocumentoIdentidad(String documentoIdentidad) {
        return listaUsuarios.stream().filter(usuario -> documentoIdentidad.equals(usuario.getDocumentoIdentidad())).findFirst();
    }

    public Monedero crearMonedero(Usuario usuario, String codigo, String nombre,
                                  TipoMonedero tipo, double saldo) {
        Monedero monedero = new Monedero(codigo, nombre, saldo, tipo);
        listaTodosMonederos.add(monedero);   // lista de TODOS
        usuario.agregarMonedero(monedero);   // lista de SUS monederos del cliente
        return monedero;
    }
        //CRUD BENEFICIO
        public void crearBeneficios (Beneficio beneficio){
            listaBeneficios.add(beneficio);
        }
        public boolean verificarCodigoMonederoExiste (String codigo){
            for (Monedero aux : listaTodosMonederos) {
                if (codigo.equals(aux.getCodigo())) {
                    return true;
                }
            }  
            return false;
        }
        public Optional<Monedero> buscarMonederoPorCodigo(String codigo){
            return listaTodosMonederos.stream().filter(m-> m.equals(codigo)).findFirst();
        }
        public String transferir( Usuario usuarioActual, Monedero monederoOrigen, double monto, String codigoDestinatario, LocalDate fecha, boolean programada){
            Optional<Monedero> monederoDestinatario= buscarMonederoPorCodigo(codigoDestinatario);
            if(monederoDestinatario.isEmpty()){
                return "No existe un monedero con ese codigo";// Verificar si se puede hacer 
            }
             if(monto<=0){
                 return "El valor a transferir debe ser mayor a 0";
            } 
             
            if (monederoDestinatario.get() == monederoOrigen) {
                 return "No puedes transferir al mismo monedero";

            }
            if(monederoOrigen.getSaldo()<monto+ (monto*0.01)){
                return "Saldo insuficiente para realizar la transferencia";
            }
            
            Monedero monederoDestino=monederoDestinatario.get();

            String codigoTransferencia= generarCodigoTransaccion();
            Transaccion transferencia= new Transferencia(codigoTransferencia, fecha , monto, codigoDestinatario );
            transferencia.aplicar(monederoOrigen);
            boolean atipica=usuarioActual.detectarTransaccionesAtipicas(monto);
            transferencia.setAtipica(atipica);
            //Si la transaccion es programada, no se crea y se descuenta del saldo hasta la fecha acordada
            if(programada){
                 TransaccionProgramada transaccionProgramada = new TransaccionProgramada(codigo,fecha, frecuencia, transferencia, monederoDestino);
                 monedero.agregarTransaccionProgramada(transaccionProgramada);
                 return "La transferencua se programó con éxito.\n "+
                 "El código de esta transacción es: "+codigo+"\n"+
                 "La fecha programada es: "+fecha;
            }
            registrarTransaccion(monederoOrigen, transferencia);
            int puntos=transferencia.calcularPuntos(); 

            Transaccion nuevoDeposito= new Transferencia (generarCodigoTransaccion(), fecha, monto);
            nuevoDeposito.aplicar(monederoDestino);
            registrarTransaccion(monederoDestino, nuevoDeposito);

            usuarioActual.setPuntosAcumulados(usuarioActual.getPuntosAcumulados()+puntos);
            usuarioActual.setRango(); // ya lo cambia con los puntos acumulados
        
            return "La transferencia se realizo con exito, su código es:"+ codigoTransferencia+"\n"+
             "Los puntos que ganó con esta transferencia son: "+puntos;

        }

        public String depositar(Usuario usuarioActual, Monedero monedero, double monto, LocalDate fecha, boolean programada){
            String codigo= generarCodigoTransaccion();
            Transaccion deposito= new Deposito(codigo, fecha , monto);
            boolean atipica=usuarioActual.detectarTransaccionesAtipicas(monto);
            deposito.setAtipica(atipica);
            //Si la transaccion es programada, no se crea y se descuenta del saldo hasta la fecha acordada
            if(programada){
                 TransaccionProgramada transaccionProgramada = new TransaccionProgramada(codigo, fecha, frecuencia, deposito, monedero);
                 monedero.agregarTransaccionProgramada(transaccionProgramada);
                 return "El deposito se programó con éxito.\n "+
                 "El código de esta transacción es: "+codigo+"\n"+
                 "La fecha programada es: "+fecha;
            }
            deposito.aplicar(monedero);
            registrarTransaccion(monedero, deposito);
            int puntos= deposito.calcularPuntos();
            usuarioActual.setPuntosAcumulados(usuarioActual.getPuntosAcumulados()+puntos);
            usuarioActual.setRango(); 
            return "El deposito se realizó con éxito, su código es: "+codigo+" \n"+
            "Los puntos que ganó con esta transacción son: "+puntos;
        }
        public String retirar(Usuario usuarioActual,  Monedero monedero, double monto){
            if(monto<=0){
                return "El valor a retirar debe ser mayor a 0";
            }
            if(monedero.getSaldo()<monto){
                return "Saldo insuficiente para hacer el retiro";
            }
            String codigoRetiro=generarCodigoTransaccion();
            Transaccion retiro= new Retiro (codigoRetiro, LocalDate.now(), monto);
            retiro.aplicar(monedero);
            boolean atipica= usuarioActual.detectarTransaccionesAtipicas(monto);
            retiro.setAtipica(atipica);
            registrarTransaccion(monedero, retiro);

            int puntos=retiro.calcularPuntos();
            usuarioActual.setPuntosAcumulados(usuarioActual.getPuntosAcumulados()+puntos);
            usuarioActual.setRango();

            return "El retiro se realizó con éxito, su código es: "+codigoRetiro+" \n"+
            "Los puntos que ganó con esta transacción son: "+puntos;
        }
       
        //Metodo para agregar cualquier tipo de transaccion a un monedero, ya sea deposito, retiro o transferencia
        public void registrarTransaccion(Monedero monedero,Transaccion transaccion){
            monedero.agregarTransaccion(transaccion); 
        }


        public String generarCodigoTransaccion(){
            contadorTransacciones++;
            return "T" + contadorTransacciones; //genera el codigo solito cada que se va hacer cualquier transaccion
        }

        //Método que busca cuáles transacciones se deben aplicar hoy y las ejecuta de acuerdo a su tipo de transaccion
        public void ejecutarTransaccionesProgramadas(){
            LocalDate hoy= LocalDate.now();
            for(TransaccionProgramada programada: listaTransaccionesProgramadas){
                if(programada.getEstado()== EstadoTransaccion.PENDIENTE && programada.getFechaEjecucion()== hoy){
                     Transaccion transaccion = programada.getTransaccion();
                     if(transaccion instanceof Deposito){
                        deposito.aplicar(programada.getMonedero());
                     }else if(transaccion instanceof Transferencia){
                        transferencia.aplicar(programada.getMonedero());
                    }
                        
                }
            }
        }
        

}

