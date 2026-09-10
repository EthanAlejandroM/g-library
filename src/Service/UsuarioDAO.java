package src.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UsuarioDAO {
    private int id;
    private String nombre;
    private String correo;
    private String cedula;
    private String telefono;


    //metodo constructor 
    public UsuarioDAO(int id, String nombre, String correo, String cedula, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.cedula = cedula;
        this.telefono = telefono;
    }


    //getters y setters
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getCedula() {
        return cedula;
    }


    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //metodo abstracto para validar correo institucional
    public abstract boolean validarCorreo();



    // Método para verificar si el usuario ya existe en la base de datos

    public boolean verificarUserExistenteDAO() {
        boolean existe = false;
        String sql = "SELECT COUNT(*) FROM usuarios WHERE correo = ?";

        try (Connection cn = ConexionBD.hacerConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, this.getCorreo());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    existe = rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error SQL al verificar existencia: " + e.getMessage());
        }
        return existe;
    }
}
