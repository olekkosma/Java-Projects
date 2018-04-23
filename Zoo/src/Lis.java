public class Lis extends Zwierze {

    public Lis(int polozenieX, int polozenieY, Swiat swiat) {
        super(3, 7, polozenieX, polozenieY, swiat);
        nazwa = "Lis";
    }

    public void akcja() {
        int ilosc = swiat.getObiekty().size();
        super.akcja();
        if (swiat.getObiekty().size() > ilosc) {
            Organizm nowyLis = new Lis(this.polozenie.getPolozenieX(), this.polozenie.getPolozenieY(), swiat);
            swiat.getObiekty().remove(ilosc);
            swiat.add(nowyLis);
            nowyLis.przejdzNaWolneMiejsce();
            nowyLis.setPopPolozenie(new Polozenie(nowyLis.getPolozenie().getPolozenieX(), nowyLis.getPolozenie().getPolozenieY()));
        }
    }

    @Override
    public void kolizja(Organizm broniacy) {
        swiat.relacja = swiat.relacja + this.nazwa + " atakuje\n";
        if (sila < broniacy.getSila()) {
            swiat.relacja = swiat.relacja + broniacy.nazwa + " jest za silny, " + this.nazwa + " ucieka\n";
            this.setPolozenie(new Polozenie(this.getPopPolozenie().getPolozenieX(), this.getPopPolozenie().getPolozenieY()));
        }

        if (broniacy.obrona(this) == 0) {
            if (sila >= broniacy.getSila()) {
                swiat.obiektyDoUsuniecia.add(broniacy);
                swiat.relacja = swiat.relacja + this.nazwa + " pokonuje " + broniacy.nazwa + "\n";
            }
        }

    }

    @Override
    public void rysowanie() {

        System.out.print("L");
    }

}
