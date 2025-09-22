class Main {
    def score(word: String): Int = word.replaceAll("a", "").length
    def rankedWords(scoring: String => Int, words: List[String]): List[String] = {
        def negativeScoring(word: String): Int = -scoring(word)
        words.sortBy(negativeScoring)
    }
}
