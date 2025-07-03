package controleur;

import java.util.Scanner;

import modele.Morpion;
import modele.SystemeMENACE;
import vue.VueTexte;

public class ControleurMorpion
{
    private Morpion morpion;
    private SystemeMENACE menace;
    private VueTexte vue;

    public ControleurMorpion(Morpion morpion, SystemeMENACE menace, VueTexte vue)
    {
        this.morpion = morpion;
        this.menace = menace;
        this.vue = vue;
    }

    public void demarrerPartie()
    {
        Scanner scanner = new Scanner(System.in);
        char gagnant = ' ';

        this.vue.afficherMessage("Début de la partie !");
        while (gagnant == ' ' && !this.morpion.estPlein())
        {
            this.vue.afficherGrille(this.morpion.getGrille());

            int coupHumain;
            do
            {
                this.vue.afficherMessage("Votre coup (0-8) : ");
                coupHumain = scanner.nextInt();
            } while (!this.morpion.jouerCoup(coupHumain, 'X'));

            gagnant = this.morpion.verifierGagnant();
            if (gagnant != ' ' || this.morpion.estPlein())
            {
                break;
            }

            int coupMENACE = this.menace.choisirCoup(this.morpion);
            this.morpion.jouerCoup(coupMENACE, 'O');

            gagnant = this.morpion.verifierGagnant();
        }

        this.vue.afficherGrille(this.morpion.getGrille());

        if (gagnant == 'X')
        {
            this.vue.afficherMessage("Vous avez gagné !");
            this.menace.miseAJour(false);
        }
        else if (gagnant == 'O')
        {
            this.vue.afficherMessage("MENACE a gagné !");
            this.menace.miseAJour(true);
        }
        else
        {
            this.vue.afficherMessage("Match nul !");
            this.menace.miseAJour(false);
        }

        scanner.close();
    }
}