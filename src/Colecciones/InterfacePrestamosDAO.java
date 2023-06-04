package Colecciones;

import java.util.List;

import Modelos.ModeloPrestamos;

public interface InterfacePrestamosDAO {
    List<ModeloPrestamos> prestamos();
    ModeloPrestamos getPrestamos(int codigo, int isbn);
    void save(ModeloPrestamos prestamo);
    void update(ModeloPrestamos prestamo);
    void delete(ModeloPrestamos prestamo);
}
