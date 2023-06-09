package Controladores;


import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
        this.vistaRecursos.bntBuscarAutor.addActionListener(this);
    }

    public void iniciar(){
        vistaRecursos.setTitle("Recursos");
        vistaRecursos.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaRecursos.btnAgregar){
            if(!vistaRecursos.txtIsbn.getText().isEmpty()){
                int referencia = Integer.parseInt(vistaRecursos.txtIsbn.getText());
                ModeloRecursos recursoEncontrado = interfaceRecursosDAO.getRecursos(referencia);

                if(recursoEncontrado != null){
                    JOptionPane.showMessageDialog(null, "¡El Recurso ya existe!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //Agregar recurso

                try {
                    
                    if(!vistaRecursos.txtIsbn.getText().isEmpty() && !vistaRecursos.txtNombreEjemplar.getText().isEmpty() 
                    && !vistaRecursos.txtAutor.getText().isEmpty() && !vistaRecursos.txtGeneroLiterario.getText().isEmpty()){

                        //Sacar las opciones del tipo para agregar un nuevo usuario
                        String tipoSelecionado = (String) vistaRecursos.cmbTipoRecurso.getSelectedItem();

                        modeloRecursos.setIsbn(referencia);
                        modeloRecursos.setNombre(vistaRecursos.txtNombreEjemplar.getText());
                        modeloRecursos.setAutor(vistaRecursos.txtAutor.getText());
                        modeloRecursos.setTipoDeRecursos(tipoSelecionado);
                        modeloRecursos.setGenero(vistaRecursos.txtGeneroLiterario.getText());
        
                        //Vaciar los campos de textos
                        vistaRecursos.txtIsbn.setText("");
                        vistaRecursos.txtNombreEjemplar.setText("");
                        vistaRecursos.txtAutor.setText("");
                        vistaRecursos.txtGeneroLiterario.setText("");

                        JOptionPane.showMessageDialog(null, "¡El Recurso ha sido agregado!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);


                        interfaceRecursosDAO.save(modeloRecursos);
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos para registrar el usuario", "Advertencia", JOptionPane.ERROR_MESSAGE);
                    }
    
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite un número válido en el campo ISBN", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "El campo ISBN está vacío", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource() == vistaRecursos.btnBuscar){
            if(!vistaRecursos.txtIsbn.getText().isEmpty()){

                int referencia = Integer.parseInt(vistaRecursos.txtIsbn.getText());
                ModeloRecursos recursoEncotrado = interfaceRecursosDAO.getRecursos(referencia);

                if(recursoEncotrado == null){
                    JOptionPane.showMessageDialog(null, "¡El Recurso no esta registrado!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "¡El Recurso esta registrado!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Digite el numero de identificación del recurso", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource() == vistaRecursos.bntBuscarAutor){
            if(!vistaRecursos.txtAutor.getText().isEmpty()){

                String nombreAutor = vistaRecursos.txtAutor.getText();
                List<ModeloRecursos> recursoAutor = new ArrayList<>();

                List<ModeloRecursos> todosLosRecursos = interfaceRecursosDAO.recursos();

                for(ModeloRecursos recurso : todosLosRecursos){
                    if(recurso.getAutor().equalsIgnoreCase(nombreAutor)){
                        recursoAutor.add(recurso);
                    }
                }
                
                if(recursoAutor.isEmpty()){
                    JOptionPane.showMessageDialog(null, "¡No hay ningun recurso del autor registrado!", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }else{
                    StringBuilder mensaje = new StringBuilder("Se han encontrado recursos del autor: \n");

                    for(ModeloRecursos recurso: recursoAutor){
                        mensaje.append("- Nombre: ").append(recurso.getNombre()).append("\n");
                        mensaje.append("  Autor: ").append(recurso.getAutor()).append("\n");
                        mensaje.append("  Tipo de Recurso: ").append(recurso.getTipoDeRecurso()).append("\n");
                        mensaje.append("  Género: ").append(recurso.getGenero()).append("\n");
                        mensaje.append("  ISBN: ").append(recurso.getIsbn()).append("\n");
                        mensaje.append("\n");
                    }
                    JOptionPane.showMessageDialog(null, mensaje.toString(), "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    vistaRecursos.mostrarRecursos(recursoAutor);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Por favor digite el nombre del autor", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource() == vistaRecursos.btnActualizar){
            if(!vistaRecursos.txtIsbn.getText().isEmpty() && !vistaRecursos.txtNombreEjemplar.getText().isEmpty() 
                    && !vistaRecursos.txtAutor.getText().isEmpty() && !vistaRecursos.txtGeneroLiterario.getText().isEmpty()){

                        int referencia = Integer.parseInt(vistaRecursos.txtIsbn.getText());
                        ModeloRecursos recursoEncontrado = interfaceRecursosDAO.getRecursos(referencia);

                        if(recursoEncontrado != null){
                            String tipoSelecionado = (String) vistaRecursos.cmbTipoRecurso.getSelectedItem();

                            // Actualizar los datos del recurso
                            recursoEncontrado.setNombre(vistaRecursos.txtNombreEjemplar.getText());
                            recursoEncontrado.setAutor(vistaRecursos.txtAutor.getText());
                            recursoEncontrado.setTipoDeRecursos(tipoSelecionado);
                            recursoEncontrado.setGenero(vistaRecursos.txtGeneroLiterario.getText());

                            interfaceRecursosDAO.update(recursoEncontrado);

                            JOptionPane.showMessageDialog(null, "¡El Recurso se ha actualizado!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);

                             //Vaciar los campos de textos
                            vistaRecursos.txtIsbn.setText("");
                            vistaRecursos.txtNombreEjemplar.setText("");
                            vistaRecursos.txtAutor.setText("");
                            vistaRecursos.txtGeneroLiterario.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null, "No se encontró el recurso", "Advertencia", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                else{
                    JOptionPane.showMessageDialog(null, "Llene todos los espacios para actualizar el recurso", "Advertencia", JOptionPane.ERROR_MESSAGE);
                }
        }

        if(e.getSource() == vistaRecursos.btnEliminar){
            
            if(!vistaRecursos.txtIsbn.getText().isEmpty()){
                
                int referencia = Integer.parseInt(vistaRecursos.txtIsbn.getText());         
                ModeloRecursos recursoEncontrado = interfaceRecursosDAO.getRecursos(referencia);
                
                try{ modeloRecursos.setIsbn(referencia);

                if(recursoEncontrado != null){
                    interfaceRecursosDAO.delete(recursoEncontrado);
                    JOptionPane.showMessageDialog(null, "¡El Recurso fue eliminado!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }

            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Digite el numero ISBN del recurso", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
            }else{
                JOptionPane.showMessageDialog(null, "El campo ISBN está vacío", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
            
            

            
        }

        if(e.getSource() == vistaRecursos.btnListar){
            List<ModeloRecursos> recursos = interfaceRecursosDAO.recursos();
            vistaRecursos.mostrarRecursos(recursos);
        }

        if(e.getSource() == vistaRecursos.btnFinalizar){
            vistaRecursos.setVisible(false);
            vistaMenu.setVisible(true);
        }
    }
}
