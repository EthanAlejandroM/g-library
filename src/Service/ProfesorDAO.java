package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesorDAO extends UsuarioDAO {

    // atributos propios de la clase hija
    private String codigoProfesor;
    private String departamento;

    // metodo constructor
    public ProfesorDAO(int id, String nombre, String correo, String cedula, String telefono, String codigoProfesor,
            String departamento) {
        super(id, nombre, correo, cedula, telefono);
        this.codigoProfesor = codigoProfesor;
        this.departamento = departamento;
    }

    // getters y setters
    public String getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(String codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // sobrescribimos el metodo absatracto de la clase padre
    @Override
    public boolean validarCorreo() {
        String correoVeri = getCorreo();

        if (correoVeri == null || correoVeri.trim().isEmpty()) {
            return false;
        }
        // Convierte a minúsculas para evitar fallos si escriben en mayúsculas
        return correoVeri.toLowerCase().endsWith("@profesor.uniajc.edu.co");
    }

    // metodo para registrar a un profesor en la base de datos
    public boolean registrarProfesor() {

        String sqlUsuario = "INSERT INTO usuario (nombre, correo, cedula, telefono) VALUES (?, ?, ?, ?)";
        String sqlProfesor = "INSERT INTO profesor (id_usuario, codigoProfesor, departamento) VALUES (?, ?, ?)";

        Connection cn = null;

        try {
            cn = ConexionBD.hacerConexion();

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

            // Obtener el ID generado
            java.sql.ResultSet rs = psUsuario.getGeneratedKeys();

            if (rs.next()) {

                int idUsuario = rs.getInt(1);

                // 2. Registrar los datos específicos del profesor
                PreparedStatement psProfesor = cn.prepareStatement(sqlProfesor);

                psProfesor.setInt(1, idUsuario);
                psProfesor.setString(2, getCodigoProfesor());
                psProfesor.setString(3, getDepartamento());

                psProfesor.executeUpdate();

                // Confirmar ambos registros
                cn.commit();

                // Guardar el ID en el objeto
                setId(idUsuario);

                return true;
            }

            cn.rollback();

        } catch (SQLException e) {

            try {
                if (cn != null) {
                    cn.rollback();
                }
            } catch (SQLException error) {
                System.out.println(
                        "Error al cancelar el registro: "
                                + error.getMessage());
            }

            System.out.println(
                    "Error al registrar profesor: "
                            + e.getMessage());

        } finally {

            try {
                if (cn != null) {
                    cn.setAutoCommit(true);
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println(
                        "Error al cerrar la conexión: "
                                + e.getMessage());
            }
        }

        return false;
    }
}
