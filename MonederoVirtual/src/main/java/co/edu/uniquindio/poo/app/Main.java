package co.edu.uniquindio.poo.app;


import co.edu.uniquindio.poo.model.*;

import javax.swing.*;
import java.util.Optional;

public class Main {
    static void main() {
        MonederoVirtual monederoVirtual= new MonederoVirtual("MonederoVirtual", "LGJDN04850Ñ");
        Beneficio beneficio100= new Beneficio("Beneficio100", (int)100, "Reducción del 10% en la comision por tranferencias");
        Beneficio beneficio500= new Beneficio("Beneficio500", (int)500, "Un mes sin cargos por retiro");
        Beneficio beneficio1000= new Beneficio("Beneficio1000", (int)1000, "Bono de saldo de 50 unidaddes en el monedero");
        monederoVirtual.crearBeneficios(beneficio100,beneficio500,beneficio1000);
        JOptionPane.showMessageDialog(null,"Bienvendio a Monedero Virtual");
        Usuario usuarioActual=null;
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
                    String documentoIdentidad = JOptionPane.showInputDialog(null, "Ingrese su documento de Indentidad");
                    Optional<Usuario> clienteEncontrado=monederoVirtual.buscarUsuarioDocumentoIdentidad(documentoIdentidad);
                    if(clienteEncontrado.isPresent()){
                        Usuario usuario =clienteEncontrado.get();
                        int intentos=0;
                        while (intentos < 3 && usuarioActual == null) {
                            String contraseña = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");
                            if(usuario.verificarContraseña(contraseña)){
                                usuarioActual= usuario;
                                break;
                            }else{
                                intentos++;
                                JOptionPane.showMessageDialog(null,
                                        "Contraseña incorrecta. Intentos restantes: " + (3 - intentos));
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,
                                "No se encontro un cliente con ese nombre: ");
                    }
                    break;

                case 2:
                    String documentoIdentidad2 = JOptionPane.showInputDialog(null, "Ingrese su documento de Indentidad");
                    String nombreCompleto2 = JOptionPane.showInputDialog(null, "Ingrese su nombreCompleto");
                    String telefono2 = JOptionPane.showInputDialog(null, "Ingrese su telefono");
                    String correo2 = JOptionPane.showInputDialog(null, "Ingrese su correo");
                    String contraseña = JOptionPane.showInputDialog(null, "cree una contraseña");
                    Usuario usuario = new Usuario(documentoIdentidad2, nombreCompleto2,telefono2, correo2, contraseña);
                    String resultado=monederoVirtual.crearUsuario(usuario);
                    JOptionPane.showMessageDialog(null,resultado);
                    while(usuarioActual==null){
                        String codigo = JOptionPane.showInputDialog(null, "Ingrese un codigo para su monedero:");
                        if(!monederoVirtual.verificarCodigoMonederoExiste(codigo)){
                            Monedero monedero=new Monedero(codigo, "PRINCIPAL",TipoMonedero.GASTOS_DIARIOS, (double) 0);
                        }else{

                        }
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }

        }while(opcion!=0);





    }
}
