package estructuras.mains;

import estructuras.estaticas.colas.ColaPU;
import estructuras.tdas.ColaTDA;

public class MainColaPU {

    public static void main(String[] args) {
        ColaTDA cola1 = new ColaPU();

        cola1.InicializarCola();

        System.out.println(cola1.ColaVacia());

        cola1.Acolar(1);
        cola1.Acolar(3);
        cola1.Acolar(5);

        System.out.println(cola1.ColaVacia());

        System.out.println(cola1.Primero());

        cola1.Desacolar();

        System.out.println(cola1.Primero());






    }
}
