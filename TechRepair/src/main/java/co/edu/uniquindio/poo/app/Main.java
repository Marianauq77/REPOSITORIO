package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import javax.swing.*;
import java.util.Optional;

public class Main {
    static void main() {
        EmpresaTechRepair empresaTechRepair = new EmpresaTechRepair("TechRepair", "901.234.567-8", "389 843 8738", "Calle 15 N° 23 - 45, Armenia, Quindío");
        // crear repuestos
        int opcion;
        do {
            JOptionPane.showMessageDialog(null, "===MENÚ===\n");
            opcion = Integer.valueOf(JOptionPane.showInputDialog(null,
                    "Por favor seleccione una opcion :\n" +
                            "1. Registrar cliente\n" +
                            "2. Registrar equipo\n" +
                            "3. Registrar técnico\n" +
                            "4. Registrar repuesto\n" +
                            "5. Crear orden de servicio\n" +
                            "6. Agregar detalle a una orden\n" +
                            "7. Asignar técnico\n" +
                            "8. Registrar repuestos utilizados\n" +
                            "9. Calcular valor de un detalle\n" +
                            "10. Calcular valor total de la orden\n" +
                            "11. Actualizar estado de un detalle\n" +
                            "12. Finalizar una orden\n" +
                            "13. Consultar órdenes de un cliente\n" +
                            "14. Consultar trabajos de un técnico\n" +
                            "15. Consultar equipos pendientes\n" +
                            "16. Generar reporte de servicios\n" +
                            "17. Generar reporte de técnicos\n" +
                            "18. Consultar inventario crítico\n" +
                            "19. Slir del sistema"));
            switch (opcion) {
                case 1:
                    registrarCliente(empresaTechRepair);
                    break;
                case 2:
                    registrarEquipo(empresaTechRepair);
                    break;
                case 3:
                    registrarTecnico(empresaTechRepair);
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
                    break;
                case 12:
                    break;
                case 13:
                    consultarOrdenesCliente(empresaTechRepair);
                    break;
                case 14:
                    consultarTrabajosTecnico(empresaTechRepair);
                    break;
                case 15:
                    consultarEquiposPendientes(empresaTechRepair);
                    break;
                case 16:
                    generarReporteServicios(empresaTechRepair);
                    break;
                case 17:
                    generarReporteTecnicos(empresaTechRepair);
                    break;
                case 18:
                    consultarInventarioCritico(empresaTechRepair);
                    break;
                case 19:
                    break;
            }

        } while (opcion != 19);
    }

    public static void registrarCliente(EmpresaTechRepair empresaTechRepair) {
        String documento = JOptionPane.showInputDialog("Ingrese el docuemnto de identidad del cliente:");
        String nombreCompleto = JOptionPane.showInputDialog("Ingrese el nombre completo del cliente:");
        String telefono = JOptionPane.showInputDialog("Ingrese el telefono  del cliente:");
        String correo = JOptionPane.showInputDialog("Ingrese el correo  del cliente:");
        String direccion = JOptionPane.showInputDialog("Ingrese la direccion del cliente:");
        Cliente clienteNuevo = new Cliente(documento, nombreCompleto, telefono, correo, direccion, empresaTechRepair);
        String resultado = empresaTechRepair.registrarCliente(clienteNuevo);
        JOptionPane.showMessageDialog(null, resultado);
    }

    public static void registrarEquipo(EmpresaTechRepair empresaTechRepair) {
        String documento = JOptionPane.showInputDialog("Ingrese el docuemento de identidad del cliente al cual pertene el equipo que desa registrar:");
        Optional<Cliente> clienteEncontrado = empresaTechRepair.buscarClientePorDocumento(documento);
        if (clienteEncontrado.isPresent()) {
            Cliente cliente = clienteEncontrado.get();
            String codigo = JOptionPane.showInputDialog("Ingrese el código del equipo:");
            String numeroSerie = JOptionPane.showInputDialog("Ingrese el número de serie:");
            String marca = JOptionPane.showInputDialog("Ingrese la marca:");
            String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
            String añoFabricacion = JOptionPane.showInputDialog("Ingrese el año de fabricación:");
            String descripcionEstadoFisico = JOptionPane.showInputDialog("Describa el estado físico del equipo:");
            String ingresoTipoEquipo = JOptionPane.showInputDialog("Ingrese el tipo de equipo que desea registrar:\n" +
                                                                   "COMPUTADOR_PORTATIL\n" +
                                                                   "COMPUTADOR_ESCRITORIO\n" +
                                                                   "TELEFONO_INTELIGENTE:");
            TipoEquipo tipoEquipo = TipoEquipo.valueOf(ingresoTipoEquipo.toUpperCase());
            if (tipoEquipo == TipoEquipo.COMPUTADOR_PORTATIL) {
                float pantallaPulgadas = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el tamaño de pantalla en pulgadas:"));
                int ramGB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de RAM en GB:"));
                int almacenamientoGB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de almacenamiento en GB:"));
                int ingresoBateriaExtraible = JOptionPane.showConfirmDialog(null, "¿El equipo tiene batería extraíble?"); //Muestra opciones si/no y recibe numeros, donde si=0 y  no=1
                boolean bateriaExtraible = (ingresoBateriaExtraible == JOptionPane.YES_OPTION); //determina el bboleano comparando los numeros
                Equipo nuevoEquipo = new ComputadorPortatil(codigo, numeroSerie, marca, modelo, añoFabricacion, descripcionEstadoFisico, pantallaPulgadas, ramGB, almacenamientoGB, bateriaExtraible);
                String resultado = empresaTechRepair.registrarEquipo(cliente, nuevoEquipo);
                JOptionPane.showMessageDialog(null, resultado);
            }
            else if (tipoEquipo == TipoEquipo.COMPUTADOR_ESCRITORIO) {
                String procesador = JOptionPane.showInputDialog("Ingrese el tipo de procesador:");
                int ramGB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de RAM en GB:"));
                int almacenamientoGB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de almacenamiento en GB:"));
                int ingresoGraficaDedicada = JOptionPane.showConfirmDialog(null, "¿El equipo posee tarjeta gráfica dedicada?");
                boolean graficaDedicada = (ingresoGraficaDedicada == JOptionPane.YES_OPTION);
                Equipo nuevoEquipo = new ComputadorEscritorio(codigo, numeroSerie, marca, modelo, añoFabricacion, descripcionEstadoFisico, procesador, ramGB, almacenamientoGB, graficaDedicada);
                String resultado = empresaTechRepair.registrarEquipo(cliente, nuevoEquipo);
                JOptionPane.showMessageDialog(null, resultado);
            }
            else if   (tipoEquipo == TipoEquipo.TELEFONO_INTELIGENTE) {
                String sistemaOperativo = JOptionPane.showInputDialog("Ingrese el sistema operativo:");
                int almacenamientoGB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de almacenamiento en GB:"));
                int bateriaMah = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de la batería en mAh:"));
                int ingresoCompatible5G = JOptionPane.showConfirmDialog(null, "¿El teléfono es compatible con tecnología 5G?");
                boolean compatible5G = (ingresoCompatible5G == JOptionPane.YES_OPTION);
                Equipo nuevoEquipo = new TelefonoInteligente(codigo, numeroSerie, marca, modelo, añoFabricacion, descripcionEstadoFisico, sistemaOperativo,  almacenamientoGB, bateriaMah, compatible5G );
                String resultado = empresaTechRepair.registrarEquipo(cliente, nuevoEquipo);
                JOptionPane.showMessageDialog(null, resultado);

            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay ningun cliente registrado con ese documento");
        }
    }
    public static void registrarTecnico(EmpresaTechRepair empresaTechRepair){
        String codigo = JOptionPane.showInputDialog("Ingrese el codigo del tecnico:");
        String documento = JOptionPane.showInputDialog("Ingrese el docuemnto de identidad del tecnico:");
        String nombreCompleto = JOptionPane.showInputDialog("Ingrese el nombre completo del tecnico:");
        String ingresoEspecialidad = JOptionPane.showInputDialog("Ingrese la especialidad del tecnico:"+
                                                                 "COMPUTADORES\n" +
                                                                 "DISPOSITIVOS_MOVILES\n" +
                                                                 "SOPORTE_GENERAL");
        Especialidad especialidad= Especialidad.valueOf(ingresoEspecialidad);
        String ingresoEstadoLaboral = JOptionPane.showInputDialog("Ingrese la especialidad del tecnico:"+
                                                                  "ACTIVO\n" +
                                                                  "INACTIVO");
        EstadoLaboral estadoLaboral= EstadoLaboral.valueOf(ingresoEstadoLaboral);
        Tecnico tecnicoNuevo = new Tecnico(codigo,documento, nombreCompleto, especialidad,estadoLaboral, empresaTechRepair);
        String resultado = empresaTechRepair.registrarTecnico(tecnicoNuevo);
        JOptionPane.showMessageDialog(null, resultado);
    }
    public static void consultarOrdenesCliente(EmpresaTechRepair empresaTechRepair){
        String documento = JOptionPane.showInputDialog("Ingrese el docuemento del cliente al cual desea consultar las ordenes:");
        Optional<Cliente> clienteEncontrado = empresaTechRepair.buscarClientePorDocumento(documento);
        if(clienteEncontrado.isPresent()){
            Cliente cliente=clienteEncontrado.get();
            String resultado=cliente.consultarOrdenes();
            JOptionPane.showMessageDialog(null, resultado);
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro un cliente con ese documento de identidad");
        }
    }
    public static void consultarTrabajosTecnico (EmpresaTechRepair empresaTechRepair){
        String documento = JOptionPane.showInputDialog("Ingrese el docuemento del técnico al cual desea consulatr los trabajos:");
        Optional<Tecnico> tecnicoEncontrado = empresaTechRepair.buscarTecnicoPorDocumento(documento);
        if(tecnicoEncontrado.isPresent()){
           Tecnico tecnico=tecnicoEncontrado.get();
            String resultado=tecnico.consultarTrabajos();
            JOptionPane.showMessageDialog(null, resultado);
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro un técnico con ese documento de identidad");
        }
    }
    public static void consultarEquiposPendientes (EmpresaTechRepair empresaTechRepair){
        String resultado= empresaTechRepair.consultarEquiposPendientes();
        JOptionPane.showMessageDialog(null, resultado);
    }
    public static void generarReporteServicios (EmpresaTechRepair empresaTechRepair){
        String resultado= empresaTechRepair.generarReporteServicios();
        JOptionPane.showMessageDialog(null, resultado);
    }
    public static void generarReporteTecnicos(EmpresaTechRepair empresaTechRepair){
        String resultado= empresaTechRepair.generarReporteTecnicos();
        JOptionPane.showMessageDialog(null, resultado);
    }
    public static void consultarInventarioCritico(EmpresaTechRepair empresaTechRepair){
        String resultado= empresaTechRepair.consultarInvetarioCritico();
        JOptionPane.showMessageDialog(null, resultado);
    }
}