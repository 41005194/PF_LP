package app.src.main.java.pf.Purete.Ex1;

import java.util.ArrayList;
import java.util.List;

public class CalculateurPourboire {
    
    private List<String> noms = new ArrayList<>();

    public boolean ajouterPersonne(String nom) {
        return noms.add(nom);
    }

    public boolean retirerPersonne(String nom) {
        return noms.remove(nom);
    } 

    public static int pourcentage(List<String> noms) {
        int taille = noms.size();
        if (taille > 5) { return 20; }
        else if (taille > 0) { return 10; }
        return 0;
    }

    public List<String> noms() { return noms; }
}
