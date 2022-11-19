package tarea3;

import java.awt.*;

public abstract class Bebidas {
    protected int serie;
    protected int x, y;
    public Bebidas(int n) {
        serie = n;
    }
    public int getSerie() {
        return serie;
    }
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract String beber();
    public abstract void paint(Graphics g);
}

class CocaCola extends Bebidas {
    public CocaCola(int n) {
        super(n);
    }
    public String beber() {
        return new String("cocacola");
    }
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(this.x, this.y, 17, 30);
        g.setColor(Color.black);
        g.drawString(""+this.serie, this.x, this.y+20);
    }
}

class Sprite extends Bebidas {
    public Sprite(int n) {
        super(n);
    }
    public String beber() {
        return new String("sprite");
    }
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(this.x, this.y, 17, 30);
        g.setColor(Color.black);
        g.drawString(""+this.serie, this.x, this.y+20);
    }
}
class Fanta extends Bebidas {
    public Fanta (int n) {
        super(n);
    }
    public String beber() {
        return new String("fanta");
    }
    public void paint(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(this.x, this.y, 17, 30);
        g.setColor(Color.black);
        g.drawString(""+this.serie, this.x, this.y+20);
    }
}