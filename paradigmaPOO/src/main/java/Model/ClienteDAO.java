package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ClienteDAO {
    
    
    //CREATE - Crear
    public void agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO db_clientes (TipoID, Nombre, Apellido, Usuario, password, NroCelular, email) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection conexion = ConexionBD.ConectarBD();
            PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setString(1, cliente.getTipoID());
        stmt.setString(2, cliente.getNombre());
        stmt.setString(3, cliente.getApellido());
        stmt.setString(4, cliente.getUsuario());
        stmt.setString(5, cliente.getPassword());
        stmt.setInt(6, cliente.getNroCelular());
        stmt.setString(7, cliente.getEmail());

        stmt.executeUpdate();

        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                int nuevoID = rs.getInt(1);
                System.out.println("Cliente agregado con ID: " + nuevoID);
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al agregar cliente: " + e.getMessage());
    }
}
    
    //READ - Listar
    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM db_clientes";
        
        // Obtener la conexión desde ConexionBD
        try (Connection conexion = ConexionBD.ConectarBD();
             PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("ID"),
                    rs.getString("TipoID"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Usuario"),
                    rs.getString("password"),
                    rs.getInt("NroCelular"),
                    rs.getString("email")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener clientes: " + e.getMessage());
        }
        return clientes;
    }

    //UPTDATE - Actualizar
    public void actualizarCliente(Cliente cliente) {
    String sql = "UPDATE db_clientes SET TipoID = ?, Nombre = ?, Apellido = ?, Usuario = ?, password = ?, NroCelular = ?, email = ? WHERE ID = ?";

    try (Connection conexion = ConexionBD.ConectarBD();
         PreparedStatement stmt = conexion.prepareStatement(sql)) {

        stmt.setString(1, cliente.getTipoID());
        stmt.setString(2, cliente.getNombre());
        stmt.setString(3, cliente.getApellido());
        stmt.setString(4, cliente.getUsuario());
        stmt.setString(5, cliente.getPassword());
        stmt.setInt(6, cliente.getNroCelular());
        stmt.setString(7, cliente.getEmail());
        stmt.setInt(8, cliente.getID());

        stmt.executeUpdate();
        System.out.println("Cliente actualizado correctamente.");
    } catch (SQLException e) {
        System.out.println("Error al actualizar cliente: " + e.getMessage());
    }
}

    //DELETE - Borrar
    public void eliminarCliente(int id) {
    String sql = "DELETE FROM db_clientes WHERE ID = ?";

    try (Connection conexion = ConexionBD.ConectarBD();
         PreparedStatement stmt = conexion.prepareStatement(sql)) {

        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("Cliente eliminado correctamente.");
    } catch (SQLException e) {
        System.out.println("Error al eliminar cliente: " + e.getMessage());
    }
}
    
    //Obtener cliente por ID
    public Cliente obtenerClientePorID(int id) {
    String sql = "SELECT * FROM db_clientes WHERE ID = ?";
    Cliente cliente = null;

    try (Connection conexion = ConexionBD.ConectarBD();
         PreparedStatement stmt = conexion.prepareStatement(sql)) {

        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                cliente = new Cliente(
                    rs.getInt("ID"),
                    rs.getString("TipoID"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Usuario"),
                    rs.getString("password"),
                    rs.getInt("NroCelular"),
                    rs.getString("email")
                );
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener cliente: " + e.getMessage());
    }

    return cliente;
}


    
    





}
