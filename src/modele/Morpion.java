package modele;

public class Morpion
{
    private char[] grille;

    public Morpion()
    {
        this.grille = new char[9];
        for (int i = 0; i < 9; i++)
        {
            this.grille[i] = ' ';
        }
    }

    public boolean jouerCoup(int index, char joueur)
    {
        if (index < 0 || index >= 9 || this.grille[index] != ' ')
        {
            return false;
        }

        this.grille[index] = joueur;
        return true;
    }

    public boolean estPlein()
    {
        for (char c : this.grille)
        {
            if (c == ' ')
            {
                return false;
            }
        }
        return true;
    }

    public char verifierGagnant()
    {
        int[][] combinaisons =
        {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
        };

        for (int[] comb : combinaisons)
        {
            if (this.grille[comb[0]] != ' ' && this.grille[comb[0]] == this.grille[comb[1]] && this.grille[comb[1]] == this.grille[comb[2]])
            {
                return this.grille[comb[0]];
            }
        }

        return ' ';
    }

    public char[] getGrille()
    {
        return this.grille;
    }

    public String getEtat()
    {
        return new String(this.grille);
    }
}