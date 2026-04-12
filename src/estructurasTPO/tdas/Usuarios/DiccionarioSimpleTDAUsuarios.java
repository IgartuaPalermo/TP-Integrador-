package estructurasTPO.tdas.Usuarios;

import estructurasTPO.tdas.ClavesDiccionarios.ConjuntoTDA;
import tpo.Usuario;

public interface DiccionarioSimpleTDAUsuarios {
    void InicializarDiccionario(); // pre: no aplica.
    void Agregar(int dni, Usuario usuario); // pre: diccionario inicializado.
    void Eliminar(int dni); // pre: diccionario inicializado.
    Usuario Recuperar(int dni); // pre: diccionario inicializado y dni existente.
    ConjuntoTDA Claves(); // pre: diccionario inicializado.
}
