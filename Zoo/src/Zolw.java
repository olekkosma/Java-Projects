import java.awt.Color;
import java.util.Random;

public class Zolw extends Zwierze {

    public Zolw(int polozenieX, int polozenieY, Swiat swiat) {
        super(2, 1, polozenieX, polozenieY, swiat);
        nazwa = "Zolw";
    }

    @Override
    public void rysowanie() {

        System.out.print("Z");
    }

    @Override
    public void akcja() {
        Random random = new Random();
        int wybor = random.nextInt(100);
        if (wybor > 74) {
            int ilosc = swiat.getObiekty().size();
            super.akcja();

            if (swiat.getObiekty().size() > ilosc) {
                Organizm nowyZolw = new Zolw(this.polozenie.getPolozenieX(), this.polozenie.getPolozenieY(), swiat);
                swiat.getObiekty().remove(ilosc);
                swiat.add(nowyZolw);
                nowyZolw.przejdzNaWolneMiejsce();
                nowyZolw.setPopPolozenie(new Polozenie(nowyZolw.getPolozenie().getPolozenieX(), nowyZolw.getPolozenie().getPolozenieY()));
            }
        }

    }

    @Override
    public int obrona(Organizm atakujacy) {
        super.obrona(this);
        if (atakujacy.getSila() < 5) {
            atakujacy.setPolozenie(new Polozenie(atakujacy.getPopPolozenieX(), atakujacy.getPopPolozenieY()));
            swiat.relacja = swiat.relacja + this.nazwa + " odpiera atak\n";
            return 1;

        }

        return 0;
    }

    @Override
    public Color getColor() {
        return Color.pink;
    }

}
