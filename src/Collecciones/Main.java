
package Collecciones;

import Controladores.ControladorUsuarios;
import Views.VistaIniciarSesion;
import Views.VistaUsuarios;

/**
 *
 * @author jeanp
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        VistaUsuarios view = new VistaUsuarios ( );
        
        ControladorUsuarios ctrl = new ControladorUsuarios (view);
        ctrl.iniciar();
        view.setVisible(true);
    }
    
}
    

