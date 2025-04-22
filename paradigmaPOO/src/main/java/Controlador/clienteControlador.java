package Controlador;

import Model.Cliente;
import Model.ClienteDAO;
import Vista.FormCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class clienteControlador implements ActionListener {
    private ClienteDAO clienteDAO;
    private FormCliente VisCliente;

    public clienteControlador(FormCliente VisCliente) {
        this.VisCliente = VisCliente;
        this.clienteDAO = new ClienteDAO();

        // Asignar eventos a los botones
        this.VisCliente.btnGuardar.addActionListener(this);
        this.VisCliente.btnBuscar.addActionListener(this);
        this.VisCliente.btnActualizar.addActionListener(this);
        this.VisCliente.btnEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == VisCliente.btnGuardar) {
            agregarCliente();
        } else if (e.getSource() == VisCliente.btnBuscar) {
            buscarCliente();
        } else if (e.getSource() == VisCliente.btnActualizar) {
            actualizarCliente();
        } else if (e.getSource() == VisCliente.btnEliminar) {
            eliminarCliente();
        }
    }

    private void agregarCliente() {
        Cliente cliente = new Cliente(
            VisCliente.txtTipoID.getText(),
            VisCliente.txtNombre.getText(),
            VisCliente.txtApellido.getText(),
            VisCliente.txtUsuario.getText(),
            VisCliente.txtPassword.getText(),
            Integer.parseInt(VisCliente.txtNroCelular.getText()),
            VisCliente.txtEmail.getText()
        );

        clienteDAO.agregarCliente(cliente);
        limpiarCampos();  // Limpiar los campos después de agregar
    }

    
    private void buscarCliente() {
    try {
        int id = Integer.parseInt(VisCliente.txtID.getText().trim()); // Elimina espacios vacíos
        Cliente cliente = clienteDAO.obtenerClientePorID(id);

        if (cliente != null) {
            VisCliente.txtTipoID.setText(cliente.getTipoID());
            VisCliente.txtNombre.setText(cliente.getNombre());
            VisCliente.txtApellido.setText(cliente.getApellido());
            VisCliente.txtUsuario.setText(cliente.getUsuario());
            VisCliente.txtPassword.setText(cliente.getPassword());
            VisCliente.txtNroCelular.setText(String.valueOf(cliente.getNroCelular()));
            VisCliente.txtEmail.setText(cliente.getEmail());
        } else {
            JOptionPane.showMessageDialog(VisCliente, "Cliente no encontrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(VisCliente, "Error: ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void actualizarCliente() {
        Cliente cliente = new Cliente(
            Integer.parseInt(VisCliente.txtID.getText()),
            VisCliente.txtTipoID.getText(),
            VisCliente.txtNombre.getText(),
            VisCliente.txtApellido.getText(),
            VisCliente.txtUsuario.getText(),
            VisCliente.txtPassword.getText(),
            Integer.parseInt(VisCliente.txtNroCelular.getText()),
            VisCliente.txtEmail.getText()
        );

        clienteDAO.actualizarCliente(cliente);
        limpiarCampos();
    }

    private void eliminarCliente() {
        int id = Integer.parseInt(VisCliente.txtID.getText());
        clienteDAO.eliminarCliente(id);
        limpiarCampos();
    }

    private void limpiarCampos() {
        VisCliente.txtID.setText("");
        VisCliente.txtTipoID.setText("");
        VisCliente.txtNombre.setText("");
        VisCliente.txtApellido.setText("");
        VisCliente.txtUsuario.setText("");
        VisCliente.txtPassword.setText("");
        VisCliente.txtNroCelular.setText("");
        VisCliente.txtEmail.setText("");
    }
}
