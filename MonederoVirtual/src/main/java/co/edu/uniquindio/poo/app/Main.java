package co.edu.uniquindio.poo.app;


import co.edu.uniquindio.poo.model.*;

import javax.swing.*;
import java.util.Optional;

public class Main {
   // static, la ven todos los métodos de la clase y la pueden modificar dependiendo si por ejemplo ya se inicio sesion
    static Usuario usuarioActual = null;
    static void main() {
        MonederoVirtual monederoVirtual= new MonederoVirtual("MonederoVirtual", "LGJDN04850Ñ");
        Beneficio beneficio100= new Beneficio("Beneficio100", (int)100, "Reducción del 10% en la comision por tranferencias");
        Beneficio beneficio500= new Beneficio("Beneficio500", (int)500, "Un mes sin cargos por retiro");
        Beneficio beneficio1000= new Beneficio("Beneficio1000", (int)1000, "Bono de saldo de 50 unidaddes en el monedero");
        monederoVirtual.crearBeneficios(beneficio100);
        monederoVirtual.crearBeneficios(beneficio500);
        monederoVirtual.crearBeneficios(beneficio1000);

        JOptionPane.showMessageDialog(null,"Bienvendio a Monedero Virtual");

        int opcion;
        do{
            JOptionPane.showMessageDialog(null,"===MENÚ===");
            opcion = Integer.valueOf(JOptionPane.showInputDialog(null,
                    "Por favor seleccione una opcion :\n" +
                            "1. Iniciar Sesion\n" +
                            "2. Registrarse \n"+
                            "0. Salir"));
            switch (opcion){
                case 1:
                    iniciarSesion(monederoVirtual);
                    break;
                case 2:
                    registrarse(monederoVirtual);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias por usar monedero vitual");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
            }
            if(usuarioActual != null) { // entro o se registro y aquí se queda hasta cerrar sesion
                int opcionMenu;
                do {
                    opcionMenu = mostrarMenuCliente(monederoVirtual);
                    switch (opcionMenu) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        case 9:
                            break;
                        case 10:
                            break;
                        case 11:
                            crearOtroMonedero(monederoVirtual);
                            break;
                        case 0:
                            usuarioActual = null; // Aqui se cierra la sesion
                            JOptionPane.showMessageDialog(null, "Adios");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opcion no valida");
                    }
                }while(opcionMenu!=0);
            }
        }while(opcion!=0);

    }
    public static void   iniciarSesion (MonederoVirtual monederoVirtual){
        String documentoIdentidad = JOptionPane.showInputDialog(null, "Ingrese su documento de Indentidad");
        Optional<Usuario> usuarioEncontrado=monederoVirtual.buscarUsuarioDocumentoIdentidad(documentoIdentidad);
        if(usuarioEncontrado.isPresent()){
            Usuario usuario= usuarioEncontrado.get();
            int intento=0;
            while(intento<3 && usuarioActual == null){
                String contraseña = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");
                if(usuario.verificarContraseña(contraseña)){
                    usuarioActual=usuario;
                    break; //Rompe el while cuando se ingrese bien la contraseña y el usuario ingrese
                }else{
                    intento++;
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta, le quedan :"+ (3-intento)+ "intentos");
                }
            }
        }else {
            JOptionPane.showInputDialog(null, "No se encontró usuario con ese documento de identidad");
        }
    }
    public static void   registrarse (MonederoVirtual monederoVirtual){
        String documentoIdentidad= JOptionPane.showInputDialog(null, "Ingrese su documento de Indentidad");
        if (monederoVirtual.buscarUsuarioDocumentoIdentidad(documentoIdentidad).isPresent()) {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese documento");
            return; //No  retorna nada porque es void pero se sale del metodo
        }
        String nombreCompleto= JOptionPane.showInputDialog(null, "Ingrese su nombreCompleto");
        String telefono = JOptionPane.showInputDialog(null, "Ingrese su telefono");
        String correo= JOptionPane.showInputDialog(null, "Ingrese su correo");
        String contraseña= JOptionPane.showInputDialog(null, "cree una contraseña");
        Usuario usuario= new Usuario (documentoIdentidad, nombreCompleto,telefono, correo, contraseña);
        String resultado=monederoVirtual.crearUsuario(usuario);
        JOptionPane.showMessageDialog(null,resultado);
        String codigo;
        boolean existe;
        do {
            codigo = JOptionPane.showInputDialog(null, "Ingrese un código para su monedero:");
            existe = monederoVirtual.verificarCodigoMonederoExiste(codigo);
            if (existe) {
                JOptionPane.showMessageDialog(null, "Ese código ya existe, elija otro");
            }
        } while (existe); //Le pide el codigo al usuario hasta que enucnetre uno que no exista
        monederoVirtual.crearMonedero(usuario, codigo, "PRINCIPAL", TipoMonedero.GASTOS_DIARIOS, 0);
        usuarioActual = usuario; // queda con la sesion iniciada
        JOptionPane.showMessageDialog(null, "Registro exitoso. Bienvenido " + nombreCompleto);
        }
    public static int mostrarMenuCliente (MonederoVirtual monederoVirtual){
        int opcion;
        opcion = Integer.valueOf(JOptionPane.showInputDialog(null,
                "Por favor seleccione una opcion :\n" +
                        "1. Realizar transferencia \n" +
                        "2. Realizar deposito\n \n"+
                        "3. Realizar retiro \n" +
                        "4. Programar transacción \n"+
                        "5. Consultar saldo\n" +
                        "6. Consultar puntos acumulados y rangos \n"+
                        "7. Canjear puntos\n \n"+
                        "8. Consultar historial transacciones\n" +
                        "9. Consular Notificaciones \n"+
                        "10.Consultar reporte gastos \n" +
                        "11.Crear otra monedero \n"+
                        "0. Salir"));
        return opcion;
    }
    public void crearOtroMonedero(MonederoVirtual monederoVirtual){
        String codigo;
        boolean existe;
        do{

        }while()

    }
}
