class Test {
    object WordScore {
        def score(word: String): Int = word.replaceAll("a", "").length
        def bonus(word: String): Int = if (word.contains("c")) 5 else 0
        def malus(word: String): Int = if (word.contains("s")) 7 else 0

        def rankedWords(scoring: String => Int, words: List[String]): List[String] = {
            words.sortBy(scoring).reverse
        }
        
        def test(): Unit = {
            val words: List[String] = List("ada", "haskell", "scala", "java", "rust")
            println(rankedWords(w => score(w) + bonus(w) - malus(w), words))
        }
    }
}
