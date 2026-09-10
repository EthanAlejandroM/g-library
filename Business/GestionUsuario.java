package Business;
import Service.UsuarioDAO;


public class GestionUsuario {

    public String validarDatosBO(UsuarioDAO usuario) {
        
        // 1. Validar que la cédula no esté vacía
        if (usuario.getCedula() == null || usuario.getCedula().trim().isEmpty()) {
            return "La cédula es obligatoria.";
        }

        // 2. Validar que el nombre no esté vacío
        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()) {
            return "El nombre es obligatorio.";
        }

        // 3. Validar el formato/dominio del correo institucional según la subclase (validarCorreo)
        if (!usuario.validarCorreo()) {
            return "El correo no coincide con el dominio institucional requerido.";
        }

        // 4. Validar que el usuario no exista previamente en MySQL (validarExistenciaBO)
        if (validarExistenciaBO(usuario)) {
            return "El correo ingresado ya se encuentra registrado en la base de datos.";
        }

        // Si pasa todas las validaciones sin inconvenientes
        return null;
    }

    public boolean validarExistenciaBO(UsuarioDAO usuario) {
        // Invoca la instrucción técnica de acceso a datos en UsuarioDAO
        return usuario.verificarUserExistenteDAO();
    }
}