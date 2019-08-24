/*
 * Programa	: ProgramaController.java
 * Fecha	: 10/04/2016
 * Objetivo	: Recibe acciones de la vista y lanza acciones del modelo
 *                Programa
 * Programador	: Luis Yovany Romo Portilla
 */
package Controlador;

import Vista.EstudianteIG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import modelo.EstudianteDAO;

/**
 *
 * @author Admin
 */
public class ControllerEstudiante {
    
    private EstudianteIG vista;
    private EstudianteDAO modelo;
    
     /**
     * @param vista Instancia de la vista de Estudiante
     * @param modelo Instancia del modelo de Estudiante
     */
    public ControllerEstudiante(EstudianteIG vista, EstudianteDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.addListenerBtnNuevo(new ProgramaListener());
        this.vista.addListenerBtnModificar(new ProgramaListener());        
        this.vista.addListenerBtnBorrar(new ProgramaListener());
        this.vista.addListenerBtnCerrar(new ProgramaListener());
        
        ArrayList<Estudiante> listadoEstudiantes;
        listadoEstudiantes = this.modelo.listadoEstudiantes("0");
        this.vista.cargarEstudiantes(listadoEstudiantes);
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

        //Explicar*********************************************************
        private void registrar(){
            if(vista.getCodigo().equals("")){
                vista.gestionMensajes("Ingrese el código",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }else if (vista.getSexo().trim().
                            equals("Seleccionar ...")){
                    vista.gestionMensajes("Seleccione un sexo",
                            "Error de Entrada", JOptionPane.ERROR_MESSAGE );                        
            }else{
                Estudiante estudiante = new Estudiante();
                estudiante.setCodigo(vista.getCodigo());
                estudiante.setNombre(vista.getNombre());
                estudiante.setSexo(vista.getSexo());
                estudiante.setCodigoPrograma(vista.getCodigoPrograma());

                int tamaño;
                tamaño = modelo.listadoEstudiantes(estudiante.getCodigo()).size();

                if(tamaño == 0){
                    int resultado = 0;
                    resultado = modelo.grabarEstudiante(estudiante);
                    if(resultado == 1){
                        vista.gestionMensajes("Registro Grabado con éxito", 
                                "Confirmación",JOptionPane.INFORMATION_MESSAGE); 
                        
                        ArrayList<Estudiante> listadoEstudiante;
                        listadoEstudiante = modelo.listadoEstudiantes("0");
                        vista.cargarEstudiantes(listadoEstudiante);

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
                         "Por favor seleccione un estudiante de la tabla",
                         "Mensaje de Advertencia ", 
                    JOptionPane.ERROR_MESSAGE);
            }else{
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Desea Eliminar el estudiante de codigo : " +
                        codigo + " ?", 
                        "Confirmación de Acción", JOptionPane.YES_NO_OPTION);
                
                if(respuesta == JOptionPane.YES_OPTION){                    

                    if(modelo.borrarEstudiante(codigo) ==  1){
                        JOptionPane.showMessageDialog(null, 
                                "Registro Borrado con éxtio", 
                                "Confirmación de acción", 
                                JOptionPane.INFORMATION_MESSAGE);                    
                       
                        ArrayList<Estudiante> listadoEstudiantes; 
                        listadoEstudiantes = modelo.listadoEstudiantes("0");
                        vista.cargarEstudiantes(listadoEstudiantes);
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
            Estudiante estudiante = new Estudiante();
             
            //Se configura los datos en el objeto estudiante de la clase
            //Estudiante
            estudiante.setCodigo(vista.getCodigo());
            estudiante.setNombre(vista.getNombre());                                          
            estudiante.setSexo(vista.getSexo());                                          
            estudiante.setCodigoPrograma(vista.getCodigoPrograma());     
                         
            if(modelo.modificarEstudiante(estudiante) == 1){
                vista.gestionMensajes(
                        "Actualización exitosa",
                        "Confirmación ", 
                        JOptionPane.INFORMATION_MESSAGE);
                                        
                vista.activarControles(false); 
                vista.nuevoAction();
                ArrayList<Estudiante> listadoEstudiantes; 
                listadoEstudiantes = modelo.listadoEstudiantes("0");
                vista.cargarEstudiantes(listadoEstudiantes);           
            } else {
                vista.gestionMensajes(
                        "Actualización Falida",
                        "Confirmación ", 
                        JOptionPane.ERROR_MESSAGE);                 
            }              
        } 
    }
}
