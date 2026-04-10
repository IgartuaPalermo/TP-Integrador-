package estructuras.mains;

import estructuras.estaticas.conjuntos.ConjuntoEstatico;
import estructuras.tdas.ConjuntoTDA;

public class MainConjuntoEstatico {

    public static void main(String[] args) {
        ConjuntoTDA conjunto1 = new ConjuntoEstatico();

        conjunto1.InicializarConjunto();

        System.out.println(conjunto1.ConjuntoVacio());

        conjunto1.Agregar(5);
        conjunto1.Agregar(10);
        conjunto1.Agregar(15);

        System.out.println(conjunto1.ConjuntoVacio());

        System.out.println(conjunto1.Pertenece(10));

        System.out.println(conjunto1.Pertenece(20));

        conjunto1.Sacar(10);

        System.out.println(conjunto1.Pertenece(10));

    }

}
