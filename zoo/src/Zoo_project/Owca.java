
package java_olga_projekt;

import java.awt.Color;
import java.util.Random;

public class Owca extends Zwierze {

    public Owca(int polozenieX, int polozenieY, Swiat swiat) {
        super(4, 4, polozenieX, polozenieY, swiat);
        nazwa = "Owca";
    }

    @Override
    public void rysowanie() {

        System.out.print("O");
    }

    @Override
    public void akcja() {

        int ilosc = swiat.getObiekty().size();
        super.akcja();

        if (swiat.getObiekty().size() > ilosc) {
            Organizm nowaOwca = new Owca(this.polozenie.getPolozenieX(), this.polozenie.getPolozenieY(), swiat);
            swiat.getObiekty().remove(ilosc);
            swiat.add(nowaOwca);
            nowaOwca.przejdzNaWolneMiejsce();
            nowaOwca.setPopPolozenie(new Polozenie(nowaOwca.getPolozenie().getPolozenieX(), nowaOwca.getPolozenie().getPolozenieY()));

        }

    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }

}
