package clases;


public class mdUsuario {
    //atributos
    private long idTelegram;
    private String nombre;
    private String correo;

    //constructor
    public String getCorreo() {
        return correo;
    }

    //getters y setters
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdTelegram() {
        return idTelegram;
    }

    public void setIdTelegram(long idTelegram) {
        this.idTelegram = idTelegram;
    }
}
