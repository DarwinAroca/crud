package CRUD;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JDesktopPane escritorio;

    public VentanaPrincipal() {
        setTitle("🐾 Sistema de Gestión Clínica Veterinaria");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Fondo claro profesional
        escritorio = new JDesktopPane();
        escritorio.setBackground(new Color(255, 255, 255));
        add(escritorio, BorderLayout.CENTER);

        // Barra de menú con fondo azul visible
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setBackground(new Color(33, 150, 243)); // azul brillante
        barraMenu.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemNuevoRegistro = new JMenuItem("Nuevo registro");
        JMenuItem itemSalir = new JMenuItem("Salir");

        // Eventos
        itemSalir.addActionListener(e -> System.exit(0));
        itemNuevoRegistro.addActionListener(e -> crearFormularioIngreso());

        menuArchivo.add(itemNuevoRegistro);
        menuArchivo.addSeparator();
        menuArchivo.add(itemSalir);

        JMenu menuVista = new JMenu("Vista");
        JMenuItem itemPacientes = new JMenuItem("Pacientes");
        JMenuItem itemConsultas = new JMenuItem("Consultas");

        menuVista.add(itemPacientes);
        menuVista.add(itemConsultas);

        // Colores de texto en menú
        Color blanco = Color.black;
        menuArchivo.setForeground(blanco);
        menuVista.setForeground(blanco);

        barraMenu.add(menuArchivo);
        barraMenu.add(menuVista);

        setJMenuBar(barraMenu);
        setVisible(true);
    }

    private void crearFormularioIngreso() {
        JInternalFrame form = new JInternalFrame("📝 Registro de Paciente", true, true, true, true);
        form.setSize(520, 420);
        form.setLayout(new BorderLayout());
        form.getContentPane().setBackground(Color.WHITE);

        JPanel panelContenido = new JPanel(new GridBagLayout());
        panelContenido.setBackground(Color.WHITE);
        panelContenido.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(33, 150, 243), 2),
                "Ingrese los datos del paciente",
                0, 0,
                new Font("Segoe UI", Font.BOLD, 16),
                new Color(33, 150, 243)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(14, 14, 14, 14);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font fuenteLabel = new Font("Segoe UI", Font.PLAIN, 15);
        Font fuenteCampo = new Font("Segoe UI", Font.PLAIN, 14);

        // Nombre
        JLabel lblNombre = new JLabel("👤 Nombre del paciente:");
        lblNombre.setFont(fuenteLabel);
        JTextField txtNombre = new JTextField();
        txtNombre.setFont(fuenteCampo);

        // Clave
        JLabel lblClave = new JLabel("🔐 Clave del historial:");
        lblClave.setFont(fuenteLabel);
        JPasswordField txtClave = new JPasswordField();
        txtClave.setFont(fuenteCampo);

        // Especie
        JLabel lblEspecie = new JLabel("🐾 Especie:");
        lblEspecie.setFont(fuenteLabel);
        JComboBox<String> comboEspecie = new JComboBox<>(new String[]{"Perro", "Gato", "Conejo", "Ave", "Otro"});
        comboEspecie.setFont(fuenteCampo);

        // Edad
        JLabel lblEdad = new JLabel("📅 Edad:");
        lblEdad.setFont(fuenteLabel);
        JSpinner spinnerEdad = new JSpinner(new SpinnerNumberModel(1, 0, 100, 1));
        spinnerEdad.setFont(fuenteCampo);

        // Botón
        JButton btnRegistrar = new JButton("✅ Registrar");
        btnRegistrar.setBackground(new Color(76, 175, 80)); // verde visible
        btnRegistrar.setForeground(Color.BLACK);
        btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegistrar.setPreferredSize(new Dimension(140, 40));

        // Posicionar
        gbc.gridx = 0; gbc.gridy = 0; panelContenido.add(lblNombre, gbc);
        gbc.gridx = 1; panelContenido.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy++; panelContenido.add(lblClave, gbc);
        gbc.gridx = 1; panelContenido.add(txtClave, gbc);

        gbc.gridx = 0; gbc.gridy++; panelContenido.add(lblEspecie, gbc);
        gbc.gridx = 1; panelContenido.add(comboEspecie, gbc);

        gbc.gridx = 0; gbc.gridy++; panelContenido.add(lblEdad, gbc);
        gbc.gridx = 1; panelContenido.add(spinnerEdad, gbc);

        gbc.gridx = 1; gbc.gridy++; gbc.anchor = GridBagConstraints.EAST;
        panelContenido.add(btnRegistrar, gbc);

        // Acción del botón
        btnRegistrar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String clave = new String(txtClave.getPassword()).trim();
            String especie = (String) comboEspecie.getSelectedItem();
            int edad = (int) spinnerEdad.getValue();

            if (nombre.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(form, "⚠️ Por favor completa todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(form,
                    "✅ Registro Exitoso:\n\n" +
                            "👤 Nombre: " + nombre +
                            "\n🔐 Clave: " + clave +
                            "\n🐾 Especie: " + especie +
                            "\n📅 Edad: " + edad + " años",
                    "Datos del paciente",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        form.add(panelContenido, BorderLayout.CENTER);
        escritorio.add(form);
        form.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(VentanaPrincipal::new);
    }
}