
package Modelos;

import Controladores.ControladorIniciarSesion;
import Repositorio.ImplementacionIniciarSesionDAO;
import Repositorio.InterfaceIniciarSesionDAO;
import Views.VistaIniciarSesion;



/**
 *
 * @author jeanp
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        VistaIniciarSesion view = new VistaIniciarSesion ( );
        
        ModeloIniciarSesion model = new ModeloIniciarSesion("Usuario", "Contraseña");
        InterfaceIniciarSesionDAO daoAministrador = new ImplementacionIniciarSesionDAO();
        ControladorIniciarSesion ctrl = new ControladorIniciarSesion (view,model, daoAministrador);
        ctrl.iniciar();
        view.setVisible(true);
    }
    
}
    

