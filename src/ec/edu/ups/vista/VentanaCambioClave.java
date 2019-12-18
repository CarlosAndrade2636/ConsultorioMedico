package ec.edu.ups.vista;

import javax.swing.JOptionPane;
import controlador.ConexionDB;
import controlador.ControladorUsuario;
import modelo.Usuario;

/**
 *
 * @author jessica
 */
public class VentanaCambioClave extends javax.swing.JFrame {

    public VentanaCambioClave() {
        initComponents();
        txtID.setText(String.valueOf(ConexionDB.getUsuarioSesion().getId()));
        txtNombre.setText(ConexionDB.getUsuarioSesion().getNombre());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btRegresar = new javax.swing.JButton();
        btCambiar = new javax.swing.JButton();
        txtClaveAnterior = new javax.swing.JPasswordField();
        txtClaveNueva = new javax.swing.JPasswordField();
        txtConfirmarClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCM - Cambio de clave");
        setUndecorated(true);
        setResizable(false);

        jLabel1.setText("ID:");

        txtID.setEditable(false);
        txtID.setEnabled(false);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Clave anterior:");

        jLabel4.setText("Clave nueva:");

        jLabel5.setText("Confirmar clave:");

        txtNombre.setEnabled(false);

        btRegresar.setText("Regresar");
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });

        btCambiar.setText("Cambiar");
        btCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCambiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClaveAnterior, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClaveNueva, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConfirmarClave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(txtID)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtClaveAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtClaveNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtConfirmarClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCambiar)
                    .addComponent(btRegresar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCambiarActionPerformed
        String claveAnterior = String.valueOf(txtClaveAnterior.getPassword());
        String claveNueva = String.valueOf(txtClaveNueva.getPassword());
        String confirmar = String.valueOf(txtConfirmarClave.getPassword());
        if(ConexionDB.getUsuarioSesion().getClave().equals(claveAnterior)) {
            if (claveNueva.equals(confirmar)) {
                Usuario usuario = ConexionDB.getUsuarioSesion();
                usuario.setClave(claveNueva);
                ControladorUsuario.modificar(usuario.getNombre(), usuario);
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "La clave ha sido actualizada!");
            } else {
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Las claves no coinciden!");
            }
        } else {
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "La clave anterior es incorrecta!");
        }
    }//GEN-LAST:event_btCambiarActionPerformed

    private void btRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegresarActionPerformed
        new MenuSeleccion().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btRegresarActionPerformed

    private void limpiarCampos() {
        txtClaveAnterior.setText("");
        txtClaveNueva.setText("");
        txtConfirmarClave.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCambiar;
    private javax.swing.JButton btRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtClaveAnterior;
    private javax.swing.JPasswordField txtClaveNueva;
    private javax.swing.JPasswordField txtConfirmarClave;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
