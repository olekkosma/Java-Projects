import java.awt.Color;
import java.util.Random;

public class wilczeJagody extends Roslina {

    public wilczeJagody(int polozenieX, int polozenieY, Swiat swiat) {
        super(99, 0, polozenieX, polozenieY, swiat);
        nazwa = "Jagody";
    }

    @Override
    public void akcja() {
        int i;
        Random random = new Random();

        int wybor = random.nextInt(100);
        if (wybor > 98) {
            if (CzyJestObokWolneMiejsce(polozenie)) {
                Organizm noweJagody = new wilczeJagody(this.polozenie.getPolozenieX(), this.polozenie.getPolozenieY(), swiat);
                swiat.add(noweJagody);
                swiat.relacja = swiat.relacja + this.nazwa + " zasiewa kolejna rosline\n";
                noweJagody.szukajMiejsca();
            }
        }

    }

    @Override
    public void rysowanie() {
        System.out.print("J");
    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

}
