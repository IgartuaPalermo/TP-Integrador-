package tpo;

import estructuras.dinamicas.conjuntos.ConjuntoLD;
import estructuras.dinamicas.diccionarios.DiccionarioUsuarioDinamico;
import estructuras.tdas.ConjuntoTDA;
import estructuras.tdas.DiccionarioUsuarioTDA;

public class Biblioteca {
    private Libro[] libros;
    private int cantidadLibros;
    private DiccionarioUsuarioTDA usuarios;
    private ConjuntoTDA librosDisponibles;

    public Biblioteca() {
        libros = new Libro[100];
        cantidadLibros = 0;
        usuarios = new DiccionarioUsuarioDinamico();
        usuarios.InicializarDiccionario();
        librosDisponibles = new ConjuntoLD();
        librosDisponibles.InicializarConjunto();
    }

    public void AgregarLibro(Libro libro) {
        libros[cantidadLibros] = libro;
        cantidadLibros++;
        librosDisponibles.Agregar(libro.GetIsbn());
    }

    public void AgregarUsuario(Usuario usuario) {
        usuarios.Agregar(usuario.GetDni(), usuario);
    }

    public Libro BuscarLibroPorIsbn(int isbn) {
        for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].GetIsbn() == isbn) {
                return libros[i];
            }
        }
        return null;
    }

    public Usuario BuscarUsuarioPorDni(int dni) {
        return usuarios.Recuperar(dni);
    }

    public void RealizarPrestamo(int dni, int isbn) {
        Usuario usuario = BuscarUsuarioPorDni(dni);
        Libro libro = BuscarLibroPorIsbn(isbn);

        if (usuario == null || libro == null) {
            return;
        }

        if (libro.GetCopias() > 0) {
            libro.DisminuirCopias();
        } else {
            libro.AgregarEspera(dni);
        }
    }

    public void DevolverLibro(int isbn) {
        Libro libro = BuscarLibroPorIsbn(isbn);
        if (libro == null) {
            return;
        }

        if (!libro.CheckNoHayEspera()) {
            int siguiente = libro.PrimeroEnEspera();
            libro.QuitarEspera();
        } else {
            libro.AumentarCopias();
        }
    }

    public void MostrarLibrosDisponibles() {
        System.out.println("Libros en la Biblioteca:");
        for (int i = 0; i < cantidadLibros; i++) {
            System.out.println("ISBN: " + libros[i].GetIsbn() + 
                             " - Titulo: " + libros[i].GetTitulo() + 
                             " - Copias: " + libros[i].GetCopias());
        }
    }

    public void MostrarUsuarios() {
        System.out.println("Usuarios Registrados:");
        for (int i = 0; i < cantidadLibros; i++) {
            if (BuscarUsuarioPorDni(i) != null) {
                Usuario u = BuscarUsuarioPorDni(i);
                System.out.println("DNI: " + u.GetDni() + " - Nombre: " + u.GetNombre());
            }
        }
    }
}

