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
public class Programa {
    private String codigo;
    private String nombre;
    private String nivel;
    private int num_creditos;

    public Programa() {
    }

    public Programa(String codigo, String nombre, String nivel, int num_creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel = nivel;
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getNum_creditos() {
        return num_creditos;
    }

    public void setNum_creditos(int num_creditos) {
        this.num_creditos = num_creditos;
    }

   
}
