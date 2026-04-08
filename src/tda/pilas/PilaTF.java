package tda.pilas;

public class PilaTF implements PilaTDA{
    int[] arr;  // arreglo que contiene informacion
    int inx;  // cantidad de elementos en la pila


    public void InicializarPila(){
        arr = new int[100];
        inx = 0;
    }

    public void Apilar(int x){
        arr[inx] = x;
        inx++;
    }

    public void Desapilar(){
        inx--;
    }

    public boolean PilaVacia(){
        return (inx == 0);
    }

    public int Tope(){
        return arr[inx - 1];
    }
}


