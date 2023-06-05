package Modelos;

public class ModeloPrestamos {
    
    private String estado;
    private String FechaPrestamo;
    private String FechaDevolucion;
    private String FechaLimite;
    private int codigo;
    private int isbn;

    public ModeloPrestamos(String estado, String FechaPrestamo, String FechaDevolucion, String FechaLimite, int codigo, int isbn) {
        this.estado = estado;
        this.FechaPrestamo = FechaPrestamo;
        this.FechaDevolucion = FechaDevolucion;
        this.FechaLimite= FechaLimite;
        this.codigo = codigo;
        this.isbn = isbn;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getFechaPrestamo() {
        return FechaPrestamo;
    }

    public void setFechaPrestamo(String FechaPrestamo) {
        this.FechaPrestamo = FechaPrestamo;
    }


    public String getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(String FechaDevolucion) {
        this.FechaDevolucion = FechaDevolucion;
    }
    
    public String getFechaLimite() {
        return FechaLimite;
    }

    public void setFechaLimite(String FechaLimite) {
        this.FechaLimite = FechaLimite;
    }
    
    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public int getIsbn(){
        return isbn;
    }

    public void setIsbn(int isbn){
        this.isbn = isbn;
    }
    

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", ISBN: " + isbn + ", Estado: " + estado + ", Fecha Prestamo: " + FechaPrestamo + ", Fecha De Devolucion: " + FechaDevolucion + ", Fecha Limite: " + FechaLimite; 
    }
}
