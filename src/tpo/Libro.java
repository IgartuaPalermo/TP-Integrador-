package tpo;

import estructuras.estaticas.colas.ColaPU;

public class Libro {
    private int isbn;
    private String titulo;
    private String autor;
    private int copiasDisponibles;
    private ColaPU listaEspera = new ColaPU();

    public Libro(int isbn, String titulo, String autor, int copiasDisponibles){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.copiasDisponibles = copiasDisponibles;
        listaEspera.InicializarCola();
    }

    public void AgregarEspera(int dni){
        listaEspera.Acolar(dni);
    }

    public void QuitarEspera(){
        listaEspera.Desacolar();
    }
    //Podriamos combinar las funciones quitarespera y primeroespera?
    public int PrimeroEnEspera(){
        return listaEspera.Primero();
    }

    public boolean CheckNoHayEspera(){
        return listaEspera.ColaVacia();
    }

    public ColaPU GetEspera() {
        return listaEspera;
    }

    public String GetTitulo(){
        return titulo;
    }

    public int GetIsbn(){
        return isbn;
    }

    public int GetCopias(){
        return copiasDisponibles;
    }

    public void AumentarCopias(){
        copiasDisponibles++;
    }

    public void DisminuirCopias(){
        copiasDisponibles--;
    }
}
