package Vista;

import Controlador.ControladorCliente;
import java.util.Scanner;

public class ClienteVista {
    private final ControladorCliente controladorCliente;
    private final Scanner scanner;

    public ClienteVista() {
        controladorCliente = new ControladorCliente();
        scanner = new Scanner(System.in);
    }

    // Mostrar el menú de opciones
    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n------ Menú de Cliente ------");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Listar todos los clientes");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1 -> agregarCliente();
                case 2 -> listarClientes();
                case 3 -> actualizarCliente();
                case 4 -> eliminarCliente();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    // Agregar un cliente
    public void agregarCliente() {
        System.out.println("\n--- Agregar nuevo cliente ---");
        System.out.print("Tipo de ID: ");
        String tipoID = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        System.out.print("Número de celular: ");
        long nroCelular = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Email: ");
        String email = scanner.nextLine();

        controladorCliente.agregarNuevoCliente(tipoID, nombre, apellido, usuario, password, nroCelular, email);
    }

    // Listar todos los clientes
    public void listarClientes() {
        System.out.println("\n--- Listado de Clientes ---");
        controladorCliente.mostrarClientes();
    }

    // Actualizar un cliente
    public void actualizarCliente() {
        System.out.println("\n--- Actualizar cliente ---");
        System.out.print("Ingrese el ID del cliente a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Tipo de ID: ");
        String tipoID = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        System.out.print("Número de celular: ");
        long nroCelular = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Email: ");
        String email = scanner.nextLine();

        controladorCliente.actualizarCliente(id, tipoID, nombre, apellido, usuario, password, nroCelular, email);
    }

    // Eliminar un cliente
    public void eliminarCliente() {
        System.out.println("\n--- Eliminar cliente ---");
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        int id = scanner.nextInt();
        controladorCliente.eliminarCliente(id);
    }
}
