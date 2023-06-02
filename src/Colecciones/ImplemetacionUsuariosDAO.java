package Colecciones;

import java.util.ArrayList;
import java.util.List;

import Modelos.ModeloUsuarios;

public class ImplemetacionUsuariosDAO implements InterfaceUsuariosDAO {

    private List<ModeloUsuarios> todosLosUsuarios;

    public ImplemetacionUsuariosDAO(){
        todosLosUsuarios = new ArrayList<>();

        
        todosLosUsuarios.add(new ModeloUsuarios("Carlos Aguirre Lopez", "Ingenieria De Sistema","Estudiante",201965685));
        todosLosUsuarios.add(new ModeloUsuarios("Franklin", "Ingenieria De Sistema", "Estudiante", 201865575));
        todosLosUsuarios.add(new ModeloUsuarios("Juan Esteban Hernadez", "Derecho", "Profesor", 100104556));
    }

    @Override
    public List<ModeloUsuarios> usuarios() {
    
        return todosLosUsuarios;
        
    }
    @Override
    public ModeloUsuarios getUsuarios(int codigo) {
        for(ModeloUsuarios usuario : todosLosUsuarios){
            if(usuario.getCodigo() == codigo){
                System.out.println(usuario);
                return usuario;
            }
        }

        return null;
    }

    @Override
    public void save(ModeloUsuarios usuario) {
        ModeloUsuarios nuevoUsuario =  new ModeloUsuarios("Nombre", "Dependencia", "Estamento", 0);
        nuevoUsuario.setCodigo(usuario.getCodigo());
        nuevoUsuario.setNombre(usuario.getNombre());
        nuevoUsuario.setDependencia(usuario.getDependencia());
        nuevoUsuario.setEstamento(usuario.getEstamento());
        todosLosUsuarios.add(nuevoUsuario);
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
