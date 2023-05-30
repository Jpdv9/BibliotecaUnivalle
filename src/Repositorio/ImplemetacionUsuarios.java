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
    public ModeloUsuarios getUsuarios(int codigo) {
        for(ModeloUsuarios usuario : todosLosUsuarios){
            if(usuario.getCodigo() == codigo){
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
        for(int i = 0; i < todosLosUsuarios.size(); i++){
            if(todosLosUsuarios.get(i).getCodigo() == usuario.getCodigo()){
                todosLosUsuarios.set(i, usuario);
                break;
            }
        }
    }

    @Override
    public void delete(ModeloUsuarios usuario) {
        todosLosUsuarios.remove(usuario);
    }
    
}
