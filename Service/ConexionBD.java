package Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Datos de conexión para XAMPP
    private static final String URL = "jdbc:mysql://localhost:3306/g-library";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // En XAMPP por defecto es vacío

    public static Connection hacerConexion() {
        Connection conexion = null;
        try {
            // Carga automática del Driver mediante DriverManager
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("¡Conexión exitosa a la Base de Datos!");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos de XAMPP: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }

    
    // verificación de conexión
    public static void main(String[] args) {
        Connection cn = hacerConexion();
        
        // Verificar que el objeto no sea nulo y que la conexión siga abierta
        try {
            if (cn != null && !cn.isClosed()) {
                System.out.println(">>> Estado: CONEXIÓN ACTIVA Y FUNCIONANDO CORRECTAMENTE <<<");
                cn.close(); // Buena práctica: cerrar la conexión de prueba
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    
