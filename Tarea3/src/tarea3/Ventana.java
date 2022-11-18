
package tarea3;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class Ventana extends JFrame {
    private PanelPrincipal panel;
    public Ventana(){
        super();
        this.setTitle("Maquina Expendedora");
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        panel = new PanelPrincipal();
        this.getContentPane().add(panel);
        this.add(panel);
        this.setVisible(true);
        
    }
}