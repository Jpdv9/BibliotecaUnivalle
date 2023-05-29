package Repositorio;

import java.util.ArrayList;
import java.util.List;

import Modelos.ModeloIniciarSesion;

public class ImplementacionIniciarSesionDAO implements InterfaceIniciarSesionDAO {

    private  List<ModeloIniciarSesion> administradores;

    public ImplementacionIniciarSesionDAO(){
        administradores = new ArrayList<>();

        //Adiministradores
        administradores.add(new ModeloIniciarSesion("Jean Paul", "12345"));
        administradores.add(new ModeloIniciarSesion("Franklin", "MVC2023"));
        administradores.add(new ModeloIniciarSesion("profesor", "123"));
    }

    @Override
    public List<ModeloIniciarSesion> administrador() {
        return administradores;
    }

    @Override
    public ModeloIniciarSesion getAdministrador(String nombre) {
        for(ModeloIniciarSesion usuario: administradores){
            if(usuario.getUsuario().equals(nombre)){
                return usuario;
            }
        }

        return null;
    }

    @Override
    public void save(ModeloIniciarSesion usuario) {
        administradores.add(usuario);
    }

    @Override
    public void uptade(ModeloIniciarSesion usuario) {
        for(ModeloIniciarSesion iniciarSesion : administradores){
            if(iniciarSesion.getUsuario().equals(usuario.getUsuario())){
                usuario.setContraseña(usuario.getContraseña());;
            }
        }
    }

    @Override
    public void delete(ModeloIniciarSesion usuario) {
        administradores.remove(usuario);
    }
    
}
