package tpo;

public class Usuario {
    int dni;
    String nombre;
    // ConjuntoTDA prestamos;

    public void Usuario(int dni, String nombre){
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
