package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.*;

public class Tienda {
    private final String nombre;
    private final String nit;
    private String telefono;
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final List<Factura> listaFacturas = new LinkedList<>();
    private Map<String, Producto> listaProductos = new HashMap<>();

    public Tienda(String nombre, String nit, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    // CRUDS
    public String registrarCliente(Cliente cliente) { //Desde el main pide la info, lo crea y lo pasa aca para registrarlo
        Optional<Cliente> clienteEncontrado = buscarCliente(cliente.getDocumentoIdentidad());
        if (clienteEncontrado.isEmpty()) { //is.Empty() para la condicion
            listaClientes.add(cliente);
            return "El cliente fue registrado exitosamente";
        } else return "No se puede registrar, ya existe un cliente con esa informacion registrado anteriormente.";
    }

    public Optional<Cliente> buscarCliente(String documentoIdentidad) { //Devuelve un Optional, si no hay nada lo devuelve vacio
        return listaClientes.stream().filter(cliente -> documentoIdentidad.equals(cliente.getDocumentoIdentidad())).findFirst();
        //Automaticamente en el Optional pone el cliente si lo encuentra
    }

    public String registrarFactura(Factura factura) { //Desde el main pide la info, lo crea y lo pasa aca para registrarlo
        Optional<Factura> facturaEncontrada = buscarFactura(factura.codigo());
        if (facturaEncontrada.isEmpty()) {
            listaFacturas.add(factura);
            return "La factura fue registrada existosamente";
        } else return "No se puede registrar, ya existe una factura con esa informacion registrada anteiormente.";
    }

    public Optional<Factura> buscarFactura(String codigo) { //Devuelve un Optional, si no hay nada lo devuelve vacio
        return listaFacturas.stream().filter(factura -> codigo.equals(factura.codigo())).findFirst();//para acceder a un atributo de record es .condigo sin get
        // es mejor comparar primero el parametro
    }

    public String agregarDetalleAFactura(String codigoFactura, DetalleFactura detalle) { //Cuando la factura ya este agregada, la busca para meterle el detalle factura
        Optional<Factura> facturaEncontrada = buscarFactura(codigoFactura);

        if (facturaEncontrada.isPresent()) {
            facturaEncontrada.get().agregarDetalleFactura(detalle); // La factura se encarga de su lista
            return "Detalle factura agregado con éxito";
        }

        return "No se encontró la factura";
    }

    public Optional<DetalleFactura> buscarDetalleEnFactura(String codigoFactura, String codigoProducto) {
        Optional<Factura> facturaEncontrada = buscarFactura(codigoFactura);

        if (facturaEncontrada.isPresent()) {
            // Le pide a la factura encontrada que busque en su propia lista
            return facturaEncontrada.get().buscarDetalle(codigoProducto);
        }

        return Optional.empty(); // No existe la factura, así que no hay detalle
    }

    public String registrarProducto(Producto producto) { //Desde el main pide la info, lo crea y lo pasa aca para registrarlo
        Optional<Producto> productoEncontrado = buscarProducto(producto.getCodigo());
        if (productoEncontrado.isEmpty()) {
            listaProductos.put(producto.getCodigo(), producto);
            return "El producto fue registrada existosamente";
        } else return "No se puede registrar, ya existe un producto con esa informacion registrado anteiormente.";
    }

    public Optional<Producto> buscarProducto(String codigo) { //Devuelve un Optional, si no hay nada lo devuelve vacio
        return Optional.ofNullable(listaProductos.get(codigo));
    }

    public String actualizarNombreCliente(String documentoIdentidad, String nombreCompletoNuevo) {
        Optional<Cliente> clienteEncontrado = buscarCliente(documentoIdentidad);
        if (clienteEncontrado.isPresent()) {
            clienteEncontrado.get().setNombreCompleto(nombreCompletoNuevo); //hay que sacar el optional de la cajita primero con .get() para aplicarle el metodo set al cliente escontrado
            return "El nombre fue actualizado de manera exitosa";
        }
        return "No existe un cliente registrado con ese documento";
    }

    //Obtener los productos con una cantidad disponible mayor o igual a 10
    public List<Producto> obetenrProductosMayora10() {
        List<Producto> resultado = new ArrayList<>();
        for (Producto aux : listaProductos.values()) {
            if (aux.getCantidadDisponible() >= 10) {
                resultado.add(aux);
            }
        }
        return resultado;
    }

    //2. Obtener los productos agotados
    public ArrayList<String> obtenerCodigosProductosAgotados2(int limiteInferior, int limiteSuperior) {
        ArrayList<String> resultado = new ArrayList<>();
        for (Producto aux : listaProductos.values()) {
            if (aux.getCantidadDisponible() >= 10 && aux.getCantidadDisponible() < 50) {
                resultado.add(aux.getCodigo());
            }
        }
        return resultado;
    }

    // Obtener clientes que compraron el 07 de octubre
    public ArrayList<Cliente> obtenerClientesCompras() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        LocalDate fechaBuscada = LocalDate.of(2026, 10, 7);
        for (Factura aux : listaFacturas) {
            if (aux.fecha().isEqual(fechaBuscada)) {
                listaClientes.add(aux.cliente());
            }
        }
        return listaClientes;
    }

    //4. Obtern las facturas que tenga un cliente donde su nombre empiece con R
    public ArrayList<Factura> obtenerFacturasClienteConR() {
        ArrayList<Factura> resultado = new ArrayList<>();

        for (Factura aux : listaFacturas) {
            if (aux.tieneClienteConR()) {
                resultado.add(aux);
            }
        }

        return resultado;
    }

    //5. Ontener las faturas donde se haya comprado  un celular de marca 16 pro max
    public ArrayList<Factura> obtenerFacturasIphone16ProMax() {
        ArrayList<Factura> resultado = new ArrayList<>();
        for (Factura aux : listaFacturas) {
            if (aux.tieneProductoIphone16ProMax()) {
                resultado.add(aux);
            }
        }
        return resultado;
    }

    //6. Ontener las faturas que tengan un cliente Juan y donde se haya comprado  un celular de marca 16 pro max
    public ArrayList<Factura> obtenerFacturasJuanYIphone16ProMax() {
        ArrayList<Factura> resultado = new ArrayList<>();
        for (Factura aux : listaFacturas) {
            if (aux.tieneProductoIphone16ProMax() && aux.tieneClienteJuan()) {
                resultado.add(aux);
            }
        }
        return resultado;
    }

    //7. implementar un metodo que reciba una categoria y retone todos los productos registrados que pertenezcan a ella
    public ArrayList<Producto> obtenerProductosCategoriaBuscada(Categoria categoriaBuscada) {
        ArrayList<Producto> resultado = new ArrayList<>();
        for (Producto aux : listaProductos.values()) {
            if (aux.tieneCatgoriaBuscada(categoriaBuscada)) {
                resultado.add(aux);
            }
        }
        return resultado;
    }
    //8. Implementar un metodo que reciba un precio minimo y un precio maximo y que retorne los productos que se encuentren en ese rango
    public ArrayList<Producto> obtenerProductosRangoBuscado(double precioMin, double precioMax) {
        ArrayList<Producto> resultado = new ArrayList<>();
        for (Producto aux : listaProductos.values()) {
            if (aux.estaEnElRango(precioMin, precioMax)) {
                resultado.add(aux);
            }
        }
        return resultado;
    }
}



