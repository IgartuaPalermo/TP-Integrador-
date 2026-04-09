package tda.diccionarios;

import tpo.Usuario;

public class DiccionarioUsuarioEstatico implements DiccionarioUsuarioTDA {
    private int[] claves;
    private Usuario[] valores;
    private int cantidad;

    public void InicializarDiccionario() {
        claves = new int[100];
        valores = new Usuario[100];
        cantidad = 0;
    }

    public void Agregar(int dni, Usuario usuario) {
        if (!Existe(dni)) {
            claves[cantidad] = dni;
            valores[cantidad] = usuario;
            cantidad++;
        }
    }

    public void Eliminar(int dni) {
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == dni) {
                for (int j = i; j < cantidad - 1; j++) {
                    claves[j] = claves[j + 1];
                    valores[j] = valores[j + 1];
                }
                cantidad--;
                return;
            }
        }
    }

    public Usuario Recuperar(int dni) {
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == dni) {
                return valores[i];
            }
        }
        return null;
    }

    public boolean Existe(int dni) {
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == dni) return true;
        }
        return false;
    }

    public boolean DiccionarioVacio() {
        return cantidad == 0;
    }
}
