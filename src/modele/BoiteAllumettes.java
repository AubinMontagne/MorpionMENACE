package modele;

import java.io.Serializable;
import java.util.*;

public class BoiteAllumettes implements Serializable
{
    private static final long serialVersionUID = 1L;

    private List<Integer> coupsPossibles;

    public BoiteAllumettes(String etat)
    {
        this.coupsPossibles = new ArrayList<>();
        for (int i = 0; i < etat.length(); i++)
        {
            if (etat.charAt(i) == ' ')
            {
                this.coupsPossibles.add(i);
            }
        }
    }

    public int tirerCoupAleatoire(Random random)
    {
        if (this.coupsPossibles.isEmpty())
        {
            return -1;
        }

        return this.coupsPossibles.get(random.nextInt(this.coupsPossibles.size()));
    }

    public void renforcement(int coup, boolean gagner)
    {
        if (gagner)
        {
            this.coupsPossibles.add(coup);
        }
        else
        {
            this.coupsPossibles.remove(Integer.valueOf(coup));
        }
    }

    public List<Integer> getCoups()
    {
        return this.coupsPossibles;
    }
}