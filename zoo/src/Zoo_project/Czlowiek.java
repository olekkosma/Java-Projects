
package java_olga_projekt;

import java.awt.Color;
import java.util.Random;

public class Czlowiek extends Zwierze {

    Polozenie planowanePolozenie;
    int mocSpecjalna;

    public Czlowiek(int polozenieX, int polozenieY, Swiat swiat) {
        super(5, 4, polozenieX, polozenieY, swiat);
        nazwa = "Czlowiek";
        planowanePolozenie = new Polozenie(polozenieX, polozenieY);
        mocSpecjalna = -5;
    }

    public int getMocSpecjalna() {
        return mocSpecjalna;
    }

    public void setMocSpecjalna(int mocSpecjalna) {
        this.mocSpecjalna = mocSpecjalna;
    }

    public void setPlanowanePolozenie(Polozenie planowanePolozenie) {
        this.planowanePolozenie = planowanePolozenie;
    }

    @Override
    public int krok(Polozenie nowePolozenie) {
        if (czyMiesciSieNaMapie(nowePolozenie, swiat) == false) {
            return 0;
        } else {
            Organizm broniacy = swiat.sprawdzMiejsce(nowePolozenie);
            this.setPolozenie(nowePolozenie);

            if (broniacy != null) {
                    kolizja(broniacy);
            }
            setPopPolozenie(new Polozenie(this.getPolozenie().getPolozenieX(), this.getPolozenie().getPolozenieY()));
        }
        return 1;
    }

    @Override
    public void akcja() {
        swiat.relacja = swiat.relacja + this.nazwa + " moc specjalna:" + mocSpecjalna + "\n";
        if (!this.getPolozenie().equals(this.planowanePolozenie)) {
            krok(planowanePolozenie);
        }
        planowanePolozenie = new Polozenie(getPolozenieX(), getPolozenieY());
        if (mocSpecjalna > -5) {
            mocSpecjalna--;
        }
    }

    @Override
    public int obrona(Organizm atakujacy) {
        if (mocSpecjalna > 0) {
            this.przejdzNaWolneMiejsce();
            this.setPopPolozenie(new Polozenie(this.getPolozenie().getPolozenieX(), this.getPolozenie().getPolozenieY()));
            swiat.relacja = swiat.relacja + this.nazwa + " udalo sie uciec dzieki mocy\n";
            return 1;
        }
        return 0;
    }

    @Override
    public void kolizja(Organizm broniacy) {
        swiat.relacja = swiat.relacja + this.nazwa + " atakuje\n";
        if (broniacy.obrona(this) == 0) {
            if (sila >= broniacy.getSila()) {
                swiat.obiektyDoUsuniecia.add(broniacy);
                swiat.relacja = swiat.relacja + this.nazwa + " pokonuje " + broniacy.nazwa + "\n";
            } else {
                if (sila < broniacy.getSila()) {
                    if (mocSpecjalna > 0) {
                        this.przejdzNaWolneMiejsce();
                        this.setPopPolozenie(new Polozenie(this.getPolozenie().getPolozenieX(), this.getPolozenie().getPolozenieY()));
                        swiat.relacja = swiat.relacja + this.nazwa + " udalo sie uciec dzieki mocy\n";
                    } else {
                        swiat.obiektyDoUsuniecia.add(this);
                        swiat.relacja = swiat.relacja + broniacy.nazwa + " broni sie i pokonuje " + this.nazwa + "\n";
                    }
                }
            }
        }
    }

    @Override
    public Color getColor() {
        return Color.black;
    }

}
