package tarea3;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class Ambiente extends JPanel implements MouseListener {
    private int state;
    private Comprador com;
    private Expendedor exp;
    private PanelSur ps;
    public Ambiente() {
        this.state = 0;
        this.setLayout(new BorderLayout());
        this.exp = new Expendedor(10, 1500, 600);
        this.exp.setXY(50, 60);
        this.com = new Comprador(this.exp);
        this.com.setXY(550, 150);
        this.setBackground(Color.white);
        this.addMouseListener(this);
        this.ps = new PanelSur(this.com, this);
        this.add(ps, BorderLayout.SOUTH);
    }
    public void paint(Graphics g) {
        super.paint(g);
        if (exp != null) exp.paint(g);
        if (com != null) com.paint(g);
        g.setColor(Color.black);
        if (this.state == 0) g.drawString("Comprar", 550, 130);
        else if (this.state == 1) g.drawString("Beber", 550, 130);
        else if (this.state == 2) g.drawString("Sacar vuelto", 550, 130);
    }
    private boolean insideExp(MouseEvent e) {
        if (exp.getX() <= e.getX() && e.getX() <= exp.getX()+370 && exp.getY() <= e.getY() && e.getY() <= exp.getY()+450) {
            return true;
        } else {
            return false;
        }
    }
    private boolean insideCom(MouseEvent e) {
        if (com.getX()-20 <= e.getX() && e.getX() <= com.getX()+70 && com.getY() <= e.getY() && e.getY() <= com.getY()+320) {
            return true;
        } else {
            return false;
        }
    }
    public void mouseClicked(MouseEvent e) {
        if (insideExp(e)) {
            exp.rellenar(5, 500);
            exp.updateComponents();
        } else if (insideCom(e)) {
            if (this.state == 0) {
                com.comprar();
                this.state = 1;
            } else if (this.state == 1) {
                com.beber();
                this.state = 2;
            } else if (this.state == 2) {
                com.getVuelto();
                this.state = 0;
            }
        }
        this.repaint();
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}