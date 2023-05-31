
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
    private VistaUsuarios vistaUsuarios;
    private ModeloUsuarios modeloUsuarios;
    private InterfaceUsuariosDAO interfaceUsuariosDAO;

    public ControladorMenu(VistaMenu vistaMenu){
        this.vistaMenu = vistaMenu;

        this.vistaMenu.btnUsuarios.addActionListener(this);

        this.vistaUsuarios = new VistaUsuarios();
        this.modeloUsuarios = new ModeloUsuarios("Nombre", "Dependencia", "Estamento", 0);
        this.interfaceUsuariosDAO = new ImplemetacionUsuariosDAO();
    }

    public void iniciar() {
        vistaMenu.setTitle("MENU");
        vistaMenu.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaMenu.btnUsuarios){
            ControladorUsuarios controladorUsuarios = new ControladorUsuarios(vistaUsuarios, modeloUsuarios, interfaceUsuariosDAO);
            controladorUsuarios.iniciar();
            vistaUsuarios.setVisible(true);
            vistaMenu.setVisible(false);
        }
    }


}
