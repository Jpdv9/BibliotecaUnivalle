/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Franklin Aguirre
 */
public class ModeloUsuarios {
    //private String tipoId;
    private String nombre;
    private String dependencia;
    private int codigo;

    public ModeloUsuarios(String nombre, String dependecia, int codigo){
        this.nombre = nombre;
        this.dependencia = dependecia;
        this.codigo = codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDependencia(){
        return dependencia;
    }

    public int getCodigo(){
        return codigo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDependencia(String dependecia){
        this.dependencia = dependecia;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
}
