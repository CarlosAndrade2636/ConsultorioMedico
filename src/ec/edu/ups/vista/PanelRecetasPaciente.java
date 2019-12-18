package ec.edu.ups.vista;

import javax.swing.JFileChooser;
import controlador.ControladorConsulta;
import modelo.Consulta;

/**
 *
 * @author jessica
 */
public class PanelRecetasPaciente extends javax.swing.JPanel {

    private Consulta consultaFinal;
    
    public PanelRecetasPaciente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReceta = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtIndicaciones = new javax.swing.JTextArea();
        btImprimir = new javax.swing.JButton();

        jLabel1.setText("Receta:");

        txtReceta.setColumns(20);
        txtReceta.setRows(5);
        txtReceta.setEnabled(false);
        jScrollPane1.setViewportView(txtReceta);

        jLabel2.setText("Indicaciones:");

        txtIndicaciones.setColumns(20);
        txtIndicaciones.setRows(5);
        txtIndicaciones.setEnabled(false);
        jScrollPane2.setViewportView(txtIndicaciones);

        btImprimir.setText("Imprimir");
        btImprimir.setEnabled(false);
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btImprimir))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        imprimirReceta();
    }//GEN-LAST:event_btImprimirActionPerformed
    
    public void agregarReceta(int idConsultaElegida) {
        Consulta consulta = ControladorConsulta.buscar(idConsultaElegida);
        txtReceta.setText(consulta.getReceta());
        txtIndicaciones.setText(consulta.getIndicaciones());
        btImprimir.setEnabled(true);
    }

    public void generarReceta(int idConsultaElegida) {
        consultaFinal = ControladorConsulta.buscar(idConsultaElegida);
        if (consultaFinal != null) {
            consultaFinal.setReceta(txtReceta.getText());
            consultaFinal.setIndicaciones(txtIndicaciones.getText());
            ControladorConsulta.modificar(consultaFinal);
            imprimirReceta();
        }
    }
    
    private void imprimirReceta() {
        PanelExportarReceta panel = new PanelExportarReceta(consultaFinal);
        panel.setVisible(true);
        String ruta = buscarRutaGuardado();
        panel.imprimirImagen(ruta);
        panel.dispose();
    }
    
    private String buscarRutaGuardado() {
        JFileChooser menu = new JFileChooser();
        menu.setDialogType(JFileChooser.FILES_AND_DIRECTORIES);
        int respuesta = menu.showSaveDialog(null);
        String ruta = "";
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            ruta = menu.getSelectedFile().getPath();
        }
        return ruta;
    }
    
    public void limpiarCampos() {
        txtReceta.setText("");
        txtIndicaciones.setText("");
    }
    
    public void activarCampos() {
        btImprimir.setEnabled(true);
        txtReceta.setEnabled(true);
        txtIndicaciones.setEnabled(true);
    }
    
    public void desactivarCampos() {
        btImprimir.setEnabled(false);
        txtReceta.setEnabled(false);
        txtIndicaciones.setEnabled(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtIndicaciones;
    private javax.swing.JTextArea txtReceta;
    // End of variables declaration//GEN-END:variables
}
