package pf.OS.Cours;

import java.util.Comparator;

public class ComparatorMot implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(Main.score(o2), Main.score(o1));
    }
}
