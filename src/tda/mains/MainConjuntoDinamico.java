package tda.mains;

import tda.conjuntos.ConjuntoDinamico;
import tda.conjuntos.ConjuntoTDA;

public class MainConjuntoDinamico {

    public static void main(String[] args) {
        ConjuntoTDA conjunto2 = new ConjuntoDinamico();

        conjunto2.InicializarConjunto();

        System.out.println(conjunto2.ConjuntoVacio());

        conjunto2.AgregarElemento(5);
        conjunto2.AgregarElemento(10);
        conjunto2.AgregarElemento(15);

        System.out.println(conjunto2.ConjuntoVacio());

        System.out.println(conjunto2.Pertenece(10));

        System.out.println(conjunto2.Pertenece(20));

        conjunto2.EliminarElemento(10);

        System.out.println(conjunto2.Pertenece(10));

    }

}
