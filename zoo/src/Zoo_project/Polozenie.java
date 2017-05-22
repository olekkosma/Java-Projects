
package java_olga_projekt;

public class Polozenie {

    int polozenieX;
    int polozenieY;

    public Polozenie(int polozenieX, int polozenieY) {
        this.polozenieX = polozenieX;
        this.polozenieY = polozenieY;
    }

    public int getPolozenieX() {
        return polozenieX;
    }

    public int getPolozenieY() {
        return polozenieY;
    }

    public void setPolozenie(Polozenie polozenie) {
        polozenieX = polozenie.getPolozenieX();
        polozenieY = polozenie.getPolozenieY();
    }


    @Override
    public boolean equals(Object obj) {
        Polozenie o = (Polozenie) obj;
        if (o.getPolozenieX() == polozenieX && o.getPolozenieY() == polozenieY) {
            return true;
        } else {
            return false;
        }

    }
}
