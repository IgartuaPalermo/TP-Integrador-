package estructurasTPO.estaticas.diccionarios.Libros;

import estructurasTPO.dinamicas.ClavesDiccionarios.ConjuntoLD;
import estructurasTPO.tdas.ClavesDiccionarios.ConjuntoTDA;
import estructurasTPO.tdas.Libros.DiccionarioSimpleTDALibros;
import tpo.Libro;

public class DiccionarioSimpleALibros implements DiccionarioSimpleTDALibros {
    private ElementoLibro[] elementos;
    private int cant;

    public void InicializarDiccionario() {
        elementos = new ElementoLibro[100];
        cant = 0;
    }

    public void Agregar(int isbn, Libro libro) {
        int pos = Clave2Ind(isbn);
        if (pos == -1) { // El isbn no existe
            pos = cant; // Nueva entrada
            elementos[pos] = new ElementoLibro();
            elementos[pos].isbn = isbn;
            cant++;
        }
        elementos[pos].libro = libro;
    }

    private int Clave2Ind(int isbn) {
        int i = cant - 1;
        while (i >= 0 && elementos[i].isbn != isbn)
            i--;
        return i;
    }

    public void Eliminar(int isbn) {
        int pos = Clave2Ind(isbn);
        if (pos != -1) { // El isbn existe
            elementos[pos] = elementos[cant - 1];
            cant--;
        }
    }

    public Libro Recuperar(int isbn) {
        int pos = Clave2Ind(isbn);
        return elementos[pos].libro;
    }

    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoLD();
        c.InicializarConjunto();
        for (int i = 0; i < cant; i++)
            c.Agregar(elementos[i].isbn);
        return c;
    }
}
