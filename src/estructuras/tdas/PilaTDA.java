package estructuras.tdas;

public interface PilaTDA {
    void InicializarPila();  // pre: no aplica.

    void Apilar(int x);  // pre: pila inicializada.

    void Desapilar();  // pre: pila inicializada y no vacia.

    boolean PilaVacia(); // pre: pila inicializada

    int Tope();  // pre: pila inicializada y no vacia
}

