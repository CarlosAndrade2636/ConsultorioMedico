package ec.edu.ups.vista;

import javax.swing.JOptionPane;
import controlador.ControladorUsuario;
import modelo.Usuario;

/**
 *
 * @author jessica
 */
public class VentanaGestionUsuarios extends javax.swing.JFrame {

    String accion;
    String usuarioAnterior;
    
    public VentanaGestionUsuarios() {
        initComponents();
        accion = "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        cbRol = new javax.swing.JComboBox<>();
        btBuscar = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btListar = new javax.swing.JButton();
        btRegresar = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCM - Gestión de usuarios");
        setResizable(false);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel2.setText("Usuario:");

        jLabel3.setText("ID:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Clave:");

        jLabel6.setText("Rol:");

        txtID.setEditable(false);
        txtID.setEnabled(false);

        txtNombre.setEnabled(false);

        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Medico", "Recepcionista" }));
        cbRol.setEnabled(false);

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btAgregar.setText("Agregar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        btModificar.setText("Modificar");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });

        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
            }
        });

        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btListar.setText("Listar");
        btListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarActionPerformed(evt);
            }
        });

        btRegresar.setText("Regresar");
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });

        txtClave.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBusqueda)
                    .addComponent(txtNombre)
                    .addComponent(txtID)
                    .addComponent(cbRol, javax.swing.GroupLayout.Alignment.TRAILING, 0, 204, Short.MAX_VALUE)
                    .addComponent(txtClave))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(btEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(btRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btListar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAgregar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btModificar)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEliminar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardar)
                    .addComponent(btRegresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        Usuario usuario = ControladorUsuario.buscar(txtBusqueda.getText());
        if (usuario != null) {
            txtID.setText(String.valueOf(usuario.getId()));
            txtNombre.setText(usuario.getNombre());
            txtClave.setText(usuario.getClave());
            if (usuario.getRol().equals("admin")) {
                cbRol.setSelectedIndex(0);
            } else if (usuario.getRol().equals("medico")) {
                cbRol.setSelectedIndex(1);
            } else if (usuario.getRol().equals("recepcionista")) {
                cbRol.setSelectedIndex(2);
            }
            usuarioAnterior = txtNombre.getText();
            accion = "busqueda";
        } else {
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "Operacion fallida:\n" +
                                              "El usuario no existe!");
        }
        txtBusqueda.setText("");
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        new VentanaListarUsuarios().setVisible(true);
    }//GEN-LAST:event_btListarActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        limpiarCampos();
        txtBusqueda.setText("");
        int id = ControladorUsuario.generarID();
        txtID.setText(String.valueOf(id));
        txtNombre.setEnabled(true);
        txtClave.setEnabled(true);
        cbRol.setEnabled(true);
        accion = "insertar";
    }//GEN-LAST:event_btAgregarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        txtBusqueda.setText("");
        if (accion.equals("busqueda")) {
            txtNombre.setEnabled(true);
            txtClave.setEnabled(true);
            cbRol.setEnabled(true);
            btModificar.setEnabled(false);
            accion = "modificar";
        } else {
            limpiarCampos();
            txtNombre.setEnabled(false);
            txtClave.setEnabled(false);
            cbRol.setEnabled(false);
            btModificar.setEnabled(true);
            accion = "";
            JOptionPane.showMessageDialog(null, "Accion cancelada:\n" +
                                              "Primero busque el usuario a modificar!");
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        txtBusqueda.setText("");
        desactivarCampos();
        if (accion.equals("busqueda")) {
            btEliminar.setEnabled(false);
            accion = "eliminar";
        } else {
            limpiarCampos();
            btEliminar.setEnabled(true);
            accion = "";
            JOptionPane.showMessageDialog(null, "Accion cancelada:\n" +
                                              "Primero busque el usuario a eliminar!");
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        if (accion.equals("")) {
            JOptionPane.showMessageDialog(null, "Sin cambios a realizar!");
            return;
        } else {
            int opcion = JOptionPane.showConfirmDialog(null, "Confirmar:\n" +
                                                   "Esta seguro de continuar?",
                                                   null,
                                                   JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Operacion cancelada!");
                return;
            }
        }
        int id = Integer.valueOf(txtID.getText());
        String nombre = txtNombre.getText();
        String clave = String.valueOf(txtClave.getPassword());
        String rol = String.valueOf(cbRol.getSelectedItem()).toLowerCase();
        if (accion.equals("insertar")) {
            if (ControladorUsuario.agregar(new Usuario(id, nombre, clave, rol))) {
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Operacion exitosa:\n" +
                                              "El usuario ha sido registrado!");
            } else {
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Operación cancelada:\n" +
                                              "El usuario ya existe en el sistema!.");
            }
        } else if (accion.equals("modificar")) {
            if (ControladorUsuario.modificar(usuarioAnterior,new Usuario(id, nombre, clave, rol))) {
                limpiarCampos();
                btModificar.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Operacion exitosa:\n" +
                                              "El usuario ha sido modificado!");
            }
        } else if (accion.equals("eliminar")) {
            if (ControladorUsuario.eliminar(usuarioAnterior)) {
                limpiarCampos();
                btEliminar.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Operacion exitosa:\n" +
                                              "El usuario ha sido eliminado!");
            }
        }
        desactivarCampos();
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegresarActionPerformed
        new MenuSeleccion().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btRegresarActionPerformed
    
    private void limpiarCampos() {
        txtBusqueda.setText("");
        txtID.setText("");
        txtNombre.setText("");
        txtClave.setText("");
        cbRol.setSelectedIndex(0);
    }

    public void activarCampos() {
        txtNombre.setEnabled(true);
        txtClave.setEnabled(true);
        cbRol.setEnabled(true);
    }
    
    public void desactivarCampos() {
        txtNombre.setEnabled(false);
        txtClave.setEnabled(false);
        cbRol.setEnabled(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btListar;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btRegresar;
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
