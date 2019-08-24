/*
 * Programa	: ProgramaDAO.java
 * Fecha	: 10/04/2016
 * Objetivo	: Modela el acceso a datos de la tabla Programa
 * Programador	: Luis Yovany Romo Portilla
 */

package modelo;
import Servicios.Fachada;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class EstudianteDAO {

    public EstudianteDAO() {
    }
    /**
     * 
     * @param e Objeto de la clase Estudiante a grabar
     * @return rtdo resultado de la operación grbar
     */
    public int grabarEstudiante(Estudiante e){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO estudiante values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, e.getCodigo());
            pstm.setString(2, e.getNombre());
            pstm.setString(3,e.getSexo());
            pstm.setString(4,e.getCodigoPrograma());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
     /**
     * 
     * @param p Objeto de la clase Estudiante a modificar
     * @return rtdo resultado de la operación modificar
     */
    public int modificarEstudiante(Estudiante e){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE estudiante " +
                         "SET codigo =?, nombre =?, sexo =?, codigo_programa =?"
                    +    "WHERE codigo=?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, e.getCodigo());
            pstm.setString(2, e.getNombre());
            pstm.setString(3, e.getSexo());
            pstm.setString(4, e.getCodigoPrograma());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
            
    /**
     * 
     * @param codigo código del estudiante a borrar
     * @return rtdo resultado de la operación borrar
     */
    public int borrarEstudiante(String codigo){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM estudiante WHERE codigo = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, codigo);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    /**
     * 
     * @param codigo codigo de estudiantes a listar, 0 se listaran todos
     * @return ArrayList, lista de objetos Estudiante
     */
    public ArrayList<Estudiante> listadoEstudiantes(String codigo){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Estudiante> listadoEstudiantes = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(codigo.equalsIgnoreCase("0")){
                sql = "SELECT * FROM estudiante ORDER BY codigo";            
            }else{
                sql = "SELECT * FROM estudiante where codigo = ? "
                    + "ORDER BY codigo";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(codigo != "0"){
                pstm.setString(1, codigo);
            }
            
            rs = pstm.executeQuery();
                        
            Estudiante objestudiante = null;
            while(rs.next()){
                objestudiante = new Estudiante();
                objestudiante.setCodigo(rs.getString("codigo"));
                objestudiante.setNombre(rs.getString("nombre"));
                objestudiante.setSexo(rs.getString("sexo"));
                objestudiante.setCodigoPrograma(rs.getString("codigo_programa"));
                listadoEstudiantes.add(objestudiante);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listadoEstudiantes;
    }
}
