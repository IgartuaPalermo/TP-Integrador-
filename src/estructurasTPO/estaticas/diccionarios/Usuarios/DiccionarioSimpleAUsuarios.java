package estructurasTPO.estaticas.diccionarios.Usuarios;


import estructurasTPO.dinamicas.ClavesDiccionarios.ConjuntoLD;
import estructurasTPO.tdas.ClavesDiccionarios.ConjuntoTDA;
import estructurasTPO.tdas.Usuarios.DiccionarioSimpleTDAUsuarios;
import tpo.Usuario;

public class DiccionarioSimpleAUsuarios implements DiccionarioSimpleTDAUsuarios {
    private ElementoUsuario[] elementos;
    private int cant;

    public void InicializarDiccionario() {
        elementos = new ElementoUsuario[100];
        cant = 0;
    }

    public void Agregar(int dni, Usuario usuario) {
        int pos = Clave2Ind(dni);
        if (pos == -1) { // El dni no existe
            pos = cant; // Nueva entrada
            elementos[pos] = new ElementoUsuario();
            elementos[pos].dni = dni;
            cant++;
        }
        elementos[pos].usuario = usuario;
    }

    private int Clave2Ind(int dni) {
        int i = cant - 1;
        while (i >= 0 && elementos[i].dni != dni)
            i--;
        return i;
    }

    public void Eliminar(int dni) {
        int pos = Clave2Ind(dni);
        if (pos != -1) { // La dni existe
            elementos[pos] = elementos[cant - 1];
            cant--;
        }
    }

    public Usuario Recuperar(int dni) {
        int pos = Clave2Ind(dni);
        return elementos[pos].usuario;
    }

    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoLD();
        c.InicializarConjunto();
        for (int i = 0; i < cant; i++)
            c.Agregar(elementos[i].dni);
        return c;
    }
}
