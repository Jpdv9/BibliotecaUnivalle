
package Controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Colecciones.ImplemetacionUsuariosDAO;
import Colecciones.InterfaceUsuariosDAO;
import Modelos.ModeloPrestamos;
import Modelos.ModeloRecursos;
import Modelos.ModeloUsuarios;
import Views.VistaMenu;
import Views.VistaPrestamos;
import Views.VistaRecursos;
import Views.VistaUsuarios;

/**
 *
 * @author Franklin Aguirre
 */

public class ControladorMenu implements ActionListener{
    private VistaMenu vistaMenu;
    private VistaUsuarios vistaUsuarios;
    private VistaRecursos vistaRecursos;
    private VistaPrestamos vistaPrestamos;
    private ModeloUsuarios modeloUsuarios;
    private ModeloRecursos modeloRecursos;
    private ModeloPrestamos modeloPrestamos;
    private InterfaceUsuariosDAO interfaceUsuariosDAO;


    public ControladorMenu(VistaMenu vistaMenu){
        this.vistaMenu = vistaMenu;

        //Funcionalidad de los botones
        this.vistaMenu.btnUsuarios.addActionListener(this);
        this.vistaMenu.btnRecursos.addActionListener(this);
        this.vistaMenu.btnPrestamos.addActionListener(this);

        //Vista Usuario
        this.vistaUsuarios = new VistaUsuarios();
        this.modeloUsuarios = new ModeloUsuarios("Nombre", "Dependencia", "Estamento", 0);
        this.interfaceUsuariosDAO = new ImplemetacionUsuariosDAO();

        //Vista Recursos
        this.vistaRecursos = new VistaRecursos();
        this.modeloRecursos = new ModeloRecursos("Nombre", "Autor", "Tipo De Recurso", "genero",0);

        //Vista Prestamos
        this.vistaPrestamos = new VistaPrestamos();
        this.modeloPrestamos = new ModeloPrestamos("","","");
    }

    public void iniciar() {
        vistaMenu.setTitle("MENU");
        vistaMenu.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaMenu.btnUsuarios){
            ControladorUsuarios controladorUsuarios = new ControladorUsuarios(vistaUsuarios, modeloUsuarios, interfaceUsuariosDAO, vistaMenu);
            controladorUsuarios.iniciar();
            vistaUsuarios.setVisible(true);
            vistaMenu.setVisible(false);
        }

        if(e.getSource() == vistaMenu.btnRecursos){
            vistaMenu.setVisible(false);
            vistaRecursos.setVisible(true);
            ControladorRecursos controladorRecursos = new ControladorRecursos(vistaRecursos, vistaMenu, modeloRecursos);
            controladorRecursos.iniciar();
        }

        if(e.getSource() == vistaMenu.btnPrestamos){
            vistaMenu.setVisible(false);
            vistaPrestamos.setVisible(true);
        }
    }
}
