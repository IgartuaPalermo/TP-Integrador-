package estructuras.dinamicas.conjuntos;

import estructuras.tdas.ConjuntoTDA;

public class ConjuntoLD implements ConjuntoTDA {
    private Nodo primero;

    private class Nodo {
        int info;
        Nodo sig;
    }

    public void InicializarConjunto() {
        primero = null;
    }

    public void Agregar(int x) {
        if (!Pertenece(x)) {
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            nuevo.sig = primero;
            primero = nuevo;
        }
    }

    public int Elegir() {
        return primero.info;
    }

    public boolean ConjuntoVacio() {
        return primero == null;
    }

    public void Sacar(int x) {
        if (primero == null) return;

        if (primero.info == x) {
            primero = primero.sig;
            return;
        }

        Nodo aux = primero;
        while (aux.sig != null) {
            if (aux.sig.info == x) {
                aux.sig = aux.sig.sig;
                return;
            }
            aux = aux.sig;
        }
    }

    public boolean Pertenece(int x) {
        Nodo aux = primero;
        while (aux != null) {
            if (aux.info == x) return true;
            aux = aux.sig;
        }
        return false;
    }

    

    
}
