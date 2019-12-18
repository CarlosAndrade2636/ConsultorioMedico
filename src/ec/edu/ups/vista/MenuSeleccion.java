package ec.edu.ups.vista;

import controlador.ConexionDB;
import javax.swing.ImageIcon;

/**
 *
 * @author jessica
 */
public class MenuSeleccion extends javax.swing.JFrame {

    private String rol;
    
    public MenuSeleccion() {
        initComponents();
        rol = ConexionDB.getUsuarioSesion().getRol();
        if (rol.equals("medico") || rol.equals("recepcionista")) {
            btUsuarios.setEnabled(false);
        }
        if (rol.equals("recepcionista")) {
            btPacientes.setEnabled(true);
           // JLabel1.setIcon(new ImageIcon(ruta));
           // jLabel1.setIcon(new ImageIcon("/imagenes/recepcionista.png"));
            this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/recepcionista.png")).getImage());

        
        }
        if (rol.equals("medico")) {
            btCitas.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btUsuarios = new javax.swing.JButton();
        btMedicos = new javax.swing.JButton();
        btPacientes = new javax.swing.JButton();
        btCerrarSesion = new javax.swing.JButton();
        btCambiarClave = new javax.swing.JButton();
        btCitas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCM - Menu principal");
        setAlwaysOnTop(true);

        btUsuarios.setText("Usuarios");
        btUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuariosActionPerformed(evt);
            }
        });

        btMedicos.setText("Medicos");
        btMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMedicosActionPerformed(evt);
            }
        });

        btPacientes.setText("Pacientes");
        btPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPacientesActionPerformed(evt);
            }
        });

        btCerrarSesion.setText("Cerrar Sesión");
        btCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarSesionActionPerformed(evt);
            }
        });

        btCambiarClave.setText("Cambiar clave");
        btCambiarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCambiarClaveActionPerformed(evt);
            }
        });

        btCitas.setText("Citas");
        btCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCitasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCambiarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btUsuarios)
                .addGap(18, 18, 18)
                .addComponent(btPacientes)
                .addGap(18, 18, 18)
                .addComponent(btCitas))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btMedicos)
                .addGap(18, 18, 18)
                .addComponent(btCambiarClave)
                .addGap(18, 18, 18)
                .addComponent(btCerrarSesion))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarSesionActionPerformed
        new InicioSesion().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btCerrarSesionActionPerformed

    private void btUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuariosActionPerformed
        new VentanaGestionUsuarios().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btUsuariosActionPerformed

    private void btMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMedicosActionPerformed
        if (rol.equals("medico")) {
            new VentanaDatosMedico().setVisible(true);
        } else {
            new VentanaGestionMedicos().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btMedicosActionPerformed

    private void btPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPacientesActionPerformed
        if (rol.equals("medico")) {
            new VentanaDatosPaciente().setVisible(true);
        } else {
            new VentanaGestionPacientes().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btPacientesActionPerformed

    private void btCambiarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCambiarClaveActionPerformed
        new VentanaCambioClave().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btCambiarClaveActionPerformed

    private void btCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCitasActionPerformed
        new VentanaGestionCitas().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btCitasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCambiarClave;
    private javax.swing.JButton btCerrarSesion;
    private javax.swing.JButton btCitas;
    private javax.swing.JButton btMedicos;
    private javax.swing.JButton btPacientes;
    private javax.swing.JButton btUsuarios;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}