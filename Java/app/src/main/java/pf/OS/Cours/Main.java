package pf.OS.Cours;

import java.util.*;
import java.util.function.Function;

public class Main {
    static int score(String word) {
        return word.replaceAll("a", "").length();
    }

    public interface Calculateur extends Function<String, Integer> {}
    
    static List<String> rankedWords(Comparator<String> comp, List<String> words) {
        List<String> rankedWords = new ArrayList<>(words);
        rankedWords.sort(comp);
        return rankedWords;
    }

    static int scoreWithBonus(String word) {
        int base = score(word);
        return (word.contains("c")) ? base + 5 : base;
    }

    static int scoreWithMalus(String word) {
        int base = score(word);
        return (word.contains("s")) ? base - 7 : base;
    }

    static Comparator<String> genComparator(Calculateur scoring) {
        return (o1, o2) -> Integer.compare(scoring.apply(o2), scoring.apply(o1));
    }

    static Function<String, Integer> scoreWithBonusFunction = new Function<String, Integer>() {
        @Override
        public Integer apply(String s) {
            return scoreWithBonus(s);
        }
    };

    static Calculateur score = word -> word.replaceAll("a", "").length();

    static Calculateur bonus = word -> word.contains("c") ? 5 : 0;

    static Calculateur malus = word -> word.contains("s") ? -7 : 0;

    static Calculateur wordScore(Calculateur base, Calculateur bonus, Calculateur malus) {
        return word -> base.apply(word) + bonus.apply(word) + malus.apply(word);
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("aaa", "bb", "c", "ddddd", "eeeee", "fffffs", "ggggg");
        System.out.println(rankedWords(genComparator(wordScore(score, bonus, malus)), words));
    }
}
                                                                               