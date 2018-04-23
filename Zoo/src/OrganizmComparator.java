import java.util.Comparator;

public class OrganizmComparator implements Comparator<Organizm> {

    @Override
    public int compare(Organizm o1, Organizm o2) {

        if (o1.getInicjatywa() > o2.getInicjatywa()) {
            return -1;
        } else {
            if (o1.getInicjatywa() < o2.getInicjatywa()) {
                return 1;
            } else {
                if (o1.getWiek() > o2.getWiek()) {
                    return -1;
                } else {
                    if (o1.getWiek() < o2.getWiek()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }

    }
}
