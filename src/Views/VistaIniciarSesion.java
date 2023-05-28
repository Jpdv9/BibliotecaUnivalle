
package Views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jeanp
 */
public class VistaIniciarSesion extends JFrame{
    private JLabel lblTitulo;
    private JLabel lblUsuario;
    private JLabel lblContraseña;
    private JTextField txtUsuario;
    private JTextField txtContraseña;
    private JButton btnEntrar;
    private JPanel jpContenido;

    public VistaIniciarSesion(){
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

        //Titulo
        lblTitulo = new JLabel("BIBLIOTECA UNIVALLE");
        lblTitulo.setBounds(100, 20, 100, 100);

        //Usuario
        lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(50, 125, 100, 100);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(150, 150, 200, 50);

        //Contraseña
        lblContraseña = new JLabel("Contraseña");
        lblContraseña.setBounds(50, 225, 100, 100);

        txtContraseña = new JTextField();
        txtContraseña.setBounds(150, 250, 200, 50);

        //Boton
        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(300, 350, 150, 100);

        //Layout
        jpContenido.setSize(500, 500);
        jpContenido.setLayout(null);

        //Agregar el contenido al JPanel
        jpContenido.add(lblTitulo);
        jpContenido.add(lblUsuario);
        jpContenido.add(txtUsuario);
        jpContenido.add(lblContraseña);
        jpContenido.add(txtContraseña);
        jpContenido.add(btnEntrar);
    }
}
