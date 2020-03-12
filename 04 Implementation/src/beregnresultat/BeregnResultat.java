package beregnresultat;

import entities.Resultat;
import entities.ResultatFoerSkat;

public interface BeregnResultat {
    void angivResultatFoerSkat(ResultatFoerSkat resultatFoerSkat);
    void angivSkatteprocent(double beloeb);
    void beregnResultat();
    Resultat hentResultat();
}
