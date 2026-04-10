package estructuras.dinamicas.diccionarios;

import estructuras.dinamicas.conjuntos.ConjuntoLD;
import estructuras.tdas.ConjuntoTDA;
import estructuras.tdas.DiccionarioSimpleTDA;

public class DiccionarioSimpleL implements DiccionarioSimpleTDA {
    private class NodoClave { // la célula de la estructura de claves
        int clave; // la clave
        int valor; // el valor
        NodoClave sigClave; // la referencia a la siguiente clave
    }

    private NodoClave origen; // la referencia de la estructura

    public void InicializarDiccionario() {
        origen = null;
    }

    public void Agregar(int clave, int valor) {
        NodoClave nc = Clave2NodoClave(clave);
        if (nc == null) { // la clave no existe
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc; // nuevo origen
        }
        nc.valor = valor;
    }

    private NodoClave Clave2NodoClave(int clave) {
        NodoClave aux = origen; // el nodo viajero
        while (aux != null && aux.clave != clave)
            aux = aux.sigClave;
        return aux;
    }

    public void Eliminar(int clave) {
        if (origen != null) {
            if (origen.clave == clave) { // es el primero
                origen = origen.sigClave;
            } else { // es algún otro
                NodoClave aux = origen; // el nodo viajero
                while (aux.sigClave != null && aux.sigClave.clave != clave)
                    aux = aux.sigClave;
                
                if (aux.sigClave != null)
                    aux.sigClave = aux.sigClave.sigClave;
            }
        }
    }

    public int Recuperar(int clave) {
        NodoClave nc = Clave2NodoClave(clave);
        return nc.valor;
    }

    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoLD();
        c.InicializarConjunto();
        NodoClave aux = origen; // el nodo viajero
        while (aux != null) {
            c.Agregar(aux.clave);
            aux = aux.sigClave;
        }
        return c;
    }
}
