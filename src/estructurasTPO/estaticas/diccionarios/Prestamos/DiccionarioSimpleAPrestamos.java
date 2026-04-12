package estructurasTPO.estaticas.diccionarios.Prestamos;


import estructurasTPO.dinamicas.ClavesDiccionarios.ConjuntoLD;
import estructurasTPO.tdas.ClavesDiccionarios.ConjuntoTDA;
import estructurasTPO.tdas.Prestamos.DiccionarioSimpleTDAPrestamos;
import tpo.Prestamo;

public class DiccionarioSimpleAPrestamos implements DiccionarioSimpleTDAPrestamos {
    private ElementoPrestamo[] elementos;
    private int cant;

    public void InicializarDiccionario() {
        elementos = new ElementoPrestamo[100];
        cant = 0;
    }

    public void Agregar(int id, Prestamo prestamo) {
        int pos = Clave2Ind(id);
        if (pos == -1) { // El id no existe
            pos = cant; // Nueva entrada
            elementos[pos] = new ElementoPrestamo();
            elementos[pos].id = id;
            cant++;
        }
        elementos[pos].prestamo = prestamo;
    }

    private int Clave2Ind(int id) {
        int i = cant - 1;
        while (i >= 0 && elementos[i].id != id)
            i--;
        return i;
    }

    public void Eliminar(int id) {
        int pos = Clave2Ind(id);
        if (pos != -1) { // El id existe
            elementos[pos] = elementos[cant - 1];
            cant--;
        }
    }

    public Prestamo Recuperar(int id) {
        int pos = Clave2Ind(id);
        return elementos[pos].prestamo;
    }

    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoLD();
        c.InicializarConjunto();
        for (int i = 0; i < cant; i++)
            c.Agregar(elementos[i].id);
        return c;
    }
}
