package Repositorio;

import java.util.List;

import Modelos.ModeloUsuarios;

public interface InterfaceUsuariosDAO {
    List<ModeloUsuarios> usuarios();
    ModeloUsuarios getUsuarios(String codigo);
    void save(ModeloUsuarios usuario);
    void uptade(ModeloUsuarios usuario);
    void delete(ModeloUsuarios usuario);
}
