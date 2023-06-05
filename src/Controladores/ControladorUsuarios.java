
package Controladores;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Colecciones.ImplemetacionUsuariosDAO;
import Colecciones.InterfaceUsuariosDAO;
import Modelos.ModeloUsuarios;
import Views.VistaMenu;
import Views.VistaUsuarios;

    
/**
 *
 * @author Franklin Aguirre
 */
public class ControladorUsuarios implements ActionListener{
    
    private VistaUsuarios vistaUsuarios;
    private ModeloUsuarios modeloUsuarios;
    private InterfaceUsuariosDAO interfaceUsuariosDAO;
    private VistaMenu vistaMenu;
    
    
    public ControladorUsuarios (VistaUsuarios vistaUsuarios, ModeloUsuarios modeloUsuarios, InterfaceUsuariosDAO interfaceUsuariosDAO, VistaMenu vistaMenu) {
        this.vistaUsuarios = vistaUsuarios;
        this.modeloUsuarios = modeloUsuarios;
        this.interfaceUsuariosDAO = new ImplemetacionUsuariosDAO();
        this.vistaMenu = vistaMenu;
        
        //Funcionalidades de los botones
        this.vistaUsuarios.btnAgregar.addActionListener(this);
        this.vistaUsuarios.btnBuscar.addActionListener(this);
        this.vistaUsuarios.btnListar.addActionListener(this);
        this.vistaUsuarios.btnEliminar.addActionListener(this);
        this.vistaUsuarios.btnActualizar.addActionListener(this);
        this.vistaUsuarios.btnFinalizar.addActionListener(this);
    }
    public void iniciar() {
        vistaUsuarios.setTitle("USUARIOS");
        vistaUsuarios.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Agrega al usuario
        if(e.getSource() == vistaUsuarios.btnAgregar){
            if (!vistaUsuarios.txtIdUsuario.getText().isEmpty()) {

                //Verifica si el usuario existe, si es asi no se agregara a la lista
                int codigoUsuario = Integer.parseInt(vistaUsuarios.txtIdUsuario.getText());
                    ModeloUsuarios usuarioEncontrado = interfaceUsuariosDAO.getUsuarios(codigoUsuario);
                    
                if(usuarioEncontrado != null){
                    JOptionPane.showMessageDialog(null, "¡El usuario ya existe!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //Agrega al usuario
                try {
                    //Sacar las opciones del estamento para agregar un nuevo usuario
                    String estamentoSelecionado = (String) vistaUsuarios.cmbEstamento.getSelectedItem();
    
                    modeloUsuarios.setCodigo(codigoUsuario);
                    modeloUsuarios.setNombre(vistaUsuarios.txtNombre.getText());
                    modeloUsuarios.setDependencia(vistaUsuarios.txtDependencia.getText());
                    modeloUsuarios.setEstamento(estamentoSelecionado);
    
                    //Vaciar los campos de textos
                    vistaUsuarios.txtIdUsuario.setText("");
                    vistaUsuarios.txtNombre.setText("");
                    vistaUsuarios.txtDependencia.setText("");
    
                    interfaceUsuariosDAO.save(modeloUsuarios);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite un número válido en el campo Código", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El campo Código está vacío", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
            
        }

        //Busca al usuario
        if(e.getSource() == vistaUsuarios.btnBuscar){
            if(!vistaUsuarios.txtIdUsuario.getText().isEmpty()){
                int codigoUsuario = Integer.parseInt(vistaUsuarios.txtIdUsuario.getText());
                ModeloUsuarios usuarioEncontrado = interfaceUsuariosDAO.getUsuarios(codigoUsuario);

                if(usuarioEncontrado == null){
                    JOptionPane.showMessageDialog(null, "¡El usuario no esta registrado!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "¡El usuario esta registrado!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    vistaUsuarios.mostrarUsuarioBuscado(usuarioEncontrado);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Digite el numero de identificación", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Elimina al usuario
        if(e.getSource() == vistaUsuarios.btnEliminar){
            if (!vistaUsuarios.txtIdUsuario.getText().isEmpty()) {
            int codigoUsuario = Integer.parseInt(vistaUsuarios.txtIdUsuario.getText());
            ModeloUsuarios usuarioEncontrado = interfaceUsuariosDAO.getUsuarios(codigoUsuario);

            try { modeloUsuarios.setCodigo(codigoUsuario);

                if(usuarioEncontrado != null){
                    interfaceUsuariosDAO.delete(usuarioEncontrado);
                    JOptionPane.showMessageDialog(null, "¡El usuario fue eliminado!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Digite el numero de identificación", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
            }else {
            JOptionPane.showMessageDialog(null, "El campo Código está vacío", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }

            
        }

        //Actualiza al usuario
        if(e.getSource() == vistaUsuarios.btnActualizar){
            if(!vistaUsuarios.txtIdUsuario.getText().isEmpty() && !vistaUsuarios.txtNombre.getText().isEmpty() && !vistaUsuarios.txtDependencia.getText().isEmpty()){
                int codigoUsuario = Integer.parseInt(vistaUsuarios.txtIdUsuario.getText());
                ModeloUsuarios usuarioEncontrado = interfaceUsuariosDAO.getUsuarios(codigoUsuario);

                if (usuarioEncontrado != null) {
                    
                    String estamentoSelecionado = (String) vistaUsuarios.cmbEstamento.getSelectedItem();

                    // Actualizar los datos del usuario
                    usuarioEncontrado.setNombre(vistaUsuarios.txtNombre.getText());
                    usuarioEncontrado.setDependencia(vistaUsuarios.txtDependencia.getText());
                    modeloUsuarios.setEstamento(estamentoSelecionado);
        
                    interfaceUsuariosDAO.uptade(usuarioEncontrado);

                    JOptionPane.showMessageDialog(null, "¡El usuario se ha actualizado!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);

                    //Vaciar los campos de textos
                    vistaUsuarios.txtIdUsuario.setText("");
                    vistaUsuarios.txtNombre.setText("");
                    vistaUsuarios.txtDependencia.setText("");

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el usuario", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Llene todos los espacios para actualizar el usuario", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Da la lista de los usuario registrados
        if(e.getSource() == vistaUsuarios.btnListar){
            List<ModeloUsuarios> usuarios = interfaceUsuariosDAO.usuarios();
            vistaUsuarios.mostrarUsuario(usuarios);
        }

        //Cierra la vista de usuario y devuelve la vista menu
        if(e.getSource() == vistaUsuarios.btnFinalizar){
            vistaUsuarios.setVisible(false);
            vistaMenu.setVisible(true);
            
        }
    }
}
