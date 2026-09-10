package src.Service;

public class ProfesorDAO extends UsuarioDAO {

    //atributos propios de la clase hija
    private String codigoProfesor;
    private String departamento;

    //metodo constructor
    public ProfesorDAO(int id, String nombre, String correo, String cedula, String telefono, String codigoProfesor, String departamento) {
        super(id, nombre, correo, cedula, telefono);
        this.codigoProfesor = codigoProfesor;
        this.departamento = departamento;
    }


    //getters y setters
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

    
    //sobrescribimos el metodo absatracto de la clase padre
    @Override
    public boolean validarCorreo() {
        String correoVeri = getCorreo();

        if (correoVeri == null || correoVeri.trim().isEmpty()) {
            return false;
        }
        // Convierte a minúsculas para evitar fallos si escriben en mayúsculas
        return correoVeri.toLowerCase().endsWith("@profesor.uniajc.edu.co");
    } 
}
    

