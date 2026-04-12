package tpo;

import estructurasTPO.dinamicas.ClavesDiccionarios.ConjuntoLD;
import estructurasTPO.tdas.ClavesDiccionarios.ConjuntoTDA;

public class Usuario {
    private int dni;
    private String nombre;
    private String apellido;
    private ConjuntoTDA prestamosActivos;

    // CONSTRUCTOR
    public Usuario(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.prestamosActivos = new ConjuntoLD();
        this.prestamosActivos.InicializarConjunto();
    }

    // GETTERS Y SETTERS
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ConjuntoTDA getPrestamosActivos() {
        return prestamosActivos;
    }

    // METODOS
    public void agregarPrestamo(int isbn) {
        this.prestamosActivos.Agregar(isbn);
    }

    public void quitarPrestamo(int isbn) {
        this.prestamosActivos.Sacar(isbn);
    }
    
    public boolean tieneElLibro(int isbn) {
        return this.prestamosActivos.Pertenece(isbn);
    }

}
