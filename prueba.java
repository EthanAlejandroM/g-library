import Service.EstudianteDAO;
import Business.GestionUsuario;
import Service.ProfesorDAO;
import Service.UsuarioDAO;

public class prueba {

    public static void main(String[] args) {

        // Crear objeto estudiante
        UsuarioDAO estudiante = new EstudianteDAO(
                1,
                "Nicolle Mera",
                "nicolle@tyrtu.uniajc.edu.co",  // muestra que no se cumple con el correo 
                "123456789",
                "3001234567",
                "20250001",
                "Ingeniería de Sistemas"
        );

        // Crear objeto profesor
        UsuarioDAO profesor = new ProfesorDAO(
                2,
                "Carlos Perez",
                "carlos@profesor.uniajc.edu.co",
                "987654321",
                "3109876543",
                "PROF001",
                "Ingeniería de Sistemas"
        );

        // Crear objeto para gestionar las validaciones
        GestionUsuario gestion = new GestionUsuario();

        // Probar estudiante
        System.out.println("===== VALIDACIÓN DEL ESTUDIANTE =====");

        String resultadoEstudiante = gestion.validarDatosBO(estudiante);

        if (resultadoEstudiante == null) {
            System.out.println("El estudiante cumple con todas las validaciones.");
        } else {
            System.out.println("Error: " + resultadoEstudiante);
        }


        // Probar profesor
        System.out.println("\n===== VALIDACIÓN DEL PROFESOR =====");

        String resultadoProfesor = gestion.validarDatosBO(profesor);

        if (resultadoProfesor == null) {
            System.out.println("El profesor cumple con todas las validaciones.");
        } else {
            System.out.println("Error: " + resultadoProfesor);
        }
    }
}