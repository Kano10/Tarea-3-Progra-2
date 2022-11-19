package tarea3;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Moneda extends JLabel {

    public Moneda() {
        super();
    }

    public Moneda getSerie() {
        return this;
    }

    public void setXY(int x1, int y1) {
        this.setLocation(x1, y1);
    }

    public abstract int getValor();
}

class M500 extends Moneda {
 public M500() {
        super();

        ImageIcon imagen = new ImageIcon(getClass().getResource("/Tarea-3-progra-2/500.png"));
        this.setIcon(imagen);
        this.setSize(imagen.getIconWidth(),imagen.getIconHeight());
    }
    @Override
    public int getValor() {
        return 500;
    }
}

class M100 extends Moneda {
 public M100() {
        super();

        ImageIcon imagen = new ImageIcon(getClass().getResource("/Tarea-3-progra-2/100.png"));
        this.setIcon(imagen);
        this.setSize(imagen.getIconWidth(),imagen.getIconHeight());
    }
    @Override
    public int getValor() {
        return 100;
    }
}

class M1000 extends Moneda {
 public M1000() {
        super();

        ImageIcon imagen = new ImageIcon(getClass().getResource("/Tarea-3-progra-2/1000.png"));
        this.setIcon(imagen);
        this.setSize(imagen.getIconWidth(),imagen.getIconHeight());
    }
    @Override
    public int getValor() {
        return 1000;
    }
}
