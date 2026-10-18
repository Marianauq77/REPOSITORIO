package co.edu.uniquindio.poo.app;


import co.edu.uniquindio.poo.model.*;

import javax.swing.*;

import java.util.Optional;

import static java.lang.Integer.parseInt;

public class Main {
    static void main() {
        EmpresaEnvios empresaEnvios= new EmpresaEnvios("Envios mensajeria");
        int opcion=0;
        do {
            opcion = parseInt(JOptionPane.showInputDialog("Bienveido al Sistema de Envios\n" +
                    "Seleccione una opcion:\n" +
                    "===MENÚ==\n" +
                    "1.Agregar envio nacional\n" +
                    "2.Agregar envio internacional\n" +
                    "3.Agregar envio express\n" +
                    "4.Mostrar envioMas caro\n"+
                    "5.Salir del sistema\n" ));
            switch (opcion){
                case 1:
                    registrarEnvioNacional(empresaEnvios);
                    break;
                case 2:
                    registrarEnvioInternacional(empresaEnvios);
                    break;
                case 3:
                    registrarEnvioExpres(empresaEnvios);
                    break;
                case 4:
                    mostrarEnvioMasCaro(empresaEnvios);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema de envios");
                    break;
                default:


            }
        }while(opcion!=5);
    }
    public static void registrarEnvioNacional(EmpresaEnvios empresaEnvios) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del envío:");
        float peso = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el peso del envío (en kg):"));
        float incremento = 2000; //Son valores fijos del enunciado establecidos por cada envio
        float valorFijo =6000;
        String destinatario = JOptionPane.showInputDialog("Ingrese el nombre del destinatario:");
        String ciudadDestino = JOptionPane.showInputDialog("Ingrese la ciudad de destino:");

        int respuestaDomicilio = JOptionPane.showConfirmDialog(null, "¿El envío incluye entrega a domicilio?");
        boolean entregaDomicilio = (respuestaDomicilio == JOptionPane.YES_OPTION);

        Envio nuevoEnvio = new EnvioNacional(codigo,peso, incremento, valorFijo,destinatario,ciudadDestino, entregaDomicilio);
        String resultado = empresaEnvios.registrarEnvio(nuevoEnvio);
        JOptionPane.showMessageDialog(null, resultado);
        if (resultado.equals("Se registro exitosamente el envio")) {
            JOptionPane.showMessageDialog(null, "El costo  de el envio es:" + nuevoEnvio.calcularCostoTotal());
        }
    }

    public static void registrarEnvioInternacional(EmpresaEnvios empresaEnvios) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del envío:");
        float peso = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el peso del envío (en kg):"));
        float incremento =9000;
        float valorFijo =15000;
        String destinatario = JOptionPane.showInputDialog("Ingrese el nombre del destinatario:");
        String paisDestino = JOptionPane.showInputDialog("Ingrese el país de destino:");

        int respuestaSeguro = JOptionPane.showConfirmDialog(null, "¿El envío requiere seguro internacional?");
        boolean necesitaSeguro = (respuestaSeguro == JOptionPane.YES_OPTION);

        Envio nuevoEnvio = new EnvioInternacional(codigo, peso, incremento, valorFijo, destinatario, paisDestino, necesitaSeguro);
        String resultado = empresaEnvios.registrarEnvio(nuevoEnvio);
        JOptionPane.showMessageDialog(null, resultado);
        if (resultado.equals("Se registro exitosamente el envio")) {
            JOptionPane.showMessageDialog(null, "El costo  de el envio es:" + nuevoEnvio.calcularCostoTotal());
        }
    }

    public static void registrarEnvioExpres(EmpresaEnvios empresaEnvios) {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del envío:");
        float peso = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el peso del envío (en kg):"));
        float incremento = 2000;
        float valorFijo = 6000;
        String destinatario = JOptionPane.showInputDialog("Ingrese el nombre del destinatario:");
        String ciudadDestino = JOptionPane.showInputDialog("Ingrese la ciudad de destino:");

        // Ajusta la clase y parámetros según tu implementación de EnvioExpress
        int respuestaDomicilio = JOptionPane.showConfirmDialog(null, "¿El envío incluye entrega a domicilio?");
        boolean entregaDomicilio = (respuestaDomicilio == JOptionPane.YES_OPTION);
        int cantidadHorasMaxima=Integer.parseInt(JOptionPane.showInputDialog("Ingrese ela cantidad de horas maxima para la entrega"));

        Envio nuevoEnvio = new EnvioExpres(codigo, peso, incremento, valorFijo, destinatario, ciudadDestino, entregaDomicilio, cantidadHorasMaxima);
        String resultado = empresaEnvios.registrarEnvio(nuevoEnvio);
        JOptionPane.showMessageDialog(null, resultado);
        if (resultado.equals("Se registro exitosamente el envio")) {
            JOptionPane.showMessageDialog(null, "El costo  de el envio es:" + nuevoEnvio.calcularCostoTotal());
        }
    }

    public static void mostrarEnvioMasCaro(EmpresaEnvios empresaEnvios) {
        Optional<Envio> EnvioMasCaroEncontrado=empresaEnvios.encontrarEnvioMasCaro();
        if(EnvioMasCaroEncontrado.isPresent()){
            Envio envioMasCaro=EnvioMasCaroEncontrado.get();
            JOptionPane.showMessageDialog(null, envioMasCaro.toString());
        }else{
            JOptionPane.showMessageDialog(null, "No hay envios regsitrados todavia");
        }
    }
}
