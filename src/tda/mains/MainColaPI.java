package tda.mains;

import tda.colas.ColaPI;
import tda.colas.ColaTDA;

public class MainColaPI {

    public static void main(String[] args) {
        ColaTDA cola1 = new ColaPI();

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
