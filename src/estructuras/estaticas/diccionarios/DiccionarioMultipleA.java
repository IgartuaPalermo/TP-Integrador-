package estructuras.estaticas.diccionarios;

import estructuras.estaticas.conjuntos.ConjuntoA;
import estructuras.tdas.ConjuntoTDA;
import estructuras.tdas.DiccionarioMultipleTDA;

public class DiccionarioMultipleA implements DiccionarioMultipleTDA {
    class Elemento { // Las entradas del diccionario
        int clave;
        int[] valores;
        int cantValores;
    }

    private Elemento[] elementos;
    private int cantClaves;

    public void InicializarDiccionario() {
        elementos = new Elemento[100];
        cantClaves = 0;
    }

    public void Agregar(int clave, int valor) {
        int PosC = Clave2Indice(clave);
        if (PosC == -1) { // La clave no existe
            PosC = cantClaves;
            elementos[PosC] = new Elemento(); // Nueva entrada
            elementos[PosC].clave = clave;
            elementos[PosC].cantValores = 0;
            elementos[PosC].valores = new int[100];
            cantClaves++;
        }
        
        // Elemento e = new Elemento(); // Error
        Elemento e = elementos[PosC];
        int PosV = Valor2Indice(e, valor);
        if (PosV == -1) { // El valor no existe
            e.valores[e.cantValores] = valor;
            e.cantValores++;
        }
    }

    public void Eliminar(int clave) {
        int PosC = Clave2Indice(clave);
        if (PosC != -1) { // La clave existe
            elementos[PosC] = elementos[cantClaves - 1];
            cantClaves--;
        }
    }

    public void EliminarValor(int clave, int valor) {
        int PosC = Clave2Indice(clave);
        if (PosC != -1) { // La clave existe
            Elemento e = elementos[PosC];
            int PosV = Valor2Indice(e, valor);
            if (PosV != -1) { // El valor existe
                e.valores[PosV] = e.valores[e.cantValores - 1];
                e.cantValores--;
            }
            if (e.cantValores == 0) { // Verificación final
                Eliminar(clave); // Se elimina la clave
            }
        }
    }

    private int Clave2Indice(int clave) {
        int i = cantClaves - 1;
        while (i >= 0 && elementos[i].clave != clave)
            i--;
        return i;
    }

    private int Valor2Indice(Elemento e, int valor) {
        int i = e.cantValores - 1;
        while (i >= 0 && e.valores[i] != valor)
            i--;
        return i;
    }

    public ConjuntoTDA Recuperar(int clave) {
        ConjuntoTDA c = new ConjuntoA();
        c.InicializarConjunto();
        int PosC = Clave2Indice(clave);
        if (PosC != -1) { // La clave existe
            Elemento e = elementos[PosC];
            for (int i = 0; i < e.cantValores; i++)
                c.Agregar(e.valores[i]);
        }
        return c;
    }

    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoA();
        c.InicializarConjunto();
        for (int i = 0; i < cantClaves; i++)
            c.Agregar(elementos[i].clave);
        return c;
    }
}
