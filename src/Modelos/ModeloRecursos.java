package Modelos;

public class ModeloRecursos {
    private String nombre;
    private String autor;
    private String tipoDeRecurso;
    private int referencia;

    public ModeloRecursos(String nombre, String autor, String tipoDeRecurso, int referencia){
        this.nombre = nombre;
        this.autor = autor;
        this.tipoDeRecurso = tipoDeRecurso;
        this.referencia = referencia;
    }

    // gets

    public String getNombre(){
        return nombre;
    }

    public String getAutor(){
        return autor;
    }

    public String getTipoDeRecurso(){
        return tipoDeRecurso;
    }

    public int getReferencia(){
        return referencia;
    }

    // sets

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setTipoDeRecursos(String tipoDeRecurso){
        this.tipoDeRecurso = tipoDeRecurso;
    }

    public void setReferencia(int referencia){
        this.referencia = referencia;
    }
}
