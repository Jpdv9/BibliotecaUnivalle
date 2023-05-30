
package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelos.ModeloUsuarios;
import Repositorio.ImplementacionIniciarSesionDAO;
import Repositorio.ImplemetacionUsuariosDAO;
import Repositorio.InterfaceUsuariosDAO;
import Views.VistaUsuarios;

    
/**
 *
 * @author Franklin Aguirre
 */
public class ControladorUsuarios implements ActionListener{
    
    private VistaUsuarios vistaUsuarios;
    private ModeloUsuarios modeloUsuarios;
    private InterfaceUsuariosDAO interfaceUsuariosDAO;
    
    public ControladorUsuarios (VistaUsuarios vistaUsuarios, ModeloUsuarios modeloUsuarios, InterfaceUsuariosDAO interfaceUsuariosDAO) {
        this.vistaUsuarios = vistaUsuarios;
        this.modeloUsuarios = modeloUsuarios;
        this.interfaceUsuariosDAO = interfaceUsuariosDAO;
        
        this.vistaUsuarios.btnAgregar.addActionListener(this);
    }
    public void iniciar() {
        vistaUsuarios.setTitle("USUARIOS");
        vistaUsuarios.setLocationRelativeTo(null);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaUsuarios.btnAgregar){
            modeloUsuarios.setCodigo(vistaUsuarios.txtIdUsuario.getText());
            modeloUsuarios.setNombre(vistaUsuarios.txtNombre.getText());
            modeloUsuarios.setDependencia(vistaUsuarios.txtDependencia.getText());
            modeloUsuarios.setEstamento(vistaUsuarios.jTextArea1.getText());

            //String codigo = vistaUsuarios.txtIdUsuario.getText();

            ImplemetacionUsuariosDAO implemetacionUsuariosDAO = new ImplemetacionUsuariosDAO();

            implemetacionUsuariosDAO.save(modeloUsuarios);

            
            System.out.println(implemetacionUsuariosDAO.usuarios());
            
        }
    }
}
