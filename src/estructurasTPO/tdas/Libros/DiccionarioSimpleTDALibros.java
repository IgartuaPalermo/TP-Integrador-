package estructurasTPO.tdas.Libros;

import estructurasTPO.tdas.ClavesDiccionarios.ConjuntoTDA;
import tpo.Libro;

public interface DiccionarioSimpleTDALibros {
    void InicializarDiccionario(); // pre: no aplica.
    void Agregar(int isbn, Libro libro); // pre: diccionario inicializado.
    void Eliminar(int isbn); // pre: diccionario inicializado.
    Libro Recuperar(int isbn); // pre: diccionario inicializado y clave existente.
    ConjuntoTDA Claves(); // pre: diccionario inicializado.
}
