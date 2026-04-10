package tda.conjuntos;

public class ConjuntoEstatico implements ConjuntoTDA {
    private int[] elementos;
    private int cantidad;

    public void InicializarConjunto() {
        elementos = new int[100];
        cantidad = 0;
    }

    public void AgregarElemento(int x) {
        if (!Pertenece(x)) {
            elementos[cantidad] = x;
            cantidad++;
        }
    }

    public void EliminarElemento(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                for (int j = i; j < cantidad - 1; j++) {
                    elementos[j] = elementos[j + 1];
                }
                cantidad--;
                return;
            }
        }
    }

    public boolean Pertenece(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) return true;
        }
        return false;
    }

    public boolean ConjuntoVacio() {
        return cantidad == 0;
    }
}
