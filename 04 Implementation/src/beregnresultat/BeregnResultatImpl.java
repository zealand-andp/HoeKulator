package beregnresultat;

import entities.*;

public class BeregnResultatImpl implements BeregnResultat {
    private Resultat resultat;

    public BeregnResultatImpl() {
        resultat = new ResultatImpl();
    }


    @Override
    public void angivResultatFoerSkat(ResultatFoerSkat resultatFoerSkat) {
        resultat.angivResultatFoerSkat(resultatFoerSkat);
    }

    @Override
    public void angivSkatteprocent(double beloeb) {
        Skatteprocent skatteprocent = new SkatteprocentImpl();
        skatteprocent.angivSkatteprocent(beloeb);
        resultat.angivSkatteprocent(skatteprocent);
    }

    @Override
    public void beregnResultat() {
        resultat.beregnResultat();
    }

    @Override
    public Resultat hentResultat() {
        return resultat;
    }
}
