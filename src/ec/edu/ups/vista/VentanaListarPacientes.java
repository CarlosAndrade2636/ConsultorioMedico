package ec.edu.ups.vista;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorPersona;
import modelo.Paciente;

/**
 *
 * @author jessica
 */
public class VentanaListarPacientes extends javax.swing.JFrame {

    public VentanaListarPacientes() {
        initComponents();
        listarPacientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbPacientes = new javax.swing.JTable();
        btRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCM - Listar Pacientes");
        setUndecorated(true);
        setResizable(false);

        tbPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "Sexo", "Fecha de Nacimiento", "Procedencia", "Tipo de Sangre", "Etnia", "Instrucción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbPacientes);

        btRegresar.setText("Regresar");
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(btRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btRegresar)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btRegresarActionPerformed

    private void listarPacientes() {
        List<Paciente> lista = ControladorPersona.listarPacientes();
        DefaultTableModel modelo = (DefaultTableModel) tbPacientes.getModel();
        String nombre;
        String sexo;
        String fechaNacimiento;
        String procedencia;
        String tipoSangre;
        String etnia;
        String instruccion;
        for (Paciente paciente : lista) {
            nombre = paciente.getNombre() + " " + paciente.getApellido();
            sexo = String.valueOf(paciente.getSexo());
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-YYYY");
            fechaNacimiento = formato.format(paciente.getFechaNacimiento());
            procedencia = paciente.getProcedencia();
            tipoSangre = paciente.getTipoSangre();
            etnia = paciente.getEtnia();
            instruccion = paciente.getInstruccion();
            modelo.addRow(new Object[]{nombre, sexo, fechaNacimiento, procedencia,
                                       tipoSangre, etnia, instruccion});
        }
        tbPacientes.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPacientes;
    // End of variables declaration//GEN-END:variables
}
