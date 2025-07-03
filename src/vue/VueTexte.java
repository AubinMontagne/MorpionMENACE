package vue;

public class VueTexte
{
    public void afficherGrille(char[] grille)
    {
        System.out.println();
        for (int i = 0; i < grille.length; i++)
        {
            System.out.print(" " + grille[i] + " ");
            if ((i + 1) % 3 == 0)
            {
                System.out.println();
                if (i != 8)
                {
                    System.out.println("---+---+---");
                }
            }
            else
            {
                System.out.print("|");
            }
        }
        System.out.println();
    }

    public void afficherMessage(String message)
    {
        System.out.println(message);
    }
}