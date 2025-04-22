package Vista;

import javax.swing.*;
import java.awt.*;

public class FormCliente extends JFrame {
    public JTextField txtID, txtTipoID, txtNombre, txtApellido, txtUsuario, txtPassword, txtNroCelular, txtEmail;
    public JButton btnGuardar, btnBuscar, btnActualizar, btnEliminar;

    public FormCliente() {
        setTitle("Administración de Clientes");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2, 5, 5));  // Organiza los elementos en una cuadrícula

        // Crear campos de texto y etiquetas
        add(new JLabel("ID:"));
        txtID = new JTextField();
        add(txtID);

        add(new JLabel("Tipo ID:"));
        txtTipoID = new JTextField();
        add(txtTipoID);

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        add(txtApellido);

        add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        add(txtUsuario);

        add(new JLabel("Contraseña:"));
        txtPassword = new JTextField();
        add(txtPassword);

        add(new JLabel("Celular:"));
        txtNroCelular = new JTextField();
        add(txtNroCelular);

        add(new JLabel("Correo:"));
        txtEmail = new JTextField();
        add(txtEmail);

        // Botones
        btnGuardar = new JButton("Guardar");
        btnBuscar = new JButton("Buscar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        add(btnGuardar);
        add(btnBuscar);
        add(btnActualizar);
        add(btnEliminar);

        // Hacer visible la ventana
        setVisible(true);
    }
}
