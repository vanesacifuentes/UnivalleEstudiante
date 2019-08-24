/*
 * Programa	: InterfazPrincipal.java
 * Fecha	: 10/04/2016
 * Objetivo	: Construye la interfaz principal de la aplicación
 * Programador	: Luis Yovany Romo Portilla
 */
package Vista;

import Controlador.ProgramaController;
import Controlador.ControllerEstudiante;
import javax.swing.JOptionPane;
import modelo.EstudianteDAO;
import modelo.ProgramaDAO;

/**
 *
 * @author Admin
 */
public class InterfazPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form InterfazPrincipal
     */
    public InterfazPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jmbMenu = new javax.swing.JMenuBar();
        jmPrincipal = new javax.swing.JMenu();
        jmiPrograma = new javax.swing.JMenuItem();
        jMenuEstudiante = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiSalir = new javax.swing.JMenuItem();
        jmAyuda = new javax.swing.JMenu();
        hmiAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jmPrincipal.setText("Principal");
        jmPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPrincipalActionPerformed(evt);
            }
        });

        jmiPrograma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jmiPrograma.setText("Programa");
        jmiPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProgramaActionPerformed(evt);
            }
        });
        jmPrincipal.add(jmiPrograma);

        jMenuEstudiante.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuEstudiante.setText("Estudiante");
        jMenuEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEstudianteActionPerformed(evt);
            }
        });
        jmPrincipal.add(jMenuEstudiante);
        jmPrincipal.add(jSeparator1);

        jmiSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jmPrincipal.add(jmiSalir);

        jmbMenu.add(jmPrincipal);

        jmAyuda.setText("Ayuda");

        hmiAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        hmiAcerca.setText("Acerca de");
        hmiAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hmiAcercaActionPerformed(evt);
            }
        });
        jmAyuda.add(hmiAcerca);

        jmbMenu.add(jmAyuda);

        setJMenuBar(jmbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPrincipalActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jmPrincipalActionPerformed

    private void jmiProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProgramaActionPerformed
        // TODO add your handling code here:
        //ProgramaIG programaIG = new ProgramaIG();
        ProgramaIG programaView = new ProgramaIG();
        ProgramaDAO programaModel = new ProgramaDAO();
       
        
        ProgramaController programaController = 
                new ProgramaController(programaView, programaModel);
        
        int x = (jDesktopPane1.getWidth() / 2) - programaView.getWidth() /2;
        int y = (jDesktopPane1.getHeight() / 2) - programaView.getHeight() /2;

        if (programaView.isShowing()){
            programaView.setLocation(x,y);
        }
        else{
            jDesktopPane1.add(programaView);
            programaView.setLocation(x,y);
            programaView.setVisible(true);
        }
       
    }//GEN-LAST:event_jmiProgramaActionPerformed

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jmiSalirActionPerformed

    private void hmiAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hmiAcercaActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this,"Univalle V 0.1","Acerca de ",2); 
    }//GEN-LAST:event_hmiAcercaActionPerformed

    private void jMenuEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEstudianteActionPerformed
        // TODO add your handling code here:
                
        EstudianteIG estudianteView = new EstudianteIG();
        EstudianteDAO estudianteModel = new EstudianteDAO();
        
       ControllerEstudiante estudianteController = new ControllerEstudiante(estudianteView, estudianteModel);
               
        int x = (jDesktopPane1.getWidth() /2) - estudianteView.getWidth()/2;
        
        int y = (jDesktopPane1.getWidth() /2) - estudianteView.getWidth()/2;
        
        if (estudianteView.isShowing()){
            estudianteView.setLocation(x, y);
        }
        else{
            jDesktopPane1.add(estudianteView);
            estudianteView.setLocation(x, y);
            estudianteView.setVisible(true);
        }
    }//GEN-LAST:event_jMenuEstudianteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem hmiAcerca;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuItem jMenuEstudiante;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu jmAyuda;
    private javax.swing.JMenu jmPrincipal;
    private javax.swing.JMenuBar jmbMenu;
    private javax.swing.JMenuItem jmiPrograma;
    private javax.swing.JMenuItem jmiSalir;
    // End of variables declaration//GEN-END:variables
}
