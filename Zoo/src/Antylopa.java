import java.awt.Color;
import java.util.Random;

public class Antylopa extends Zwierze {

    public Antylopa(int polozenieX, int polozenieY, Swiat swiat) {
        super(4, 4, polozenieX, polozenieY, swiat);
        nazwa = "Antylopa";
    }

    @Override
    public void akcja() {

        int i;
        for (i = 0; i < 2; i++) {

            int ilosc = swiat.getObiekty().size();
            super.akcja();

            if (swiat.getObiekty().size() > ilosc) {
                Organizm nowaAntylopa = new Antylopa(this.polozenie.getPolozenieX(), this.polozenie.getPolozenieY(), swiat);
                swiat.getObiekty().remove(ilosc);
                swiat.add(nowaAntylopa);
                nowaAntylopa.przejdzNaWolneMiejsce();
                nowaAntylopa.setPopPolozenie(new Polozenie(nowaAntylopa.getPolozenie().getPolozenieX(), nowaAntylopa.getPolozenie().getPolozenieY()));
            }
        }

    }

    @Override
    public int obrona(Organizm atakujacy) {
        Random random = new Random();
        int wybor = random.nextInt(2);
        if (wybor == 0) {
            this.przejdzNaWolneMiejsce();
            this.setPopPolozenie(new Polozenie(this.getPolozenie().getPolozenieX(), this.getPolozenie().getPolozenieY()));
            swiat.relacja = swiat.relacja + this.nazwa + " udalo sie uciec\n";
            return 1;
        }
        return 0;
    }

    @Override
    public void rysowanie() {
        System.out.print("A");
    }

    @Override
    public Color getColor() {
        return Color.CYAN;
    }

}
