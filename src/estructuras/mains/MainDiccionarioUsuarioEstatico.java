package estructuras.mains;

import estructuras.estaticas.diccionarios.DiccionarioUsuarioEstatico;
import estructuras.tdas.DiccionarioUsuarioTDA;
import tpo.Usuario;

public class MainDiccionarioUsuarioEstatico {

    public static void main(String[] args) {
        DiccionarioUsuarioTDA diccionario1 = new DiccionarioUsuarioEstatico();

        diccionario1.InicializarDiccionario();

        System.out.println(diccionario1.DiccionarioVacio());

        Usuario usuario1 = new Usuario(12345, "Juan");
        Usuario usuario2 = new Usuario(67890, "Maria");

        diccionario1.Agregar(12345, usuario1);
        diccionario1.Agregar(67890, usuario2);

        System.out.println(diccionario1.DiccionarioVacio());

        System.out.println(diccionario1.Existe(12345));

        Usuario recuperado = diccionario1.Recuperar(12345);
        System.out.println(recuperado.GetNombre());

        diccionario1.Eliminar(12345);

        System.out.println(diccionario1.Existe(12345));

    }

}
