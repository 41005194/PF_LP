package pf.OS.Cours;

import java.util.*;
import java.util.function.Function;

public class Main {
    static int score(String word) {
        return word.replaceAll("a", "").length();
    }
    
    static List<String> rankedWords(Comparator<String> comp, List<String> words) {
        List<String> rankedWords = new ArrayList<>(words);
        rankedWords.sort(comp);
        return rankedWords;
    }

    static int scoreWithBonus(String word) {
        int base = score(word);
        return (word.contains("c")) ? base + 5 : base;
    }
    static Comparator<String> genComparator(Function<String, Integer> scoring) {
        return (o1, o2) -> Integer.compare(scoring.apply(o2), scoring.apply(o1));
    }

    static Function<String, Integer> scoreWithBonusFunction = new Function<String, Integer>() {
        @Override
        public Integer apply(String s) {
            return scoreWithBonus(s);
        }
    };
    
    public static void main(String[] args) {
        List<String> words = Arrays.asList("aaa", "bb", "c", "ddddd", "eeeee", "fffff", "ggggg");
        System.out.println(rankedWords(genComparator(scoreWithBonusFunction), words));
        System.out.println(rankedWords(genComparator(w -> scoreWithBonus(w)), words));
        System.out.println(rankedWords(genComparator(Main::scoreWithBonus), words));
    }
}
                                                                               