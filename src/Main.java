import java.util.Scanner;

import tpo.Biblioteca;

public class Main {
    public static void main(String[] args) {

        Biblioteca miBiblioteca = new Biblioteca();
        Scanner leer = new Scanner(System.in);
        int opcion = -1;

        System.out.println("=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===");

        while (opcion != 0) {
            System.out.println("\n\n----------------------------------------");
            System.out.println("            MENÚ DE OPCIONES            ");
            System.out.println("----------------------------------------");
            System.out.println("1. Cargar nuevo libro");
            System.out.println("2. Buscar libro por ISBN");
            System.out.println("3. Cargar nuevo usuario");
            System.out.println("4. Buscar usuario por DNI");
            System.out.println("5. Cargar nuevo prestamo");
            System.out.println("6. Devolver libro");
            System.out.println("7. Reporte de libros prestados");
            System.out.println("8. Reporte de proximos usuarios en espera");
            System.out.println("0. Salir");
            System.out.print("\nSeleccione una opción: ");

            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n[REGISTRO]");
                    System.out.print("ISBN: ");
                    int isbn = leer.nextInt();
                    leer.nextLine();

                    System.out.print("Título: ");
                    String titulo = leer.nextLine();

                    System.out.print("Autor: ");
                    String autor = leer.nextLine();

                    System.out.print("Copias: ");
                    int copias = leer.nextInt();

                    miBiblioteca.cargarLibro(isbn, titulo, autor, copias);
                    break;

                case 2:
                    System.out.println("\n[BUSQUEDA LIBRO]");
                    System.out.print("ISBN: ");
                    int isbnInfo = leer.nextInt();
                    System.out.println("");
                    miBiblioteca.mostrarInfoLibro(isbnInfo);
                    break;

                case 3:
                    System.out.println("\n[REGISTRO DE USUARIO]");
                    System.out.print("DNI: ");
                    int dni = leer.nextInt();
                    leer.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = leer.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = leer.nextLine();

                    miBiblioteca.cargarUsuario(dni, nombre, apellido);
                    break;

                case 4:
                    System.out.println("\n[BUSQUEDA USUARIO]");
                    System.out.print("Ingrese DNI: ");
                    int dniConsulta = leer.nextInt();
                    leer.nextLine();
                    miBiblioteca.mostrarInfoUsuario(dniConsulta);
                    break;

                case 5:
                    System.out.println("\n[NUEVO PRÉSTAMO]");
                    System.out.print("Ingrese DNI del usuario: ");
                    int dniPrestamo = leer.nextInt();
                    System.out.print("Ingrese ISBN del libro: ");
                    int isbnPrestamo = leer.nextInt();

                    miBiblioteca.pedirPrestamo(dniPrestamo, isbnPrestamo);
                    break;

                case 6:
                    System.out.println("\n[DEVOLUCIÓN DE LIBRO]");
                    System.out.print("Ingrese el ID del Prestamo: ");
                    int idTicket = leer.nextInt();

                    miBiblioteca.devolverLibro(idTicket);
                    break;

                case 7:
                    miBiblioteca.librosPrestados();
                    break;

                case 8:
                    miBiblioteca.usuariosEspera();
                    break;

                case 0:
                    System.out.println("\nSaliendo del sistema...");
                    break;

                default:
                    System.out.println("\nOpción inválida.");
                    break;
            }
        }
        leer.close();

    }
}