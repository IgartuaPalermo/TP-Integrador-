package tda.mains;

import tda.pilas.PilaTDA;
import tda.pilas.PilaTI;

public class MainPilaTI {

    public static void main(String[] args) {
        PilaTDA pila2 = new PilaTI();

        pila2.InicializarPila();

        System.out.println(pila2.PilaVacia());

        pila2.Apilar(2);
        pila2.Apilar(3);
        pila2.Apilar(9);

        System.out.println(pila2.Tope());

        System.out.println(pila2.PilaVacia());

        pila2.Desapilar();

        System.out.println(pila2.Tope());

    }
}
