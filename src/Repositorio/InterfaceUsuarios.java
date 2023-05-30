package Repositorio;

import java.util.List;

import Modelos.ModeloUsuarios;

public interface InterfaceUsuarios {
    List<ModeloUsuarios> usuarios();
    ModeloUsuarios getUsuarios(int codigo);
    void save(ModeloUsuarios usuario);
    void uptade(ModeloUsuarios usuario);
    void delete(ModeloUsuarios usuario);
}
