
package tarea3;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Ventana extends JFrame {
    public Ventana(String s) {
        this.setLayout(new BorderLayout());
        Ambiente a = new Ambiente();
        this.add(a, BorderLayout.CENTER);
        this.setTitle("Expendedor");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
    }
}