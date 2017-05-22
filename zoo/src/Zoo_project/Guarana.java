
package java_olga_projekt;

import java.awt.Color;
import java.util.Random;

public class Guarana extends Roslina {

    public Guarana(int polozenieX, int polozenieY, Swiat swiat) {
        super(0, 0, polozenieX, polozenieY, swiat);
        nazwa = "Guarana";
    }

    @Override
    public void akcja() {
        int i;
        Random random = new Random();

        int wybor = random.nextInt(100);
        if (wybor > 98) {
            if (CzyJestObokWolneMiejsce(polozenie)) {
                Organizm nowaGuarana = new Guarana(this.polozenie.getPolozenieX(), this.polozenie.getPolozenieY(), swiat);
                swiat.add(nowaGuarana);
                nowaGuarana.szukajMiejsca();
                swiat.relacja = swiat.relacja + this.nazwa + " zasiewa kolejna rosline\n";
            }
        }

    }

    @Override
    public int obrona(Organizm atakujacy) {
        swiat.relacja = swiat.relacja + atakujacy.nazwa + " zjada guarana\nsila " + atakujacy.nazwa + " zwieksza sie o 3\n";
        atakujacy.setSila(atakujacy.getSila() + 3);
        return 0;
    }

    @Override
    public void rysowanie() {
        System.out.print("G");
    }

    @Override
    public Color getColor() {
        return Color.lightGray;
    }

}
