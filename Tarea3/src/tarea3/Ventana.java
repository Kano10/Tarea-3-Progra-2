
package tarea3;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import Java.awt.Dimension;


public class Ventana extends JFrame {
    public JPanel panel = new JPanel();
    private Maquina exp;
    private Comprador comp;
    JLabel etiqueta = new JLabel();
    ImageIcon imagen = new ImageIcon("pared.jpeg");
    public Ventana(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Para poder acabar el programa con la X de la ventana
        setTitle("Maquina expendedora");
        setBounds(350, 250, 1024, 576);// para la posicion de la ventana y su tamaño. x,y ancho largo
        setLocationRelativeTo(null);//localizar al centro de la pantalla
        //this.getContentPane().setBackground(Color.BLUE);//establecer color ventana
        panel.setLayout(null);//se desactivo el diseño del panel, con esto, se podrá usar el setBounds en etiqueta
        getContentPane().add(panel);//se agrega el panel a la ventana
        etiqueta.setBounds(0,0,1024,720);
        etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta.getWidth(),etiqueta.getHeight(),Image.SCALE_SMOOTH)));//SIrve para escalar la imagen
        panel.add(etiqueta);
        

    }
}