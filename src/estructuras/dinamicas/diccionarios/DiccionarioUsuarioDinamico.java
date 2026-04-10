package estructuras.dinamicas.diccionarios;

import estructuras.tdas.DiccionarioUsuarioTDA;
import tpo.Usuario;

public class DiccionarioUsuarioDinamico implements DiccionarioUsuarioTDA {
    private Nodo inicio;

    private class Nodo {
        int dni;
        Usuario usuario;
        Nodo sig;
    }

    public void InicializarDiccionario() {
        inicio = null;
    }

    public void Agregar(int dni, Usuario usuario) {
        if (!Existe(dni)) {
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.dni = dni;
            nuevoNodo.usuario = usuario;
            nuevoNodo.sig = inicio;
            inicio = nuevoNodo;
        }
    }

    public void Eliminar(int dni) {
        if (inicio == null) return;

        if (inicio.dni == dni) {
            inicio = inicio.sig;
            return;
        }

        Nodo actual = inicio;
        while (actual.sig != null) {
            if (actual.sig.dni == dni) {
                actual.sig = actual.sig.sig;
                return;
            }
            actual = actual.sig;
        }
    }

    public Usuario Recuperar(int dni) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.dni == dni) {
                return actual.usuario;
            }
            actual = actual.sig;
        }
        return null;
    }

    public boolean Existe(int dni) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.dni == dni) return true;
            actual = actual.sig;
        }
        return false;
    }

    public boolean DiccionarioVacio() {
        return inicio == null;
    }
}
