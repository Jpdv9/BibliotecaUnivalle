package Modelos;

public class ModeloRecursos {
    private String nombre;
    private String autor;
    private String tipoDeRecurso;
    private String genero;
    private int isbn;

    public ModeloRecursos(String nombre, String autor, String tipoDeRecurso, String genero, int isbn){
        this.nombre = nombre;
        this.autor = autor;
        this.tipoDeRecurso = tipoDeRecurso;
        this.genero = genero;
        this.isbn = isbn;
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

    public String getGenero(){
        return genero;
    }

    public int getIsbn(){
        return isbn;
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

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setIsbn(int isbn){
        this.isbn = isbn;
    }

    @Override
    public String toString(){
        return "ISBN: " + isbn + ", Nombre: " + nombre + ", Autor: " + autor + ", Genero: " + genero + ", Tipo de Recurso: " + tipoDeRecurso;
    }

}
