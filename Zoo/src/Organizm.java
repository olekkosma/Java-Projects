import java.awt.Color;
import java.util.Random;

public abstract class Organizm {

    int sila;
    int inicjatywa;
    Polozenie polozenie;
    Polozenie popPolozenie;
    Swiat swiat;
    String nazwa;
    int wiek;

    public Organizm(int sila, int inicjatywa, int polozenieX, int polozenieY, Swiat swiat) {
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        polozenie = new Polozenie(polozenieX, polozenieY);
        popPolozenie = new Polozenie(polozenieX, polozenieY);
        this.swiat = swiat;
        wiek = 0;
    }

    public int getInicjatywa() {
        return inicjatywa;
    }

    public int getSila() {
        return sila;
    }

    public Polozenie getPolozenie() {
        return polozenie;
    }

    public Polozenie getPopPolozenie() {
        return popPolozenie;
    }

    public int getPolozenieY() {
        return polozenie.getPolozenieY();
    }

    public int getPolozenieX() {
        return polozenie.getPolozenieX();
    }

    public int getPopPolozenieX() {
        return popPolozenie.getPolozenieX();
    }

    public int getPopPolozenieY() {
        return popPolozenie.getPolozenieY();
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public void setInicjatywa(int inicjatywa) {
        this.inicjatywa = inicjatywa;
    }

    public void setPolozenie(Polozenie polozenie) {
        this.polozenie.setPolozenie(polozenie);
    }

    public void setPopPolozenie(Polozenie polozenie) {
        popPolozenie.setPolozenie(polozenie);
    }

    public void akcja() {

    }

    public void kolizja() {

    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public int getWiek() {
        return wiek;
    }

    public int obrona(Organizm atakujacy) {

        return 0;
    }

    public void rysowanie() {
        System.out.print("O");

    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void stworzOrganizm() {
        Organizm nowy = new Organizm(0, 0, -1, -1, swiat) {
        };
        swiat.add(nowy);

    }

    public static boolean czyMiesciSieNaMapie(Polozenie nowePolozenie, Swiat swiat) {
        if (nowePolozenie.getPolozenieX() < 0 || nowePolozenie.getPolozenieX() >= swiat.wymX || nowePolozenie.getPolozenieY() < 0 || nowePolozenie.getPolozenieY() >= swiat.wymY) {
            return false;
        }
        return true;

    }

    public boolean CzyToWolneMiejsce(Polozenie polozenie) {
        if (!czyMiesciSieNaMapie(polozenie, swiat)) {
            return false;
        }
        Polozenie temp = new Polozenie(polozenie.getPolozenieX(), polozenie.getPolozenieY());
        Organizm wolny = swiat.sprawdzMiejsce(temp);

        if (wolny == null) {
            return true;
        }
        return false;
    }

    public boolean CzyJestObokWolneMiejsce(Polozenie polozenie) {

        if (CzyToWolneMiejsce(new Polozenie(polozenie.getPolozenieX() + 1, polozenie.getPolozenieY()))) {
            return true;
        }
        if (CzyToWolneMiejsce(new Polozenie(polozenie.getPolozenieX() - 1, polozenie.getPolozenieY()))) {
            return true;
        }
        if (CzyToWolneMiejsce(new Polozenie(polozenie.getPolozenieX(), polozenie.getPolozenieY() + 1))) {
            return true;
        }
        return CzyToWolneMiejsce(new Polozenie(polozenie.getPolozenieX(), polozenie.getPolozenieY() - 1));

    }

    public boolean przejdzNaWolneMiejsce() {

        if (CzyToWolneMiejsce(new Polozenie(polozenie.getPolozenieX() + 1, polozenie.getPolozenieY()))) {
            this.polozenie.setPolozenie(new Polozenie(polozenie.getPolozenieX() + 1, polozenie.getPolozenieY()));
            return true;
        }
        if (CzyToWolneMiejsce(new Polozenie(polozenie.getPolozenieX() - 1, polozenie.getPolozenieY()))) {
            polozenie.setPolozenie(new Polozenie(polozenie.getPolozenieX() - 1, polozenie.getPolozenieY()));
            return true;
        }
        if (CzyToWolneMiejsce(new Polozenie(polozenie.getPolozenieX(), polozenie.getPolozenieY() + 1))) {
            polozenie.setPolozenie(new Polozenie(polozenie.getPolozenieX(), polozenie.getPolozenieY() + 1));
            return true;
        }
        if (CzyToWolneMiejsce(new Polozenie(polozenie.getPolozenieX(), polozenie.getPolozenieY() - 1))) {
            polozenie.setPolozenie(new Polozenie(polozenie.getPolozenieX(), polozenie.getPolozenieY() - 1));
            return true;
        }
        return false;
    }

    void szukajMiejsca() {

    }

    public Color getColor() {
        return Color.WHITE;
    }
}
