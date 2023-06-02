package Colecciones;

import java.util.ArrayList;
import java.util.List;

import Modelos.ModeloRecursos;

public class ImplementacionRecursosDAO implements InterfaceRecursosDAO{

    private List<ModeloRecursos> todosLosRecursos;

    public ImplementacionRecursosDAO(){
        todosLosRecursos = new ArrayList<>();
    }

    @Override
    public List<ModeloRecursos> recursos() {
        return todosLosRecursos;
    }

    @Override
    public ModeloRecursos getRecursos(int referencia) {
        for(ModeloRecursos recurso : todosLosRecursos){
            if(recurso.getIsbn() == referencia){
                return recurso;
            }
        }

        return null;
    }

    @Override
    public void save(ModeloRecursos recurso) {
        ModeloRecursos nuevoRecursos =  new ModeloRecursos("Nombre", "Autor", "Tipo De Recurso","genero", 0);
        nuevoRecursos.setNombre(recurso.getNombre());
        nuevoRecursos.setIsbn(recurso.getIsbn());
        nuevoRecursos.setAutor(recurso.getAutor());
        nuevoRecursos.setTipoDeRecursos(recurso.getTipoDeRecurso());
        nuevoRecursos.setGenero(recurso.getGenero());
        todosLosRecursos.add(nuevoRecursos);
        System.out.println(nuevoRecursos);
    }

    @Override
    public void update(ModeloRecursos recurso) {
        for(int i = 0; i < todosLosRecursos.size(); i++){
            if(todosLosRecursos.get(i).getIsbn() == recurso.getIsbn()){
                todosLosRecursos.set(i, recurso);
                break;
            }
        }
    }

    @Override
    public void delete(ModeloRecursos recurso) {
        todosLosRecursos.remove(recurso);
    }
    
}
