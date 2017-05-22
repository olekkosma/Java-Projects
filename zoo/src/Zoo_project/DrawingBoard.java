
package java_olga_projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawingBoard extends JPanel {

    ArrayList<Organizm> organizmy;

    public DrawingBoard(ArrayList<Organizm> organizmy) {
        this.organizmy = organizmy;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        for (Organizm organizm : organizmy) {

            g.setColor(organizm.getColor());
            g.fillRect(organizm.getPolozenieX() * 40, organizm.getPolozenieY() * 40, 40, 40);
            g.setColor(Color.darkGray);
            g.drawString(organizm.getNazwa(), organizm.getPolozenieX() * 40 + 5, organizm.getPolozenieY() * 40 + 25);

        }
    }

}
