package tpo;

public class Biblioteca {

    public cargarLibro(int isbn, String titulo, String autor, int copias){
        tpo.Libro libro = new tpo.Libro(isbn, titulo, autor, copias);
    }
}
