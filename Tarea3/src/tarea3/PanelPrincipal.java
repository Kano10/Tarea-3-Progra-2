
package tarea3;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {
    private Comprador comp;
    private Maquina exp;
    private Image fondo;
    
    public PanelPrincipal(){
        JPanel panel = new JPanel();
        JLabel etiqueta = new JLabel();
        fondo = new ImageIcon(getClass().getResource("pared.jpeg")).getImage();
        exp = new Maquina();//por rellenar
        comp = new Comprador();//por rellenar
        
    }
    
    public Comprador getComprador(){
        return comp;
    }
    public Maquina getExpendedor(){
        return exp;
    }
    @Override
    public void paint(Graphics g){
        super.paintComponent(g);
        comp.paintComponent(g);
        exp.paintComponent(g);
    }
    
    
    
}
