package tarea3;

import java.awt.Color;
import java.awt.Graphics;

public class Comprador {

    private int x, y, queBebidas;
    private int vuelto;
    private String sonido;
    private Expendedor exp;
    private Bebidas b;
    private Moneda m;

    public Comprador(Expendedor exp) {
        this.vuelto = 0;
        this.sonido = null;
        this.exp = exp;
    }

    public void comprar() {
        this.b = exp.comprarBebida(this.m, this.queBebidas);
        if (this.b != null) {
            this.b.setXY(this.x - 50, this.y + 170);
            this.m = null;
        }
    }

    public void beber() {
        if (this.b != null) {
            this.sonido = b.beber();
            this.b = null;
        }
    }

    public void darMoneda(Moneda m) {
        this.m = m;
        this.m.setXY(this.x + 60, this.y + 180);
    }

    public void getVuelto() {
        while (true) {
            Moneda tmp = exp.getVuelto();
            if (tmp == null) {
                break;
            }
            this.vuelto = this.vuelto + tmp.getValor();
        }
    }

    public String queBebiste() {
        return sonido;
    }

    public int cuantaPlata() {
        return vuelto;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bebidas getBebidas() {
        return this.b;
    }

    public void setBebidas(int q) {
        this.queBebidas = q;
    }

    public void paint(Graphics g) {
        g.setColor(new Color(234, 197, 127));
        g.fillOval(this.x, this.y, 50, 60);
        g.fillRect(this.x - 30, this.y + 180, 10, 10);
        g.fillRect(this.x + 70, this.y + 180, 10, 10);

        g.setColor(Color.CYAN);
        g.fillRect(this.x - 10, this.y + 60, 70, 130);
        g.fillPolygon(new int[]{this.x - 10, this.x - 20, this.x - 30, this.x - 20}, new int[]{this.y + 60, this.y + 60, this.y + 120, this.y + 120}, 4);
        g.fillPolygon(new int[]{this.x + 60, this.x + 70, this.x + 80, this.x + 70}, new int[]{this.y + 60, this.y + 60, this.y + 120, this.y + 120}, 4);
        g.fillRect(this.x - 30, this.y + 120, 10, 60);
        g.fillRect(this.x + 70, this.y + 120, 10, 60);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(this.x, this.y + 190, 15, 130);
        g.fillRect(this.x + 35, this.y + 190, 15, 130);

        g.setColor(Color.lightGray);
        g.fillOval(this.x, this.y + 315, 15, 10);
        g.fillOval(this.x + 35, this.y + 315, 15, 10);
        if (this.b != null) {
            this.b.paint(g);
        }
        if (this.m != null) {
            this.m.paint(g);
        }
    }
}
