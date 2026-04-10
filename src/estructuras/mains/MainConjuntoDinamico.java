package estructuras.mains;

import estructuras.dinamicas.conjuntos.ConjuntoLD;
import estructuras.tdas.ConjuntoTDA;

public class MainConjuntoDinamico {

    public static void main(String[] args) {
        ConjuntoTDA conjunto2 = new ConjuntoLD();

        conjunto2.InicializarConjunto();

        System.out.println(conjunto2.ConjuntoVacio());

        conjunto2.Agregar(5);
        conjunto2.Agregar(10);
        conjunto2.Agregar(15);

        System.out.println(conjunto2.ConjuntoVacio());

        System.out.println(conjunto2.Pertenece(10));

        System.out.println(conjunto2.Pertenece(20));

        conjunto2.Sacar(10);

        System.out.println(conjunto2.Pertenece(10));

    }

}
