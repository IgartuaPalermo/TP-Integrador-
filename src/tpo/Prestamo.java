package tpo;

import java.time.LocalDateTime;

public class Prestamo {
    private int id;
    private boolean activo;
    private Usuario usuario;
    private Libro libro;
    private LocalDateTime fecha;

    // CONSTRUCTOR
    public Prestamo(int id, Usuario usuario, Libro libro) {
        this.id = id;
        this.activo = true;
        this.usuario = usuario;
        this.libro = libro;
        this.fecha = LocalDateTime.now();
    }

    // GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


}
