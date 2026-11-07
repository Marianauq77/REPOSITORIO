package co.edu.uniquindio.poo.monederovirtualjfx.controller;

import co.edu.uniquindio.poo.monederovirtualjfx.model.MonederoVirtual;
import co.edu.uniquindio.poo.monederovirtualjfx.model.TipoMonedero;
import co.edu.uniquindio.poo.monederovirtualjfx.model.Usuario;

import java.util.Optional;

/**
 * Contiene las operaciones de inicio de sesión y registro.
 * La vista solo se encarga de leer los campos y mostrar los mensajes.
 */
public class InicioSesionRegistroController {

    private final MonederoVirtual monederoVirtual;

    public InicioSesionRegistroController(MonederoVirtual monederoVirtual) {
        this.monederoVirtual = monederoVirtual;
    }

    public Optional<Usuario> buscarUsuario(String documentoIdentidad) {
        return monederoVirtual.buscarUsuarioDocumentoIdentidad(documentoIdentidad);
    }

    public boolean existeUsuario(String documentoIdentidad) {
        return buscarUsuario(documentoIdentidad).isPresent();
    }

    public boolean verificarContrasenia(Usuario usuario, String contrasenia) {
        return usuario.verificarContraseña(contrasenia);
    }

    public Optional<Usuario> iniciarSesion(String documentoIdentidad, String contrasenia) {
        Optional<Usuario> usuario = buscarUsuario(documentoIdentidad);
        if (usuario.isPresent() && verificarContrasenia(usuario.get(), contrasenia)) {
            return usuario;
        }
        return Optional.empty();
    }

    public boolean existeCodigoMonedero(String codigo) {
        return monederoVirtual.verificarCodigoMonederoExiste(codigo);
    }

    /**
     * Crea el usuario y su monedero principal.
     *
     * @return el usuario creado o null si el documento o el código de monedero ya existen.
     */
    public Usuario registrarUsuario(String documentoIdentidad, String nombreCompleto, String telefono,
                                    String correo, String contrasenia, String codigoMonedero) {
        if (existeUsuario(documentoIdentidad) || existeCodigoMonedero(codigoMonedero)) {
            return null;
        }

        Usuario usuario = new Usuario(documentoIdentidad, nombreCompleto, telefono, correo, contrasenia);
        monederoVirtual.crearUsuario(usuario);
        monederoVirtual.crearMonedero(usuario, codigoMonedero, "PRINCIPAL", TipoMonedero.GASTOS_DIARIOS, 0);
        return usuario;
    }
}
