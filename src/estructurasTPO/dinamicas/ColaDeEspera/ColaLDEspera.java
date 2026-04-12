package estructurasTPO.dinamicas.ColaDeEspera;

import estructurasTPO.tdas.ColaDeEspera.ColaTDAEspera;

public class ColaLDEspera implements ColaTDAEspera {
    class Nodo { // la célula de la estructura
        int dni; // el valor almacenado
        Nodo sig; // la referencia al siguiente nodo
    }

    Nodo primero; // primer elemento (más antiguo)
    Nodo ultimo; // último elemento (más reciente)

    public void InicializarCola() {
        primero = null;
        ultimo = null;
    }

    public void Acolar(int dni) {
        Nodo nuevo = new Nodo();
        nuevo.dni = dni;
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
        return primero.dni;
    }
}
