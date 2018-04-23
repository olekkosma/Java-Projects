import java.awt.Color;

public class barszczSosnowskiego extends Roslina {

    public barszczSosnowskiego(int polozenieX, int polozenieY, Swiat swiat) {
        super(10, 0, polozenieX, polozenieY, swiat);
        nazwa = "Barszcz";
    }

    @Override
    public void akcja() {

        Organizm broniacy = swiat.sprawdzMiejsce(new Polozenie(polozenie.getPolozenieX() + 1, polozenie.getPolozenieY()));
        if (broniacy != null) {
            if (broniacy instanceof Czlowiek) {
                Czlowiek bohater = (Czlowiek) broniacy;
                if (bohater.getMocSpecjalna() <= 0) {
                    swiat.relacja = swiat.relacja + broniacy.nazwa + " umiera od barszczu\n";
                    swiat.obiektyDoUsuniecia.add(bohater);

                } else {
                    swiat.relacja = swiat.relacja + broniacy.nazwa + " ucieka przed barszczem dzieki mocy\n";
                    bohater.przejdzNaWolneMiejsce();
                }
            } else {
                swiat.relacja = swiat.relacja + broniacy.nazwa + " umiera od barszczu\n";
                swiat.obiektyDoUsuniecia.add(broniacy);
            }
        }
        broniacy = swiat.sprawdzMiejsce(new Polozenie(polozenie.getPolozenieX() - 1, polozenie.getPolozenieY()));
        if (broniacy != null) {
            if (broniacy instanceof Czlowiek) {
                Czlowiek bohater = (Czlowiek) broniacy;
                if (bohater.getMocSpecjalna() <= 0) {
                    swiat.relacja = swiat.relacja + broniacy.nazwa + " umiera od barszczu\n";
                    swiat.obiektyDoUsuniecia.add(bohater);

                } else {
                    swiat.relacja = swiat.relacja + broniacy.nazwa + " ucieka przed barszczem dzieki mocy\n";
                    bohater.przejdzNaWolneMiejsce();
                }
            } else {
                swiat.relacja = swiat.relacja + broniacy.nazwa + " umiera od barszczu\n";
                swiat.obiektyDoUsuniecia.add(broniacy);
            }
        }
        broniacy = swiat.sprawdzMiejsce(new Polozenie(polozenie.getPolozenieX(), polozenie.getPolozenieY() + 1));
        if (broniacy != null) {
            if (broniacy instanceof Czlowiek) {
                Czlowiek bohater = (Czlowiek) broniacy;
                if (bohater.getMocSpecjalna() <= 0) {
                    swiat.relacja = swiat.relacja + broniacy.nazwa + " umiera od barszczu\n";
                    swiat.obiektyDoUsuniecia.add(bohater);

                } else {
                    swiat.relacja = swiat.relacja + broniacy.nazwa + " ucieka przed barszczem dzieki mocy\n";
                    bohater.przejdzNaWolneMiejsce();
                }
            } else {
                swiat.relacja = swiat.relacja + broniacy.nazwa + " umiera od barszczu\n";
                swiat.obiektyDoUsuniecia.add(broniacy);
            }
        }
        broniacy = swiat.sprawdzMiejsce(new Polozenie(polozenie.getPolozenieX(), polozenie.getPolozenieY() - 1));
        if (broniacy != null) {
            if (broniacy instanceof Czlowiek) {
                Czlowiek bohater = (Czlowiek) broniacy;
                if (bohater.getMocSpecjalna() <= 0) {
                    swiat.relacja = swiat.relacja + broniacy.nazwa + " umiera od barszczu\n";
                    swiat.obiektyDoUsuniecia.add(bohater);

                } else {
                    swiat.relacja = swiat.relacja + broniacy.nazwa + " ucieka przed barszczem dzieki mocy\n";
                    bohater.przejdzNaWolneMiejsce();
                }
            } else {
                swiat.relacja = swiat.relacja + broniacy.nazwa + " umiera od barszczu\n";
                swiat.obiektyDoUsuniecia.add(broniacy);
            }
        }

    }

    @Override
    public Color getColor() {
        return Color.magenta;
    }

}
