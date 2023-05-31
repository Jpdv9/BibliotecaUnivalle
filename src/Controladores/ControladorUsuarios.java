
package Controladores;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
    //private ImplemetacionUsuariosDAO implemetacionUsuariosDAO;
    
    
    public ControladorUsuarios (VistaUsuarios vistaUsuarios, ModeloUsuarios modeloUsuarios, InterfaceUsuariosDAO interfaceUsuariosDAO) {
        this.vistaUsuarios = vistaUsuarios;
        this.modeloUsuarios = modeloUsuarios;
        this.interfaceUsuariosDAO = new ImplemetacionUsuariosDAO();
        //this.implemetacionUsuariosDAO = new ImplemetacionUsuariosDAO();
        
        
        this.vistaUsuarios.btnAgregar.addActionListener(this);
        this.vistaUsuarios.btnBuscar.addActionListener(this);
        this.vistaUsuarios.btnListar.addActionListener(this);
    }
    public void iniciar() {
        vistaUsuarios.setTitle("USUARIOS");
        vistaUsuarios.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        

        if(e.getSource() == vistaUsuarios.btnAgregar){

            //Sacar las opciones del estamento para agregar un nuevo usuario
            String estamentoSelecionado = (String) vistaUsuarios.cmbEstamento.getSelectedItem();

            try { modeloUsuarios.setCodigo(Integer.parseInt(vistaUsuarios.txtIdUsuario.getText()));
            modeloUsuarios.setNombre(vistaUsuarios.txtNombre.getText());
            modeloUsuarios.setDependencia(vistaUsuarios.txtDependencia.getText());
            modeloUsuarios.setEstamento(estamentoSelecionado);

            //Vaciar los campos de textos

            vistaUsuarios.txtIdUsuario.setText("");
            vistaUsuarios.txtNombre.setText("");
            vistaUsuarios.txtDependencia.setText("");

            interfaceUsuariosDAO.save(modeloUsuarios);
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Digite un numero", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource() == vistaUsuarios.btnBuscar){
            if(!vistaUsuarios.txtIdUsuario.getText().isEmpty()){
                int codigoUsuario = Integer.parseInt(vistaUsuarios.txtIdUsuario.getText());
                ModeloUsuarios usuarioEncontrado = interfaceUsuariosDAO.getUsuarios(codigoUsuario);

                if(usuarioEncontrado == null){
                    JOptionPane.showMessageDialog(null, "¡El usuario no esta registrado!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }else{
                    // El usuario fue encontrado, mas tarde se hara el codigo ya que debe aparecer en pantalla;
                    System.out.println("Se encotro el usuario");
                }
            }else{
                System.out.println("Vacio");
            }
        }

        if(e.getSource() == vistaUsuarios.btnListar){
            List<ModeloUsuarios> usuarios = interfaceUsuariosDAO.usuarios();
            vistaUsuarios.mostrarUsuario(usuarios);
        }
    }
}
