package tpo;

public class Usuario {
    private int dni;
    private String nombre;

    public Usuario(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public int GetDni() {
        return dni;
    }

    public String GetNombre() {
        return nombre;
    }
}
