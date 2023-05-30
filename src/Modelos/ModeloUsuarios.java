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
    private String nombre;
    private String dependencia;
    private String estamento;
    private String codigo;

    public ModeloUsuarios(String nombre, String dependencia, String estamento, String codigo){
        this.nombre = nombre;
        this.dependencia = dependencia;
        this.estamento = estamento;
        this.codigo = codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDependencia(){
        return dependencia;
    }

    public String getEstamento(){
        return estamento;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDependencia(String dependecia){
        this.dependencia = dependecia;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public void setEstamento(String estamento){
        this.estamento = estamento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Código: " + codigo + ", Dependencia: " + dependencia + ", Estamento: " + estamento;
    }
}
