

import clases.MongoDBConnection;
import clases.PersonaCRUD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Clase para la interfaz gráfica de la aplicación
public class PersonaGUI extends JFrame {
    private PersonaCRUD personaCRUD;

    private JTextField nombreField;
    private JTextField edadField;
    private JTextField ciudadField;

  //Constructor
    public PersonaGUI(PersonaCRUD personaCRUD) {
        this.personaCRUD = personaCRUD;

        setTitle("Gestión de Personas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }
    //Método para inicializar los componentes de la interfaz gráfica
    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();
        mainPanel.add(nombreLabel);
        mainPanel.add(nombreField);

        JLabel edadLabel = new JLabel("Edad:");
        edadField = new JTextField();
        mainPanel.add(edadLabel);
        mainPanel.add(edadField);

        JLabel ciudadLabel = new JLabel("Ciudad:");
        ciudadField = new JTextField();
        mainPanel.add(ciudadLabel);
        mainPanel.add(ciudadField);

        JButton insertarButton = new JButton("Insertar Persona");
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                int edad = Integer.parseInt(edadField.getText());
                String ciudad = ciudadField.getText();
                personaCRUD.insertarPersona(nombre, edad, ciudad);
                JOptionPane.showMessageDialog(null, "Persona insertada correctamente");
            }
        });

        //Agregar el botón al panel principal
        mainPanel.add(insertarButton);

        //Botón para mostrar las personas
        JButton mostrarButton = new JButton("Mostrar Personas");

        //Agregar un ActionListener al botón
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String personasInfo = personaCRUD.mostrarPersonas();
                JOptionPane.showMessageDialog(null, "Listado de Personas:\n" + personasInfo);
            }
        });
        //Agregar el botón al panel principal
        mainPanel.add(mostrarButton);


        getContentPane().add(mainPanel);
    }
        //Método main
    public static void main(String[] args) {
        MongoDBConnection dbConnection = new MongoDBConnection("mongodb://localhost:27017", "miBaseDatos");
        PersonaCRUD personaCRUD = new PersonaCRUD(dbConnection.getDatabase(), "personas");

        // Crear la interfaz gráfica en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PersonaGUI(personaCRUD).setVisible(true);
            }
        });
    }
}
