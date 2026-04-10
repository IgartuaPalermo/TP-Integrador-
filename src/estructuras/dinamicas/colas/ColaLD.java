package estructuras.dinamicas.colas;

import estructuras.tdas.ColaTDA;

public class ColaLD implements ColaTDA {
    class Nodo { // la célula de la estructura
        int info; // el valor almacenado
        Nodo sig; // la referencia al siguiente nodo
    }

    Nodo primero; // primer elemento (más antiguo)
    Nodo ultimo; // último elemento (más reciente)

    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    public void Acolar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.sig = null;
        if (ultimo != null) // cola no vacía
            ultimo.sig = nuevo;
        ultimo = nuevo;
        if (primero == null) // la cola estaba vacía
            primero = ultimo;
    }

    public void Desacolar() {
        primero = primero.sig; // nueva referencia a la estructura
        if (primero == null) // la cola quedó vacía
            ultimo = null;
    }

    public boolean ColaVacia() {
        return (ultimo == null);
    }

    public int Primero() {
        return primero.info;
    }
}
