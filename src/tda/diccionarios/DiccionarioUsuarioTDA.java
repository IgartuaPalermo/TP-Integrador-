package tda.diccionarios;

import tpo.Usuario;

public interface DiccionarioUsuarioTDA {
    void InicializarDiccionario();  // pre: no aplica.
    void Agregar(int dni, Usuario usuario);  // pre: diccionario inicializado.
    void Eliminar(int dni);  // pre: diccionario inicializado.
    Usuario Recuperar(int dni);  // pre: diccionario inicializado.
    boolean Existe(int dni);  // pre: diccionario inicializado.
    boolean DiccionarioVacio();  // pre: diccionario inicializado.
}
