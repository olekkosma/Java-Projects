import java.util.Random;

public class Zwierze extends Organizm {

    public Zwierze(int sila, int inicjatywa, int polozenieX, int polozenieY, Swiat swiat) {
        super(sila, inicjatywa, polozenieX, polozenieY, swiat);

    }

    public int krok(Polozenie nowePolozenie) {
        if (czyMiesciSieNaMapie(nowePolozenie, swiat) == false) {
            return 0;
        } else {
            Organizm broniacy = swiat.sprawdzMiejsce(nowePolozenie);
            this.setPolozenie(nowePolozenie);

            if (broniacy != null) {

                if (broniacy.getNazwa().equals(this.getNazwa())) {

                    this.setPolozenie(new Polozenie(this.getPopPolozenie().getPolozenieX(), this.getPopPolozenie().getPolozenieY()));
                    if (CzyJestObokWolneMiejsce(polozenie)) {
                        swiat.relacja=swiat.relacja+this.nazwa+" rodzi kolejne zwierze\n";

                        stworzOrganizm();
                    }
                } else {

                    kolizja(broniacy);
                }
            }
            setPopPolozenie(new Polozenie(this.getPolozenie().getPolozenieX(), this.getPolozenie().getPolozenieY()));
        }

        return 1;
    }

    @Override
    public void akcja() {
        int zmianaPozycji = 0;
        Random random = new Random();
        while (zmianaPozycji != 1) {
            int wybor = random.nextInt(4);
            switch (wybor) {
                case 0:

                    zmianaPozycji = krok(new Polozenie(getPolozenieX(), getPolozenieY() + 1));
                    break;
                case 1:
                    zmianaPozycji = krok(new Polozenie(getPolozenieX() + 1, getPolozenieY()));
                    break;
                case 2:
                    zmianaPozycji = krok(new Polozenie(getPolozenieX(), getPolozenieY() - 1));
                    break;
                case 3:
                    zmianaPozycji = krok(new Polozenie(getPolozenieX() - 1, getPolozenieY()));
                    break;

            }
        }
    }

    public void kolizja(Organizm broniacy) {
        swiat.relacja=swiat.relacja+this.nazwa+" atakuje\n";
        if (broniacy.obrona(this) == 0) {
            if (sila >= broniacy.getSila()) {
                swiat.obiektyDoUsuniecia.add(broniacy);
                swiat.relacja=swiat.relacja+this.nazwa+" pokonuje "+broniacy.nazwa+"\n";
            } else {
                if (sila < broniacy.getSila()) {
                    swiat.obiektyDoUsuniecia.add(this);
                    swiat.relacja=swiat.relacja+broniacy.nazwa+" broni sie i pokonuje "+this.nazwa+"\n";
                }
            }
        }
    }

    @Override
    public void rysowanie() {
        System.out.print("Z");
    }

}
