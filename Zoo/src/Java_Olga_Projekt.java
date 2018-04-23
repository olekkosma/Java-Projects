import javax.swing.SwingUtilities;

public class Java_Olga_Projekt {

    public static void main(String[] args) {

        Swiat ziemia = new Swiat(20, 20);
        Czlowiek czlowiek = new Czlowiek(10, 10, ziemia);
        Organizm wilk = new Wilk(15, 12, ziemia);
        Organizm wilk2 = new Wilk(1, 6, ziemia);
        Organizm zolw = new Zolw(2, 2, ziemia);
        Organizm zolw2 = new Zolw(7, 11, ziemia);
        Organizm lis = new Lis(4, 4, ziemia);
        Organizm lis2 = new Lis(18, 9, ziemia);
        Organizm owca = new Owca(2, 14, ziemia);
        Organizm owca2 = new Owca(5, 4, ziemia);
        Organizm antylopa = new Antylopa(18, 1, ziemia);
        Organizm antylopa2 = new Antylopa(1, 3, ziemia);
        Organizm trawa = new Trawa(16, 6, ziemia);
        Organizm trawa2 = new Trawa(0, 2, ziemia);
        Organizm mlecz = new Mlecz(4, 6, ziemia);
        Organizm mlecz2 = new Mlecz(16, 12, ziemia);
        Organizm guarana = new Guarana(12, 9, ziemia);
        Organizm guarana2 = new Guarana(18, 16, ziemia);
        Organizm jagody = new wilczeJagody(10, 3, ziemia);
        Organizm jagody2 = new wilczeJagody(3, 6, ziemia);
        Organizm barszcz = new barszczSosnowskiego(19, 19, ziemia);
        Organizm barszcz2 = new barszczSosnowskiego(15, 0, ziemia);

        ziemia.add(czlowiek);
        ziemia.add(wilk);
        ziemia.add(wilk2);
        ziemia.add(zolw);
        ziemia.add(zolw2);
        ziemia.add(lis);
        ziemia.add(lis2);
        ziemia.add(owca);
        ziemia.add(owca2);
        ziemia.add(antylopa);
        ziemia.add(antylopa2);
        ziemia.add(trawa);
        ziemia.add(trawa2);
        ziemia.add(mlecz);
        ziemia.add(mlecz2);
        ziemia.add(guarana);
        ziemia.add(guarana2);
        ziemia.add(jagody);
        ziemia.add(jagody2);
        ziemia.add(barszcz);
        ziemia.add(barszcz2);


        UserInterface ui = new UserInterface(ziemia, czlowiek);
        SwingUtilities.invokeLater(ui);
    }

}
