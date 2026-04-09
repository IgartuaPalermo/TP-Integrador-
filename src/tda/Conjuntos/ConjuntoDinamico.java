package tda.Conjuntos;

public class ConjuntoDinamico implements ConjuntoTDA {
    private Nodo inicio;

    private class Nodo {
        int dato;
        Nodo sig;
    }

    public void InicializarConjunto() {
        inicio = null;
    }

    public void AgregarElemento(int x) {
        if (!Pertenece(x)) {
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.dato = x;
            nuevoNodo.sig = inicio;
            inicio = nuevoNodo;
        }
    }

    public void EliminarElemento(int x) {
        if (inicio == null) return;

        if (inicio.dato == x) {
            inicio = inicio.sig;
            return;
        }

        Nodo actual = inicio;
        while (actual.sig != null) {
            if (actual.sig.dato == x) {
                actual.sig = actual.sig.sig;
                return;
            }
            actual = actual.sig;
        }
    }

    public boolean Pertenece(int x) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.dato == x) return true;
            actual = actual.sig;
        }
        return false;
    }

    public boolean ConjuntoVacio() {
        return inicio == null;
    }
}
