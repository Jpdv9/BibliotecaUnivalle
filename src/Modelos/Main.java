
package Modelos;

import Colecciones.ImplementacionIniciarSesionDAO;
import Colecciones.InterfaceIniciarSesionDAO;
import Controladores.ControladorIniciarSesion;
import Views.VistaIniciarSesion;
/*
 * EN ESTA LINEA UBICAMOS EL LINK AL VIDEO DEL FUNCIONAMIENTO /
 * *se añade link del video aqui*
 * VIDEO:
 * su nombre es MiniProyecto2
 * https://drive.google.com/drive/folders/18D3aBNtPlwAYa2xn9bUV2pQJ0CXMbYw2?usp=share_link
 * AUTORES
 * FRANKLIN AGUIRRE ORTIZ 201841743
 * JEAN PAUL DAVALOS VALENCIA 201832375
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        VistaIniciarSesion view = new VistaIniciarSesion ();
        
        ModeloIniciarSesion model = new ModeloIniciarSesion("Usuario", "Contraseña");
        InterfaceIniciarSesionDAO daoAministrador = new ImplementacionIniciarSesionDAO();
        ControladorIniciarSesion ctrl = new ControladorIniciarSesion (view,model, daoAministrador);

        ctrl.iniciar();

        view.setVisible(true);
    }
    
}
    

