package Modelos;

public class ModeloPrestamos {
    
    private String estado;
    private String DiasPrestamo;
    private String FechaDevolucion;

    public ModeloPrestamos(String estado, String DiasPrestamo, String FechaDevolucion) {
        this.estado = estado;
        this.DiasPrestamo = DiasPrestamo;
        this.FechaDevolucion = FechaDevolucion;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDiasPrestamo() {
        return DiasPrestamo;
    }

    public void setDiasPrestamo(String DiasPrestamo) {
        this.DiasPrestamo = DiasPrestamo;
    }

    public String getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(String FechaDevolucion) {
        this.FechaDevolucion = FechaDevolucion;
    }
    
}
