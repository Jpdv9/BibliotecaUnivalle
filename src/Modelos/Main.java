
package Modelos;

import Controladores.ControladorIniciarSesion;
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
        
        ModeloIniciarSesion model = new ModeloIniciarSesion();
        ControladorIniciarSesion ctrl = new ControladorIniciarSesion (view,model);
        ctrl.iniciar();
        view.setVisible(true);
    }
    
}
    

