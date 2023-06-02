package Colecciones;

import java.util.List;

import Modelos.ModeloRecursos;

public interface InterfaceRecursosDAO {
    List<ModeloRecursos> recursos();
    ModeloRecursos getRecursos(int referencia);
    void save(ModeloRecursos recurso);
    void update(ModeloRecursos recurso);
    void delete(ModeloRecursos recurso);
}
