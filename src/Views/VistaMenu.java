
package Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jeanp
 */

public class VistaMenu extends JFrame{
    private JButton btnRecursos;
    private JButton btnUsuarios;
    private JButton btnPrestamos;
    private JPanel jpContenido;

    public VistaMenu(){
        iniciarComponentes();
    }

    private void iniciarComponentes(){
        //Configuracion de la pantalla
        setTitle("Biblioteca");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        jpContenido = new JPanel();
        add(jpContenido);

        //Recursos
        btnRecursos = new JButton("RECURSOS");
        //Bounds

        //Usuarios
        btnUsuarios = new JButton("USUARIOS");
        //Bounds

        //Prestamos
        btnPrestamos = new JButton("PRESTAMOS");
        //Bounds

        //Layout
        jpContenido.setSize(500, 500);
        jpContenido.setLayout(null);

        //Agregar contenido a el JPanel
        jpContenido.add(btnRecursos);
        jpContenido.add(btnUsuarios);
        jpContenido.add(btnPrestamos);
    }
}