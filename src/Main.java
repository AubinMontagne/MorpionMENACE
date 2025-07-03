import modele.Morpion;
import modele.SystemeMENACE;
import vue.VueTexte;
import controleur.ControleurMorpion;

public class Main
{
    public static void main(String[] args)
    {
        Morpion morpion = new Morpion();
        SystemeMENACE menace = new SystemeMENACE();
        VueTexte vue = new VueTexte();
        ControleurMorpion controleur = new ControleurMorpion(morpion, menace, vue);
        controleur.demarrerPartie();
    }
}