package Controladores;

import Modelos.ModeloRecursos;
import Views.VistaMenu;
import Views.VistaRecursos;

public class ControladorRecursos {
    private VistaRecursos vistaRecursos;
    private VistaMenu vistaMenu;
    private ModeloRecursos modeloRecursos;

    public ControladorRecursos(VistaRecursos vistaRecursos, VistaMenu vistaMenu, ModeloRecursos modeloRecursos){
        this.vistaRecursos = vistaRecursos;
        this.vistaMenu = vistaMenu;
        this.modeloRecursos = modeloRecursos;
    }

    public void iniciar(){
        vistaRecursos.setTitle("Recursos");
        vistaRecursos.setLocationRelativeTo(null);
    }
}
