package tpo;

import estructurasTPO.dinamicas.ColaDeEspera.ColaLDEspera;
import estructurasTPO.tdas.ColaDeEspera.ColaTDAEspera;

public class Libro {
    private int isbn;
    private String titulo;
    private String autor;
    private int copiasDisponibles;
    private ColaTDAEspera colaDeEspera;

    // CONSTRUCTOR
    public Libro(int isbn, String titulo, String autor, int copiasDisponibles) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.copiasDisponibles = copiasDisponibles;
        this.colaDeEspera = new ColaLDEspera();
        this.colaDeEspera.InicializarCola();
    }

    // GETTERS Y SETTERS
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

    public ColaTDAEspera getColaDeEspera() {
        return colaDeEspera;
    }

    // METODOS
    public boolean hayCopias() {
        return this.copiasDisponibles > 0;
    }

    public void aumentarCopias() {
        this.copiasDisponibles++;
    }

    public void disminuirCopias() {
        if (hayCopias()) {
            this.copiasDisponibles--;
        } else {
            System.out.println("Error: No hay copias disponibles para disminuir.");
        }
    }

}
