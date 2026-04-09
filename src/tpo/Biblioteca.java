package tpo;

public class Biblioteca {
    private DiccionarioSimpleTDA libros;
    private DiccionarioSimpleTDA usuarios;
    private ConjuntoTDA librosDisponibles;

    public cargarLibro(int isbn, String titulo, String autor, int copias){
        tpo.Libro libro = new tpo.Libro(isbn, titulo, autor, copias);
    }
}
