package ec.edu.ups.vista;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import controlador.ControladorCita;
import controlador.ControladorPersona;
import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author jessica
 */
public class VentanaGestionCitas extends javax.swing.JFrame {

    private int id;
    private String accion;
    private DefaultComboBoxModel<Medico> modeloCBMedicos;
    private DefaultComboBoxModel<Paciente> modeloCBPacientes;
            
    public VentanaGestionCitas() {
        initComponents();
        modeloCBMedicos = new DefaultComboBoxModel();
        modeloCBPacientes = new DefaultComboBoxModel();
        List<Medico> listaMedicos = ControladorPersona.listarMedicos();
        List<Paciente> listaPacientes = ControladorPersona.listarPacientes();
        for (Medico medico : listaMedicos) {
            modeloCBMedicos.addElement(medico);
        }
        for (Paciente paciente : listaPacientes) {
            modeloCBPacientes.addElement(paciente);
        }
        cbMedico.setModel(modeloCBMedicos);
        cbPaciente.setModel(modeloCBPacientes);
        btFecha.setCalendar(new GregorianCalendar());
        accion = "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spHora = new javax.swing.JSpinner();
        cbMedico = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtMotivo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbPaciente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btRegresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JFormattedTextField();
        btFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Fecha:");

        jLabel2.setText("Hora:");

        spHora.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));
        spHora.setEditor(new javax.swing.JSpinner.DateEditor(spHora, "HH:mm"));
        spHora.setEnabled(false);

        cbMedico.setEnabled(false);

        jLabel3.setText("Medico:");

        txtMotivo.setEnabled(false);

        jLabel4.setText("Motivo:");

        cbPaciente.setEnabled(false);

        jLabel5.setText("Paciente:");

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

        btRegresar.setText("Regresar");
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });

        jLabel6.setText("ID:");

        txtID.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        btFecha.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbPaciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spHora)
                    .addComponent(txtMotivo)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btBuscar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1))
                            .addComponent(btFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btModificar)))
                    .addComponent(btAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btRegresar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        Cita cita = ControladorCita.buscar(Integer.valueOf(txtID.getText()));
        if (cita != null) {
            btFecha.setDate(cita.getFecha());
            spHora.setValue(new Date(Long.valueOf(cita.getHora())));
            txtMotivo.setText(cita.getPrioridad());
            cbMedico.setSelectedItem(cita.getMedico());
            cbPaciente.setSelectedItem(cita.getPaciente());
            id = cita.getId();
            accion = "busqueda";
        } else {
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "Operacion fallida:\n" +
                                                "La cita no existe!");
        }
        txtID.setText("");
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        txtID.setText("");
        txtID.setEnabled(false);
        limpiarCampos();
        activarCampos();
        id = ControladorCita.generarID();
        accion = "insertar";
    }//GEN-LAST:event_btAgregarActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        txtID.setText("");
        txtID.setEnabled(false);
        if (accion.equals("busqueda")) {
            activarCampos();
            btModificar.setEnabled(false);
            accion = "modificar";
        } else {
            limpiarCampos();
            desactivarCampos();
            btModificar.setEnabled(true);
            accion = "";
            JOptionPane.showMessageDialog(null, "Operacion fallida:\n" +
                                                "Primero busque la cita a modificar!");
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed
        txtID.setText("");
        txtID.setEnabled(false);
        if (accion.equals("busqueda")) {
            btEliminar.setEnabled(false);
            accion = "eliminar";
        } else {
            limpiarCampos();
            desactivarCampos();
            btEliminar.setEnabled(true);
            accion = "";
            JOptionPane.showMessageDialog(null, "Operacion fallida:\n" +
                                                "Primero busque la cita a eliminar!");
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
                limpiarCampos();
                desactivarCampos();
                JOptionPane.showMessageDialog(null, "Operacion cancelada!");
                return;
            }
        }
        SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-yyyy");
        Date fecha = btFecha.getDate();
        Date horaNoFormateada = (Date) spHora.getValue();
        String horaFormateada = String.valueOf(horaNoFormateada.getTime());
        String motivo = txtMotivo.getText();
        Medico medico = (Medico) cbMedico.getSelectedItem();
        Paciente paciente = (Paciente) cbPaciente.getSelectedItem();
        String estado = "No asistido";
        Cita cita = new Cita(id, fecha, horaFormateada, motivo, medico, paciente, estado);
        if (accion.equals("insertar")) {
            if (ControladorCita.agregar(cita)) {
                JOptionPane.showMessageDialog(null, "Operacion exitosa:\n" +
                                              "La cita ha sido registrada!");
            } else {
                JOptionPane.showMessageDialog(null, "Operación cancelada:\n" +
                                              "La cita ya existe en el sistema!.");
            }
        } else if (accion.equals("modificar")) {
            if (ControladorCita.modificar(cita)) {
                btModificar.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Operacion exitosa:\n" +
                                              "La cita ha sido modificada!");
            }
        } else if (accion.equals("eliminar")) {
            if (ControladorCita.eliminar(id)) {
                btEliminar.setEnabled(true);
                JOptionPane.showMessageDialog(null, "Operacion exitosa:\n" +
                                              "La cita ha sido eliminado!");
            }
        }
        txtID.setText("");
        txtID.setEnabled(true);
        limpiarCampos();
        desactivarCampos();
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegresarActionPerformed
        new MenuSeleccion().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btRegresarActionPerformed

    private void limpiarCampos() {
        btFecha.setDate(Date.from(Instant.now()));
        spHora.setValue(Date.from(Instant.now()));
        txtMotivo.setText("");
        cbMedico.setSelectedItem(0);
        cbPaciente.setSelectedItem(0);
    }
    
    private void activarCampos() {
        btFecha.setEnabled(true);
        spHora.setEnabled(true);
        txtMotivo.setEnabled(true);
        cbMedico.setEnabled(true);
        cbPaciente.setEnabled(true);
    }
    
    private void desactivarCampos() {
        btFecha.setEnabled(false);
        spHora.setEnabled(false);
        txtMotivo.setEnabled(false);
        cbMedico.setEnabled(false);
        cbPaciente.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btEliminar;
    private com.toedter.calendar.JDateChooser btFecha;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Medico> cbMedico;
    private javax.swing.JComboBox<Paciente> cbPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner spHora;
    private javax.swing.JFormattedTextField txtID;
    private javax.swing.JTextField txtMotivo;
    // End of variables declaration//GEN-END:variables
}