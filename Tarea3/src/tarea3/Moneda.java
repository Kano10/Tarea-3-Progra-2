package tarea3;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Moneda {
    protected int serie;
    protected int x, y;
    public Moneda(int s) {
        this.serie = s;
    }
    public Moneda getSerie() {
        return this;
    }
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract int getValor();
    public abstract void paint(Graphics g);
}

class Moneda100 extends Moneda {
    public Moneda100() {
        super((int)(Math.random()*100));
    }
    public int getValor() {
        return 100;
    }
    public void paint(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(this.x, this.y, 20, 20);
        g.setColor(Color.black);
        g.drawString(""+this.serie, this.x+3, this.y+15);
    }
}

class Moneda500 extends Moneda {
    public Moneda500() {
        super((int)(Math.random()*100));
    }
    public int getValor() {
        return 500;
    }
    public void paint(Graphics g) {
        g.setColor(new Color(255,148,8));
        g.fillOval(this.x, this.y, 20, 20);
        g.setColor(Color.black);
        g.drawString(""+this.serie, this.x+3, this.y+15);
    }
}

class Moneda1000 extends Moneda {
    public Moneda1000() {
        super((int)(Math.random()*100));
    }
    public int getValor() {
        return 1000;
    }
    public void paint(Graphics g) {
        g.setColor(new Color(173,255,8));
        g.fillOval(this.x, this.y, 20, 20);
        g.setColor(Color.black);
        g.drawString(""+this.serie, this.x+3, this.y+15);
    }
}

class Moneda1500 extends Moneda {
    public Moneda1500() {
        super((int)(Math.random()*100));
    }
    public int getValor() {
        return 1500;
    }
    public void paint(Graphics g) {
        g.setColor(new Color(38,219,255));
        g.fillOval(this.x, this.y, 20, 20);
        g.setColor(Color.black);
        g.drawString(""+this.serie, this.x+3, this.y+15);
    }
}
