package beregnresultat;

import entities.Resultat;
import entities.ResultatFoerSkat;
import entities.Skatteprocent;

public interface BeregnResultat {
    void angivResultatFoerSkat(ResultatFoerSkat resultatFoerSkat);
    void angivSkatteprocent(double beloeb);
    void beregnResultat();
    Resultat hentResultat();
    Skatteprocent hentSkatteprocent();
}
