package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Cliente;
import Model.ConexionBD;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO() {
        conn = ConexionBD.ConectarBD();  // Solo inicializamos la conexión en el constructor
    }

    // Create
    public boolean agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO db_clientes (TipoID, Nombre, Apellido, Usuario, Password, NroCelular, Email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getTipoID());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellido());
            stmt.setString(4, cliente.getUsuario());
            stmt.setString(5, cliente.getPassword());
            stmt.setLong(6, cliente.getNroCelular());
            stmt.setString(7, cliente.getEmail());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
            return false;
        }
    }

    // Read
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM db_clientes";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("ID"),
                    rs.getString("TipoID"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Usuario"),
                    rs.getString("Password"),
                    rs.getLong("NroCelular"),
                    rs.getString("Email")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los clientes: " + e.getMessage());
        }
        return clientes;
    }

    // Update
    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE db_clientes SET TipoID=?, Nombre=?, Apellido=?, Usuario=?, Password=?, NroCelular=?, Email=? WHERE ID=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getTipoID());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellido());
            stmt.setString(4, cliente.getUsuario());
            stmt.setString(5, cliente.getPassword());
            stmt.setLong(6, cliente.getNroCelular());
            stmt.setString(7, cliente.getEmail());
            stmt.setInt(8, cliente.getID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }

    // Delete
    public boolean eliminarCliente(int id) {
        String sql = "DELETE FROM db_clientes WHERE ID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
}
