package org.example.GUI;

import java.awt.geom.Area;

public class JfrEstadisticas  extends javax.swing.JFrame{


    private javax.swing.JTextArea AreaDeTextoEstadisticas;
    private javax.swing.JButton BotonAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;



    public JfrEstadisticas() {
        initComponents();
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AreaDeTextoEstadisticas = new javax.swing.JTextArea();
        BotonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 500));

        jPanel1.setBackground(new java.awt.Color(63, 63, 63));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LOGO FINAL.png"))); // NOI18N

        AreaDeTextoEstadisticas.setEditable(false);
        AreaDeTextoEstadisticas.setBackground(new java.awt.Color(130, 130, 130));
        AreaDeTextoEstadisticas.setColumns(20);
        AreaDeTextoEstadisticas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AreaDeTextoEstadisticas.setForeground(new java.awt.Color(242, 242, 242));
        AreaDeTextoEstadisticas.setRows(22);
        AreaDeTextoEstadisticas.setTabSize(100);
        AreaDeTextoEstadisticas.setBorder(null);
        jScrollPane2.setViewportView(AreaDeTextoEstadisticas);

        BotonAtras.setBackground(new java.awt.Color(63, 63, 63));
        BotonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/return.png"))); // NOI18N
        BotonAtras.setBorder(null);
        BotonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(54, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2))
                                .addGap(54, 54, 54))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(BotonAtras)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BotonAtras)
                                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>

    private void BotonAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        JfrMenuPrincipal menu = new JfrMenuPrincipal();
        menu.setVisible(true);
    }

    public void actualizarTextoEstadisticas(String texto){
        AreaDeTextoEstadisticas.setText(texto);
    }
}