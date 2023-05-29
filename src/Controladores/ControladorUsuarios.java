
package Controladores;

import Views.VistaUsuarios;

    
/**
 *
 * @author Franklin Aguirre
 */
public class ControladorUsuarios {
    
    private VistaUsuarios view;
    
    public ControladorUsuarios (VistaUsuarios view ) {
        this.view= view;
        
        
    }
    public void iniciar() {
        view.setTitle("USUARIOS");
        view.setLocationRelativeTo(null);
        
    }
}
