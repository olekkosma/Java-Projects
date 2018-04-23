import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Swiat {

    int wymX;
    int wymY;
    ArrayList<Organizm> obiekty = new ArrayList<>();
    List<Organizm> obiektyDoUsuniecia = new ArrayList<>();
    public String relacja = "";

    public Swiat(int wymX, int wymY) {
        this.wymX = wymX;
        this.wymY = wymY;
    }

    public int getWymX() {
        return wymX;
    }

    public ArrayList<Organizm> getObiekty() {
        return obiekty;
    }

    public int getWymY() {
        return wymY;
    }

    public void add(Organizm nowyOrganizm) {
        obiekty.add(nowyOrganizm);
    }

    public String getRelacja() {
        return relacja;
    }

    public List<Organizm> getObiektyDoUsuniecia() {
        return obiektyDoUsuniecia;
    }

    public void wykonajTure() {
        Collections.sort(obiekty, new OrganizmComparator());
        relacja = "";
        int i;
        int iloscOrganizmow = obiekty.size();
        for (i = 0; i < iloscOrganizmow; i++) {

            obiekty.get(i).akcja();
            obiekty.get(i).setWiek(obiekty.get(i).getWiek() + 1);

        }
        if (!obiektyDoUsuniecia.isEmpty()) {
            for (Organizm organizm : obiektyDoUsuniecia) {
                obiekty.remove(organizm);
            }
            obiektyDoUsuniecia.clear();
        }
    }

    public Organizm sprawdzMiejsce(Polozenie polozenie) {

        for (Organizm organizm : obiekty) {
            if (polozenie.equals(organizm.getPolozenie())) {
                return organizm;
            }

        }
        return null;
    }


}
