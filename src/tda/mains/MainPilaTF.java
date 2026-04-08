package tda.mains;

import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;

public class MainPilaTF {

    public static void main(String[] args) {
        PilaTDA pila1 = new PilaTF();

        pila1.InicializarPila();

        System.out.println(pila1.PilaVacia());

        pila1.Apilar(2);
        pila1.Apilar(3);
        pila1.Apilar(9);

        System.out.println(pila1.Tope());

        System.out.println(pila1.PilaVacia());

        pila1.Desapilar();

        System.out.println(pila1.Tope());

    }

}
