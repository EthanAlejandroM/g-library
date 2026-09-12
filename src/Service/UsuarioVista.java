package Service;

public class UsuarioVista {

    private int id;
    private String nombre;
    private String correo;
    private String cedula;
    private String telefono;
    private String tipo;
    private String codigo;
    private String detalle;

    public UsuarioVista(int id, String nombre, String correo, String cedula,
            String telefono, String tipo, String codigo, String detalle) {

        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.cedula = cedula;
        this.telefono = telefono;
        this.tipo = tipo;
        this.codigo = codigo;
        this.detalle = detalle;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDetalle() {
        return detalle;
    }
}