package estructuras.mains;

import estructuras.dinamicas.diccionarios.DiccionarioUsuarioDinamico;
import estructuras.tdas.DiccionarioUsuarioTDA;
import tpo.Usuario;

public class MainDiccionarioUsuarioDinamico {

    public static void main(String[] args) {
        DiccionarioUsuarioTDA diccionario2 = new DiccionarioUsuarioDinamico();

        diccionario2.InicializarDiccionario();

        System.out.println(diccionario2.DiccionarioVacio());

        Usuario usuario1 = new Usuario(12345, "Juan");
        Usuario usuario2 = new Usuario(67890, "Maria");

        diccionario2.Agregar(12345, usuario1);
        diccionario2.Agregar(67890, usuario2);

        System.out.println(diccionario2.DiccionarioVacio());

        System.out.println(diccionario2.Existe(12345));

        Usuario recuperado = diccionario2.Recuperar(12345);
        System.out.println(recuperado.GetNombre());

        diccionario2.Eliminar(12345);

        System.out.println(diccionario2.Existe(12345));

    }

}
