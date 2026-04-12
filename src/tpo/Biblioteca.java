package tpo;

import estructurasTPO.dinamicas.LibrosD.ConjuntoLDLibrosD;
import estructurasTPO.estaticas.diccionarios.Libros.DiccionarioSimpleALibros;
import estructurasTPO.estaticas.diccionarios.Prestamos.DiccionarioSimpleAPrestamos;
import estructurasTPO.estaticas.diccionarios.Usuarios.DiccionarioSimpleAUsuarios;
import estructurasTPO.tdas.ClavesDiccionarios.ConjuntoTDA;
import estructurasTPO.tdas.Libros.DiccionarioSimpleTDALibros;
import estructurasTPO.tdas.LibrosD.ConjuntoTDALibrosD;
import estructurasTPO.tdas.Prestamos.DiccionarioSimpleTDAPrestamos;
import estructurasTPO.tdas.Usuarios.DiccionarioSimpleTDAUsuarios;

public class Biblioteca {
     private DiccionarioSimpleTDALibros libros;
     private DiccionarioSimpleTDAUsuarios usuarios;
     private ConjuntoTDALibrosD librosDisponibles;
     private DiccionarioSimpleTDAPrestamos historialPrestamos;
     private int idPrestamo;

     // CONSTRUCTOR
     public Biblioteca() {
          // Aquí debes usar las clases reales que implementan tus interfaces
          this.libros = new DiccionarioSimpleALibros();
          this.usuarios = new DiccionarioSimpleAUsuarios();
          this.librosDisponibles = new ConjuntoLDLibrosD();
          this.historialPrestamos = new DiccionarioSimpleAPrestamos();

          this.libros.InicializarDiccionario();
          this.usuarios.InicializarDiccionario();
          this.librosDisponibles.InicializarConjunto();
          this.historialPrestamos.InicializarDiccionario();
          this.idPrestamo = 1;
     }

     // METODOS
     // METODOS PARA LIBROS
     // CARGAR LIBRO
     public void cargarLibro(int isbn, String titulo, String autor, int copias) {
          Libro nuevoLibro = new Libro(isbn, titulo, autor, copias);

          // AGREGAMOS EL LIBRO
          this.libros.Agregar(isbn, nuevoLibro);

          // SI TIENE COPIAS DISPONIBLES LO PASAMOS AL CONJUNTO DE LIBROS DISPONIBLES
          if (nuevoLibro.hayCopias()) {
               this.librosDisponibles.Agregar(isbn);
          }

          System.out.println("Libro cargado exitosamente: " + titulo);
     }

     // BUSCAR LIBRO (AL SER UN DICCIONARIO LO BUSCAMOS POR ISBN)
     public Libro buscarLibro(int isbn) {
          ConjuntoTDA clavesDisponibles = this.libros.Claves();

          if (clavesDisponibles.Pertenece(isbn)) {
               return this.libros.Recuperar(isbn);
          }

          System.out.println("El ISBN " + isbn + " no existe en el catalogo.");
          return null;
     }

     // MOSTRAR LIBRO (SOLO MUESTRA LA INFORMACION DEL LIBRO)
     public void mostrarInfoLibro(int isbn) {
          Libro libro = buscarLibro(isbn);

          if (libro == null) {
               return;
          }

          System.out.println("\n[DETALLE DEL LIBRO]");
          System.out.println("Título: " + libro.getTitulo());
          System.out.println("Autor: " + libro.getAutor());
          System.out.println("Copias: " + libro.getCopiasDisponibles());

          if (this.librosDisponibles.Pertenece(isbn)) {
               System.out.println("Estado: Disponible");
          } else {
               System.out.println("Estado: Sin stock");
          }
     }

     // METODOS PARA USUARIOS
     // CARGAR USUARIO
     public void cargarUsuario(int dni, String nombre, String apellido) {
          Usuario nuevoUsuario = new Usuario(dni, nombre, apellido);

          this.usuarios.Agregar(dni, nuevoUsuario);

          System.out.println("Usuario registrado con éxito: " + nombre + " " + apellido);
     }

     // BUSCAR USUARIO (AL SER UN DICCIONARIO LO BUSCAMOS POR DNI)
     public Usuario buscarUsuario(int dni) {
          ConjuntoTDA clavesUsuarios = this.usuarios.Claves();

          if (clavesUsuarios.Pertenece(dni)) {
               return this.usuarios.Recuperar(dni);
          }

          System.out.println("El usuario con DNI " + dni + " no está registrado en el sistema.");
          return null;
     }

     // MOSTRAR USUARIO (SOLO MUESTRA LA INFORMACION DEL USUARIO)
     public void mostrarInfoUsuario(int dni) {
          Usuario user = buscarUsuario(dni);

          if (user != null) {
               System.out.println("\n[DETALLE DEL USUARIO]");
               System.out.println("DNI: " + user.getDni());
               System.out.println("Nombre: " + user.getNombre());
               System.out.println("Apellido: " + user.getApellido());
          }
     }

     // METODOS PARA PRESTAMOS
     // PEDIR PRESTAMO
     public void pedirPrestamo(int dni, int isbn) {
          Usuario usuario = buscarUsuario(dni);
          Libro libro = buscarLibro(isbn);

          if (usuario == null || libro == null)
               return;

          if (usuario.tieneElLibro(isbn)) {
               System.out.println("El usuario ya posee una copia de este libro.");
               return;
          }

          if (libro.hayCopias()) {
               libro.disminuirCopias();
               if (!libro.hayCopias()) {
                    this.librosDisponibles.Sacar(isbn);
               }

               usuario.agregarPrestamo(isbn);

               int idPrestamo = this.idPrestamo++;
               Prestamo p = new Prestamo(idPrestamo, usuario, libro);
               this.historialPrestamos.Agregar(idPrestamo, p);

               System.out.println("Préstamo exitoso. ID Nro: " + idPrestamo);
          } else {
               libro.getColaDeEspera().Acolar(dni);
               System.out.println("Sin copias. Usuario " + dni + " añadido a la lista de espera.");
          }
     }

     // DEVOLVER LIBRO
     public void devolverLibro(int idPrestamo) {
          if (!this.historialPrestamos.Claves().Pertenece(idPrestamo)) {
               System.out.println("ID de préstamo inexistente.");
               return;
          }

          Prestamo p = this.historialPrestamos.Recuperar(idPrestamo);
          if (!p.isActivo()) {
               System.out.println("Este libro ya fue devuelto.");
               return;
          }

          p.setActivo(false);
          Usuario usuarioQueDevuelve = p.getUsuario();
          Libro libro = p.getLibro();
          usuarioQueDevuelve.quitarPrestamo(libro.getIsbn());

          if (!libro.getColaDeEspera().ColaVacia()) {
               int dniSiguiente = libro.getColaDeEspera().Primero();
               libro.getColaDeEspera().Desacolar();

               Usuario usuarioEnCola = buscarUsuario(dniSiguiente);

               int nuevoId = this.idPrestamo++;
               usuarioEnCola.agregarPrestamo(libro.getIsbn());
               this.historialPrestamos.Agregar(nuevoId, new Prestamo(nuevoId, usuarioEnCola, libro));

               System.out.println("Devolución exitosa. Libro asignado automáticamente a DNI: " + dniSiguiente);
          } else {
               libro.aumentarCopias();
               this.librosDisponibles.Agregar(libro.getIsbn());
               System.out.println("Devolución exitosa. El libro volvió al estante.");
          }
     }

     // GENERAR REPORTE DE PRESTAMOS
     public void librosPrestados() {
          System.out.println("\n[REPORTE LIBROS PRESTADOS]");

          ConjuntoTDA idPrestamo = this.historialPrestamos.Claves();

          if (idPrestamo.ConjuntoVacio()) {
               System.out.println("No se han realizado préstamos.");
               return;
          }

          while (!idPrestamo.ConjuntoVacio()) {
               int id = idPrestamo.Elegir();
               Prestamo p = this.historialPrestamos.Recuperar(id);

               System.out.println("ID: " + id +
                         " | Estado: " + p.isActivo() +
                         " | Fecha: " + p.getFecha() +
                         " | Libro: " + p.getLibro().getTitulo() +
                         " | Usuario: " + p.getUsuario().getNombre() + " " + p.getUsuario().getApellido() +
                         " (DNI: " + p.getUsuario().getDni() + ")");

               idPrestamo.Sacar(id);
          }
     }

     // GENERAR REPORTE DE PROXIMOS USUARIOS EN ESPERA DE CADA LIBRO
     public void usuariosEspera() {
          System.out.println("\n[REPORTE USUARIOS EN ESPERA]");

          ConjuntoTDA isbns = this.libros.Claves();

          while (!isbns.ConjuntoVacio()) {
               int isbn = isbns.Elegir();
               Libro libro = this.libros.Recuperar(isbn);

               if (!libro.getColaDeEspera().ColaVacia()) {
                    Usuario usuarioProximo = buscarUsuario(libro.getColaDeEspera().Primero());

                    System.out.println("Libro: " + libro.getTitulo() + " (ISBN: " + isbn + ")");
                    System.out.println("Hay usuarios en la Cola.");
                    System.out.println("Próximo en recibirlo: " + usuarioProximo.getNombre() + " "
                              + usuarioProximo.getApellido() + "\n");
               }
               isbns.Sacar(isbn);
          }
     }

}
