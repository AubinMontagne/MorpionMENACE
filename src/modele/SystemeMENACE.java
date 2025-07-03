package modele;

import java.util.*;
import java.io.*;

public class SystemeMENACE
{
    private Map<String, BoiteAllumettes> memoire;
    private List<Coup> historique;
    private Random random;
    private static final String FICHIER_MEMOIRE = "memoire_menace.ser";

    public SystemeMENACE()
    {
        this.memoire = this.chargerMemoire();
        this.historique = new ArrayList<>();
        this.random = new Random();
    }

    public int choisirCoup(Morpion morpion)
    {
        String etat = morpion.getEtat();
        this.memoire.putIfAbsent(etat, new BoiteAllumettes(etat));
        int coup = this.memoire.get(etat).tirerCoupAleatoire(this.random);
        this.historique.add(new Coup(etat, coup));
        return coup;
    }

    public void miseAJour(boolean gagner)
    {
        for (Coup coup : this.historique)
        {
            BoiteAllumettes boite = this.memoire.get(coup.etat);
            boite.renforcement(coup.index, gagner);
        }
        this.sauvegarderMemoire();
        this.historique.clear();
    }

    @SuppressWarnings("unchecked")
    private Map<String, BoiteAllumettes> chargerMemoire()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHIER_MEMOIRE)))
        {
            return (Map<String, BoiteAllumettes>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            return new HashMap<>();
        }
    }

    private void sauvegarderMemoire()
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHIER_MEMOIRE)))
        {
            oos.writeObject(this.memoire);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}