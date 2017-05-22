
package java_olga_projekt;

import java.awt.Color;

public class Wilk extends Zwierze {

    public Wilk(int polozenieX, int polozenieY, Swiat swiat) {
        super(9, 5, polozenieX, polozenieY, swiat);
        nazwa = "wilk";
    }
    @Override
    public void akcja() {

        int ilosc = swiat.getObiekty().size();
        super.akcja();

        if (swiat.getObiekty().size() > ilosc) {
            Organizm nowyWilk = new Wilk(this.polozenie.getPolozenieX(), this.polozenie.getPolozenieY(), swiat);
           
            swiat.getObiekty().remove(ilosc);
            swiat.add(nowyWilk);
            nowyWilk.przejdzNaWolneMiejsce();
            nowyWilk.setPopPolozenie(new Polozenie(nowyWilk.getPolozenie().getPolozenieX(),nowyWilk.getPolozenie().getPolozenieY()));
           

        }
    }

    @Override
    public void rysowanie() {

        System.out.print("W");
    }
     @Override
    public Color getColor() {
        return Color.RED;
    }

}
