package org.example.GUI;


import org.example.Enum.EDiasSemana;
import org.example.Enum.ESexo;
import org.example.Excepciones.MailSinArrobaE;
import org.example.GUI.PopUps.JfrAvisoPopUp;
import org.example.GUI.PopUps.JfrErrorPopUp;
import org.example.GUI.PopUps.JfrEsperaPopUp;
import org.example.GUI.PopUps.PopupQR;
import org.example.Modelo.*;

import javax.mail.MessagingException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import static org.example.GUI.GUIEnvoltorio.gimnasio;

public class JfrCliente extends JFrame {

    // atributos
    private JButton BotonArchivarCliente;
    private JButton BotonAsignarRutina;
    private JButton BotonIrAtras;
    private JButton BotonRealizarBusquedaCliente;
    private JButton BotonoCrearNuevoCliente;
    private JComboBox<String> BuscarClienteMenu;
    private JTable TablaClientes;
    private JTextField TextAreaBusqueda;
    private JLabel jLabel1;
    private JList<String> jList1;
    private JMenu jMenu1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JButton BotonActualizarCliente;
    private JButton BotonEnviarRutina;

    public Cliente cliente;
    private javax.swing.JToggleButton BotonMostrarQRParaQueMandenMail;


    //constructor
    public JfrCliente() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);



        //Cambiar el Icono de la app
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Images/LOGO CORTO.png")));
        setIconImage(icon.getImage());
    }


    private void initComponents() {

        jMenu1 = new JMenu();
        cliente = null;
        jScrollPane1 = new JScrollPane();
        jList1 = new JList<>();
        BuscarClienteMenu = new JComboBox<>();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        BotonoCrearNuevoCliente = new JButton();
        BotonArchivarCliente = new JButton();
        TablaClientes = new JTable();
        BotonAsignarRutina = new JButton();
        BotonRealizarBusquedaCliente = new JButton();
        BotonIrAtras = new JButton();
        TextAreaBusqueda = new JTextField();
        BotonActualizarCliente = new JButton();
        BotonMostrarQRParaQueMandenMail = new javax.swing.JToggleButton();


        BotonEnviarRutina = new JButton();
        TextAreaBusqueda = new JTextField();


//        jMenu1.setText("jMenu1");

//        jList1.setModel(new AbstractListModel<String>() {
//            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
//            public int getSize() { return strings.length; }
//            public String getElementAt(int i) { return strings[i]; }
//        });
//        jScrollPane1.setViewportView(jList1);
//
//        BuscarClienteMenu.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
//        BuscarClienteMenu.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                BuscarClienteActionPerformed(evt);
//            }
//        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // No cerrar directamente

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {


                // Crear el panel de opciones con los botones personalizados
                Object[] options = {"Si", "No"};
                int option = JOptionPane.showOptionDialog(
                        JfrCliente.this,
                        "¿Desea salir?",
                        "Confirmación de salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                );

                if (option == JOptionPane.YES_OPTION) {
                    // Llamar al método de guardar cambios antes de cerrar
                    gimnasio.guardarClientesEnArchivo("clientes.bin");
                    System.exit(0);
                }



            }
        });

        setPreferredSize(new Dimension(915, 500));


        jPanel1.setBackground(new Color(63, 63, 63));
        jPanel1.setPreferredSize(new Dimension(900, 500));

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N

        BotonoCrearNuevoCliente.setBackground(new Color(130, 130, 130));
        BotonoCrearNuevoCliente.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        BotonoCrearNuevoCliente.setForeground(new Color(242, 242, 242));
        BotonoCrearNuevoCliente.setText("Agregar Nuevo Cliente");
        BotonoCrearNuevoCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonoCrearNuevoClienteActionPerformed(evt);
            }
        });

        BotonArchivarCliente.setBackground(new Color(130, 130, 130));
        BotonArchivarCliente.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        BotonArchivarCliente.setForeground(new Color(242, 242, 242));
        BotonArchivarCliente.setText("Archivar/Desarchivar");
        BotonArchivarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonArchivarClienteActionPerformed(evt);
            }
        });

        TablaClientes.setBackground(new Color(242, 242, 242));
        TablaClientes.setBorder(new LineBorder(new Color(130, 130, 130), 1, true));
        TablaClientes.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "N° Socio", "Nombre", "Apellido", "DNI", "Actividad", "Sexo", "Estado"
                }
        ) {
            Class[] types = new Class[]{
                    Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false,
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        TablaClientes.setToolTipText("");
        // TablaClientes.setColumnSelectionAllowed(true);
        TablaClientes.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(TablaClientes);
        TablaClientes.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (TablaClientes.getColumnModel().getColumnCount() > 0) {
            TablaClientes.getColumnModel().getColumn(0).setResizable(false);
            TablaClientes.getColumnModel().getColumn(1).setResizable(false);
            TablaClientes.getColumnModel().getColumn(2).setResizable(false);
            TablaClientes.getColumnModel().getColumn(3).setResizable(false);
            TablaClientes.getColumnModel().getColumn(4).setResizable(false);
            TablaClientes.getColumnModel().getColumn(5).setResizable(false);

        }


        GUIEnvoltorio.agregarUnArrayDeClientesEnTablaDeClientes((DefaultTableModel) TablaClientes.getModel(), GUIEnvoltorio.getGimnasio().retornarListaDeClientes(), false);

        BotonAsignarRutina.setBackground(new Color(130, 130, 130));
        BotonAsignarRutina.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        BotonAsignarRutina.setForeground(new Color(242, 242, 242));
        BotonAsignarRutina.setText("Asignar Rutina");
        BotonAsignarRutina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonAsignarRutinaActionPerformed(evt);
            }
        });

        BuscarClienteMenu.setBackground(new Color(130, 130, 130));
        BuscarClienteMenu.setForeground(new Color(242, 242, 242));
        BuscarClienteMenu.setModel(new DefaultComboBoxModel<>(new String[]{"Todos", "Por ID", "Por Nombre", "Por Apellido", "Por Actividad", "Por Sexo", "Por Dni"}));
        BuscarClienteMenu.setBorder(BorderFactory.createTitledBorder(null, "Buscar Cliente", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 14), new Color(242, 242, 242))); // NOI18N
        BuscarClienteMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BuscarClienteMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BuscarClienteMenuActionPerformed(evt);
            }
        });

        BotonRealizarBusquedaCliente.setBackground(new Color(130, 130, 130));
        BotonRealizarBusquedaCliente.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        BotonRealizarBusquedaCliente.setForeground(new Color(242, 242, 242));
        BotonRealizarBusquedaCliente.setText("Buscar");
        BotonRealizarBusquedaCliente.setPreferredSize(new Dimension(130, 40));
        BotonRealizarBusquedaCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonRealizarBusquedaClienteActionPerformed(evt);
            }
        });

        BotonIrAtras.setBackground(new Color(63, 63, 63));
        BotonIrAtras.setIcon(new ImageIcon(getClass().getResource("/Images/return.png"))); // NOI18N
        BotonIrAtras.setBorder(null);
        BotonIrAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonIrAtrasActionPerformed(evt);
            }
        });

        BotonEnviarRutina.setBackground(new Color(130, 130, 130));
        BotonEnviarRutina.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        BotonEnviarRutina.setForeground(new Color(242, 242, 242));
        BotonEnviarRutina.setText("Enviar Rutina");
        BotonEnviarRutina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonEnviarRutinaActionPerformed(evt);
            }
        });

        TextAreaBusqueda.setBackground(new Color(130, 130, 130));
        TextAreaBusqueda.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        TextAreaBusqueda.setPreferredSize(new Dimension(202, 53));
        TextAreaBusqueda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TextAreaBusquedaActionPerformed(evt);
            }
        });

        BotonActualizarCliente.setBackground(new Color(130, 130, 130));
        BotonActualizarCliente.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        BotonActualizarCliente.setForeground(new Color(242, 242, 242));
        BotonActualizarCliente.setText("Actualizar Cliente");
        BotonActualizarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonActualizarClienteActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        BotonMostrarQRParaQueMandenMail.setBackground(new java.awt.Color(130, 130, 130));
        BotonMostrarQRParaQueMandenMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotonMostrarQRParaQueMandenMail.setForeground(new java.awt.Color(242, 242, 242));
        BotonMostrarQRParaQueMandenMail.setText("QR Mail");
        BotonMostrarQRParaQueMandenMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMostrarQRParaQueMandenMailActionPerformed(evt);
            }
        });

        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(BotonoCrearNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addGap(281, 281, 281))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(BotonRealizarBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(289, 289, 289))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(BuscarClienteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextAreaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(BotonEnviarRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BotonAsignarRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BotonArchivarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BotonActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(47, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(BotonIrAtras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonMostrarQRParaQueMandenMail)
                                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonoCrearNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BuscarClienteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextAreaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(BotonRealizarBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(BotonEnviarRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BotonAsignarRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BotonArchivarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BotonActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(35, 35, 35)
                                                .addComponent(BotonIrAtras))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(BotonMostrarQRParaQueMandenMail)))
                                .addGap(9, 9, 9))
        );
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void BotonEnviarRutinaActionPerformed(ActionEvent evt) {
        Gimnasio gym = GUIEnvoltorio.getGimnasio();//llamo a tod o el gimnasio
        Integer idSocioAuxInteger = 0;
        Integer filaSeleccionada = TablaClientes.getSelectedRow();
        String idSocioAuxString = "";


        if (filaSeleccionada != -1)//si selecciono una fila correctamente
        {

            idSocioAuxString = (String) TablaClientes.getValueAt(filaSeleccionada, 0);//Fila que selecciona el usuario, la comlumna 0 que es el ID
            idSocioAuxInteger = Integer.parseInt(idSocioAuxString);


            if (idSocioAuxInteger != null)//si el id es seleccionado
            {
                Cliente cliente = gym.buscar(idSocioAuxInteger);//agarro el cliente

                if (cliente.isEstado())
                {

                    if (gym.isTieneEjerciciosLaRutina(cliente))//si la rutina contiene ejercicios
                    {
                        gym.crearUnPDFConUnaRutina(cliente);//le genero el PDF con la rutina


                        // Crear y mostrar la ventana de espera
                        JfrEsperaPopUp esperaPopUp = new JfrEsperaPopUp((Frame) SwingUtilities.getWindowAncestor(this), "Enviando Email...");
                        esperaPopUp.showWindow();

                        // Crear y ejecutar la tarea en segundo plano
                        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() { //Nos permite trabajar en un segundo plano
                            @Override
                            protected Void doInBackground() throws Exception { //Este metodo ejecuta el envio del correo y si hay problmeas los cachea
                                try
                                {

                                    gym.enviarUnMail(cliente.geteMail(), "Rutina semanal", true); // Enviar la rutina por email

                                } catch (MessagingException e) {
                                    e.printStackTrace();
                                    JfrErrorPopUp errorPopUp = new JfrErrorPopUp(null, true, e.getMessage());
                                    errorPopUp.setVisible(true);
                                } catch (MailSinArrobaE e) {
                                    e.printStackTrace();
                                    JfrErrorPopUp errorPopUp = new JfrErrorPopUp(null, true, e.getMessage());
                                    errorPopUp.setVisible(true);
                                }
                                return null;
                            }

                            @Override
                            protected void done() { //Este metodo oculta la ventana

                                esperaPopUp.hideWindow();
                                JOptionPane.showMessageDialog(null, "Correo enviado correctamente!");
                            }
                        };

                        // Ejecutar la tarea
                        worker.execute();

                    } else {
                        JfrErrorPopUp errorPopUp = new JfrErrorPopUp(this, true, "La rutina se encuentra vacia");//si la rutina esta vacia le aviso que no se le va a enviar porque esta vacia
                    }
                }
                else {
                    JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp(this,true,"No es posible enviar una rutina ya que el cliente se encuentra archivado");
                }

            } else {
                JfrErrorPopUp errorPopUp = new JfrErrorPopUp(this, true, "Busque un cliente para enviar la rutina");//si no selecciona nada es null por lo que necesito seleccione
            }
        } else {
            JfrErrorPopUp errorPopUp = new JfrErrorPopUp(this, true, "Seleccione un cliente");//si no selecciona nada es null por lo que necesito seleccione
        }
    }

    private void TextAreaBusquedaActionPerformed(ActionEvent evt) {
    }

    private void BotonArchivarClienteActionPerformed(ActionEvent evt) {

        if (TablaClientes.getSelectedRow() != -1) {

            String idSocio = (String) TablaClientes.getValueAt(TablaClientes.getSelectedRow(), 0);//aunque sea un int el id, si lo hago string se rompe y lanza una exception
            Cliente clienteSeleccionado = GUIEnvoltorio.getGimnasio().buscar(Integer.valueOf(idSocio));//paso el string a int(lo parseo)
            clienteSeleccionado.setEstado(!clienteSeleccionado.isEstado());//pongo el estado contrario al que estaba antes
            TablaClientes.setValueAt(clienteSeleccionado.isEstado(),TablaClientes.getSelectedRow(),6);

            String mensaje;

            if (clienteSeleccionado.isEstado())//si es true es activo
            {
                // System.out.println(clienteSeleccionado.isEstado());
                mensaje= "Cliente activo";

            } else//inactivo/desarchivado
            {
                //System.out.println(clienteSeleccionado.isEstado());
                mensaje="Cliente archivado";
            }
            JfrAvisoPopUp jfrErrorPopUp = new JfrAvisoPopUp(this, true, mensaje);
        } else {
            JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "Seleccione un cliente");
        }
    }

    private void BotonAsignarRutinaActionPerformed(ActionEvent evt) {

        int filaSeleccionada = TablaClientes.getSelectedRow();

        if (filaSeleccionada != -1) {
            String idSocioSeleccionado = (String) TablaClientes.getValueAt(filaSeleccionada, 0);
            Cliente clienteAux = GUIEnvoltorio.getGimnasio().buscar(Integer.valueOf(idSocioSeleccionado));

            if (clienteAux.isEstado())
            {

                this.setVisible(false);
                JfrGenerarRutina rut = new JfrGenerarRutina(clienteAux);
                rut.setVisible(true);
            }
            else {
                JfrErrorPopUp jfrErrorPopUp= new JfrErrorPopUp(this,true,"El cliente elegido esta archivado");
            }

        } else {
            JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "Elija un cliente primero para asignarle una rutina");
        }


    }

    private void BuscarClienteMenuActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void BotonRealizarBusquedaClienteActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

        //muestro lo obtenido de la busqueda en la tabla
        ArrayList<Cliente> arrayQueSeMostrara = new ArrayList<>();
        ArrayList<Cliente> todosLosClientes = GUIEnvoltorio.getGimnasio().retornarListaDeClientes();

        String opcionElegida = (String) BuscarClienteMenu.getSelectedItem(); //obtengo el valor de la op q eligio el usuario
        assert opcionElegida != null; // aseguro que la variable opcionElegida no va a ser null

        opcionElegida = opcionElegida.toLowerCase();

        String busqueda = TextAreaBusqueda.getText(); //obtengo el valor de la caja de texto que hay

        busqueda = busqueda.replace(" ", ""); //le saco todos los espacios


        switch (opcionElegida) {
            case "todos":
                arrayQueSeMostrara = todosLosClientes;
                break;
            case "por id":


                if (!busqueda.isEmpty()) //si no contiene nada o si no hay espacios, tiene que haber un numero si o si
                {
                    //el parseo del string a Integer puede provocar errores si no se verifica

                    try {
                        int idLeido = Integer.parseInt(busqueda);

                        if (GUIEnvoltorio.getGimnasio().verificarSiExisteClienteXId(idLeido)) {

                            arrayQueSeMostrara.add(GUIEnvoltorio.getGimnasio().buscar(idLeido));
                        } else {
                            JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "El ID buscado no existe");
                        }
                    } catch (NumberFormatException e) {
                        JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "Solo puede ingresar numeros si busca por ID");
                    }

                } else {
                    JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No ingreso ningun ID");
                }

                break;
            case "por nombre":

                if (!busqueda.isEmpty()) {

                    for (Cliente cliente : todosLosClientes) {
                        if (cliente.getNombre().equalsIgnoreCase(busqueda)) {
                            arrayQueSeMostrara.add(cliente);
                        }
                    }
                    if (arrayQueSeMostrara.isEmpty()) {
                        JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No se encontro el nombre buscado");
                    }
                } else {
                    JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No ingreso ningun nombre");
                }

                break;
            case "por apellido":
                if (!busqueda.isEmpty()) {

                    for (Cliente cliente : todosLosClientes) {
                        if (cliente.getApellido().equalsIgnoreCase(busqueda)) {
                            arrayQueSeMostrara.add(cliente);
                        }
                    }
                    if (arrayQueSeMostrara.isEmpty()) {
                        JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No se encontro el apellido buscado");
                    }
                } else {
                    JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No ingreso ningun apellido");
                }
                break;
            case "por actividad":
                if (!busqueda.isEmpty())//si tengo algo en el campo de busqueda
                {

                    for (Cliente cliente : todosLosClientes)//recorro todos los clientes
                    {

                        if (cliente.getActividadesInscripto().contains(formatearBusquedaPorActividad(busqueda)))//si el cliente coincide con la busqueda del usuario se lo muestro en la tabla
                        {
                            arrayQueSeMostrara.add(cliente);//lo añado a la tabla
                        }

                    }
                    if (arrayQueSeMostrara.isEmpty()) {
                        JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No se encontro la actividad buscada");
                    }
                } else {
                    JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No ingreso ninguna actividad");
                }


                break;
            case "por sexo":
                try {
                    ESexo sexoElegido = ESexo.valueOf(busqueda.toUpperCase());
                    if (!busqueda.isEmpty()) {

                        for (Cliente cliente : todosLosClientes) {
                            if (cliente.getSexo() == sexoElegido) {
                                arrayQueSeMostrara.add(cliente);
                            }
                        }
                        if (arrayQueSeMostrara.isEmpty()) {
                            JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No hay ninguna persona del sexo elegido");
                        }
                    } else {
                        JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No ingreso ningun sexo");
                    }
                } catch (IllegalArgumentException e) {
                    JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "Ingrese un sexo valido: masculino o femenino");
                }
                break;
            case "por dni":
                if (!busqueda.isEmpty()) {

                    for (Cliente cliente : todosLosClientes) {
                        if (cliente.getDNI().equalsIgnoreCase(busqueda)) {
                            arrayQueSeMostrara.add(cliente);
                        }
                    }
                    if (arrayQueSeMostrara.isEmpty()) {
                        JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No se encontro el DNI buscado");
                    }
                } else {
                    JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No ingreso ningun apellido");
                }
                break;
            default:
                arrayQueSeMostrara = GUIEnvoltorio.getGimnasio().retornarListaDeClientes();
                break;
        }

        DefaultTableModel defaultTableModelClientes = (DefaultTableModel) TablaClientes.getModel();

        GUIEnvoltorio.limpiarTabla(defaultTableModelClientes);
        GUIEnvoltorio.agregarUnArrayDeClientesEnTablaDeClientes(defaultTableModelClientes, arrayQueSeMostrara, false);
    }


    private void TextBoxClienteBusquedaActionPerformed(ActionEvent evt) {

    }

    private void BotonoCrearNuevoClienteActionPerformed(ActionEvent evt) {

        this.setVisible(false);
        JfrAgregarNuevoCliente nuevo = new JfrAgregarNuevoCliente();
        nuevo.setVisible(true);


    }

    private void BotonIrAtrasActionPerformed(ActionEvent evt) {

        this.setVisible(false);
        JfrMenuPrincipal menu = new JfrMenuPrincipal();

    }

//    public Cliente pasarPersona(){
//        return cliente;
//    }

    public Cliente obtenerClienteSeleccionado() {

        ArrayList<Cliente> clienteArrayList = GUIEnvoltorio.getGimnasio().retornarListaDeClientes();

        int filaSeleccionada = TablaClientes.getSelectedRow();
        int idSocio = -1;
        try {
            idSocio = Integer.parseInt(TablaClientes.getValueAt(filaSeleccionada, 0).toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            JfrErrorPopUp jfrErrorPopUp = new JfrErrorPopUp(this, true, "No se selecciono ningun cliente");
        }

        Gimnasio gym = GUIEnvoltorio.getGimnasio();

        try {
            cliente = gym.buscar(idSocio);
        } catch (NullPointerException e) {
            JfrErrorPopUp errorPopUp = new JfrErrorPopUp(this, true, "N° de socio no encontrado");
        }

        return cliente;
    }

    private void BotonActualizarClienteActionPerformed(ActionEvent evt) {
        if (obtenerClienteSeleccionado() != null) {
            this.setVisible(false);

            JfrModificarCliente modificarCliente = new JfrModificarCliente(obtenerClienteSeleccionado());
            modificarCliente.setVisible(true);
        }


    }

    private String formatearBusquedaPorActividad(String str) {

        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();//formatea la 1er letra en mayuscula y lo demas en minuscula
    }


    private void BotonMostrarQRParaQueMandenMailActionPerformed(java.awt.event.ActionEvent evt) {
        PopupQR popupQR = new PopupQR();
    }

}





