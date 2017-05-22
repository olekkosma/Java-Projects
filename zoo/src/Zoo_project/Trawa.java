
package java_olga_projekt;

import java.awt.Color;
import java.util.Random;

public class Trawa extends Roslina {

    public Trawa(int polozenieX, int polozenieY, Swiat swiat) {
        super(0, 0, polozenieX, polozenieY, swiat);
        nazwa="Trawa";
    }

    @Override
    public void akcja() {

        Random random = new Random();
        int wybor = random.nextInt(100);
        if (wybor > 95) {
            if (CzyJestObokWolneMiejsce(polozenie)) {
                Organizm nowaTrawa = new Trawa(this.polozenie.getPolozenieX(), this.polozenie.getPolozenieY(), swiat);
                swiat.add(nowaTrawa);
                swiat.relacja=swiat.relacja+this.nazwa+" zasiewa kolejna rosline\n";
                nowaTrawa.szukajMiejsca();
            }
        }

    }

    @Override
    public void rysowanie() {
        System.out.print("T");
    }

    @Override
    public Color getColor() {
        return Color.green;
    }

}
