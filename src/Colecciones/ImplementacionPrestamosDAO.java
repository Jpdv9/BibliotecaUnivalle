package Colecciones;

import java.util.ArrayList;
import java.util.List;

import Modelos.ModeloPrestamos;

public class ImplementacionPrestamosDAO implements InterfacePrestamosDAO{

    private List<ModeloPrestamos> todosLosPrestamos;
    private InterfaceUsuariosDAO interfaceUsuariosDAO;
    private InterfaceRecursosDAO interfaceRecursosDAO;

    public ImplementacionPrestamosDAO(InterfaceUsuariosDAO interfaceUsuariosDAO, InterfaceRecursosDAO interfaceRecursosDAO){
        todosLosPrestamos = new ArrayList<>();
        this.interfaceRecursosDAO = interfaceRecursosDAO;
        this.interfaceUsuariosDAO = interfaceUsuariosDAO;
    }

    @Override
    public List<ModeloPrestamos> prestamos() {
        return todosLosPrestamos;
    }

    @Override
    public ModeloPrestamos getPrestamos(int codigo, int isbn) {
        for(ModeloPrestamos prestamo : todosLosPrestamos){
            if(prestamo.getCodigo() == codigo && prestamo.getIsbn() == isbn){
                return prestamo;
            }
        }
        return null;
    }

    @Override
    public void save(ModeloPrestamos prestamo) {
        todosLosPrestamos.add(prestamo);
        System.out.println(prestamo);
    }

    @Override
    public void update(ModeloPrestamos prestamo) {
        for(int i = 0; i < todosLosPrestamos.size(); i++){
            if(todosLosPrestamos.get(i).getIsbn() == prestamo.getIsbn() || todosLosPrestamos.get(i).getCodigo() == prestamo.getCodigo()){
                todosLosPrestamos.set(i, prestamo);
                break;
            }
        }
    }

    @Override
    public void delete(ModeloPrestamos prestamo) {
        todosLosPrestamos.remove(prestamo);
    }
    
}
