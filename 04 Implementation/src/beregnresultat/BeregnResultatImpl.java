package beregnresultat;

import entities.*;

public class BeregnResultatImpl implements BeregnResultat {
    private Resultat resultat;
    private Skatteprocent skatteprocent;

    public BeregnResultatImpl() {
        resultat = new ResultatImpl();
        skatteprocent = new SkatteprocentImpl();
    }


    @Override
    public void angivResultatFoerSkat(ResultatFoerSkat resultatFoerSkat) {
        resultat.angivResultatFoerSkat(resultatFoerSkat);
    }

    @Override
    public void angivSkatteprocent(double beloeb) {
        skatteprocent.angivSkatteprocent(beloeb);
        resultat.angivSkatteprocent(skatteprocent);
        beregnResultat();
    }

    @Override
    public void beregnResultat() {
        resultat.beregnResultat();
    }

    @Override
    public Resultat hentResultat() {
        return resultat;
    }

    @Override
    public Skatteprocent hentSkatteprocent() {
        return skatteprocent;
    }
}
