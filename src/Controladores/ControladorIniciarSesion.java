
package Controladores;

import Modelos.ModeloIniciarSesion;
import Views.VistaIniciarSesion;
import Views.VistaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Franklin Aguirre
 */
public class ControladorIniciarSesion implements ActionListener {
    private VistaIniciarSesion view;
    private ModeloIniciarSesion Model;
    
    public ControladorIniciarSesion (VistaIniciarSesion view , ModeloIniciarSesion Model) {
        this.view= view;
        this.Model= Model;
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
            
            if ("MVC2023".equals(Model.getContraseña())) {
                VistaMenu vistamenu = new VistaMenu();
                vistamenu.setVisible(true);
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
