package ec.ups.edu.vista;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorCita;
import controlador.ControladorConsulta;
import modelo.Cita;
import modelo.Consulta;
import modelo.Medico;
import modelo.RenderizadorJButton;

/**
 *
 * @author jessica
 */
public class PanelCitasPaciente extends javax.swing.JPanel {

    public PanelCitasPaciente() {
        initComponents();
        limpiarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbCitas = new javax.swing.JTable();

        tbCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Hora", "Motivo", "Medico", "Estado", "Consulta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCitasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCitas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCitasMouseClicked
        int fila = evt.getY() / tbCitas.getRowHeight();
        int columna = tbCitas.getColumnModel().getColumnIndexAtX(evt.getX());
        boolean existenFilas = tbCitas.getRowCount() > 0;
        boolean existenColumnas = tbCitas.getColumnCount() > 0;
        if (existenFilas && existenColumnas) {
            Object valor = tbCitas.getValueAt(fila, columna);
            if (valor instanceof JButton) {
                ((JButton) valor).doClick();
            }
        }
    }//GEN-LAST:event_tbCitasMouseClicked

    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tbCitas.getModel();
        for (int i = 0; modelo.getRowCount() > 0; i++) {
            modelo.removeRow(i);
        }
        tbCitas.setModel(modelo);
    }
    
    public void setDatosCita(String idPaciente) {
        DefaultTableModel modelo = (DefaultTableModel) tbCitas.getModel();
        tbCitas.setDefaultRenderer(Object.class, new RenderizadorJButton());
        tbCitas.setRowHeight(30);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-YYYY");
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm");
        List<Cita> citas = ControladorCita.listarCitasNoAsistidas(idPaciente);
        List<Consulta> consultas = ControladorConsulta.listarConsultasEspecificas(idPaciente);
        for (Cita cita : citas) {
            String fecha = formatoFecha.format(cita.getFecha());
            String hora = formatoHora.format(new Date(Long.valueOf(cita.getHora())));
            String motivo = cita.getPrioridad();
            Medico medico = cita.getMedico();
            String nombreMedico = medico.getNombre() + " " + medico.getApellido();
            String estado = cita.getEstado();
            modelo.addRow(new Object[]{fecha, hora, motivo, nombreMedico, estado, null});
        }
        for (Consulta consulta : consultas) {
            Cita cita = consulta.getCita();
            String fecha = formatoFecha.format(cita.getFecha());
            String hora = formatoHora.format(new Date(Long.valueOf(cita.getHora())));
            String motivo = cita.getPrioridad();
            Medico medico = cita.getMedico();
            String nombreMedico = medico.getNombre() + " " + medico.getApellido();
            String estado = cita.getEstado();
            JButton boton = new JButton("Ver");
            boton.setVisible(true);
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    verConsulta(consulta);
                }
            });
            modelo.addRow(new Object[]{fecha, hora, motivo, nombreMedico, estado, boton});
        }
        tbCitas.setModel(modelo);
    }
    
    private void verConsulta(Consulta consulta) {
        Component[] componentes = this.getParent().getComponents();
        for (Component componente : componentes) {
            if (componente instanceof PanelConsultasPaciente) {
                ((PanelConsultasPaciente) componente).setDatos(consulta);
                ((PanelConsultasPaciente) componente).requestFocus();
            } else if (componente instanceof PanelRecetasPaciente) {
                ((PanelRecetasPaciente) componente).agregarReceta(consulta.getId());
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCitas;
    // End of variables declaration//GEN-END:variables
}