
package Controladores;

import Modelos.ModeloIniciarSesion;
import Repositorio.InterfaceIniciarSesionDAO;
import Views.VistaIniciarSesion;
import Views.VistaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Franklin Aguirre
 */
public class ControladorIniciarSesion implements ActionListener {
    private VistaIniciarSesion view;
    private ModeloIniciarSesion Model;
    private InterfaceIniciarSesionDAO administradorDAO;

    

    public ControladorIniciarSesion (VistaIniciarSesion view , ModeloIniciarSesion Model, InterfaceIniciarSesionDAO administradorDAO) {
        this.view= view;
        this.Model= Model;
        this.administradorDAO = administradorDAO;

        this.view.btnEntrar.addActionListener(this);
        view.txtContraseña.addActionListener(this);
    }

    public void iniciar() {
        view.setTitle("LOGIN");
        view.setLocationRelativeTo(null);
    }

    public void actionPerformed(    ActionEvent e) {
        if (e.getSource() == view.btnEntrar || e.getSource() == view.txtContraseña) {
            Model.setContraseña(view.txtContraseña.getText());
            Model.setUsuario(view.txtUsuario.getText());
            
            ModeloIniciarSesion administrador = administradorDAO.getAdministrador(Model.getUsuario());
            
            if(administrador != null && administrador.getContraseña().equals(Model.getContraseña())){
                VistaMenu vistamenu = new VistaMenu();
                vistamenu.setVisible(true);
                ControladorMenu controladorMenu = new ControladorMenu(vistamenu);
                controladorMenu.iniciar();
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
