/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Views.VistaUsuarios;

    
/**
 *
 * @author Franklin Aguirre
 */
public class ControladorUsuarios {
    
    private VistaUsuarios view;
    
    public ControladorUsuarios (VistaUsuarios view ) {
        this.view= view;
        
        
    }
    public void iniciar() {
        view.setTitle("MVC multiplicar");
        view.setLocationRelativeTo(null);
        
    }
}
