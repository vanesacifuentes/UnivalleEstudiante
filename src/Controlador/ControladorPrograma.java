/*
 * Programa	: ControladorPrograma.java
 * Fecha	: 10/04/2016
 * Objetivo	: Recibe acciones de la vista y lanza acciones del modelo
 *                Programa
 * Programador	: Luis Yovany Romo Portilla
 */
package Controlador;

import java.util.ArrayList;
import modelo.Programa;
import modelo.ProgramaDAO;

/**
 *
 * @author Admin
 */
public class ControladorPrograma {
    
    /**
     * @param p objeto de la clase Programa para grabar
     * @return resultado resultdo obtenido de la acción grabar
     */
    public static int grabarPrograma(Programa p)
    {
        ProgramaDAO programaDAO = new ProgramaDAO();
        int resultado = programaDAO.grabarPrograma(p);
        return resultado; 
    }
    
    /**
     * @param codigo codigo del programa a listar, 0 son todos
     * @return ArrayList lista de objetos de comuna
     */
    public static ArrayList<Programa> listadoProgramas(String codigo)
    {
        ArrayList<Programa> listado;
        listado = new ArrayList();
        ProgramaDAO programas = new ProgramaDAO();
        listado = programas.listadoProgramas(codigo);
        return listado; 
    }
    
    /**
     * @param codigo codigo del programa a borrar
     * @return comu_codi código de lacolumna a borrar
     */
    public static int borrarPrograma(String codigo)
    {
        ProgramaDAO programaDAO = new ProgramaDAO();
        int resultado = programaDAO.borrarPrograma(codigo);
        return resultado; 
    }
    
     public static int modificarPrograma(Programa p)
    {
        ProgramaDAO programaDAO = new ProgramaDAO();
        int resultado = programaDAO.modificarPrograma(p);
        return resultado; 
    }
}
