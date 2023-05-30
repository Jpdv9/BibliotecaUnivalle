package Repositorio;

import java.util.ArrayList;
import java.util.List;

import Modelos.ModeloUsuarios;

public class ImplemetacionUsuarios implements InterfaceUsuarios {

    private List<ModeloUsuarios> todosLosUsuarios;

    public ImplemetacionUsuarios(){
        todosLosUsuarios = new ArrayList<>();
    }

    @Override
    public List<ModeloUsuarios> usuarios() {
        return todosLosUsuarios;
    }

    @Override
    public ModeloUsuarios getUsuarios(int id) {
        for(ModeloUsuarios usuario : todosLosUsuarios){
            if(usuario.getCodigo() == id){
                return usuario;
            }
        }

        return null;
    }

    @Override
    public void save(ModeloUsuarios usuario) {
        todosLosUsuarios.add(usuario);
    }

    @Override
    public void uptade(ModeloUsuarios usuario) {
        // el codigo se implantara mas tarde, cuando la vista usuario este 100% realizada
    }

    @Override
    public void delete(ModeloUsuarios usuario) {
        todosLosUsuarios.remove(usuario);
    }
    
}
