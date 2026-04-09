package tpo;

public class Usuario {
    private int dni;
    private String nombre;
    // ConjuntoTDA prestamos;

    public Usuario(int dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
    }

    public int GetDNI(){
        return dni;
    }

    public String GetNombre(){
        return nombre;
    }

}
