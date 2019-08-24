/*
 * Programa	: ProgramaController.java
 * Fecha	: 10/04/2016
 * Objetivo	: Recibe acciones de la vista y lanza acciones del modelo
 *                Programa
 * Programador	: Luis Yovany Romo Portilla
 */
package Controlador;

import Vista.ProgramaIG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Programa;
import modelo.ProgramaDAO;

/**
 *
 * @author Admin
 */
public class ProgramaController {
    
    private ProgramaIG vista;
    private ProgramaDAO modelo;
    
     /**
     * @param vista Instancia de la vista de Programa
     * @param modelo Instancia del modelo de Programa
     */
    public ProgramaController(ProgramaIG vista, ProgramaDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.addListenerBtnNuevo(new ProgramaListener());
        this.vista.addListenerBtnModificar(new ProgramaListener());        
        this.vista.addListenerBtnBorrar(new ProgramaListener());
        this.vista.addListenerBtnCerrar(new ProgramaListener());
        
        ArrayList<Programa> listadoProgramas;
        listadoProgramas = this.modelo.listadoProgramas("0");
        this.vista.cargarProgramas(listadoProgramas);
    }
               
    class ProgramaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getActionCommand().equalsIgnoreCase("nuevo")){
                vista.nuevoAction();
            }else if(e.getActionCommand().equalsIgnoreCase("cancelar")){
                vista.nuevoAction();
            }else if(e.getActionCommand().equalsIgnoreCase("modificar")){
                vista.modificarAction();
            }else if(e.getActionCommand().equalsIgnoreCase("salir")){
                vista.cerrarAction();
            }else if(e.getActionCommand().equalsIgnoreCase("grabar")){     
                registrar();
            }else if(e.getActionCommand().equalsIgnoreCase("borrar")){
                borrar();
            }else if(e.getActionCommand().equalsIgnoreCase("actualizar")){
                actualizar();
            }
        }

        private void registrar(){
            if(vista.getCodigo().equals("")){
                vista.gestionMensajes("Ingrese el código",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }else if (vista.getNivel().trim().
                            equals("Seleccionar ...")){
                    vista.gestionMensajes("Seleccione un nivel",
                            "Error de Entrada", JOptionPane.ERROR_MESSAGE );                        
            }else{
                Programa programa = new Programa();
                programa.setCodigo(vista.getCodigo());
                programa.setNombre(vista.getNombre());
                programa.setNivel(vista.getNivel());
                programa.setNum_creditos(vista.getCreditos());

                int tamaño;
                tamaño = modelo.listadoProgramas(programa.getCodigo()).size();

                if(tamaño == 0){
                    int resultado = 0;
                    resultado = modelo.grabarPrograma(programa);
                    if(resultado == 1){
                        vista.gestionMensajes("Registro Grabado con éxito", 
                                "Confirmación",JOptionPane.INFORMATION_MESSAGE); 
                        
                        ArrayList<Programa> listadoProgramas;
                        listadoProgramas = modelo.listadoProgramas("0");
                        vista.cargarProgramas(listadoProgramas);

                        vista.activarControles(false); 
                        vista.nuevoAction();
                    }
                    else{
                        vista.gestionMensajes("Error al grabar",
                                "Confirmación",JOptionPane.ERROR_MESSAGE);                                                 
                    }
                }else{
                    vista.gestionMensajes("Codigo ya está registrado",
                            "Confirmación",
                            JOptionPane.ERROR_MESSAGE);                                      
                }
            }                                               
        }
        
        private void borrar(){
            String codigo = "";
            codigo  = vista.getCodigo().trim();
            
            if(codigo.isEmpty()){
                 vista.gestionMensajes(
                         "Por favor seleccione un programa de la tabla",
                         "Mensaje de Advertencia ", 
                    JOptionPane.ERROR_MESSAGE);
            }else{
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Desea Eliminar el programa de codigo : " +
                        codigo + " ?", 
                        "Confirmación de Acción", JOptionPane.YES_NO_OPTION);
                
                if(respuesta == JOptionPane.YES_OPTION){                    

                    if(modelo.borrarPrograma(codigo) ==  1){
                        JOptionPane.showMessageDialog(null, 
                                "Registro Borrado con éxtio", 
                                "Confirmación de acción", 
                                JOptionPane.INFORMATION_MESSAGE);                    
                       
                        ArrayList<Programa> listadoProgramas; 
                        listadoProgramas = modelo.listadoProgramas("0");
                        vista.cargarProgramas(listadoProgramas);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                                "Error al borrar",
                                "Confirmación de acción", 
                                JOptionPane.ERROR_MESSAGE);                    
                    }
                }
            }
        } 
        
        private void actualizar(){
            //Se crea el objeto Programa 
            Programa programa = new Programa();
             
            //Se configura los datos en el objeto programa de la clase
            //Programa
            programa.setCodigo(vista.getCodigo());
            programa.setNombre(vista.getNombre());                                          
            programa.setNivel(vista.getNivel().toString());                                          
            programa.setNum_creditos(vista.getCreditos());     
                         
            if(modelo.modificarPrograma(programa) == 1){
                vista.gestionMensajes(
                        "Actualización exitosa",
                        "Confirmación ", 
                        JOptionPane.INFORMATION_MESSAGE);
                                        
                vista.activarControles(false); 
                vista.nuevoAction();
                ArrayList<Programa> listadoProgramas; 
                listadoProgramas = modelo.listadoProgramas("0");
                vista.cargarProgramas(listadoProgramas);           
            } else {
                vista.gestionMensajes(
                        "Actualización Falida",
                        "Confirmación ", 
                        JOptionPane.ERROR_MESSAGE);                 
            }              
        } 
    }
}
