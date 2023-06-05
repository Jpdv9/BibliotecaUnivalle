package Controladores;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Colecciones.ImplementacionPrestamosDAO;
import Colecciones.ImplementacionRecursosDAO;
import Colecciones.ImplemetacionUsuariosDAO;
import Colecciones.InterfacePrestamosDAO;
import Colecciones.InterfaceRecursosDAO;
import Colecciones.InterfaceUsuariosDAO;
import Modelos.ModeloPrestamos;
import Modelos.ModeloRecursos;
import Modelos.ModeloUsuarios;
import Views.VistaMenu;
import Views.VistaPrestamos; 


public class ControladorPrestamos implements ActionListener{
    private VistaPrestamos vistaPrestamos;
    private VistaMenu vistaMenu;
    private ModeloPrestamos modeloPrestamos;
    private InterfacePrestamosDAO interfacePrestamosDAO;
    private InterfaceUsuariosDAO interfaceUsuariosDAO;
    private InterfaceRecursosDAO interfaceRecursosDAO;

    public ControladorPrestamos(VistaPrestamos vistaPrestamos, VistaMenu vistaMenu, ModeloPrestamos modeloPrestamos){
        this.vistaPrestamos = vistaPrestamos;
        this.vistaMenu = vistaMenu;
        this.modeloPrestamos = modeloPrestamos;

        //DAO
        interfacePrestamosDAO = new ImplementacionPrestamosDAO(interfaceUsuariosDAO, interfaceRecursosDAO);
        interfaceRecursosDAO = new ImplementacionRecursosDAO();
        interfaceUsuariosDAO = new ImplemetacionUsuariosDAO();

        //Funcionalidad de los botones
        this.vistaPrestamos.btnAgregar.addActionListener(this);
        this.vistaPrestamos.btnConsultar.addActionListener(this);
        this.vistaPrestamos.btnActualizar.addActionListener(this);
        this.vistaPrestamos.btnEliminar.addActionListener(this);
        this.vistaPrestamos.btnFinalizar.addActionListener(this);

    }

    public void iniciar(){
        vistaPrestamos.setTitle("Prestamos");
        vistaPrestamos.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() ==vistaPrestamos.btnFinalizar){
                vistaPrestamos.setVisible(false);
                vistaMenu.setVisible(true);
            }  
        
        
        if(e.getSource() == vistaPrestamos.btnAgregar){

            int codigoUsario;
            int referenciaRecurso;
            
            try{
                codigoUsario = Integer.parseInt(vistaPrestamos.txtUsuarioId.getText());
                referenciaRecurso = Integer.parseInt(vistaPrestamos.txtIsbnRrecurso.getText());

            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "¡Llene primero los campos de ISBN y Código!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ModeloUsuarios usuarioEncontrado = interfaceUsuariosDAO.getUsuarios(codigoUsario);
            ModeloRecursos recursoEncontrado = interfaceRecursosDAO.getRecursos(referenciaRecurso);

            if(usuarioEncontrado == null){
                JOptionPane.showMessageDialog(null, "¡El Usuario no existe!", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }

            if(recursoEncontrado == null){
                JOptionPane.showMessageDialog(null, "¡El Recurso no existe!", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }else{
                List<ModeloPrestamos> prestamos = interfacePrestamosDAO.prestamos();
                for(ModeloPrestamos prestamo : prestamos){
                    if(prestamo.getIsbn() == referenciaRecurso){
                        JOptionPane.showMessageDialog(null, "¡El Recurso no esta disponible!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            if(!vistaPrestamos.txtUsuarioId.getText().isEmpty() && !vistaPrestamos.txtIsbnRrecurso.getText().isEmpty() && !vistaPrestamos.txtFechaDevolucion.getText().isEmpty() 
                && !vistaPrestamos.txtFechaPrestamo.getText().isEmpty()){

                    String estadoSelecionado = (String) vistaPrestamos.cmbEstado.getSelectedItem();

                    modeloPrestamos.setCodigo(codigoUsario);
                    modeloPrestamos.setIsbn(referenciaRecurso);
                    modeloPrestamos.setEstado(estadoSelecionado);
                    modeloPrestamos.setFechaPrestamo(vistaPrestamos.txtFechaPrestamo.getText());
                    modeloPrestamos.setFechaDevolucion(vistaPrestamos.txtFechaDevolucion.getText());
                    modeloPrestamos.setFechaLimite(vistaPrestamos.txtFechaLimite.getText());

                    //Vaciar Espacios
                    vistaPrestamos.txtUsuarioId.setText("");
                    vistaPrestamos.txtIsbnRrecurso.setText("");
                    vistaPrestamos.txtFechaPrestamo.setText("");
                    vistaPrestamos.txtFechaDevolucion.setText("");
                    vistaPrestamos.txtFechaLimite.setText("");

                    JOptionPane.showMessageDialog(null, "¡El prestamos ha sido agregado!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);


                    interfacePrestamosDAO.save(modeloPrestamos);
                
                }else{
                    JOptionPane.showMessageDialog(null, "¡Llene todos los campos para agregar el prestamo!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }
        }

        //Consultar si el usuario tiene un prestamo o si el recurso esta disponible 
        if (e.getSource() == vistaPrestamos.btnConsultar) {
            int codigoUsuario = 0;
            int referenciaRecurso = 0;
        
            try {
                if (!vistaPrestamos.txtUsuarioId.getText().isEmpty()) {
                    codigoUsuario = Integer.parseInt(vistaPrestamos.txtUsuarioId.getText());
                }
        
                if (!vistaPrestamos.txtIsbnRrecurso.getText().isEmpty()) {
                    referenciaRecurso = Integer.parseInt(vistaPrestamos.txtIsbnRrecurso.getText());
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "¡Llene el campo de ISBN o Código con números para consultar!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
            if (codigoUsuario != 0) {

                ModeloUsuarios usuarioEncontrado = interfaceUsuariosDAO.getUsuarios(codigoUsuario);

                if (usuarioEncontrado == null) {
                    JOptionPane.showMessageDialog(null, "¡El Usuario no existe!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                } else {

                    List<ModeloPrestamos> prestamos = interfacePrestamosDAO.prestamos();
                    StringBuilder mensajeUsuario = new StringBuilder("El usuario tiene los siguientes recursos prestados:\n");
                    boolean usuarioEnPrestamo = false;
                    for (ModeloPrestamos prestamo : prestamos) {
                        if (prestamo.getCodigo() == codigoUsuario) {
                            mensajeUsuario.append("- Codigo: ").append(prestamo.getCodigo()).append("\n");
                            mensajeUsuario.append("  ISBN: ").append(prestamo.getIsbn()).append("\n");
                            mensajeUsuario.append("  Estado: ").append(prestamo.getEstado()).append("\n");
                            mensajeUsuario.append("  Fecha Prestamo: ").append(prestamo.getFechaPrestamo()).append("\n");
                            mensajeUsuario.append("  Fecha de devolucion: ").append(prestamo.getFechaDevolucion()).append("\n\n");
                            usuarioEnPrestamo = true;
                        }
                    }
        
                    if (!usuarioEnPrestamo) {
                        mensajeUsuario.append("El usuario no tiene recursos prestados.");
                    }
        
                    JOptionPane.showMessageDialog(null, mensajeUsuario.toString(), "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        
            if (referenciaRecurso != 0) {

                ModeloRecursos recursoEncontrado = interfaceRecursosDAO.getRecursos(referenciaRecurso);

                if (recursoEncontrado == null) {
                    JOptionPane.showMessageDialog(null, "¡El Recurso no existe!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                } else {
                    List<ModeloPrestamos> prestamos = interfacePrestamosDAO.prestamos();
                    for (ModeloPrestamos prestamo : prestamos) {
                        if (prestamo.getIsbn() == referenciaRecurso) {
                            JOptionPane.showMessageDialog(null, "¡El Recurso no está disponible!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
        
                    JOptionPane.showMessageDialog(null, "El Recurso está disponible.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        
            JOptionPane.showMessageDialog(null, "Ingrese el código de usuario o la referencia del recurso para consultar.", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }

        if(e.getSource() == vistaPrestamos.btnActualizar){

            int codigoUsario;
            int referenciaRecurso;

            try{
                codigoUsario = Integer.parseInt(vistaPrestamos.txtUsuarioId.getText());
                referenciaRecurso = Integer.parseInt(vistaPrestamos.txtIsbnRrecurso.getText());

            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "¡Llene primero todos los campos!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ModeloUsuarios usuarioEncontrado = interfaceUsuariosDAO.getUsuarios(codigoUsario);
            ModeloRecursos recursoEncontrado = interfaceRecursosDAO.getRecursos(referenciaRecurso);

            if(usuarioEncontrado == null){

                JOptionPane.showMessageDialog(null, "¡El usuario no existe!", "Advertencia", JOptionPane.ERROR_MESSAGE);

            }else if(recursoEncontrado == null){

                JOptionPane.showMessageDialog(null, "¡El recurso no existe!", "Advertencia", JOptionPane.ERROR_MESSAGE);

            }else{

                List<ModeloPrestamos> prestamos = interfacePrestamosDAO.prestamos();
                boolean prestamoEncontrado = false;

                for(ModeloPrestamos prestamo : prestamos){
                    if(prestamo.getCodigo() == codigoUsario && prestamo.getIsbn() == referenciaRecurso){
                        prestamoEncontrado = true;

                        String estadoSelecionado = (String) vistaPrestamos.cmbEstado.getSelectedItem();

                        prestamo.setFechaPrestamo(vistaPrestamos.txtFechaPrestamo.getText()); 
                        prestamo.setFechaDevolucion(vistaPrestamos.txtFechaDevolucion.getText());
                        prestamo.setEstado(estadoSelecionado);
                        prestamo.setFechaLimite(vistaPrestamos.txtFechaLimite.getText());

                        interfacePrestamosDAO.update(prestamo);

                        vistaPrestamos.txtUsuarioId.setText("");
                        vistaPrestamos.txtIsbnRrecurso.setText("");
                        vistaPrestamos.txtFechaPrestamo.setText("");
                        vistaPrestamos.txtFechaDevolucion.setText("");
                        vistaPrestamos.txtFechaLimite.setText("");
                        JOptionPane.showMessageDialog(null, "El prestamo fue actualizado", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }

                if(!prestamoEncontrado){
                    JOptionPane.showMessageDialog(null, "¡No extiste el prestamo!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if(e.getSource() == vistaPrestamos.btnEliminar){

            int codigoUsario;

            try{
                codigoUsario = Integer.parseInt(vistaPrestamos.txtUsuarioId.getText());

            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "¡Llene el campo usuario(ID)!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ModeloUsuarios usuarioEncontrado = interfaceUsuariosDAO.getUsuarios(codigoUsario);

            if(usuarioEncontrado == null){

                JOptionPane.showMessageDialog(null, "¡El usuario no existe!", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }else{

                List<ModeloPrestamos> prestamos = interfacePrestamosDAO.prestamos();
                boolean prestamoEncontrado = false;

                for(ModeloPrestamos prestamo : prestamos){
                    if(prestamo.getCodigo() == codigoUsario){
                        prestamoEncontrado = true;

                        String estadoSelecionado = (String) vistaPrestamos.cmbEstado.getSelectedItem();

                        prestamo.setFechaPrestamo(vistaPrestamos.txtFechaPrestamo.getText()); 
                        prestamo.setFechaDevolucion(vistaPrestamos.txtFechaDevolucion.getText());
                        prestamo.setEstado(estadoSelecionado);
                        prestamo.setFechaLimite(vistaPrestamos.txtFechaLimite.getText());

                        interfacePrestamosDAO.delete(prestamo);

                        vistaPrestamos.txtUsuarioId.setText("");
                        vistaPrestamos.txtIsbnRrecurso.setText("");
                        vistaPrestamos.txtFechaPrestamo.setText("");
                        vistaPrestamos.txtFechaDevolucion.setText("");
                        vistaPrestamos.txtFechaLimite.setText("");

                        JOptionPane.showMessageDialog(null, "El prestamo ha sido eliminado", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }

                if(!prestamoEncontrado){
                    JOptionPane.showMessageDialog(null, "¡No extiste el prestamo!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }
}
