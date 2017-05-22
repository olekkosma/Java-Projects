
package java_olga_projekt;

import java.util.Random;

public class Roslina extends Organizm {

    public Roslina(int sila, int inicjatywa, int polozenieX, int polozenieY, Swiat swiat) {
        super(sila, 0, polozenieX, polozenieY, swiat);
    }

    public int krok(Polozenie nowePolozenie) {

        if (czyMiesciSieNaMapie(nowePolozenie, swiat) == false) {
            return 0;
        } else {
            Organizm broniacy = swiat.sprawdzMiejsce(nowePolozenie);
            this.setPolozenie(nowePolozenie);

            if (broniacy != null) {

                return 0;
            }
            this.setPolozenie(nowePolozenie);
        }

        return 1;
    }

    @Override
    public void szukajMiejsca() {
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

    @Override
    public void akcja() {

     
    }

}
