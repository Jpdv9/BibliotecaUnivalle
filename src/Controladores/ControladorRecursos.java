package Controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Colecciones.ImplementacionRecursosDAO;
import Colecciones.InterfaceRecursosDAO;
import Modelos.ModeloRecursos;
import Views.VistaMenu;
import Views.VistaRecursos;

public class ControladorRecursos implements ActionListener{
    private VistaRecursos vistaRecursos;
    private VistaMenu vistaMenu;
    private ModeloRecursos modeloRecursos;
    private InterfaceRecursosDAO interfaceRecursosDAO;

    public ControladorRecursos(VistaRecursos vistaRecursos, VistaMenu vistaMenu, ModeloRecursos modeloRecursos){
        this.vistaRecursos = vistaRecursos;
        this.vistaMenu = vistaMenu;
        this.modeloRecursos = modeloRecursos;
        this.interfaceRecursosDAO = new ImplementacionRecursosDAO();

        //funcionalidad de los botones
        this.vistaRecursos.btnAgregar.addActionListener(this);
        this.vistaRecursos.btnBuscar.addActionListener(this);
        this.vistaRecursos.btnActualizar.addActionListener(this);
        this.vistaRecursos.btnEliminar.addActionListener(this);
        this.vistaRecursos.btnListar.addActionListener(this);
        this.vistaRecursos.btnFinalizar.addActionListener(this);
    }

    public void iniciar(){
        vistaRecursos.setTitle("Recursos");
        vistaRecursos.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaRecursos.btnAgregar){

        }

        if(e.getSource() == vistaRecursos.btnBuscar){

        }

        if(e.getSource() == vistaRecursos.btnActualizar){

        }

        if(e.getSource() == vistaRecursos.btnEliminar){

        }

        if(e.getSource() == vistaRecursos.btnListar){

        }

        if(e.getSource() == vistaRecursos.btnFinalizar){
            vistaRecursos.setVisible(false);
            vistaMenu.setVisible(true);
        }
    }
}
