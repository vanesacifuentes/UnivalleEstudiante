/*
 * Programa	: Programa.java
 * Fecha	: 10/04/2016
 * Objetivo	: Modela la tabla Programa
 * Programador	: Luis Yovany Romo Portilla
 */

package modelo;

/**
 *
 * @author Admin
 */
public class Estudiante {
    private String codigo;
    private String nombre;
    private String sexo;
    private String codigoPrograma;

    public Estudiante() {
    }

    public Estudiante(String codigo, String nombre, String sexo, String codigoPrograma) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sexo = sexo;
        this.codigoPrograma = codigoPrograma;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(String codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

   
}
