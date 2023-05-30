
package Controladores;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.VistaMenu;

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
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaMenu.btnUsuarios){
            System.out.println("funcinando");
            vistaMenu.dispose();
        }
    }


}
