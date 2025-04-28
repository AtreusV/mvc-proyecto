package Controlador;

import Modelo.ClienteDAO;
import Model.Cliente;
import java.util.List;

public class ControladorCliente {
    private ClienteDAO clienteDAO = new ClienteDAO();

    // Agregar un nuevo cliente
    public void agregarNuevoCliente(String tipoID, String nombre, String apellido, String usuario, String password, long nroCelular, String email) {
        Cliente nuevoCliente = new Cliente(tipoID, nombre, apellido, usuario, password, nroCelular, email);
        boolean exito = clienteDAO.agregarCliente(nuevoCliente);
        if (exito) {
            System.out.println("Cliente agregado exitosamente.");
        } else {
            System.out.println("Error al agregar el cliente.");
        }
    }

    // Listar todos los clientes
    public void mostrarClientes() {
        List<Cliente> clientes = clienteDAO.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes en la base de datos.");
        } else {
            clientes.forEach(cliente -> System.out.println(cliente));
        }
    }

    // Actualizar un cliente
    public void actualizarCliente(int id, String tipoID, String nombre, String apellido, String usuario, String password, long nroCelular, String email) {
        Cliente clienteExistente = new Cliente(id, tipoID, nombre, apellido, usuario, password, nroCelular, email);
        boolean exito = clienteDAO.actualizarCliente(clienteExistente);
        if (exito) {
            System.out.println("Cliente actualizado exitosamente.");
        } else {
            System.out.println("Error al actualizar el cliente.");
        }
    }

    // Eliminar un cliente
    public void eliminarCliente(int id) {
        boolean exito = clienteDAO.eliminarCliente(id);
        if (exito) {
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("Error al eliminar el cliente.");
        }
    }
}
