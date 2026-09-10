package Service;

public class EstudianteDAO extends UsuarioDAO {
    private String codigoEstudiante;
    private String programa;

    // Constructor
    public EstudianteDAO(int id, String nombre, String correo, String cedula, String telefono, String codigoEstudiante, String programa) {
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
    
}
