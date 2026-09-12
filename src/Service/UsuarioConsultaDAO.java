package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioConsultaDAO {

    public List<UsuarioVista> obtenerUsuarios() {

        List<UsuarioVista> usuarios = new ArrayList<>();

        String sql = """
                SELECT
                    u.id,
                    u.nombre,
                    u.correo,
                    u.cedula,
                    u.telefono,
                    'Estudiante' AS tipo,
                    e.codigoEstudiante AS codigo,
                    e.programa AS detalle
                FROM usuario u
                INNER JOIN estudiante e ON u.id = e.id_usuario

                UNION ALL

                SELECT
                    u.id,
                    u.nombre,
                    u.correo,
                    u.cedula,
                    u.telefono,
                    'Profesor' AS tipo,
                    p.codigoProfesor AS codigo,
                    p.departamento AS detalle
                FROM usuario u
                INNER JOIN profesor p ON u.id = p.id_usuario

                ORDER BY id
                """;

        try (Connection cn = ConexionBD.hacerConexion();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                UsuarioVista usuario = new UsuarioVista(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("cedula"),
                        rs.getString("telefono"),
                        rs.getString("tipo"),
                        rs.getString("codigo"),
                        rs.getString("detalle"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al consultar usuarios: " + e.getMessage());
        }

        return usuarios;
    }
}
