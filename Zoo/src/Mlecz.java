import java.awt.Color;
import java.util.Random;

public class Mlecz extends Roslina {

    public Mlecz(int polozenieX, int polozenieY, Swiat swiat) {
        super(0, 0, polozenieX, polozenieY, swiat);
        nazwa = "Mlecz";
    }

    @Override
    public void akcja() {
        int i;
        Random random = new Random();
        for (i = 0; i < 3; i++) {
            int wybor = random.nextInt(100);
            if (wybor > 97) {
                if (CzyJestObokWolneMiejsce(polozenie)) {
                    Organizm nowyMlecz = new Mlecz(this.polozenie.getPolozenieX(), this.polozenie.getPolozenieY(), swiat);
                    swiat.add(nowyMlecz);
                    swiat.relacja = swiat.relacja + this.nazwa + " zasiewa kolejna rosline\n";
                    nowyMlecz.szukajMiejsca();
                }
            }
        }

    }

    @Override
    public void rysowanie() {
        System.out.print("M");
    }

    @Override
    public Color getColor() {
        return Color.gray;
    }
}
