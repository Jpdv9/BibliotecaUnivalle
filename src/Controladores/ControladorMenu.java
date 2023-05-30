
package Controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelos.ModeloUsuarios;
import Repositorio.ImplemetacionUsuariosDAO;
import Repositorio.InterfaceUsuariosDAO;
import Views.VistaMenu;
import Views.VistaUsuarios;

/**
 *
 * @author Franklin Aguirre
 */

public class ControladorMenu implements ActionListener{
    private VistaMenu vistaMenu;

    public ControladorMenu(VistaMenu vistaMenu){
        this.vistaMenu = vistaMenu;

        this.vistaMenu.btnUsuarios.addActionListener(this);
    }

    public void iniciar() {
        vistaMenu.setTitle("MENU");
        vistaMenu.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaMenu.btnUsuarios){
            VistaUsuarios vistaUsuarios = new VistaUsuarios();
            ModeloUsuarios modeloUsuarios = new ModeloUsuarios("Nombre", "Dependecia", "Estamento", "0000");
            InterfaceUsuariosDAO interfaceUsuariosDAO = new ImplemetacionUsuariosDAO();
            ControladorUsuarios controladorUsuarios = new ControladorUsuarios(vistaUsuarios, modeloUsuarios, interfaceUsuariosDAO);
            controladorUsuarios.iniciar();
            vistaUsuarios.setVisible(true);
            vistaMenu.dispose();
        }
    }


}
