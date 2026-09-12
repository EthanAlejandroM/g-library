package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EstudianteDAO extends UsuarioDAO {
    private String codigoEstudiante;
    private String programa;

    // Constructor
    public EstudianteDAO(int id, String nombre, String correo, String cedula, String telefono, String codigoEstudiante,
            String programa) {
        super(id, nombre, correo, cedula, telefono);
        this.codigoEstudiante = codigoEstudiante;
        this.programa = programa;
    }

    // Getters y Setters
    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    // Método para validar el correo electrónico del estudiante
    public boolean validarCorreo() {
        // Validar que el correo contenga el dominio de la universidad
        return getCorreo().endsWith("@estudiante.uniajc.edu.co");
    }

    // Método para registrar el estudiante en la base de datos
    public boolean registrarEstudiante() {

        String sqlUsuario = "INSERT INTO usuario (nombre, correo, cedula, telefono) VALUES (?, ?, ?, ?)";
        String sqlEstudiante = "INSERT INTO estudiante (id_usuario, codigoEstudiante, programa) VALUES (?, ?, ?)";

        Connection cn = null;

        try {
            cn = ConexionBD.hacerConexion();

            // Desactivar confirmación automática
            cn.setAutoCommit(false);

            // 1. Registrar los datos generales del usuario
            PreparedStatement psUsuario = cn.prepareStatement(
                    sqlUsuario,
                    java.sql.Statement.RETURN_GENERATED_KEYS);

            psUsuario.setString(1, getNombre());
            psUsuario.setString(2, getCorreo());
            psUsuario.setString(3, getCedula());
            psUsuario.setString(4, getTelefono());

            psUsuario.executeUpdate();

            // Obtener el ID generado automáticamente
            java.sql.ResultSet rs = psUsuario.getGeneratedKeys();

            if (rs.next()) {
                int idUsuario = rs.getInt(1);

                // 2. Registrar los datos específicos del estudiante
                PreparedStatement psEstudiante = cn.prepareStatement(sqlEstudiante);

                psEstudiante.setInt(1, idUsuario);
                psEstudiante.setString(2, getCodigoEstudiante());
                psEstudiante.setString(3, getPrograma());

                psEstudiante.executeUpdate();

                // Confirmar los dos registros
                cn.commit();

                // Guardar el ID generado en el objeto
                setId(idUsuario);

                return true;
            }

            // Si no se obtuvo el ID, cancelar
            cn.rollback();

        } catch (SQLException e) {

            try {
                if (cn != null) {
                    cn.rollback();
                }
            } catch (SQLException error) {
                System.out.println("Error al cancelar el registro: " + error.getMessage());
            }

            System.out.println("Error al registrar estudiante: " + e.getMessage());

        } finally {

            try {
                if (cn != null) {
                    cn.setAutoCommit(true);
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return false;
    }

}
