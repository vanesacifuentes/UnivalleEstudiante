/*
 * Programa	: ProgramaIG.java
 * Fecha	: 10/04/2016
 * Objetivo	: Construye la interfaz para el manejo de datos de la Programa
 * Programador	: Luis Yovany Romo Portilla
 */

package Vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Estudiante;// lzjzcjas


/**
 *
 * @author Admin
 */
public class EstudianteIG extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form Profesor
     */
    public EstudianteIG() {       
        initComponents();                       
    }
       
    
    //Borra todas la filas del jTable
    private void limpiarListadoTabla(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtListado.getModel();
        for(int i=modelo.getRowCount()-1; i>=0 ; i--){
            modelo.removeRow(i);
        }
    }
    
    //Carga los datos de las comunas en el jTable
     public void cargarEstudiantes(ArrayList <Estudiante> listadoEstudiantes){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtListado.getModel();        
        limpiarListadoTabla();
        for(int i= 0; i < listadoEstudiantes.size(); i++){
              modelo.addRow(new Object[]{
              listadoEstudiantes.get(i).getCodigo(),
              listadoEstudiantes.get(i).getNombre(),
              listadoEstudiantes.get(i).getSexo(),
              listadoEstudiantes.get(i).getCodigoPrograma()});
        }
    }
    
    //EXPLICAR *********************************++
    public String getCodigo(){
        return txtCodigo.getText().trim();
    }
    
    public String getSexo(){
        return cbxSexo.getSelectedItem().toString().trim();
    }
    
    public String getNombre(){
        return txtNombre.getText();
    }
    
    public String getCodigoPrograma(){
        return txtCodigoPrograma.getText().trim();
    }
        
    public void addListenerBtnNuevo(ActionListener listenEstudiante){
        btnNuevo.addActionListener(listenEstudiante);       
    }
    
    public void addListenerBtnModificar(ActionListener listenEstudiante){
        btnCerrar.addActionListener(listenEstudiante);        
    }
    
    public void addListenerBtnBorrar(ActionListener listenEstudiante){
        btnBorrar.addActionListener(listenEstudiante);        
    }
    
    public void addListenerBtnCerrar(ActionListener listenEstudiante){
        btnModificar.addActionListener(listenEstudiante);        
    }    
     
    //Explicar***************************************
    
    public void gestionMensajes(String mensaje, String titulo, int icono){
         JOptionPane.showMessageDialog(this,mensaje, titulo, icono);
    }
       
    public void activarControles(boolean estado){
        txtCodigo.setEnabled(estado);
        txtNombre.setEnabled(estado);
        cbxSexo.setEnabled(estado);
        txtCodigoPrograma.setEnabled(estado);        
        btnBorrar.setEnabled(!estado);
        btnCerrar.setEnabled(!estado);
        jtListado.setEnabled(!estado);
    }
    
    public void modificarAction(){
        if(btnModificar.getText().equals("Modificar")){
            if(jtListado.getSelectedRow() == -1){
               if(jtListado.getRowCount() == 0){
                   JOptionPane.showMessageDialog(this,"No hay registros");
               }
               else{
                   JOptionPane.showMessageDialog(this,"Seleccione una fila");
               }
            }else{ 
                activarControles(true); 
                txtCodigo.setEnabled(false);
                btnNuevo.setText("Actualizar");
                btnNuevo.setActionCommand("Actualizar");            
                btnModificar.setText("Cancelar");
                btnModificar.setActionCommand("Cancelar");
                btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/save-program.png"))); // NOI18N
                btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/cancel.png"))); // NOI18N
                txtNombre.requestFocusInWindow();
            }
        }else{
            activarControles(false);            
            btnNuevo.setText("Nuevo");
            btnNuevo.setActionCommand("Nuevo");
            btnModificar.setText("Modificar");
            btnModificar.setActionCommand("Modificar");
            btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/new-program.png"))); // NOI18N
            btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/update-program.png"))); // NOI18N
            btnNuevo.requestFocusInWindow();
        }
    }
    
     public void nuevoAction(){          
        if(btnNuevo.getText().equals("Nuevo")){  
            txtCodigo.setText("");
            txtNombre.setText("");
            cbxSexo.setSelectedIndex(0);
            txtCodigoPrograma.setText("");   
            activarControles(true); 
            btnNuevo.setText("Grabar");
            btnNuevo.setActionCommand("Grabar");            
            btnModificar.setText("Cancelar");
            btnModificar.setActionCommand("Cancelar");
            btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/save-program.png"))); // NOI18N
            btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/cancel.png"))); // NOI18N
            txtCodigo.requestFocusInWindow();
        }
        else{
            activarControles(false);            
            btnNuevo.setText("Nuevo");
            btnNuevo.setActionCommand("Nuevo");
            btnModificar.setText("Modificar");
            btnModificar.setActionCommand("Modificar");
            btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/new-program.png"))); // NOI18N
            btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/update-program.png"))); // NOI18N
            btnNuevo.requestFocusInWindow();
        }
    }       
           
    public void cancelarAction(){
        txtNombre.setEnabled(false);
        cbxSexo.setEnabled(false);
        txtCodigoPrograma.setEnabled(false);        
        btnBorrar.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnCerrar.setEnabled(false);
        jtListado.setEnabled(true);
    }
    
    public void cerrarAction(){
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2Sexo = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox();
        jLabel4CodPrograma = new javax.swing.JLabel();
        txtCodigoPrograma = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListado = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gestión de Estudiantes");
        setToolTipText("");
        setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Programa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabelCodigo.setText("Codigo : ");

        txtCodigo.setEnabled(false);
        txtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoFocusGained(evt);
            }
        });

        jLabelNombre.setText("Nombre : ");

        txtNombre.setEnabled(false);
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });

        jLabel2Sexo.setText("Sexo : ");

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar ...", "Masculino", "Femenino" }));
        cbxSexo.setEnabled(false);
        cbxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSexoActionPerformed(evt);
            }
        });

        jLabel4CodPrograma.setText("Codigo Programa :");

        txtCodigoPrograma.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCodigo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(288, 288, 288))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4CodPrograma)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2Sexo)
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2Sexo)
                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4CodPrograma)
                    .addComponent(txtCodigoPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/new-program.png"))); // NOI18N
        btnNuevo.setText("Nuevo");

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/update-program.png"))); // NOI18N
        btnModificar.setText("Modificar");

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete-program.png"))); // NOI18N
        btnBorrar.setText("Borrar");

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/close.png"))); // NOI18N
        btnCerrar.setText("Salir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnNuevo)
                .addGap(9, 9, 9)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jtListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Sexo", "Cod_programa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListado.getTableHeader().setReorderingAllowed(false);
        jtListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListado);
        if (jtListado.getColumnModel().getColumnCount() > 0) {
            jtListado.getColumnModel().getColumn(0).setMinWidth(80);
            jtListado.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtListado.getColumnModel().getColumn(0).setMaxWidth(80);
            jtListado.getColumnModel().getColumn(1).setMinWidth(250);
            jtListado.getColumnModel().getColumn(1).setPreferredWidth(250);
            jtListado.getColumnModel().getColumn(1).setMaxWidth(250);
            jtListado.getColumnModel().getColumn(2).setMinWidth(100);
            jtListado.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtListado.getColumnModel().getColumn(2).setMaxWidth(100);
            jtListado.getColumnModel().getColumn(3).setMinWidth(80);
            jtListado.getColumnModel().getColumn(3).setPreferredWidth(80);
            jtListado.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Datos Estudiante");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoFocusGained
        // TODO add your handling code here:
        txtCodigo.selectAll();
    }//GEN-LAST:event_txtCodigoFocusGained

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        // TODO add your handling code here:
        txtNombre.selectAll();
    }//GEN-LAST:event_txtNombreFocusGained

    private void jtListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoMouseClicked
        // TODO add your handling code here:
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtListado.getModel();
                            
        if(jtListado.getSelectedRow()==-1){
            if(jtListado.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"No hay registros");
            }
            else{
                JOptionPane.showMessageDialog(this,"Seleccione una fila");
            }
        }else {                               
            txtCodigo.setText(modelo.getValueAt(
                    jtListado.getSelectedRow(), 0).toString());            
            txtNombre.setText(modelo.getValueAt(
                    jtListado.getSelectedRow(), 1).toString());
            cbxSexo.setSelectedItem(modelo.getValueAt(
                    jtListado.getSelectedRow(), 2).toString());  
            txtCodigoPrograma.setText(modelo.getValueAt(
                    jtListado.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_jtListadoMouseClicked

    private void cbxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSexoActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cbxSexo;
    private javax.swing.JLabel jLabel2Sexo;
    private javax.swing.JLabel jLabel4CodPrograma;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtListado;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoPrograma;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
