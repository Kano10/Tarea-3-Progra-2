
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Expendedor {

    private int x, y;
    private DepositoBebidas coca;
    private DepositoBebidas sprite;
    private DepositoBebidas fanta;

    private DepositoMoneda m100;
    private DepositoMoneda m500;
    private DepositoMoneda vuelto;
    private int precio;

    public Expendedor(int numBebidas, int numDinero, int precioBebidas) {
        precio = precioBebidas;
        coca = new DepositoBebidas();
        sprite = new DepositoBebidas();
        fanta = new DepositoBebidas();

        vuelto = new DepositoMoneda();
        m100 = new DepositoMoneda();
        m500 = new DepositoMoneda();
        this.rellenar(numBebidas, numDinero);
    }

    public void updateComponents() {
        coca.setXY(this.x + 20, this.y + 20);
        sprite.setXY(this.x + 20, this.y + 120);
        fanta.setXY(this.x + 20, this.y + 215);

        vuelto.setXY(this.x + 60, this.y + 330);
        m100.setXY(this.x + 200, this.y + 25);
        m500.setXY(this.x + 200, this.y + 155);
        coca.updateComponents();
        sprite.updateComponents();
        fanta.updateComponents();

        vuelto.updateComponents();
        m100.updateComponents();
        m500.updateComponents();
    }

    public void rellenar(int numBebidas, int numDinero) {
        if (numBebidas >= 10) {
            numBebidas = 10;
        }
        for (int i = 0; i < numBebidas; i++) {
            Bebidas tmp = new CocaCola(10 + i);
            coca.add(tmp);
        }
        for (int i = 0; i < numBebidas; i++) {
            Bebidas tmp = new Sprite(20 + i);
            sprite.add(tmp);
        }
        for (int i = 0; i < numBebidas; i++) {
            Bebidas tmp = new Fanta(30 + i);
            fanta.add(tmp);
        }
        for (int i = 0; i < numDinero / 100; i++) {
            Moneda tmp = new Moneda100();
            m100.add(tmp);
        }
        for (int i = 0; i < numDinero / 500; i++) {
            Moneda tmp = new Moneda500();
            m500.add(tmp);
        }
    }

    public Bebidas comprarBebida(Moneda m, int cual) {
        if (m == null) {
            return null;
        }
        if ((cual != 1 && cual != 2 && cual != 3) || m.getValor() < precio) {
            vuelto.add(m);
            return null;
        }
        Bebidas tmp = (cual == 1)? coca.get() : sprite.get();                
        
        if (tmp == null) {
            vuelto.add(m);
        } else {
            int c = 0;
            for (int i = 0; i < precio / 500; i++) {
                m500.add(new Moneda500());
                c += 500;
            }
            for (int i = 0; i < (precio - c) / 100; i++) {
                m100.add(new Moneda100());
            }
            c = m.getValor() - precio;
            for (int i = 0; i < (m.getValor() - precio) / 500; i++) {
                vuelto.add(new Moneda500());
                c -= 500;
            }
            for (int i = 0; i < c / 100; i++) {
                vuelto.add(new Moneda100());
            }
        }
        this.updateComponents();
        return tmp;
    }

    public Moneda getVuelto() {
        return vuelto.get();
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
        this.updateComponents();
    }

    public int getPrecio() {
        return this.precio;
    }

    public void paint(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(this.x, this.y, 375, 450);
        if (coca != null) {
            coca.paint(g);
        }
        if (sprite != null) {
            sprite.paint(g);
        }
        if (fanta != null) {
            fanta.paint(g);
        }
        if (vuelto != null) {
            vuelto.paint(g);
        }
        if (m100 != null) {
            m100.paint(g);
        }
        if (m500 != null) {
            m500.paint(g);
        }
        // vidrio
        g.setColor(new Color(0.3f, 0.3f, 1.0f, 0.2f));
        g.fillRect(this.x + 15, this.y + 15, 180, 300);
        g.setColor(Color.white);
        g.drawString("precio: " + this.precio, this.x + 200, this.y + 15);
    }
}

class DepositoBebidas {

    private int x, y;
    private ArrayList<Bebidas> al;

    public DepositoBebidas() {
        al = new ArrayList<Bebidas>();
    }

    public void add(Bebidas t) {
        al.add(t);
    }

    public Bebidas get() {
        if (al.size() > 0) {
            return al.remove(0);
        } else {
            return null;
        }
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

    public void updateComponents() {
        int xoffset = 0, yoffset = 0;
        for (int i = 0; i < this.al.size(); i++) {
            if (xoffset > 6) {
                xoffset = 0;
                yoffset += 35;
            }
            this.al.get(i).setXY(this.getX() + 25 * xoffset, this.getY() + yoffset);
            xoffset++;
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(this.x, this.y, 170, 80);
        if (al != null) {
            for (Bebidas i : al) {
                i.paint(g);
            }
        }
    }
}

class DepositoMoneda {

    private int x, y;
    private ArrayList<Moneda> al;

    public DepositoMoneda() {
        al = new ArrayList<Moneda>();
    }

    public void add(Moneda t) {
        al.add(t);
    }

    public Moneda get() {
        if (al.size() > 0) {
            return al.remove(0);
        } else {
            return null;
        }
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

    public void updateComponents() {
        int xoffset = 0, yoffset = 0;
        for (int i = 0; i < this.al.size(); i++) {
            if (xoffset > 7) {
                xoffset = 0;
                yoffset += 20;
            }
            this.al.get(i).setXY(this.getX() + 20 * xoffset, this.getY() + yoffset);
            xoffset++;
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(this.x, this.y, 160, 110);
        if (al != null) {
            for (Moneda i : al) {
                i.paint(g);
            }
        }
    }
}
