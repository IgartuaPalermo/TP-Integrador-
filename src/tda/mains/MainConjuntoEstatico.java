package tda.mains;

import tda.Conjuntos.ConjuntoTDA;
import tda.Conjuntos.ConjuntoEstatico;

public class MainConjuntoEstatico {

    public static void main(String[] args) {
        ConjuntoTDA conjunto1 = new ConjuntoEstatico();

        conjunto1.InicializarConjunto();

        System.out.println(conjunto1.ConjuntoVacio());

        conjunto1.AgregarElemento(5);
        conjunto1.AgregarElemento(10);
        conjunto1.AgregarElemento(15);

        System.out.println(conjunto1.ConjuntoVacio());

        System.out.println(conjunto1.Pertenece(10));

        System.out.println(conjunto1.Pertenece(20));

        conjunto1.EliminarElemento(10);

        System.out.println(conjunto1.Pertenece(10));

    }

}
