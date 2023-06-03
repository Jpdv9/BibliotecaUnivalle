package Colecciones;

import java.util.ArrayList;
import java.util.List;

import Modelos.ModeloRecursos;

public class ImplementacionRecursosDAO implements InterfaceRecursosDAO{

    private List<ModeloRecursos> todosLosRecursos;

    public ImplementacionRecursosDAO(){
        todosLosRecursos = new ArrayList<>();
        
        todosLosRecursos.add(new ModeloRecursos("ONE piece", "Eiichiro Oda", "Comic o Manga","Aventuras y Accion", 10851064));
        todosLosRecursos.add(new ModeloRecursos("La Odisea", "Homero", "Libro", "Aventura", 12345678));
        todosLosRecursos.add(new ModeloRecursos("Tesis sobre Inteligencia Artificial", "Juan Pérez", "Tesis", "Tecnología", 23456789));
        todosLosRecursos.add(new ModeloRecursos("National Geographic ", " Frank Cuesta", "Revista", "Exploración", 34567890));
todosLosRecursos.add(new ModeloRecursos("Dragon Ball", "Akira Toriyama", "Comic o Anime", "Acción", 45678901));
        todosLosRecursos.add(new ModeloRecursos("Enciclopedia cuantica", "Albert Einstein ", "Enciclopedia", "Ciencia", 56789012));
        todosLosRecursos.add(new ModeloRecursos("El mago de oz", "George Orwell", "Libro", "Ciencia ficción", 67890123));
        todosLosRecursos.add(new ModeloRecursos("Tesis sobre Economía Internacional", "María Gómez", "Tesis", "Economía", 78901234));

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
