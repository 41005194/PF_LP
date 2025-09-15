package app.src.main.java.pf.Purete.Ex1;

import java.util.logging.Logger;

public class main1 {
    private static final Logger logger = Logger.getLogger(main1.class.getName());
    public static void main(String[] args) {
        CalculateurPourboire calc = new CalculateurPourboire();
        calc.ajouterPersonne("Alice");
        calc.ajouterPersonne("Bob");
        calc.ajouterPersonne("Charlie");
        logger.info("Noms: " + calc.noms());
        int pourcentage = CalculateurPourboire.pourcentage(calc.noms());
        logger.info("Rabais: " + pourcentage + "%");
    }
}
