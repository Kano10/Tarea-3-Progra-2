package tarea3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSur extends JPanel implements ActionListener {

    private JRadioButton rb1, rb2, rb3, rb100, rb500, rb1000;
    private Comprador com;
    private Ambiente am;

    public PanelSur(Comprador com, Ambiente am) {
        this.am = am;
        this.com = com;
        this.setBackground(Color.white);
        this.rb1 = new JRadioButton("CocaCola");
        this.rb2 = new JRadioButton("Sprite");
        this.rb3 = new JRadioButton("Fanta");

        this.rb100 = new JRadioButton("100");
        this.rb500 = new JRadioButton("500");
        this.rb1000 = new JRadioButton("1000");
        ButtonGroup bg = new ButtonGroup();
        ButtonGroup bgm = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);

        bgm.add(rb100);
        bgm.add(rb500);
        bgm.add(rb1000);
        this.add(rb1);
        this.add(rb2);
        this.add(rb3);

        this.add(rb100);
        this.add(rb500);
        this.add(rb1000);
        rb1.addActionListener(this);
        rb2.addActionListener(this);
        rb3.addActionListener(this);

        rb100.addActionListener(this);
        rb500.addActionListener(this);
        rb1000.addActionListener(this);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (rb1.isSelected()) {
            com.setBebidas(1);
        } else if (rb2.isSelected()) {
            com.setBebidas(2);
        } else if (rb3.isSelected()) {
            com.setBebidas(3);
            if (rb100.isSelected()) {
                com.darMoneda(new Moneda100());
            } else if (rb500.isSelected()) {
                com.darMoneda(new Moneda500());
            } else if (rb1000.isSelected()) {
                com.darMoneda(new Moneda1000());
            }
            am.repaint();
        }
    }
}
