package estructurasTPO.tdas.Prestamos;

import estructurasTPO.tdas.ClavesDiccionarios.ConjuntoTDA;
import tpo.Prestamo;

public interface DiccionarioSimpleTDAPrestamos {
    void InicializarDiccionario(); // pre: no aplica.
    void Agregar(int id, Prestamo prestamo); // pre: diccionario inicializado.
    void Eliminar(int id); // pre: diccionario inicializado.
    Prestamo Recuperar(int id); // pre: diccionario inicializado y id existente.
    ConjuntoTDA Claves(); // pre: diccionario inicializado.
}
